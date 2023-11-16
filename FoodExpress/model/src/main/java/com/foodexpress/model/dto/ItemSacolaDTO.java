package com.foodexpress.model.dto;

public class ItemSacolaDTO {
    private int id;
    private String idUsuario;
    private int idProduto;
    private int quantidade;
    private double precoItem;
    private double precoTotal;

    public ItemSacolaDTO(){};

    public ItemSacolaDTO(String idUsuario, int idProduto, int quantidade, double precoItem) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoItem = precoItem;
        this.precoTotal = precoItem * quantidade;
    }

    public ItemSacolaDTO(int id, String idUsuario, int idProduto, int quantidade, double precoItem) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoItem = precoItem;
        this.precoTotal = precoItem * quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        precoTotal = quantidade * precoItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
