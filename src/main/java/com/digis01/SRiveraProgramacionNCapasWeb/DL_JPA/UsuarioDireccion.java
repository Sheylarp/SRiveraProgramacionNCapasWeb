/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA;

//import jakarta.persistence.Entity;

import jakarta.validation.Valid;

/**
 *
 * @author digis
 */
// En este caso, UsuarioDireccion no es una entidad. Solo la usamos para manipular la informacion de usuario y dirección
//@Entity
public class UsuarioDireccion {
    
    @Valid
    private Usuario usuario;
    @Valid
    public Direccion direccion;

    public UsuarioDireccion() {
    }

    public UsuarioDireccion(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDireccion(Usuario usuario, Direccion direccion) {
        this.usuario = usuario;
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
}
