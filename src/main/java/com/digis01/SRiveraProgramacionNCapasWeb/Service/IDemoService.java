/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Service;

import com.digis01.SRiveraProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.SRiveraProgramacionNCapasWeb.Entity.Resultado;

/**
 *
 * @author digis
 */
public interface IDemoService {
    String HolaMundo (String HolaMundo);
  
    Resultado Suma (NumerosOperacion numero);
    Resultado Rresta (NumerosOperacion numerorest);
    Resultado Multiplicacion (NumerosOperacion numeromul);
    Resultado Division (NumerosOperacion numerosum);
    
}
