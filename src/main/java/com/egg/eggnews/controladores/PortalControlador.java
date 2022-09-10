package com.egg.eggnews.controladores;

import com.egg.eggnews.servicio.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/")
    public String index() {

        return "noticias.html";
    }
}
