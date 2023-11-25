/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DAO;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Amenidad;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IAmenidad {
    List<Amenidad> GetAll();
    Amenidad GetById (int idamenidadeditable);
}
