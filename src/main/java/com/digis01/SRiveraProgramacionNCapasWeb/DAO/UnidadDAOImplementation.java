/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Unidad;
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
public class UnidadDAOImplementation implements IUnidadDAO {

    private EntityManager entityManager;

    @Autowired
    public UnidadDAOImplementation(EntityManager EntityManager) {
        this.entityManager = EntityManager;
    }

    @Override
    public List<Unidad> GetAll() {
        TypedQuery<Unidad> query= entityManager.createQuery("FROM Unidad", Unidad.class);
        List <Unidad> unidades= query.getResultList();
        return unidades;

    }

}
