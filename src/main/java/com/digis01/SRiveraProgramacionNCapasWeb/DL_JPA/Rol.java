
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;


/**
 *
 * @author digis
 */
@Entity
public class Rol implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idrol;

@Basic
private String nombre;

    public Rol() {
    }


    public Rol(int idrol) {
        this.idrol = idrol;
    }

    public Rol(int idrol, String nombre) {
        this.idrol = idrol;
        this.nombre = nombre;
    }



    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
