package br.com.valhalla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @Column(name = "CustoProduto", nullable = false, length = 10)
    @NotNull(message = "O custo do produto é obrigatório")
    private String custoProduto;

    @Column(name="ImagemProduto", nullable = false, length = 100)
    private String imagemProduto;

    @Column(name = "TempoEspera", nullable = false, length = 20)
    @NotNull(message = "O tempo de produto é obrigatório")
    private String tempoEspera;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoriaID")
    private Categorias categorias;




}
