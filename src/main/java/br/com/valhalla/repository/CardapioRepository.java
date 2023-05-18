package br.com.valhalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio,Long>{

}
