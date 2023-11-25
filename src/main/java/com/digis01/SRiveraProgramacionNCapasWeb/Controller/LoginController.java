/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.EmailDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DAO.UsuarioDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Login;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import jakarta.validation.constraints.Email;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author digis
 */
@Controller
public class LoginController {

    private EmailDAOImplementation emailDAOImplementation;
    private UsuarioDAOImplementation usuarioDAOImplementation;

    public LoginController(EmailDAOImplementation emailDAOImplementation,
            UsuarioDAOImplementation usuarioDAOImplementation) {
        this.emailDAOImplementation = emailDAOImplementation;
        this.usuarioDAOImplementation = usuarioDAOImplementation;
    }

//    @GetMapping("/")
//    public String HolaMundo(@RequestParam(name = "name", required = false,
//            defaultValue = "Digis01") String name, Model model) {
//
//        model.addAttribute("name", name);  //modelo 
//
//        return "login";
//    }
    @GetMapping("/")

    public String Login(Model model, HttpSession session) {
        Usuario usuario = new Usuario();
         session.setAttribute("Usuario", usuario);
        model.addAttribute("usuario", new Usuario());
//        model.addAttribute("usuarioNuevo", new Usuario());

//        model.addAttribute("email", new Login());
        return "login";
    }

    @PostMapping("/")
    public String Login(Model model, @ModelAttribute Usuario usuario) {
        try {
            Usuario usuariologin = usuarioDAOImplementation.GetByEmail(usuario);
//        model.addAttribute("usuario", usuario);
            if (usuariologin == null) {
                model.addAttribute("Error", "Error de correo y/o contraseña");
                return "login";
            } else {
                if (usuariologin.getPassword().equals(usuario.getPassword())) {
                    model.addAttribute("Success", "Inicio de sesión exitoso");
                    return "redirect:/usuario/listado";
                } else {
                    model.addAttribute("Error", "Error de correo y/o contraseña");
                    return "login";
                }
            }}
              catch (Exception e){
                e.printStackTrace();
        model.addAttribute("Error", "Ocurrió un error al iniciar sesión. Por favor, inténtalo nuevamente.");
        return "login";
                }
       
          
        }

    }

