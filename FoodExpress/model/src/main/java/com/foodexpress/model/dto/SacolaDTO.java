package com.foodexpress.model.dto;

import java.util.List;

public class SacolaDTO {
    private int id_loja;
    private List<ItemSacolaViewDTO> itens;

    public SacolaDTO(int id_loja, List<ItemSacolaViewDTO> itens) {
        this.id_loja = id_loja;
        this.itens = itens;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public List<ItemSacolaViewDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemSacolaViewDTO> itens) {
        this.itens = itens;
    }
}
