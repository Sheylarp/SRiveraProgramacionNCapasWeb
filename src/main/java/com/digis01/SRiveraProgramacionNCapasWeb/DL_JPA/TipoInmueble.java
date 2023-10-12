/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



/**
 *
 * @author digis
 */
@Entity
@Table(name="TIPOINMUEBLE")
public class TipoInmueble  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idtipoinmueble;
    @Basic
  private String nombre;

    public TipoInmueble() {
    }

    public TipoInmueble(int idtipoinmueble) {
        this.idtipoinmueble = idtipoinmueble;
    }

    public TipoInmueble(int idtipoinmueble, String nombre) {
        this.idtipoinmueble = idtipoinmueble;
        this.nombre = nombre;
    }

    public int getIdtipoinmueble() {
        return idtipoinmueble;
    }

    public void setIdtipoinmueble(int idtipoinmueble) {
        this.idtipoinmueble = idtipoinmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    
    
    
}
