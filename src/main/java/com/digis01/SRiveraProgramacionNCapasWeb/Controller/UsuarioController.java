/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.ColoniaDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.MunicipioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.PaisDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.RolDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.TipoInmuebleDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Colonia;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Direccion;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Estado;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Municipio;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Rol;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.UsuarioDireccion;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.DeleteExchange;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAOImplementation usuarioDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private RolDAOImplementation rolDAOImplementation;
    private PaisDAOImplementation paisDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;
    private MunicipioDAOImplementation municipioDAOImplementation;
    private ColoniaDAOImplementation coloniaDAOImplementation;
    private TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation;

    @Autowired  //Habilita inyección automática de dependencias 
    public UsuarioController(UsuarioDAOImplementation usuarioDAOImplementation,
            DireccionDAOImplementation direccionDAOImplementation,
            RolDAOImplementation rolDAOImplementation,
            PaisDAOImplementation paisDAOImplementation,
            EstadoDAOImplementation estadoDAOImplementation,
            MunicipioDAOImplementation municipioDAOImplementation,
            TipoInmuebleDAOImplementation tipoInmuebleDAOImplementation,
            ColoniaDAOImplementation coloniaDAOImplementation
    ) {
        this.usuarioDAOImplementation = usuarioDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.rolDAOImplementation = rolDAOImplementation;
        this.paisDAOImplementation = paisDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
        this.municipioDAOImplementation = municipioDAOImplementation;
        this.tipoInmuebleDAOImplementation = tipoInmuebleDAOImplementation;
        this.coloniaDAOImplementation = coloniaDAOImplementation;
    }

//    //listado
//    @GetMapping("/listado")                                         //recuperar inf.
//    private String listadoUsuarios(Model model, @ModelAttribute ("usuariobusqueda")Usuario usuario) {
//        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); // recuperación de datos
//        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
//        model.addAttribute("usuariobusqueda", new Usuario());
////        List<Direccion> direcciones =direccionDAOImplementation.GetAll();
////        model.addAttribute("usuarios", usuarios);
//        return "listadoUsuarios";
//
//    }
    //listado
    @GetMapping("/listado")
    private String listadoUsuarios(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre(""); //Valor vacío
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuario); // recuperación de datos
        model.addAttribute("usuarios", usuarios); //envío de datos para HTML
        model.addAttribute("usuariobusqueda", new Usuario());

        return "listadoUsuarios";

    }

    @PostMapping("/listado")
    private String listadoUsuarios(Model model, @ModelAttribute("usuariobusqueda") Usuario usuariobusqueda) {
        List<Usuario> usuarios = usuarioDAOImplementation.GetAll(usuariobusqueda);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuariobusqueda", usuariobusqueda);
        return "listadoUsuarios";

    }

    @GetMapping("/form/{idusuario}")
    public String Form(@PathVariable int idusuario, Model model) {
//        List<Rol> roles = rolDAOImplementation.GetAll();
//        model.addAttribute("roles", roles);
        model.addAttribute("roles", rolDAOImplementation.GetAll());
        model.addAttribute("paises", paisDAOImplementation.GetAll());
        model.addAttribute("estado", estadoDAOImplementation.GetAll());
        model.addAttribute("municipios", municipioDAOImplementation.GetAll());
        model.addAttribute("colonias", coloniaDAOImplementation.GetAll());

        if (idusuario == 0) { //ADD
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formUsuarioEditable";
        } else { //UPDATE

            Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
            model.addAttribute("usuario", usuario);
            UsuarioDireccion usuarioDireccion = new UsuarioDireccion();
            usuarioDireccion.setUsuario(usuarioDAOImplementation.GetById(idusuario));
            usuarioDireccion.setDireccion(direccionDAOImplementation.GetByIdUsuario(idusuario));
            model.addAttribute("usuarioDireccion", usuarioDireccion);
            if (usuarioDireccion.getDireccion().getColonia() !=null){
            model.addAttribute("estados", estadoDAOImplementation.GetByIdPais(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
            }
            model.addAttribute("municipios", municipioDAOImplementation.GetByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
            model.addAttribute("colonias", coloniaDAOImplementation.GetByIdMunicipio(usuarioDireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));    
            return "formUsuarioEditable";
        }
    }
//
    // VALIDACIÓN CON INFORMACIÓN DEL CLIENTE
//    @PostMapping("/form")
//    public String Update(@ModelAttribute UsuarioDireccion usuarioDireccion) {
//        // actualización
//        Rol rol = new Rol();
//        rol.setIdrol(1);
//        usuarioDireccion.getUsuario().setRol(rol);
//        if (usuarioDireccion.getUsuario().getIdusuario() > 0) { //UPDATE
//           usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
//        } else {
//       int idUsuario= usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());
//        usuarioDireccion.direccion.setIddireccion(idUsuario);
//       direccionDAOImplementation.Add(usuarioDireccion.direccion);
//        }
//
//        return "redirect:/usuario/listado";
//    }

    // VALIDACIÓN CON CLIENTE Y SERVIDOR
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuarioDireccion,
            BindingResult bindingResult,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            Model model) {
        // actualización
        if (bindingResult.hasErrors()) {
            model.addAttribute("usuariodireccion", usuarioDireccion);
            return "formUsuarioEditable";
        }
        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                String imagenBase64 = Base64.encodeBase64String(bytes);
                usuarioDireccion.getUsuario().setImagen(imagenBase64);
            } else {
                usuarioDireccion.getUsuario().setImagen(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //img
        // @RequestParam ("imagenFile") MultipartFile imagenFile

        if (usuarioDireccion.getUsuario().getIdusuario() > 0) { //UPDATE
            usuarioDAOImplementation.Update(usuarioDireccion.getUsuario());
        } else {
            int idUsuario = usuarioDAOImplementation.Add(usuarioDireccion.getUsuario());
            usuarioDireccion.direccion.setIddireccion(idUsuario);
            direccionDAOImplementation.Add(usuarioDireccion.direccion);
        }

        return "redirect:/usuario/listado";
    }

//    @GetMapping("/add")
//    public String Add(Model model) {
//        model.addAttribute("usuario", new Usuario());
////     model.addAttribute("usuario", DateTimeForma);
//        return "formUsuario";
//    }
//
//    @PostMapping("addusuario")
//    public String Add(@ModelAttribute Usuario usuario) {
//        usuarioDAOImplementation.Add(usuario);
//        return "redirect:/usuario/listado";
//
//    }
//    @GetMapping("/editarUsuario/{idusuario}")
//    public String Update(@PathVariable int idusuario, Model model) {
//        Usuario usuario = usuarioDAOImplementation.GetById(idusuario);
//        model.addAttribute("usuario", usuario);
//        return "fromUsuarioEditable";
//    }
//
//    @PostMapping("/updateUsuario")
//    public String Upate(@ModelAttribute Usuario usuario) {
//        Rol rol = new Rol();
//        rol.setIdrol(1);
//        usuario.setRol(rol);
//        usuarioDAOImplementation.Update(usuario);
//        return "redirect:/usuario/listado";
//
//    }
//   @GetMapping("/eliminarUsuario/{idusuario}")
//    public String Delete(@PathVariable int idusuario, Model model) {
//       Usuario usuario =  usuarioDAOImplementation.Delete(idusuario);
//       model.addAttribute("usuario", usuario);
//       
//        return "redirect:/usuario/listad";
//    }
    @GetMapping("/eliminarUsuario/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model
    ) {
//        Usuario usuario = usuarioDAOImplementation.Delete(idusuario);
//        model.addAttribute("usuario", usuario);
        usuarioDAOImplementation.Delete(idusuario);
        return "redirect:/usuario/listado";
    }

    @PostMapping("/deleteUsuario")
    public String Delete(@ModelAttribute Usuario usuario
    ) {
        Rol rol = new Rol();
        rol.setIdrol(1);
        usuario.setRol(rol);
        usuarioDAOImplementation.Delete(1);
        return "redirect:/usuario/listado";

    }

//    @GetMapping(value = "/eliminar")
////  @RequestParam:  pasar datos de la petición al método que maneja la solicitud
//    public String Delete(@RequestParam(value = "idusuario") Integer idusuario) {
//        usuarioDAOImplementation.Delete(idusuario);
//
//        return "redirect:/usuario/listado";
//    }
    @GetMapping("/GetEstadoByIdPais")
    @ResponseBody
    public List<Estado> GetEstadoByIdPais(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = estadoDAOImplementation.GetByIdPais(IdPais);
        return estados;
    }

    @GetMapping("/GetMunicipioByIdEstado")
    @ResponseBody
    public List<Municipio> GetMunicipioByIdEstado(@RequestParam("IdEstado") int idEstado) {
        List<Municipio> municipios = municipioDAOImplementation.GetByIdEstado(idEstado);
        return municipios;

    }

    @GetMapping("/GetMunicipioByIdColonia")
    @ResponseBody
    public List<Colonia> GetMunicipioByIdColonia(@RequestParam("idMunicipio") int idMunicipio) {
        List<Colonia> colonias = coloniaDAOImplementation.GetByIdMunicipio(idMunicipio);

        return colonias;

    }

    //status
   @GetMapping("/ChangeStatus")
    @ResponseBody
    public void ChangeStatus(@RequestParam("idUsuario") int idUsuario, @RequestParam("status") boolean status) {
       usuarioDAOImplementation.ChangeStatus(idUsuario, status);
    }

  

}

