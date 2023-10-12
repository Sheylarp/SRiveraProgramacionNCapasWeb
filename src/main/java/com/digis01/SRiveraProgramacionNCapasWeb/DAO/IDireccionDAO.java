/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Direccion;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IDireccionDAO {
  List <Direccion> GetAll();
Direccion GetByIdUsuario (int idUsuario);
void Add (Direccion direccion);
  
}
