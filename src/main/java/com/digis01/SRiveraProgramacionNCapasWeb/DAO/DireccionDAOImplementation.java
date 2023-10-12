/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class DireccionDAOImplementation implements IDireccionDAO {

    private EntityManager entityManager;

    @Autowired
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Direccion> GetAll() {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccio", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        return direcciones;

    }

    @Override
    public Direccion GetByIdUsuario(int idUsuario) {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion where usuario.idusuario=:idusuario", Direccion.class);
        query.setParameter("idUsuario", idUsuario);
        Direccion direccion = query.getSingleResult();
        return direccion;
    }

    @Override
    @Transactional
    public void Add(Direccion direccion) {
        entityManager.persist(direccion);
    }

}
