/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.restController;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/apiUsuario")
public class UsuarioRestController {

    private UsuarioDAOImplementation usuarioDAOImplementation;

    public UsuarioRestController(UsuarioDAOImplementation usuarioDAOImplementation) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }

    @GetMapping("/GetAll")
    public List<Usuario> GetAll(Usuario usuario) {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario);
//        return usuarioDAOImplementation.GetAll(usuario);
//        return "usuario:"+usuarios;
        return usuarios;
    }

    @GetMapping("/GetById/{idusuario}")
    public Usuario GetById(@PathVariable("idusuario") int idusuario) {
        Usuario usuarios = usuarioDAOImplementation.GetById(idusuario);
        return usuarios;
//        return usuarioDAOImplementation.GetById(idusuario);
    }

    @GetMapping("/Add")
    public String Add(Usuario usuario) {
        

        return null;

    }

}
