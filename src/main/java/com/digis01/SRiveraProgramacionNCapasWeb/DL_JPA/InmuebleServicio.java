/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

/**
 *
 * @author digis
 */
public class InmuebleServicio {

    private Inmueble inmueble;
    private Servicio servicio;

    public InmuebleServicio() {
    }

    public InmuebleServicio(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public InmuebleServicio(Inmueble inmueble, Servicio servicio) {
        this.inmueble = inmueble;
        this.servicio = servicio;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}
