package com.c3g27_28_e15.legendaryadmin.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.services.EnterpriseService;

@Controller
public class FrontController {

    EnterpriseService serviceEnter;

    public FrontController(EnterpriseService serviceEnter) {
        this.serviceEnter = serviceEnter;
    }
    // Get

    @GetMapping("/")
    public String index(Model model) {

        String[] url = new String[] { "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp",
                "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(12).webp",
                "https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(10).webp" };
        // int id = 2;
        Enterprise dat = new Enterprise();
        model.addAttribute("dat", dat);
        model.addAttribute("imageUrls", url);
        return "index";
    }

    @GetMapping("/Enter")
    public String enterprise(Model model) {

        List<Enterprise> enterpriseL = serviceEnter.getEnterpriseList();
        model.addAttribute("Lenter", enterpriseL);

        return "listEnter";
    }

    @GetMapping("/EnterN")
    public String enterprisePost(Model model) {

        Enterprise newEmp = new Enterprise();

        model.addAttribute("newEnter", newEmp);
        var mensaje = "Empresa nueva";
        Boolean editState = newEmp.getEditDone();
        model.addAttribute("Edit", editState);
        model.addAttribute("msn", mensaje);
        return "enterprise";
    }

    // Post

    @PostMapping("/FindId")
    public String findIdEnterprise(Enterprise enterprise, Model model) {

        // System.out.println(enterprise.getAux());
        Enterprise enterpriseByID = this.serviceEnter.getEnterpriseById(enterprise.getAux());

        model.addAttribute("Lenter", enterpriseByID);
        return "listEnter";

    }

    // Patch
    @PatchMapping("/Enter/{id}")
    public String enterpriseEd(Model model, @PathVariable("id") Long id) {
        Enterprise empId = this.serviceEnter.editEnter(id);
        model.addAttribute("idEmp", empId);

        return "enterpriseEdit";
    }
}