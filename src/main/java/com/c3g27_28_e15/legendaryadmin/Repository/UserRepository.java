package com.c3g27_28_e15.legendaryadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3g27_28_e15.legendaryadmin.entities.User;



public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    
}
