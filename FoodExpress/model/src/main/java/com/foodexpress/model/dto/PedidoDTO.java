/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author washi
 */
public class PedidoDTO {
    int id;
    int idLoja;
    String idCliente;

    String nomeCliente;
    Timestamp dhPedido; //Data e hora do pedido
    String lEntrega; //Local entrega
    double pTotal; //Preco total
    ArrayList<ItemPedidoDTO> produtos;

    //criar objeto
    public PedidoDTO() {
    }

    //resgatar bd
    public PedidoDTO(int id, int id_loja, String id_cliente, Timestamp dhPedido, String lEntrega, double preco_total) {
        this.id = id;
        this.idLoja = id_loja;
        this.idCliente = id_cliente;
        this.dhPedido = dhPedido;
        this.lEntrega = lEntrega;
        this.pTotal = preco_total;
        this.produtos = new ArrayList<>();
    }

    //salvar no bd
    public PedidoDTO(int idLoja, String idCliente, String lEntrega, double pTotal, ArrayList<ItemPedidoDTO> produtos) {
        this.idLoja = idLoja;
        this.idCliente = idCliente;
        this.dhPedido = dhPedido;
        this.lEntrega = lEntrega;
        this.pTotal = pTotal;
        this.produtos = produtos;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getDhPedido() {
        return dhPedido;
    }

    public Date getDataPedido() {
        LocalDate data = dhPedido.toLocalDateTime().toLocalDate();

        return java.sql.Date.valueOf(data);
    }

    public void setDhPedido(Timestamp dhPedido) {
        this.dhPedido = dhPedido;
    }

    public String getlEntrega() {
        return lEntrega;
    }

    public void setlEntrega(String lEntrega) {
        this.lEntrega = lEntrega;
    }

    public double getpTotal() {
        return pTotal;
    }

    public void setpTotal(double pTotal) {
        this.pTotal = pTotal;
    }
    
    public void setProdutos(ArrayList<ItemPedidoDTO> prod){
        produtos = prod;
    }

    public void addProduto(ItemPedidoDTO produto) {
        produtos.add(produto);
    }

    public List<ItemPedidoDTO> getProdutos(){
        return produtos;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }

    public String getNomeCliente() { return nomeCliente; }
}
