/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

/**
 *
 * @author digis
 */
//manipular la informacion
public class InmuebleAmenidad {

    private Inmueble inmueble;
    private Amenidad amenidad;

    public InmuebleAmenidad() {
    }

    public InmuebleAmenidad(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public InmuebleAmenidad(Inmueble inmueble, Amenidad amenidad) {
        this.inmueble = inmueble;
        this.amenidad = amenidad;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Amenidad getAmenidad() {
        return amenidad;
    }

    public void setAmenidad(Amenidad amenidad) {
        this.amenidad = amenidad;
    }

}
