package com.c3g27_28_e15.legendaryadmin.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_profile")
    public Long id;


    @Column(name = "image")
    private String image;


    @Column(name = "phone")
    private String phone;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "createAt")
    private LocalDate createAt;
    @Column(name = "updateAt")
    private LocalDate updatedAt;

    

    // @ManyToOne(targetEntity = Enterprise.class , cascade = CascadeType.ALL )
    // @JoinColumn(name="employeeId",referencedColumnName="id_enterprise", insertable=false, updatable=false) 
    // // @Transient
    // private Enterprise enterprise;
    @Transient
    private Boolean editDone;
    @Transient
    private Long aux;

    // @OneToOne(mappedBy = "profile_id")
    // private Profile profile;
    // @OneToOne(mappedBy = "employee")
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "user_id", referencedColumnName = "id_employee")
    // private Address address;
    // @Transient
    // private Employee employee;
    @ManyToOne(targetEntity = Enterprise.class , cascade = CascadeType.MERGE )
    @JoinColumn(name="employeeId",referencedColumnName="id_enterprise") 
    private Enterprise enterprise;



  
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Profile(Long id, String image, String phone, String name, LocalDate createAt, LocalDate updatedAt,
            Boolean editDone, Long aux) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.name = name;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
        this.editDone = editDone;
        this.aux = aux;
        // this.employee = employee;
    }

    public Profile() {
        this.editDone = false;
        // this.aux = (long) 1;

    }

    public Profile(String email, LocalDate createAt) {
  
        this.createAt = createAt;
        this.updatedAt = createAt;
        // this.enterprise = enterprise;
        // this.editDone = false;
    }

    public Long getId() {
        return id;
    }

   

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }




    public Long getAux() {
        return aux;
    }

    public void setAux(Long aux) {
        this.aux = aux;
    }

    public Boolean getEditDone() {
        return editDone;
    }

    public void setEditDone(Boolean editDone) {
        this.editDone = editDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public Employee getEmployee() {
    //     return employee;
    // }

    // public void setEmployee(Employee employee) {
    //     this.employee = employee;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    // public Enterprise getEnterprise() {
    //     return enterprise;
    // }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Profile [aux=" + aux + ", createAt=" + createAt + ", editDone=" + editDone + ", email=" + email
                + ", enterprise=" + enterprise.toString2() + ", id=" + id + ", image=" + image + ", name=" + name + ", phone="
                + phone + ", updatedAt=" + updatedAt + "]";
    }



    // public void setEnterprise(Enterprise enterprise) {
    //     this.enterprise = enterprise;
    // }

    // @Override
    // public String toString() {
    //     return "Employee [aux=" + aux + ", createAt=" + createAt + ", editDone=" + editDone + ", email=" + email
    //             + ", enterprise=" + enterprise + ", id=" + id + ", updatedAt=" + updatedAt + "]";
    // }



}
