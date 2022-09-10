/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.eggnews.controladores;

import com.egg.eggnews.excepciones.MiException;
import com.egg.eggnews.servicio.NoticiaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author marti
 */
@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/cargarNota")
    public String cargar() {

        return "noticias_cargar.html";

    }

    @PostMapping("/cargar")
    public String cargar(@RequestParam String titulo, @RequestParam String resumen,
            @RequestParam String parrafo) {

        try {
        
            noticiaServicio.crearNoticia(titulo, resumen, parrafo);
        
        } catch (MiException ex) {
           
            Logger.getLogger(NoticiaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "noticias_cargar.html";
        
        }

        return "noticias.html";
    }

}
