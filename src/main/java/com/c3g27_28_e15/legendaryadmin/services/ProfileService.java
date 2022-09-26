package com.c3g27_28_e15.legendaryadmin.services;

import com.c3g27_28_e15.legendaryadmin.Repository.EnterpriseRepository;
import com.c3g27_28_e15.legendaryadmin.Repository.ProfileRepository;
import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.entities.Profile;

import net.bytebuddy.implementation.bytecode.Throw;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProfileService {
    ProfileRepository repository;
    EnterpriseRepository repositoryEnter;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public Profile creatProfile(Profile newProfile){
        return this.repository.save(newProfile);
    }
    

    public Profile saveProfile(Profile newProfile){

        // System.out.println(newProfile.get);
        // Enterprise name = this.repository.findByName(newProfile.getEmail());
        final Profile enterprise = this.repository.findByEmail(newProfile.getEmail());
        if ( enterprise == null) {

            return this.repository.save(newProfile);
        } else {
            System.out.println("Existe");
            return newProfile;
        }

        // return this.repository.save(newProfile);
    }
    @Transactional(readOnly = true)
    public List<Profile> getProfileList(){

        // try {
        //     Boolean data = this.repository.findAll().isEmpty();
        //     // var da = ((Optional<List<Enterprise>>) this.repository.findAll()).orElseThrow();
            

        //     // this.repository.findAll()
    
        //     if (data){
        //         System.out.println("Vacio");
        //         List<Profile> dataR = new ArrayList<>();
        //         return dataR;
    
        //     }
        //     else{
        //         System.out.println("Existen");
        //         return this.repository.findAll();
        //     }
            
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println("Error");
        //     List<Profile> dataR = new ArrayList<>();
        //     return dataR;
        // }
    
        return this.repository.findAll();

       
    }

    public List<Profile> getProfileId(Long id){
        // this.repository.findById(id);
        // this.repositoryEnter.findById(id);
        System.out.println("GetID");
        System.out.println(id);
        System.out.println(this.repositoryEnter.findById(id).orElseThrow());
        return this.repository.findAll();
    }

    public void deleteProfile(Long id) {

        this.repository.deleteById(id);
    }
}
