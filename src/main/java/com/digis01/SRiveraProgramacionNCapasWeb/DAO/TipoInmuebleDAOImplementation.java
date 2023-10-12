/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
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
public class TipoInmuebleDAOImplementation implements ITipoInmuebleDAO{
   
    private EntityManager entityManager;

    @Autowired
    public TipoInmuebleDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    @Override
    public List<TipoInmueble> GetAll(TipoInmueble tipoInmueble) {
        TypedQuery <TipoInmueble> query=entityManager.createQuery("FROM TipoInmueble", TipoInmueble.class);
        List<TipoInmueble> tipoInmuebles =query.getResultList();
        return tipoInmuebles;
    
    }

    @Override
    @Transactional
    public int Add(TipoInmueble tipoInmueble) {
        entityManager.persist(tipoInmueble);
        return tipoInmueble.getIdtipoinmueble();
    }

    @Override
    public void Update(TipoInmueble tipoInmueble) {
        entityManager.merge(tipoInmueble);
    }

    @Override
    public TipoInmueble GetById(int idtipoInmuebleeditable) {
        TypedQuery <TipoInmueble> query= entityManager.createQuery("FROM TipoInmueble where idtipoinmueble=:idtipoInmuebleeditable", TipoInmueble.class);
        query.setParameter("idtipoInmuebleeditable", idtipoInmuebleeditable);
        return query.getSingleResult();
   }

    @Override
    @Transactional
    public void Delete(int idtipoInmuebleeliminado) {
        TipoInmueble tipoInmuebleEliminar = entityManager.find(TipoInmueble.class, idtipoInmuebleeliminado);
        entityManager.remove(tipoInmuebleEliminar);
    }
    
}
