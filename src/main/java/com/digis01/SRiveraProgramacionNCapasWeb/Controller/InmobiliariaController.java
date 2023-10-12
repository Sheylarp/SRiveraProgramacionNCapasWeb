/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.ServicioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.TipoInmuebleDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Servicio;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/inmobiliaria")
public class InmobiliariaController {

    @Autowired
    private TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation;
    private ServicioDAOImplementation servicioDAOImplementation;

    public InmobiliariaController(
            TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation,
            ServicioDAOImplementation servicioDAOImplementation
    ) {
        this.tipoInmuebleDAOImplementation = tipoInmuebleDAOImplementation;
        this.servicioDAOImplementation = servicioDAOImplementation;
    }

    @GetMapping("/listado")
    public String listaTipoInmueble(Model model) {
        TipoInmueble tipoInmueble = new TipoInmueble();
        List<TipoInmueble> tipoInmuebles = tipoInmuebleDAOImplementation.GetAll(tipoInmueble);
        model.addAttribute("tipoInmuebles", tipoInmuebles);
        
        return "listadoInmobiliaria";
    }
    @GetMapping ("/listadof")
    public String listadoServicio (Model model){
     Servicio servicio =new Servicio ();
      List <Servicio> servicios=servicioDAOImplementation.GetAll();
      model.addAttribute("servicios", servicios);
        return "listadoInmobiliaria";
    
    }

    @GetMapping("/form/{idtipoinmueble}")
    public String Form(@PathVariable int idtipoinmueble, @PathVariable int idservicio, Model model) {
        if (idtipoinmueble == 0) {
            model.addAttribute("tipoInmueble", new TipoInmueble());
            return "formTipoInmueble";
        } else{
        TipoInmueble tipoInmueble=tipoInmuebleDAOImplementation.GetById(idtipoinmueble);
        model.addAttribute("tipoInmueble", tipoInmueble);
        }
        if (idservicio==0) {
            model.addAttribute("servicios", new Servicio());
            return "formTipoInmueble";
            
        }
        return "formTipoInmueble";
    }
    
    @PostMapping ("form")
    public String Update (@ModelAttribute ("tipoInmueble")TipoInmueble tipoInmueble, Model model){
        if (tipoInmueble.getIdtipoinmueble()==0) {
            tipoInmuebleDAOImplementation.Update(tipoInmueble);
        } else{
        int idtipoInmueble = tipoInmuebleDAOImplementation.Add(tipoInmueble);
        }
        
    
        return null;
    
    }
    

    @GetMapping("/eliminar/{idtipoinmueble}")
    public String Delete(@PathVariable int idtipoinmueble, Model model) {
        tipoInmuebleDAOImplementation.Delete(idtipoinmueble);

        return "redirect:/inmobiliaria/listado";

    }

    @PostMapping("/deleteTipoInmueble")
    public String Delete(@ModelAttribute TipoInmueble tipoInmueble) {
        tipoInmuebleDAOImplementation.Delete(1);
        return "redirect:/inmobiliaria/listado";

    }

}
