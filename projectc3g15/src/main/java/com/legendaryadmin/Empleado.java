package com.legendaryadmin;

// Es posible crear una nueva instancia de la clase 

// "Empleado"
// Es posible leer y modificar el nombre de un empleado
// Es posible leer y modificar el correo de un empleado
// Es posible leer y modificar la empresa a la que el 
// empleado pertenece
// Es posible leer y modificar el rol del empleado 
// (administrador, operativo)

public class Empleado {

    // ATRIBUTOS
    private String nombreCompleto;
    private String email;
    private String empresa;
    private String rol;

    //CONSTRUCTOR
    public Empleado(String nombreCompleto,String email,String empresa,String rol) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.empresa = empresa;
        this.rol = rol; 
    }
    // Getter / Setter
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    
}
