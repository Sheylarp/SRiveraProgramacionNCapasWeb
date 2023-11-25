/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

/**
 *
 * @author digis
 */
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Inmueble implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idinmueble;
    @Basic
    private String nombre;
    private String descripcion;
    private int precio;
    private int numerorecamaras;
    private int numerobanios;
    private int numeroestacionamientos;
    private int superficie;
    private int latitud;
    private int longitud;
    @OneToOne
    @JoinColumn(name = "idantiguedad")
    private Antiguedad antiguedad;
    @OneToOne
    @JoinColumn(name = "idmoneda")
    private Moneda moneda;
    @OneToOne
    @JoinColumn(name = "idunidad")
    private Unidad unidad;
    @OneToOne
    @JoinColumn(name = "idtipoinmueble")
    private TipoInmueble tipoinmueble;
    @Lob
    private String imagen;

    public Inmueble() {
    }

    public Inmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public Inmueble(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public Inmueble(int idinmueble, String nombre, String descripcion, int precio, int numerorecamaras, int numerobanios, int numeroestacionamientos, int superficie, int latitud, int longitud, Antiguedad antiguedad, Moneda moneda, Unidad unidad, TipoInmueble tipoinmueble, String imagen) {
        this.idinmueble = idinmueble;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.numerorecamaras = numerorecamaras;
        this.numerobanios = numerobanios;
        this.numeroestacionamientos = numeroestacionamientos;
        this.superficie = superficie;
        this.latitud = latitud;
        this.longitud = longitud;
        this.antiguedad = antiguedad;
        this.moneda = moneda;
        this.unidad = unidad;
        this.tipoinmueble = tipoinmueble;
        this.imagen = imagen;
    }

    public int getIdinmueble() {
        return idinmueble;
    }

    public void setIdinmueble(int idinmueble) {
        this.idinmueble = idinmueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getNumerorecamaras() {
        return numerorecamaras;
    }

    public void setNumerorecamaras(int numerorecamaras) {
        this.numerorecamaras = numerorecamaras;
    }

    public int getNumerobanios() {
        return numerobanios;
    }

    public void setNumerobanios(int numerobanios) {
        this.numerobanios = numerobanios;
    }

    public int getNumeroestacionamientos() {
        return numeroestacionamientos;
    }

    public void setNumeroestacionamientos(int numeroestacionamientos) {
        this.numeroestacionamientos = numeroestacionamientos;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

  

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Antiguedad antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public TipoInmueble getTipoinmueble() {
        return tipoinmueble;
    }

    public void setTipoinmueble(TipoInmueble tipoinmueble) {
        this.tipoinmueble = tipoinmueble;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

   

}
