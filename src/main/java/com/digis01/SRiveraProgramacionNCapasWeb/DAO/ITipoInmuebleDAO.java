/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
import java.util.List;

/**
 *
 * @author digis
 */
public interface ITipoInmuebleDAO {
 List <TipoInmueble> GetAll(TipoInmueble tipoInmueble);   
 int Add(TipoInmueble tipoInmueble );
 void Update (TipoInmueble tipoInmueble);
 TipoInmueble GetById (int idtipoInmuebleeditable);
 void Delete (int idtipoInmuebleeliminado);
}
