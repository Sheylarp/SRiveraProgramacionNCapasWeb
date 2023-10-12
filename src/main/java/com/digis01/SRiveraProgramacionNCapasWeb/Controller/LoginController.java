/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author digis
 */
@Controller
public class LoginController {
    
    @GetMapping("/")
    public String HolaMundo(@RequestParam(name = "name", required = false, 
            defaultValue = "Digis01") String name, Model model){
        
         
        model.addAttribute("name", name);  //modelo 
        
        return "login";
    }
    

    
}
