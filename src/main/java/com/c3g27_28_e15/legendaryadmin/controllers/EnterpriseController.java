package com.c3g27_28_e15.legendaryadmin.controllers;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;
import com.c3g27_28_e15.legendaryadmin.services.EnterpriseService;

@RestController
public class EnterpriseController {

    EnterpriseService service;

    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }
    // Get

    @GetMapping("/enterprise")
    public List<Enterprise> EnterpriseList() {
        return this.service.getEnterpriseList();
    }

    // Post
    @PostMapping("/enterprise")
    public Enterprise creaEnterprise(@RequestBody Enterprise enterprise) {
        return this.service.creatEnterprise(enterprise);
    }

    @PostMapping("/newEn")
    public RedirectView createNewEnter(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise,
            Model model) {
        model.addAttribute(enterprise);
        enterprise.setUpdatedAt(enterprise.getCreateAt());
        this.service.creatEnterprise(enterprise);
        return new RedirectView("/Enter");
    }

    // Patch
    @PatchMapping("/updateE")
    public RedirectView updateEnter(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Enterprise enterprise,
            Model model) {
        model.addAttribute(enterprise);
        enterprise.setUpdatedAt(enterprise.getCreateAt());
        this.service.SaveEdit(enterprise);
        return new RedirectView("/Enter");
    }

    // Delete
    @DeleteMapping("/Enter/{id}")
    public RedirectView deleteTask(@PathVariable("id") Long id) {
        this.service.deleteEnter(id);
        return new RedirectView("/Enter");
    }

}
