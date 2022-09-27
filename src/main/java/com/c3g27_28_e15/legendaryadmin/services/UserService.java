package com.c3g27_28_e15.legendaryadmin.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c3g27_28_e15.legendaryadmin.Repository.UserRepository;
import com.c3g27_28_e15.legendaryadmin.entities.User;

@Service
public class UserService {
    @Autowired
    UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public List<User> getUserList(){
        return this.repository.findAll();
        // return this.repository.findAllById(ids)
    }
    public User createUser(User newUser){
        return this.repository.save(newUser);

    }
    public User findUserByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public User getOrCreateUser(Map<String,Object> userData){
        
        String email = (String)userData.get("email");
        User user = findUserByEmail(email);
        if(user==null){
            String name = (String)userData.get("nickname");
            String image = (String)userData.get("picture");
            String auth0Id = (String)userData.get("sub");
            User newUser = new User(name, email, image,auth0Id);
            return createUser(newUser);
        }
        else{
            // System.out.println(user.getEmail());
            return user;
        }
       
    }
    
    
}