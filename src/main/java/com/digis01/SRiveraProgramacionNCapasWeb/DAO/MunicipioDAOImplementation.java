/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Municipio;
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

public class MunicipioDAOImplementation implements IMunicipioDAO{
    private EntityManager entityManager;

    @Autowired
    public MunicipioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Municipio> GetByIdEstado(int idEstado) {
        TypedQuery<Municipio> query= entityManager.createQuery("FROM Municipio where estado.idestado=:id", Municipio.class);
        query.setParameter("id", idEstado);
        List <Municipio> municipios =query.getResultList();
        return municipios;
    }

    @Override
    public List<Municipio> GetAll() {
        TypedQuery <Municipio> query =entityManager.createQuery("FROM Municipio", Municipio.class);
        List <Municipio> municipios= query.getResultList();
        return municipios;
   }
    
}
