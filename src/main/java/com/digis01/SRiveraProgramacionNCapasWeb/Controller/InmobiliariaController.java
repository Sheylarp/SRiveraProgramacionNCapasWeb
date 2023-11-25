/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.AmenidadDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.AntiguedadDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.InmuebleDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.MonedaDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.OperacionDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.ServicioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.TipoInmuebleDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.UnidadDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Amenidad;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Antiguedad;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Inmueble;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Moneda;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Operacion;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Servicio;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Unidad;
import com.digis01.SRiveraProgramacionNCapasWeb.Util.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    private InmuebleDAOImplementation inmuebleDAOImplementation;
    private AntiguedadDAOImplementation antiguedadDAOImplementation;
    private MonedaDAOImplementation monedaDAOImplementation;
    private UnidadDAOImplementation unidadDAOImplementation;
    private AmenidadDAOImplementation amenidadDAOImplementation;
    private OperacionDAOImplementation operacionDAOImplementation;

    public InmobiliariaController(
            TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation,
            ServicioDAOImplementation servicioDAOImplementation,
            InmuebleDAOImplementation inmuebleDAOImplementation,
            AntiguedadDAOImplementation antiguedadDAOImplementation,
            MonedaDAOImplementation monedaDAOImplementation,
            UnidadDAOImplementation unidadDAOImplementation,
            AmenidadDAOImplementation amenidadDAOImplementation,
            OperacionDAOImplementation operacionDAOImplementation
    ) {
        this.tipoInmuebleDAOImplementation = tipoInmuebleDAOImplementation;
        this.servicioDAOImplementation = servicioDAOImplementation;
        this.inmuebleDAOImplementation = inmuebleDAOImplementation;
        this.antiguedadDAOImplementation = antiguedadDAOImplementation;
        this.monedaDAOImplementation = monedaDAOImplementation;
        this.unidadDAOImplementation = unidadDAOImplementation;
        this.amenidadDAOImplementation = amenidadDAOImplementation;
        this.operacionDAOImplementation = operacionDAOImplementation;
    }

    @GetMapping("/listado")
    public String listaTipoInmueble(Model model) {
        TipoInmueble tipoInmueble = new TipoInmueble();
        List<TipoInmueble> tipoInmuebles = tipoInmuebleDAOImplementation.GetAll();
        model.addAttribute("tipoInmuebles", tipoInmuebles);
        List<Servicio> servicios = servicioDAOImplementation.GetAll();
        model.addAttribute("servicios", servicios);
        List<Amenidad> amenidades = amenidadDAOImplementation.GetAll();
        model.addAttribute("amenidades", amenidades);
        List<Operacion> operaciones = operacionDAOImplementation.GetAll();
        model.addAttribute("operaciones", operaciones);
        return "listadoInmobiliaria";
    }

    @PostMapping("/listado")
    private String Lista(Model model, @ModelAttribute("inmueblebusqueda") Inmueble inmueblebusqueda) {
        List<Inmueble> inmuebles = inmuebleDAOImplementation.GetAll(inmueblebusqueda);
        model.addAttribute("inmuebles", inmuebles);
        model.addAttribute("inmueblebusqueda", inmueblebusqueda);
        return "listadoInmobiliaria";

    }
//    @GetMapping("/form/{idinmueble}")
//    public String Form(@PathVariable int idinmueble, Model model) {
//        List<Antiguedad> antiguedades = antiguedadDAOImplementation.GetAll();
//        model.addAttribute("antiguedades", antiguedades);
//        List<Moneda> monedas=monedaDAOImplementation.GetAll();
//        model.addAttribute("monedas", monedas);
//        List<Unidad> unidades=unidadDAOImplementation.GetAll();
//        model.addAttribute("unidades", unidades);
//        List<TipoInmueble> tipoinmueble=tipoInmuebleDAOImplementation.GetAll();
//        model.addAttribute("tipoinmuebles", tipoinmueble);
//        if (idinmueble == 0) {
//            model.addAttribute("imuebles", new Inmueble());
//            return "FormImobiliaria";
//        } else {
//            Inmueble inmueble = inmuebleDAOImplementation.GetById(idinmueble);
//            model.addAttribute("imuebles", inmueble);
//            return "FormImobiliaria";
//        }
//    }
//    
//    @PostMapping("form")
//    public String Form(@ModelAttribute("inmueble") Inmueble inmueble, 
//            @RequestParam("imagenFile") MultipartFile imagenFile,
//            Model model) {   
////        Util util=new Util();
////        util.codificarImagen(imagenFile,inmueble);
//         if(inmueble.getIdinmueble() == 0) {      
//            inmuebleDAOImplementation.Add(inmueble);
//            return "redirect:/imobiliaria/listado";
//        } else {
//            inmuebleDAOImplementation.Update(inmueble);
//            return "redirect:/imobiliaria/listado";
//        }
//    }
//
////    @GetMapping("/form/{idinmueble}")
////    public String Form(@PathVariable int idinmueble, Model model) {
////        model.addAttribute("tipoinmuebles", tipoInmuebleDAOImplementation.GetAll());
////        model.addAttribute("servicios", servicioDAOImplementation.GetAll());
////        model.addAttribute("amenidades", amenidadDAOImplementation.GetAll());
////        model.addAttribute("operaciones", operacionDAOImplementation.GetAll());
////        if (idinmueble == 0) {
////            model.addAttribute("imuebles", new Inmueble());
////            return "FormImobiliaria";
////        } else {
////            Inmueble inmueble = inmuebleDAOImplementation.GetById(idinmueble);
////            model.addAttribute("imueble", inmueble);
////            return "formInmueble";
////        }
////    }
////
////
////    @PostMapping("/form")
////    public String Form(@ModelAttribute("inmueble") Inmueble inmueble,
////            Model model) {
////        if (inmueble.getIdinmueble() == 0) {
////            inmuebleDAOImplementation.Add(inmueble);
////            return "redirect:/imobiliaria/listado";
////        } else {
////            inmuebleDAOImplementation.Update(inmueble);
////            return "redirect:/imobiliaria/listado";
////        }
////    }
//
////   
//     @GetMapping("/eliminaInmueble/{idinmueble}")
//    public String Delete(@PathVariable int idinmueble, Model model) {
//        inmuebleDAOImplementation.Delete(idinmueble);
//            return "redirect:/imobiliaria/listado";
//        }

}
