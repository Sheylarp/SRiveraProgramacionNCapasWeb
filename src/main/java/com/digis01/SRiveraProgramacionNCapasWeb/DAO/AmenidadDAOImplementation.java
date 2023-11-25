/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Amenidad;
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
public class AmenidadDAOImplementation implements IAmenidad {

    private EntityManager entityManager;

    @Autowired
    public AmenidadDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Amenidad> GetAll() {
        TypedQuery<Amenidad> query = entityManager.createQuery("FROM Amenidad", Amenidad.class);
        List<Amenidad> amenidades = query.getResultList();
        return amenidades;

    }

    @Override
    public Amenidad GetById(int idamenidadeditable) {
     TypedQuery<Amenidad> query=entityManager.createQuery("FROM Amenidad where idamenidad=:idamenidadeditable", Amenidad.class);
     query.setParameter("idamenidadeditable", idamenidadeditable);
        return query.getSingleResult();
      
    }

}
