/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Servicio;
import jakarta.persistence.EntityManager;
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
public class ServicioDAOImplementation implements IServicioDAO {

    private EntityManager entityManager;

    @Autowired
    public ServicioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Servicio> GetAll() {
        TypedQuery<Servicio> query = entityManager.createQuery("FROM Servicio", Servicio.class);
        List<Servicio> servicios = query.getResultList();
        return servicios;
    }

    @Override
    @Transactional
    public int Add(Servicio servicio) {
        entityManager.persist(servicio);
        return servicio.getIdservicio();
    }

    @Override
    @Transactional
    public void Update(Servicio servicio) {
        entityManager.merge(servicio);
    }

    @Override
    public Servicio GetById(int idservicioeditable) {
        TypedQuery<Servicio> query = entityManager.createQuery("From Servicio where idservicio:idservicioeditable", Servicio.class);
        query.setParameter("idservicioeditable", idservicioeditable);
        return query.getSingleResult();

    }

    @Override
    @Transactional
    public void Delete(int idservicioeliminado) {
   Servicio servicioeliminar =entityManager.find(Servicio.class, idservicioeliminado);
   entityManager.remove(servicioeliminar);
    }

}
