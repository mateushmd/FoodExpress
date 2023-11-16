package com.foodexpress.model.dto;

import java.util.ArrayList;

public class SacolaViewDTO {

    private int idLoja;
    private String nomeLoja;
    private ArrayList<ItemSacolaViewDTO> itens;
    private int quantidade;
    private double total;

    public SacolaViewDTO() {
        idLoja = -1;
        nomeLoja = "";
        itens = new ArrayList<>();
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

        System.out.println(total);
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

        total = 0;
        
        quantidade = 0;

        for(ItemSacolaViewDTO item : itens) {
            total += item.getPrecoTotal();
            quantidade += item.getQuantidade();
        }
    }

    public void addItem(ItemSacolaViewDTO item) {
        itens.add(item);
        total += item.getPrecoTotal();
        quantidade += item.getQuantidade();
    }

    public void updateItem(int idProduto, int quantidade, double precoTotal) {
        for(ItemSacolaViewDTO item : itens) {
            if(item.getProdutoId() == idProduto) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                item.setPrecoTotal(item.getPrecoTotal() + precoTotal);
                total += precoTotal;
                this.quantidade += quantidade;
            }
        }
    }

    public void removerItem(int idItem) {
        for(ItemSacolaViewDTO item : itens) {
            if(item.getItemSacolaId() == idItem) {
                itens.remove(item);
                total -= item.getPrecoTotal();
                quantidade -= item.getQuantidade();
                break;
            }
        }
    }

    public double getTotal() {
        return total;
    }

    public int getQuantidade() { return quantidade; }

    public boolean estaVazia() { return itens.isEmpty(); }
}
