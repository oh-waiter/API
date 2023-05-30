package br.com.valhalla.OhWaiter.resource;

import br.com.valhalla.OhWaiter.model.Categorias;
import br.com.valhalla.OhWaiter.resource.DTO.CategoriasDTO;
import br.com.valhalla.OhWaiter.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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
