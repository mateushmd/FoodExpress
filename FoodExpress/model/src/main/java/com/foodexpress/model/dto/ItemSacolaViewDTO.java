package com.foodexpress.model.dto;

public class ItemSacolaViewDTO {
    int itemSacolaId;
    int produtoId;
    String produtoNome;
    String produtoDescricao;
    double preco;
    int quantidade;
    double precoTotal;

    public ItemSacolaViewDTO() {

    }

    public ItemSacolaViewDTO(int itemSacolaId, int produtoId, String produtoNome, String produtoDescricao, double preco, int quantidade, double precoTotal) {
        this.itemSacolaId = itemSacolaId;
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    public int getItemSacolaId() {
        return itemSacolaId;
    }

    public void setItemSacolaId(int itemSacolaId) {
        this.itemSacolaId = itemSacolaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
