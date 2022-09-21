package com.c3g27_28_e15.legendaryadmin.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.c3g27_28_e15.legendaryadmin.Repository.EnterpriseRepository;

import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;

@Service

public class EnterpriseService {
    @Autowired
    private EnterpriseRepository EnterRepository;

    public EnterpriseService(EnterpriseRepository enterRepository) {
        this.EnterRepository = enterRepository;
    }

    @Transactional
    public Enterprise creatEnterprise(Enterprise newEnterprise) {

        Enterprise name = EnterRepository.findByName(newEnterprise.getName());
        final Enterprise enterprise = EnterRepository.findByDocument(newEnterprise.getDocument());
        if (name == null && enterprise == null) {
            return this.EnterRepository.save(newEnterprise);
        } else {
            return name;
        }

    }

    @Transactional(readOnly = true)
    public List<Enterprise> getEnterpriseList() {
        return this.EnterRepository.findAll();
    }

    @Transactional()
    public Enterprise getEnterpriseById(Long id) {
        try {
            return this.EnterRepository.getReferenceById(id);
            
        } catch (EntityNotFoundException e) {
            // TODO: handle exception
           return null;
        }
        
    }

    @Transactional()
    public void SaveEdit(Enterprise enterprise) {

        this.EnterRepository.save(enterprise);

    }

    @Transactional()
    public Enterprise editEnter(Long id) {
        Optional<Enterprise> enterMod = this.EnterRepository.findById(id);
        enterMod.get().setId(id);
        this.EnterRepository.deleteById(id);
        ;

        if (enterMod.isPresent()) {
            enterMod.get().getEditDone();
            enterMod.get().setEditDone(true);

            return enterMod.get();
        }

        return null;

    }

    public void deleteEnter(Long id) {
        this.EnterRepository.deleteById(id);

    }

}
