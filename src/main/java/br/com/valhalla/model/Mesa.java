package br.com.valhalla.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mesa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesaID;

    @Column(name = "QuantidadeAssentos", nullable = false, length = 20)
    private int quantidadeAssentos;

    @Column(name = "TaxaDeReserva", nullable = false, length = 20)
    private Double disponibilidadeMesa;

    @ManyToOne
    @JoinColumn(name = "ReservaID")
    private Reserva reservaID;
}
