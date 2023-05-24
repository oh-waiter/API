package br.com.valhalla.resource;

import java.util.List;
import java.util.stream.Collectors;

import br.com.valhalla.model.Categorias;
import br.com.valhalla.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.valhalla.model.Categorias;
import br.com.valhalla.services.CardapioService;


@RestController
@RequestMapping("/categorias")
public class CategoriasResources {

    @Autowired
    private CategoriasService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorias buscar(@PathVariable Long id){
        return service.buscarCategoriasID(id);
    }


}
