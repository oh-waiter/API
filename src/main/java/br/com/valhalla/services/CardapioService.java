package br.com.valhalla.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.valhalla.model.Cardapio;
import br.com.valhalla.repository.CardapioRepository;

public class CardapioService {

    private CardapioRepository cardapioRepository;

    @Autowired
    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public Cardapio itemCardapio(Cardapio cardapio) {
        return cardapioRepository.save(cardapio);

    }

    public Cardapio buscarItemPorID(Long id) {

        return cardapioRepository.findById(id).orElse(null);

    }

    public List<Cardapio> buscarTodosOsItens() {

        return cardapioRepository.findAll();

    }


    public Cardapio alterarItemCardapio(Cardapio cardapio){
        Cardapio entity =
                cardapioRepository.findById(cardapio.getCardapioID()).orElseThrow(()->
                        new ResourceAccessException("Nenhum registro encontrado para este ID!"));
        entity.setNomeProduto(cardapio.getNomeProduto());
        entity.setDescricaoProdutos(cardapio.getDescricaoProdutos());
        entity.setCustoProduto(cardapio.getCustoProduto());
        entity.setImagemProduto(cardapio.getImagemProduto());
        entity.setTempoEspera(cardapio.getTempoEspera());
        entity.setCategorias(cardapio.getCategorias());
        return cardapioRepository.save(cardapio);
    }

    public void deletarItemPorId(Long id){
        Cardapio entity = cardapioRepository.findById(id).orElseThrow(()->
                new ResourceAccessException("Nenhum registro encontrado para este ID!"));
        cardapioRepository.delete(entity);
    }

}
