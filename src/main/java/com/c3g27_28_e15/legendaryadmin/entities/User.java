package com.c3g27_28_e15.legendaryadmin.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private long id;
    public long id;
    @Column(name= "name")
    private String name;
    @Column(name= "email", unique = true)
    private String email;
    @Column(name= "image")
    private String image;
    // @Column(name= "dueDate")
    // private LocalDate dueDate;
    @Column(name= "auth0Id")
    private String auth0Id;

    // @Column(name= "rol")
    // private String rol;

    // @OneToMany(mappedBy = "user")
    // private List<Task> task;
    
    // @OneToMany(mappedBy = "user")
    // @JsonIgnoreProperties(value = "user") //se lo agregué para no ver ese ciclo infinito en Json
    // private Set<Task> task;

  
    public User(){

    }

    public User(String name,String email,String image, String auth0Id){
        this.name = name;
        this.email = email;
        this.auth0Id = auth0Id;
        this.image = image;
        // this.rol = "Admin";

    }

    public long getId() {
        System.out.println("get id");
        return id;
    }

    public void setId(long id) {
        this.id = id;
        System.out.println("Set id");
    }


   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Set<Task> getTask() {
    //     return task;
    // }

    // public void setTask(Set<Task> task) {
    //     this.task = task;
    // }

    

}
