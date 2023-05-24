package br.com.valhalla.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
