package com.foodexpress.model.dto;

public class ItemPedidoDTO {
    int id;
    int idProduto;
    int idPedido;
    int quantidade;
    double precoTotal;

    String nome;

    //Resgatar do BD
    public ItemPedidoDTO(int id, int idProduto, int idPedido, int quantidade, double precoTotal) {
        this.id = id;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }
    
    //Cadastrar no bd
    public ItemPedidoDTO(int idProduto, int quantidade, double precoTotal) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    //View
    public ItemPedidoDTO(String nome, int id, int idProduto, int idPedido, int quantidade, double precoTotal) {
        this.nome = nome;
        this.id = id;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    //Para criar objeto
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
    
    public String getNome() {return nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }
}
