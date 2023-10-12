/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.restController;

import com.digis01.SRiveraProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.SRiveraProgramacionNCapasWeb.Entity.Resultado;
import com.digis01.SRiveraProgramacionNCapasWeb.Service.DemoServiceImplementation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping ("/demoApi")
public class DemoConroller {
    
    @PostMapping("/suma")
    public Resultado suma (@RequestBody NumerosOperacion numeros){
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Suma(numeros);
    }
    
    @PostMapping ("/resta")
    public Resultado resta (@RequestBody NumerosOperacion numerosOperacion){
        DemoServiceImplementation demoServiceImplementation =new DemoServiceImplementation();
        return demoServiceImplementation.Rresta(numerosOperacion);
    }
    @PostMapping ("/mult")
    public Resultado mult(@RequestBody NumerosOperacion numerosOperacion){
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Multiplicacion(numerosOperacion);
    }
    @PostMapping ("/div")
    public Resultado div (@RequestBody NumerosOperacion numerosOperacion){
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
    
        return demoServiceImplementation.Division(numerosOperacion);
    
    }
    
      @GetMapping("/hola")
    public Map <String, Object> HolaMundo (){
       Map <String, Object> response =new HashMap<>();
       response.put("Hola", "Mundo Terricola");
        return response;
    }
}
