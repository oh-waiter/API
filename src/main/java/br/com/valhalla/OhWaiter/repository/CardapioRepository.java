package br.com.valhalla.OhWaiter.repository;

import br.com.valhalla.OhWaiter.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio,Long>{

}
