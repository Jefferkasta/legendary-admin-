package com.c3g27_28_e15.legendaryadmin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.entities.Profile;
import com.c3g27_28_e15.legendaryadmin.entities.User;
import com.c3g27_28_e15.legendaryadmin.services.EnterpriseService;
import com.c3g27_28_e15.legendaryadmin.services.ProfileService;
import com.c3g27_28_e15.legendaryadmin.services.UserService;

@Controller
public class FrontController {

    EnterpriseService serviceEnter;
    ProfileService serviceProfile;
    UserService userService;

    public FrontController(EnterpriseService serviceEnter, ProfileService serviceProfile,UserService userService) {
        this.serviceEnter = serviceEnter;
        this.serviceProfile = serviceProfile;
        this.userService = userService;
    }
    // Enterprise
    // Get

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {

        if(principal!=null){
            // System.out.println(principal.getClaims());
        User user = this.userService.getOrCreateUser(principal.getClaims());
        model.addAttribute("user", user);
    }
        
        
        String[] url = new String[] { "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp",
                "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(12).webp",
                "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(10).webp" };
        // int id = 2;
        Enterprise dat = new Enterprise();
        model.addAttribute("dat", dat);
        model.addAttribute("imageUrls", url);
        return "index";
    }

    @GetMapping("/Enter")
    public String enterprise(Model model) {

        List<Enterprise> enterpriseL = serviceEnter.getEnterpriseList();
        model.addAttribute("Lenter", enterpriseL);

        List<Integer> Nemp = new ArrayList<>();
        for (Enterprise enterprise : enterpriseL) {

            Nemp.add(enterprise.getEmployees().size());
            Long n = (long) enterprise.getEmployees().size();
            enterprise.setAux(n);
            // this.serviceEnter.SaveEdit(enterprise);
            

        }
        model.addAttribute("Nemp", Nemp);
        for (int i = 0; i < Nemp.size(); i++) {
            System.out.println(Nemp.get(i));

        }

        return "listEnter";
    }

    @GetMapping("/EnterN")
    public String enterprisePost(Model model) {

        Enterprise newEmp = new Enterprise();

        model.addAttribute("newEnter", newEmp);
        var mensaje = "Empresa nueva";
        Boolean editState = newEmp.getEditDone();
        model.addAttribute("Edit", editState);
        model.addAttribute("msn", mensaje);
        return "enterprise";
    }



    @PostMapping("/FindId")
    public String findIdEnterprise(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise,
            Model model) {
        model.addAttribute(enterprise);
    
        if (enterprise.getAux2()!= null) {
    
            Enterprise enterpriseByID = this.serviceEnter.getEnterpriseById(enterprise.getAux2());

            if (enterpriseByID.getEditDone()==false)
            {
            Integer num = enterpriseByID.getEmployees().size();
            if ( num !=null)
            {
                Long n = (long) num;
                System.out.println(n);
                
                    enterpriseByID.setAux(n);
                    // System.out.println(enterpriseByID.toString());
                    model.addAttribute("Lenter", enterpriseByID);

            }
        }
        }


    return "listEnter";
}

    // Patch
    @PatchMapping("/Enter/{id}")
    public String enterpriseEd(Model model, @PathVariable("id") Long id) {
        Enterprise empId = this.serviceEnter.editEnter(id);
        model.addAttribute("idEmp", empId);

        return "enterpriseEdit";
    }

    // Profile

    @PostMapping("/Employee/{id}/{Nem}")
    public String Employee(Model model, @PathVariable("id") Long id,  @PathVariable("Nem") Long aux) {
        Profile nProfile = new Profile();

        Enterprise info = serviceEnter.getEnterpriseById(id);
        List<Profile> empleados = new ArrayList<>();
        
        System.out.println("Info= "+info.getAux());
        System.out.println("Info= "+aux);
        System.out.println("Info= "+info.getName());
        if (aux != 0) {
            List<Profile> Empleados = this.serviceProfile.getProfileList();
            // List<Profile> empleados = new ArrayList<>();
    
            for (Profile emp : Empleados) {
                // System.out.format("%12s %12 %12",
                // emp.getName(),emp.getPhone(),emp.getEmail());
                if (emp.getEnterprise().getId() == id) {
    
                    String nameE = emp.getEnterprise().getName();
    
                    model.addAttribute("nameE", nameE);
                    empleados.add(emp);
                    nProfile.setEnterprise(emp.getEnterprise());
                    // nProfile.getEnterprise().setId(id);
    
                    System.out.println(emp.getEnterprise().getId());
                    System.out.println(emp.getEnterprise().getDocument());
                    System.out.println(emp.getEnterprise().getName());
                    // System.out.println(nProfile.getEnterprise());
                    model.addAttribute("newEmp", nProfile);
                }
            }
    
            // model.addAttribute("newEmp", nProfile);
            model.addAttribute("empleados", empleados);
         
        } else {
            System.out.println(aux);
            System.out.println("CERO");
            nProfile.setEnterprise(info);
            nProfile.getEnterprise().setId(id);
     
            model.addAttribute("newEmp", nProfile);
            model.addAttribute("empleados", empleados);
        }

  
        return "employeel";
    }

    // @PostMapping("/Employee")
    // public String employeePost(Model model){

    // Profile emple = new Profile();
    // model.addAttribute("emp",emple );
    // return "employeel";
    // }
    @PostMapping("/newEmployee")
    public RedirectView createNewEnter(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Profile profile,
            Model model) {
        // model.addAttribute(profile);
        // System.out.println("+++Newn++");
        // System.out.println(enterprise.toString());
        // enterprise.setUpdatedAt(enterprise.getCreateAt());
        // this.service.creatEnterprise(enterprise);
        // this.serviceProfile.creatProfile(profile);
        return new RedirectView("/Enter");
    }

}