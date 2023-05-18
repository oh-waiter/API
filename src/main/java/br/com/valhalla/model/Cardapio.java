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

public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardapioID;

    @Column(name = "NomeProduto", nullable = false, length = 20)
    @NotNull(message = "O Nome do produto é obrigatório")
    private String nomeProduto;

    @Column(name = "DescricaoProduto", nullable = false, length = 100)
    @NotNull(message = "A descrição do produto é obrigatório")
    private String descricaoProdutos;

    @Column(name = "TempoEspera", nullable = false, length = 20)
    @NotNull(message = "O tempo de produto é obrigatório")
    private String tempoEspera;

    @Column(name = "CustoProduto", nullable = false)
    @NotNull(message = "O custo do produto é obrigatório")
    private String custoProduto;

}
