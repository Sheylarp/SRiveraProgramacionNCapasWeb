/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Operacion;
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
public class OperacionDAOImplementation implements IOperacionDAO {

    private EntityManager entityManager;

    @Autowired
    public OperacionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Operacion> GetAll() {
        TypedQuery<Operacion> query = entityManager.createQuery("FROM Operacion", Operacion.class);
        List <Operacion> operaciones= query.getResultList();
        return operaciones;

    }

    @Override
    public Operacion GetById(int idoperacioneditable) {
        TypedQuery<Operacion> query= entityManager.createQuery("FROM Operacion where idoperacion=:idoperacioneditable", Operacion.class);
        query.setParameter("idoperacioneditable", idoperacioneditable);
        return query.getSingleResult();
    }

}
