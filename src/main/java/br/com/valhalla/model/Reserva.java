package br.com.valhalla.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservaID;

    @Column(name = "SituacaoReserva", nullable = false, length = 20)
    private String situacaoReserva;


    @ManyToOne
    @JoinColumn(name = "ClienteID")
    private Cliente nomeCliente;
}
