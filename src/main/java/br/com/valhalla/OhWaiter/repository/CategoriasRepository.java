package br.com.valhalla.OhWaiter.repository;


import br.com.valhalla.OhWaiter.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
