package com.foodexpress.model.dto;

import java.util.ArrayList;

public class SacolaViewDTO {
    private int idLoja;
    private String nomeLoja;
    private ArrayList<ItemSacolaViewDTO> itens;

    double total;

    public SacolaViewDTO() {
        idLoja = -1;
        nomeLoja = "";
        itens = new ArrayList<ItemSacolaViewDTO>();
        total = 0;
    }

    public SacolaViewDTO(int idLoja, String nomeLoja, ArrayList<ItemSacolaViewDTO> itens) {
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
        this.itens = itens;

        total = 0;

        for(ItemSacolaViewDTO item : itens) {
            total += item.getPrecoTotal();
        }
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public ArrayList<ItemSacolaViewDTO> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemSacolaViewDTO> itens) {
        this.itens = itens;
    }

    public void addItem(ItemSacolaViewDTO item) {
        itens.add(item);
        total += item.getPrecoTotal();
    }

    public double getTotal() {
        return total;
    }
}
