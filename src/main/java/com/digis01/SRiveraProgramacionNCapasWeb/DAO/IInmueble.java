/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Inmueble;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IInmueble {
    
    List<Inmueble>GetAll(Inmueble inmuebe);
     int Add (Inmueble inmueble);
    void Update (Inmueble inmueble);
    Inmueble GetById (int idinmuebleeditable);
    void Delete (int idinmuebleeliminado);
    
}
