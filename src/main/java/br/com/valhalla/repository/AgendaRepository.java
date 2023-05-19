package br.com.valhalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.valhalla.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
