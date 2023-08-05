package com.foodexpress.model.dto;

public class LojaDTO {
    private int id;
    private String nome;
    private String descricao;
    private double avaliacao;
    private String idUser;

    public LojaDTO(int id, String nome, String descricao, double avaliacao, String idUser) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.idUser = idUser;
    }
    
    public LojaDTO(){
    }
}
