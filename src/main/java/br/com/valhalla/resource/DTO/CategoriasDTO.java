package br.com.valhalla.resource.DTO;

import java.io.Serializable;

import br.com.valhalla.model.Categorias;

public class CategoriasDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long categoriaID;
    private String nomeCategoria;

    public CategoriasDTO(){}

    public CategoriasDTO(Categorias obj){
        super();
        categoriaID = obj.getCategoriaID();
        this.nomeCategoria= obj.getNomeCategoria();
    }


    public Long getCategoriaID(){
        return categoriaID;
    }

    public void setCategoriaID(Long categoriaID){
        categoriaID = categoriaID;
    }

    public String getNomeCategoria(){
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }

}
