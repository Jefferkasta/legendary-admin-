package com.c3g27_28_e15.legendaryadmin.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_enterprise")
    public Long id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "document", unique = true)
    private String document;
    @Column(name = "phone")
    private String phone;
    @Column(name = "addres")
    private String addres;
    @Column(name = "createAt")
    private LocalDate createAt;
    @Column(name = "updateAt")
    private LocalDate updatedAt;
    @Transient
    private Boolean editDone;
    @Column(name = "Nemp")
    private Long aux;

    @OneToMany(mappedBy = "enterprise",cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "enterprise")
    // @Transient
    private Set<Profile> employees;

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

    public Enterprise() {
        this.editDone = false;
          
        // this.employees = null;
        // this.aux = (long) 1;

    }

    // public Enterprise(String name, String document, String phone, String addres, LocalDate createAt ,Employee employee) {
    //     this.name = name;
    //     this.document = document;
    //     this.phone = phone;
    //     this.addres = addres;
    //     this.createAt = createAt;
    //     this.updatedAt = createAt;
    //     this.employees = employee;
    //     // this.editDone = false;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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


    public Set<Profile> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Profile> employees) {
        this.employees = employees;
    }

    // @Override
    public String toString2() {
        return "Enterprise [addres=" + addres + ", aux=" + aux + ", createAt=" + createAt + ", document=" + document
                + ", editDone=" + editDone + ", employees=" + employees + ", id=" + getId() + ", name=" + name + ", phone="
                + phone + ", updatedAt=" + updatedAt + "]";
    }



    
}
