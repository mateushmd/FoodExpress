/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.dto;

import java.util.List;

/**
 *
 * @author washi
 */
public class PedidoDTO {
    int id;
    int idLoja;
    String idCliente;
    String dhPedido; //Data e hora do pedido
    String lEntrega; //Local entrega
    double pTotal; //Preco total
    String status;
    String rCancelamento; //Razao cancelamento
    String dhFechamento; //Data e hora fechammento
    List<ItemPedidoDTO> produtos;

    public PedidoDTO() {
    }

    public PedidoDTO(int id, int id_loja, String id_cliente, String dhPedido, String lEntrega, double preco_total, String status, String razao_cancelamento, String dhFechamento) {
        this.id = id;
        this.idLoja = id_loja;
        this.idCliente = id_cliente;
        this.dhPedido = dhPedido;
        this.lEntrega = lEntrega;
        this.pTotal = preco_total;
        this.status = status;
        this.rCancelamento = razao_cancelamento;
        this.dhFechamento = dhFechamento;
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

    public String getDhPedido() {
        return dhPedido;
    }

    public void setDhPedido(String dhPedido) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getrCancelamento() {
        return rCancelamento;
    }

    public void setrCancelamento(String rCancelamento) {
        this.rCancelamento = rCancelamento;
    }

    public String getDhFechamento() {
        return dhFechamento;
    }

    public void setDhFechamento(String dhFechamento) {
        this.dhFechamento = dhFechamento;
    }
    
    public void addProduto(List<ItemPedidoDTO> prod){
        produtos = prod;
    }
    
    public List<ItemPedidoDTO> getProdutos(){
        return produtos;
    }
}
