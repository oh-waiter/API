package br.com.valhalla.OhWaiter.resource;

import br.com.valhalla.OhWaiter.model.Cardapio;
import br.com.valhalla.OhWaiter.services.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cardapio")
@RestController
public class CardapioResources {

    @Autowired
    private CardapioService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cardapio buscarItem(@PathVariable Long id){
        return service.buscarItemPorID(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cardapio> buscarTodosOsItens(){
        return service.buscarTodosOsItens();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cardapio CadastrarItemCardapio(@RequestBody Cardapio caradapio){
        return service.itemCardapio(caradapio);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cardapio UpdateItem(@RequestBody Cardapio cardapio){
        return service.alterarItemCardapio(cardapio);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> DeleteItemCardapio(@PathVariable Long id){
        service.deletarItemPorId(id);
        return ResponseEntity.noContent().build();
    }

}
