/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IUsuarioDAO {
    //firma de metodo 
    // tipo de retorno, nombre del método, parámetros
    List<Usuario> GetAll(Usuario usuario);
    
      int Add(Usuario usuario);
      
     void Update (Usuario usuario);
     
     Usuario GetById (int idusuarioeditable);
     
     void Delete (int idusuarioeliminado);
     
     void ChangeStatus (int idUsuario, boolean status);
     
    
}

