package br.com.valhalla.OhWaiter.services;


import br.com.valhalla.OhWaiter.exceptions.ObjectNotFoundException;
import br.com.valhalla.OhWaiter.exceptions.ResourceNotFoundException;
import br.com.valhalla.OhWaiter.model.Categorias;
import br.com.valhalla.OhWaiter.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoria){
        this.categoriasRepository = categoria;
    }


    public Categorias salvarCategoria(Categorias categorias){
        return categoriasRepository.save(categorias);
    }


    public Categorias buscarCategoriasID(Long id){
        Optional<Categorias> obj = categoriasRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado para este ID!"));

    }

    public List<Categorias> buscarCategorias(){
        return categoriasRepository.findAll();
    }

    public Categorias alterarCategoria(Categorias categorias){
        Categorias entity = categoriasRepository.findById(categorias.getCategoriaID()).orElseThrow(
                () -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!")
        );

        entity.setNomeCategoria(categorias.getNomeCategoria());
        return categoriasRepository.save(categorias);
    }

    public void deletarCategorias(Long ID){
        Categorias entity = categoriasRepository.findById(ID).orElseThrow(
                () -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
                categoriasRepository.delete(entity);
    }



}
