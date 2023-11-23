package com.foodexpress.model.dto;

public class FavoritosDTO {
    String idCliente;
    int idLoja;

    public FavoritosDTO(String idCliente, int idLoja) {
        this.idCliente = idCliente;
        this.idLoja = idLoja;
    }

    public FavoritosDTO() {
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }
    
    
}
