package br.com.valhalla.resource;

import java.util.List;
import java.util.stream.Collectors;

import br.com.valhalla.model.Categorias;
import br.com.valhalla.resource.DTO.CategoriasDTO;
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

import javax.print.attribute.standard.Media;


@RestController
@RequestMapping("/categorias")
public class CategoriasResources {

    @Autowired
    private CategoriasService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorias buscar(@PathVariable Long id){
        return service.buscarCategoriasID(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List <CategoriasDTO>> buscarTodoas(){
        List<Categorias> list = service.buscarCategorias();
        List<CategoriasDTO> listDTO = list.stream().map(obj -> new CategoriasDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorias Cadastrar(@RequestBody Categorias categorias){
        return service.salvarCategoria(categorias);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorias Alterar(@RequestBody Categorias categorias){
        return service.alterarCategoria(categorias);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> Apagar(@PathVariable Long id){
        service.deletarCategorias(id);
        return ResponseEntity.noContent().build();
    }


}
