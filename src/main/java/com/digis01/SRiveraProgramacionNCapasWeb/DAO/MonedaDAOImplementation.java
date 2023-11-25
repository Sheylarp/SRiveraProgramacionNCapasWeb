/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Moneda;
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
public class MonedaDAOImplementation implements IMoneda {

    private EntityManager EntityManager;

    @Autowired
    public MonedaDAOImplementation(EntityManager EntityManager) {
        this.EntityManager = EntityManager;
    }

    @Override
    public List<Moneda> GetAll() {
        TypedQuery <Moneda> query= EntityManager.createQuery("FROM Moneda", Moneda.class);
        List<Moneda> monedas=query.getResultList();
        return monedas;
    
    }

}
