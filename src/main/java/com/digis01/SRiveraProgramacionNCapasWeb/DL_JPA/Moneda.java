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

/**
 *
 * @author digis
 */
@Entity
public class Moneda {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idmoneda;
    @Basic
    private String nombre;

    public Moneda() {
    }

    public Moneda(int idmoneda) {
        this.idmoneda = idmoneda;
    }

    public Moneda(int idmoneda, String nombre) {
        this.idmoneda = idmoneda;
        this.nombre = nombre;
    }

    public int getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(int idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
    
}
