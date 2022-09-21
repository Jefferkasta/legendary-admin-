package com.c3g27_28_e15.legendaryadmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3g27_28_e15.legendaryadmin.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Long>{
    Enterprise findByName(String name);
    Enterprise findByDocument(String document);
    
}
