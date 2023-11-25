/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Login;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class EmailDAOImplementation implements IEmailDAO{
    private EntityManager entityManager;

    @Override
    public Usuario GetByIdEmail(int idusuarioeditable) {
        TypedQuery <Usuario> query= entityManager.createQuery("email FROM Usuario ", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);
     
        return query.getSingleResult();
     
    }

    @Override
    public List<Login> GetAllEmail() {
        TypedQuery<Login> query= entityManager.createQuery("FROM Login", Login.class);
        List <Login> logins= query.getResultList();
        return logins;
    }

    @Override
    public Login GetByEmail() {
    
        return null;
    
    }
    
}
