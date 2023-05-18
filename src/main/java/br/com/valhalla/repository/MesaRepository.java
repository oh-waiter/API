package br.com.valhalla.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.valhalla.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

    @Query(value = "SELECT MesaID FROM Mesa WHERE Mesa.MesaID IN :ids")
    List<Mesa> findByIdList(@Param("ids") Collection<Long> ids);

}
