/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.restController;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity < List<Usuario>> GetAll(Usuario usuario) {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario);
        if (usuario!=null) {
            return ResponseEntity.ok(this.usuarioDAOImplementation.GetAll(usuario));
        } else {
        return ResponseEntity.notFound().build();
        }
//        return usuarioDAOImplementation.GetAll(usuario);
//        return "usuario:"+usuarios;       
//        return usuarios;
    }

    @GetMapping("/GetById/{idusuario}")
    public ResponseEntity < Usuario> GetById(@PathVariable("idusuario") int idusuario) {
        Usuario usuarios = usuarioDAOImplementation.GetById(idusuario);
        if (usuarios!=null) {
            return ResponseEntity.ok(this.usuarioDAOImplementation.GetById(idusuario));
        }else {
        return ResponseEntity.notFound().build();
        }
//        return usuarios;
//        return usuarioDAOImplementation.GetById(idusuario);
    }

    @PostMapping ("/add")

    public ResponseEntity <String> Add (@RequestBody Usuario usuario){
//        usuarioDAOImplementation.Add(usuario);
       int idUsuario = usuarioDAOImplementation.Add(usuario);
       
        
        return null;
    
    }
    
    @DeleteMapping ("/delete/{idusuario}")
    public ResponseEntity <String> Delete (@PathVariable int idusuario){
        usuarioDAOImplementation.Delete(idusuario);
//        if (idusuario != null) {
//            
//        } else {
//        }
    
        return null;
    
    }
    
    
    
}
