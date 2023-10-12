/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Util;

import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.UsuarioDireccion;
import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author digis
 */
public class util  {
    
    public static void codificarImagen ( @RequestParam("imagenFile") MultipartFile imagenFile,
         UsuarioDireccion usuarioDireccion   ) {
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

    }
        
}
