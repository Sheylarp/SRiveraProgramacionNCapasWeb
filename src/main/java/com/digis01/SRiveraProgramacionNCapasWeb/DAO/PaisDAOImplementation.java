/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class PaisDAOImplementation implements IPaisDAO{
    private EntityManager entityManager;
    
    @Autowired
    public PaisDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    @Override
    public List<Pais> GetAll() {
       TypedQuery <Pais> query = entityManager.createQuery("FROM Pais", Pais.class);
       List <Pais> paises=query.getResultList();
    
        return paises;
    
    }
    
}
