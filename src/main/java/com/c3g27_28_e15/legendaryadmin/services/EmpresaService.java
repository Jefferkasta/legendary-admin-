package com.c3g27_28_e15.legendaryadmin.services;


// import java.time.LocalDate;

import com.c3g27_28_e15.legendaryadmin.entities.Empresa;



public class EmpresaService {
    Empresa empresa;
    public EmpresaService(){
        this.empresa = new Empresa("Ropa de legend", "carrera 1 #43 2", "3225773421", 12345432);
       
    }
    public Empresa getEmpresa(){
        return this.empresa;
    }
    public void setEmpresa(String nombre,String direccion, String telefono,int nitEmpresa){
        this.empresa = new Empresa(nombre, direccion, telefono, nitEmpresa);
    }
    
}
