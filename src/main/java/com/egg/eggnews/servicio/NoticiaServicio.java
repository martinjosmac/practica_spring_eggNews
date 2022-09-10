package com.egg.eggnews.servicio;

import com.egg.eggnews.entidades.Noticia;
import com.egg.eggnews.excepciones.MiException;
import com.egg.eggnews.repositorio.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public void crearNoticia(String titulo, String resumen, String parrafo) throws MiException {

        validar(titulo, resumen, parrafo);

        Noticia noticia = new Noticia();

        noticia.setTitulo(titulo);
        noticia.setResumen(resumen);
        noticia.setParrafo(parrafo);

        noticiaRepositorio.save(noticia);
    }

    public List<Noticia> listarNoticias() {

        List<Noticia> noticias = new ArrayList<>();

        noticias = noticiaRepositorio.findAll();

        return noticias;
    }

    public void modificarNoticia(String id, String titulo, String resumen, String parrafo) throws MiException {

        validar(titulo, resumen, parrafo);
        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setResumen(resumen);
            noticia.setParrafo(parrafo);

            noticiaRepositorio.save(noticia);
        }
    }

    private void validar(String titulo, String resumen, String parrafo) throws MiException {
        if (titulo == null) {
            throw new MiException("el titulo no puede ser nulo");
        }
        if (resumen == null) {
            throw new MiException("el resumen no puede ser nulo");

        }
        if (parrafo == null) {
            throw new MiException("el parrado no puede ser nulo");

        }

    }

}
