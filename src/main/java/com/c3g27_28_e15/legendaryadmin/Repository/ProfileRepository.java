package com.c3g27_28_e15.legendaryadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3g27_28_e15.legendaryadmin.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    Profile findByEmail(String email);
    
}
