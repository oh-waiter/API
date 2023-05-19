package br.com.valhalla.controller;



import java.net.URI;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.valhalla.dto.AgendaDTO;
import br.com.valhalla.model.Agenda;
import br.com.valhalla.service.AgendaService;
import jakarta.validation.Valid;


@CrossOrigin("*")
@Validated
@RequestMapping("/agenda")
@RestController
public class AgendaController {
	
	@Autowired
	AgendaService service;
	
	
    public ResponseEntity<Agenda> agendarReserva(@Valid @RequestBody AgendaDTO Dto) {
        Agenda agenda = new Agenda();
        BeanUtils.copyProperties(Dto, agenda);
        service.create(agenda);
        return new ResponseEntity<>(agenda, HttpStatus.CREATED);
    }
    @PostMapping
	public ResponseEntity<Agenda>create(@Valid @RequestBody Agenda obj){
    	Agenda agenda = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getID()).toUri();
		return ResponseEntity.created(uri).body(agenda);
	}
		
}

