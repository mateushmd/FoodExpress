package com.foodexpress.model.dto;

public class ItemPedidoDTO {
    int id;
    int idProduto;
    int idPedido;
    int quantidade;
    double precoTotal;

    public ItemPedidoDTO(int id, int idProduto, int idPedido, int quantidade, double precoTotal) {
        this.id = id;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }
    
    public ItemPedidoDTO(int idProduto, int idPedido, int quantidade, double precoTotal) {
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    public ItemPedidoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
