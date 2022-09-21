package com.c3g27_28_e15.legendaryadmin.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    private Boolean editDone;
    private Long aux;

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

    }

    public Enterprise(String name, String document, String phone, String addres, LocalDate createAt) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.addres = addres;
        this.createAt = createAt;
        this.updatedAt = createAt;
        // this.editDone = false;
    }

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

    @Override
    public String toString() {
        return "Enterprise [addres=" + addres + ", aux=" + aux + ", createAt=" + createAt + ", document=" + document
                + ", editDone=" + editDone + ", id=" + id + ", name=" + name + ", phone=" + phone + ", updatedAt="
                + updatedAt + "]";
    }

}
