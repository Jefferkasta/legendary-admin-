package com.c3g27_28_e15.legendaryadmin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.c3g27_28_e15.legendaryadmin.entities.Empresa;
import com.c3g27_28_e15.legendaryadmin.services.EmpresaService;

@RestController
public class EmpresaController {

    EmpresaService service;

    public EmpresaController(){
        this.service = new EmpresaService();
    }
    @GetMapping("/Empresa")
    public Empresa TaskList(){

        return this.service.getEmpresa();
    }
    
}
