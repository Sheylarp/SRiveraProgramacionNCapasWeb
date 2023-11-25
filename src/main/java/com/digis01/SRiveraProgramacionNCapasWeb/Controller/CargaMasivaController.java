/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.SRiveraProgramacionNCapasWeb.Controller;

import com.digis01.SRiveraProgramacionNCapasWeb.DAO.InmuebleDAOImplementation;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Antiguedad;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Inmueble;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Moneda;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.TipoInmueble;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Unidad;
import com.digis01.SRiveraProgramacionNCapasWeb.DL_JPA.Usuario;
import com.digis01.SRiveraProgramacionNCapasWeb.Entity.ResultExcel;
import com.digis01.SRiveraProgramacionNCapasWeb.Entity.ResultTxt;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author digis
 */
@Controller
public class CargaMasivaController {


    @GetMapping("/CargaMasiva")
    public String CargaMasiva() {

        return "CargaMasiva";
    }

    @PostMapping("/CargaMasiva/Excel")
    public String CargaMasiva(Model model, @RequestParam("aexcel") MultipartFile aexcel,
            HttpSession session) throws IOException {
        //validar- tamaño
        if (aexcel != null && !aexcel.isEmpty()) {//&& !aexcel.isEmpty()
            //leer archivo,
//       StringUtils:conseguir extensiones     getOriginalFilename:nombre completo con extensiones
            String extension = StringUtils.getFilenameExtension(aexcel.getOriginalFilename());
            if (extension.equals("xlsx")) { //|| extension.equals("xls")
                //se crea método para Leer archivo y entrar a detalle
                List<Inmueble> inmuebles = LeerArchivoExcel(aexcel);
                //obtener la ruta
                String root = System.getProperty("user.dir");
                String path = "/src/main/resources/archivo/";
                //recupera el nombre con su extensión
                String fileName = aexcel.getOriginalFilename();
                //formato de la fecha 
                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                //concatenar
                String absolutePath = root + "/" + path + fecha + fileName;
                //guardar
                aexcel.transferTo(new File(absolutePath));

                //tamaño
                if (!inmuebles.isEmpty()) {
                    ResultExcel result = Validar(inmuebles);
                    if (!result.getErrores().isEmpty()) {
                        model.addAttribute("errores", result.getErrores());
                        return "CargaMasiva";
                    } else {
                        session.setAttribute("path", absolutePath);
                        return "CargaMasiva";
                    }

                }

            }

        }

        return "CargaMasiva";

    }

//   @PostMapping("/CargaMasiva/AddExcel")
//    public String AddExcel(HttpSession session) throws IOException {
//
//        String path = session.getAttribute("path").toString();
//        File file = new File(path);
//        FileInputStream input = new FileInputStream(file);
//
//        MultipartFile multipartFile = new MockMultipartFile(file.getName(), input);
//
//        List<Inmueble> inmuebles = LeerArchivoExcel(multipartFile);
//        for (Inmueble Inmueble : inmuebles) {
//            
//        }
//
//        return "CargaMasiva";
//    }
    public List<Inmueble> LeerArchivoExcel(MultipartFile aexcel) throws IOException {
        List<Inmueble> inmuebles = new ArrayList<Inmueble>();

        //convertir a un archivo de tipo excel:
        //libro excel
        XSSFWorkbook workbook = new XSSFWorkbook(aexcel.getInputStream());
        //hoja excel
        Sheet workSheet = workbook.getSheetAt(0);
        //fila | ignora la primera fila (nombres referencia)
        for (Row row : workSheet) {
            Inmueble inmueble = new Inmueble();
            inmueble.setNombre(row.getCell(0).toString());
            inmueble.setDescripcion(getCellValue(row, 1));
            TipoInmueble tipoInmueble = new TipoInmueble();
            tipoInmueble.setIdtipoinmueble((int) row.getCell(2).getNumericCellValue());
            inmueble.setTipoinmueble(tipoInmueble);
            inmueble.setPrecio((int) row.getCell(3).getNumericCellValue());
            Moneda moneda = new Moneda();
            moneda.setIdmoneda((int) row.getCell(4).getNumericCellValue());
            inmueble.setMoneda(moneda);
            Antiguedad antiguedad = new Antiguedad();
            antiguedad.setIdantiguedad((int) row.getCell(5).getNumericCellValue());
            inmueble.setAntiguedad(antiguedad);
            inmueble.setNumerorecamaras((int) row.getCell(6).getNumericCellValue());
            inmueble.setNumerobanios((int) row.getCell(7).getNumericCellValue());
            inmueble.setNumeroestacionamientos((int) row.getCell(8).getNumericCellValue());
            inmueble.setSuperficie((int) row.getCell(9).getNumericCellValue());
            Unidad unidad = new Unidad();
            unidad.setIdunidad((int) row.getCell(10).getNumericCellValue());
            inmueble.setUnidad(unidad);
            inmueble.setLatitud((int) row.getCell(11).getNumericCellValue());
            inmueble.setLongitud((int) row.getCell(12).getNumericCellValue());
//            inmueble.setImagen(row.getCell(13).toString());
            inmuebles.add(inmueble);
        }
        workbook.close();
        return inmuebles;
    }

    private String getCellValue(Row row, int cellIndex) {
        Cell cell = row.getCell(cellIndex);
        if (cell != null) {
            return cell.toString();
        } else {
            return "";
        }
    }

    public ResultExcel Validar(List<Inmueble> inmuebles) {

        ResultExcel resultPrincipal = new ResultExcel();
        resultPrincipal.setErrores(new ArrayList());
        int fila = 1;
        String errorMessage = "";
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getNombre().equals("")) {
                //errorMessage = errorMessage + ""; 
                errorMessage += "Falto Nombre";
            }
            if (inmueble.getDescripcion().equalsIgnoreCase("")) {
                errorMessage += "Falto Descripción";
            }
            errorMessage += (inmueble.getTipoinmueble().getIdtipoinmueble() == 0) ? "Falto idTipoInmueble" : "";
            errorMessage += (inmueble.getPrecio() == 0) ? "Faltó precio" : "";
            errorMessage += (inmueble.getMoneda().getIdmoneda() == 0) ? "Faltó idMoneda" : "";
            errorMessage += (inmueble.getAntiguedad().getIdantiguedad() == 0) ? "Faltó idAntiguedad" : "";
            errorMessage += (inmueble.getNumerorecamaras() == 0) ? "Faltó números de recámaras" : "";
            errorMessage += (inmueble.getNumerobanios() == 0) ? "Faltó números de baños" : "";
            errorMessage += (inmueble.getNumeroestacionamientos() == 0) ? "Faltó número de estacionamientos" : "";
            errorMessage += (inmueble.getSuperficie() == 0) ? "Faltó superficie" : "";
            errorMessage += (inmueble.getUnidad().getIdunidad() == 0) ? "Faltó idUnidad" : "";
            errorMessage += (inmueble.getLatitud() == 0) ? "Faltó longitud" : "";
            errorMessage += (inmueble.getLongitud() == 0) ? "Faltó longitud" : "";
//            errorMessage += (inmueble.getImagen().equals("")) ? "Faltó imagen" : "";
            if (!errorMessage.equals("")) { //Hubo un error
                ResultExcel resultExcel = new ResultExcel();
                resultExcel.setRow(fila);
                resultExcel.setErrorMessage(errorMessage);

                resultPrincipal.getErrores().add(resultExcel);
                errorMessage = "";
            }

            fila++;
            //fila = fila + 1;
        }
        return resultPrincipal;
    }

//  @PostMapping("/CargaMasiva/Txt")
//    public String CargaMasivatxt(Model model, @RequestParam("atxt") MultipartFile atxt, HttpSession sessiontxt) throws IOException {
//        if (atxt != null && !atxt.isEmpty()) {
//            String extension = StringUtils.getFilenameExtension(atxt.getOriginalFilename());
//            if (extension.equals("txt")) {
////                
//                String root = System.getProperty("user.dir");
//                String path = "/src/main/resources/archivo/";
//                String fileName = atxt.getOriginalFilename();
//                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//                String absolutePath = root + path + fecha + fileName;
//                atxt.transferTo(new File(absolutePath));
//                sessiontxt.setAttribute("path", absolutePath);
//            }
//        }
//
//        return "CargaMasiva";
//    }
//      @PostMapping("/CargaMasiva/Addtxt")
//    public String Txt(HttpSession sessiontxt) throws IOException {
//        Inmueble inmueble = new Inmueble();
//        String path = sessiontxt.getAttribute("path").toString();
//        File file = new File(path);
//        FileReader filereader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(filereader);
//        String fila = bufferedReader.readLine();
//        while ((fila = bufferedReader.readLine()) != null) {
//            String[] datos = fila.split("\\|");
//            inmueble.setNombre(datos[0]);
//            inmueble.setDescripcion(datos[1]);
//            TipoInmueble tipoinmueble = new TipoInmueble();
//            tipoinmueble.setIdtipoinmueble(Integer.parseInt(datos[2]));
//            inmueble.setTipoinmueble(tipoinmueble);
//            inmueble.setPrecio(Integer.parseInt(datos[3]));
//            Moneda modena = new Moneda();
//            modena.setIdmoneda(Integer.parseInt(datos[4]));
//            inmueble.setMoneda(modena);
//            Antiguedad antiguedad = new Antiguedad();
//            antiguedad.setIdantiguedad(Integer.parseInt(datos[5]));
//            inmueble.setAntiguedad(antiguedad);
//            inmueble.setNumerorecamaras(Integer.parseInt(datos[6]));
//            inmueble.setNumerobanios(Integer.parseInt(datos[7]));
//            inmueble.setNumeroestacionamientos(Integer.parseInt(datos[8]));
//            inmueble.setSuperficie(Integer.parseInt(datos[9]));
//            Unidad unidad = new Unidad();
//            unidad.setIdunidad(Integer.parseInt(datos[10]));
//            inmueble.setUnidad(unidad);
//            inmueble.setLatitud(Integer.parseInt(datos[11]));
//            inmueble.setLongitud(Integer.parseInt(datos[12]));
//          
//            
//       
////            InmuebleDAOImplementation.Add(inmueble);
//            
//        }
//
//        return "CargaMasiva";
//    }
    @PostMapping("/CargaMasiva/Txt")
    private List<Inmueble> LeerArchivoTxt(Object atxt) {
        List<Inmueble> inmuebles = new ArrayList();
        InputStream is = null;
        try {
            if (atxt instanceof MultipartFile) {
                MultipartFile multipartFile = (MultipartFile) atxt;
                is = multipartFile.getInputStream();
            } else if (atxt instanceof String) {
                String filePath = (String) atxt;
                File file = new File(filePath);
                is = new FileInputStream(file);
            }

            if (is != null) {
                try (InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader br = new BufferedReader(reader)) {

                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] valores = line.split(",");

                        if (valores.length >= 13) {
                            Inmueble inmueble = new Inmueble();
                            inmueble.setNombre(valores[0].trim());
                            inmueble.setDescripcion(valores[1].trim());
                            TipoInmueble tipoInmueble = new TipoInmueble();
                            tipoInmueble.setIdtipoinmueble(Integer.parseInt(valores[2].trim()));
                            inmueble.setTipoinmueble(tipoInmueble);
                            inmueble.setPrecio((int) Double.parseDouble(valores[3].trim()));
                            Moneda moneda = new Moneda();
                            moneda.setIdmoneda(Integer.parseInt(valores[4].trim()));
                            inmueble.setMoneda(moneda);
                            Antiguedad antiguedad = new Antiguedad();
                            antiguedad.setIdantiguedad(Integer.parseInt(valores[5].trim()));
                            inmueble.setAntiguedad(antiguedad);
                            inmueble.setNumerorecamaras(Integer.parseInt(valores[6].trim()));
                            inmueble.setNumerobanios(Integer.parseInt(valores[7].trim()));
                            inmueble.setNumeroestacionamientos(Integer.parseInt(valores[8].trim()));
                            inmueble.setSuperficie((int) Double.parseDouble(valores[9].trim()));
                            Unidad unidad = new Unidad();
                            unidad.setIdunidad(Integer.parseInt(valores[10].trim()));
                            inmueble.setUnidad(unidad);
                            inmueble.setLatitud((int) Double.parseDouble(valores[11].trim()));
                            inmueble.setLongitud((int) Double.parseDouble(valores[12].trim()));

                            inmuebles.add(inmueble);
                        }
                    }
                }
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inmuebles;
    }
}
