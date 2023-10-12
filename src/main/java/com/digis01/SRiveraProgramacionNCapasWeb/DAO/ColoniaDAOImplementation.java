/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Colonia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class ColoniaDAOImplementation implements IColoniaDAO{
private EntityManager entityManager;

    public ColoniaDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Colonia> GetAll() {
        TypedQuery <Colonia> query = entityManager.createQuery("FROM Colonia", Colonia.class);
        List <Colonia> colonias=query.getResultList();
    return colonias;
    }



    @Override
    public List<Colonia> GetByIdMunicipio(int idMunicipio) {
    TypedQuery <Colonia> query = entityManager.createQuery("FROM Colonia where municipio.idmunicipio=:id", Colonia.class);
       query.setParameter("id", idMunicipio);
       List <Colonia> colonias= query.getResultList();
    return colonias;
   
    }
    
}
