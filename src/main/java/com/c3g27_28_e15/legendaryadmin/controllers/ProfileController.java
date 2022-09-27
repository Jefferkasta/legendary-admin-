package com.c3g27_28_e15.legendaryadmin.controllers;

// import java.util.ArrayList;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

// import com.c3g27_28_e15.legendaryadmin.entities.Employee;
import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.entities.Profile;
// import com.c3g27_28_e15.legendaryadmin.services.EmployeeService;
import com.c3g27_28_e15.legendaryadmin.services.EnterpriseService;
import com.c3g27_28_e15.legendaryadmin.services.ProfileService;


@RestController
public class ProfileController {

    ProfileService serviceProfile;
    // EmployeeService serviceEmployee;
    EnterpriseService serviceEnterprise;

    public ProfileController(ProfileService serviceProfile,EnterpriseService serviceEnterprise) {
        this.serviceProfile = serviceProfile;
        
        this.serviceEnterprise = serviceEnterprise;
    }


    
    @GetMapping("/Profile")
    public List<Profile> EnterpriseList() {
        return this.serviceProfile.getProfileList();
    }
       // Post
       @PostMapping("/Profile")
       public Profile creaEnterprise(@RequestBody Profile profile) {
           return this.serviceProfile.creatProfile(profile);
       }

       @PatchMapping("/newEmp/{id}")
       public RedirectView createNewEmpleado(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Profile emple,
               Model model,@PathVariable Long id) {
            System.out.println("Entro id "+id);

            System.out.println(emple.toString());
        

            // Enterprise enter = this.serviceEnterprise.getEnterpriseById(id);
            Enterprise enterMod  = this.serviceEnterprise.getEnterpriseById(id);
            // emple.setEnterprise(enter);
            System.out.println(enterMod.getAddres());

            emple.setEnterprise(enterMod);
            System.out.println( emple.getEnterprise().getDocument());
            System.out.println( emple.getEnterprise().getName());
            System.out.println( emple.getEnterprise().getId());

            // this.serviceEnterprise.deleteEnter(id);

            this.serviceProfile.saveProfile(emple);

           
       

     
           return new RedirectView("/Enter");
       }
       

    @DeleteMapping("/Empdelete/{id}")
    public RedirectView deleteProfile(@PathVariable("id") Long id) {
        this.serviceProfile.deleteProfile(id);
        return new RedirectView("/Enter");
    }

    
}
