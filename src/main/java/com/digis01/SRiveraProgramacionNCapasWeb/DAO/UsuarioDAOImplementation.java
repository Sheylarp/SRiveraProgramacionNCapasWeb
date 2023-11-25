/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Rol;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementation implements IUsuarioDAO {

    private EntityManager entityManager;

    @Autowired //Inyección de dependencias.
    public UsuarioDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> GetAll(Usuario usuario) {
        //consulta
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE "
                + "UPPER(nombre) LIKE UPPER(:nombreusuario) AND "
                + "UPPER(apellidopaterno) LIKE UPPER(:apellidopaternousuario) AND "
                + "UPPER(apellidomaterno) LIKE UPPER(:apelldiomaeternousuario)", Usuario.class);
        //setear parámetros --> nombre, ap y am
        query.setParameter("nombreusuario", ('%' + usuario.getNombre() + '%'));
        query.setParameter("apellidopaternousuario", ('%' + usuario.getApellidopaterno() + '%'));
        query.setParameter("apelldiomaeternousuario", ('%' + usuario.getApellidomaterno() + '%'));
        List<Usuario> usuarios = query.getResultList();
        return usuarios;

    }

    @Override
    @Transactional
    public int Add(Usuario usuario) {
        usuario.setFechanacimiento(new Date());
        //usuario.getFechanacimiento();
        Rol rol = new Rol();
        rol.setIdrol(1);
        usuario.setRol(rol);
        entityManager.persist(usuario);
        return usuario.getIdusuario();
    }

    @Override
    @Transactional
    public void Update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario where idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);
        return query.getSingleResult();

    }

//    public Usuario Delete(int idusuarioeliminado) {
//         //TypedQuery<Usuario> query = entityManager.createQuery("DELETE FROM Usuario where idusuario=:idusuarioeliminado", Usuario.class);
////          TypedQuery<Usuario> query = (TypedQuery<Usuario>) entityManager.createNativeQuery("DELETE FROM Usuario where idusuario=:idusuarioeliminado", Usuario.class);
//         TypedQuery<Usuario> query = entityManager.remove(this)
//          query.setParameter(1, idusuarioeliminado);
//        return query.getSingleResult();
//    }
//public Usuario Delete(int idusuarioeliminado) {
//   // TypedQuery<Usuario> query= entityManager.createNamedQuery("DELETE FROM Usuario where idusuario=:idusuarioeliminado", Usuario.class);
//    TypedQuery<Usuario> query= entityManager.createNativeQuery(string, type)
//    query.setParameter(1, idusuarioeliminado);
//    return query.getSingleResult();
//}
    @Override
    @Transactional
    public void Delete(int idusuarioeliminado) {

        // id nombre, ap, am
        // 1
        // 2 sheyla
        // 3 alejandro
        // obtener el usuario de mi tabla 
        Usuario usuarioEliminar = entityManager.find(Usuario.class, idusuarioeliminado);

        entityManager.remove(usuarioEliminar);
    }

    @Override
    @Transactional
    public void ChangeStatus(int idUsuario, boolean status) {
        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
//      if (status){
//      usuario.setStatus("Y");
//      }else {
//          usuario.setStatus("N");
//      }
//    }
        String statusString = (status) ? "Y" : "N"; //operador ternario
        usuario.setStatus(statusString);
        entityManager.merge(usuario);
    }

    @Override
    public Usuario GetByEmail(Usuario usuario) {
        String emaillog = usuario.getEmail();
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE email = :emaillog", Usuario.class);
        query.setParameter("emaillog", emaillog);

        return query.getSingleResult();
    }
}
