/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Service;

import com.digis01.SRiveraProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.SRiveraProgramacionNCapasWeb.Entity.Resultado;

/**
 *
 * @author digis
 */

public class DemoServiceImplementation implements IDemoService{

    
     @Override
    public String HolaMundo( String HolaMundo) {
        return  HolaMundo;
    }

    @Override
    public Resultado Suma(NumerosOperacion numero) {
         return new Resultado (numero.getNumero1()+numero.getNumero2());
   }

    @Override
    public Resultado Rresta(NumerosOperacion numerorest) {
         return new Resultado(numerorest.getNumero1()-numerorest.getNumero2());
    }

    @Override
    public Resultado Multiplicacion(NumerosOperacion numeromul) {
         return new Resultado(numeromul.getNumero1()*numeromul.getNumero2());
    }

    @Override
    public Resultado Division(NumerosOperacion numerosum) {
        
         return new Resultado(numerosum.getNumero1()/numerosum.getNumero2());
        
    }
    
    
}
