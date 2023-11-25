/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Inmueble;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class InmuebleDAOImplementation implements IInmueble{

    private EntityManager entityManager;

    @Autowired
    public InmuebleDAOImplementation(EntityManager EntityManager) {
        this.entityManager = EntityManager;
    }
    
    @Override
    public List<Inmueble> GetAll(Inmueble inmueble) {
        TypedQuery <Inmueble> query= entityManager.createQuery("FROM Inmueble", Inmueble.class);
        List <Inmueble> inmuebles= query.getResultList();
        return inmuebles;
    
    }

    @Override
    @Transactional
    public int Add(Inmueble inmueble) {
        entityManager.persist(inmueble);
        return inmueble.getIdinmueble();
     }

    @Override
    @Transactional
    public void Update(Inmueble inmueble) {
   entityManager.merge(inmueble);
    }

    @Override
    public Inmueble GetById(int idinmuebleeditable) {
   TypedQuery <Inmueble> query = entityManager.createQuery("FROM Inmueble where idinmueble =:idinmuebleeditable", Inmueble.class);
   query.setParameter("idinmuebleeditable", idinmuebleeditable);
   return query.getSingleResult();
   
    }

    @Override
    @Transactional
    public void Delete(int idinmuebleeliminado) {
       Inmueble inmuebleEliminar= entityManager.find(Inmueble.class, idinmuebleeliminado);
       entityManager.remove(inmuebleEliminar);
    }
    
}
