package com.c3g27_28_e15.legendaryadmin.services;

import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

// import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.servlet.view.RedirectView;

// import com.c3g27_28_e15.legendaryadmin.Repository.EmployeeRepository;
import com.c3g27_28_e15.legendaryadmin.Repository.EnterpriseRepository;
import com.c3g27_28_e15.legendaryadmin.Repository.ProfileRepository;
// import com.c3g27_28_e15.legendaryadmin.entities.Employee;
import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.entities.Profile;

@Service

public class EnterpriseService {
    @Autowired
    private EnterpriseRepository EnterRepository;
    // private EmployeeRepository employeeRepository;
    // private ProfileRepository profileRepository;



    public EnterpriseService(EnterpriseRepository enterRepository,
            ProfileRepository profileRepository) {
        EnterRepository = enterRepository;
    
        // this.profileRepository = profileRepository;
    }

    @Transactional
    public Enterprise creatEnterprise(Enterprise newEnterprise) {

        Enterprise name = EnterRepository.findByName(newEnterprise.getName());
        final Enterprise enterprise = EnterRepository.findByDocument(newEnterprise.getDocument());
        if (name == null && enterprise == null) {

            return this.EnterRepository.save(newEnterprise);
        } else {
            System.out.println("Existe");
            return name;
        }

    }

    @Transactional(readOnly = true)
    public List<Enterprise> getEnterpriseList() {
        return this.EnterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Enterprise getEnterpriseById(Long id) {
  
            System.out.println("Servicio= "+id);
          Enterprise info = new Enterprise();
            return this.EnterRepository.findById(id).orElse(info);
          
      
        
    }

    @Transactional()
    public void SaveEdit(Enterprise enterprise) {
        Long id = enterprise.getId();
        Optional<Enterprise> enterMod = this.EnterRepository.findById(id);
        // enterMod.get().setId(id);
        System.out.println("SaveEdit");
        System.out.println(enterprise.getEmployees().size());
        // this.EnterRepository.deleteById(id);
        // this.EnterRepository.save(enterprise);
        if (enterMod.isPresent()) {
            enterMod.get().getEditDone();
            enterMod.get().setDocument("1234");
            enterMod.get().setName("Arepa");
            enterMod.get().setEditDone(true);
            System.out.print("Entermod Desac = ");
            System.out.println(enterMod.get().getEmployees().size());
          
            System.out.print("Entermod Act = ");
            enterMod.get().setEmployees(enterprise.getEmployees());
            // enterMod.get().setEmployee();
            // Set <Employee> n =  enterMod.get().getEmployees();
            // Set<Profile> myArrayListE = new HashSet<Profile>();
            List<Profile> myArrayListE2 =  new ArrayList<>();
                System.out.println("****************************************");
            // for (Employee i : n){

           
            //     // System.out.println(i.getProfile().getName());
            //     // System.out.println(i.getEmail());
            //     myArrayListE2.add(i.getProfile());
            //     // myArrayListE.add(i.getProfile());


            //     System.out.format("%15s %15s %15s %s  %15s %n",i.getProfile().getName(),i.getProfile().getPhone(),i.getEmail(),i.getEnterprise().getId(),i.getEnterprise().getName());
            //     // i.getProfile().setName();
                
            // }
            System.out.println("****************************************");
        
            // this.employeeRepository.saveAll(enterMod.get().getEmployees());
            // this.profileRepository.saveAll(myArrayListE2);
            // this.profileRepository.saveAll(enterMod.get().getEmployees());
            // this.EnterRepository.save(enterMod.get());
            // System.out.print(enterMod.get());
            // Enterprise nuevoN = new Enterprise(enterMod.get().getName(), enterMod.get().getDocument(), enterMod.get().getPhone(), enterMod
            // .get().getAddres(), enterMod.get().getCreateAt(), enterMod.get().getEmployees());
            // Enterprise nuevoN = new Enterprise()
            // this.creatEnterprise(enterMod.get());
            // this.EnterRepository.save(nuevoN);

     
        }


    }

    @Transactional()
    public Enterprise editEnter(Long id) {
        Optional<Enterprise> enterMod = this.EnterRepository.findById(id);
        enterMod.get().setId(id);
        this.EnterRepository.deleteById(id);
        

        if (enterMod.isPresent()) {
            enterMod.get().getEditDone();
            enterMod.get().setEditDone(true);

            return enterMod.get();
        }

        return null;

    }

    public void deleteEnter(Long id) {
        this.EnterRepository.deleteById(id);

    }

}
