package br.com.valhalla.model;

import java.util.List;

import jakarta.persistence.*;
;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="categorias")

public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaID;

    private String nomeCategoria;
    @OneToMany(mappedBy = "categoria")
    private List<Cardapio> cardapios;

}
