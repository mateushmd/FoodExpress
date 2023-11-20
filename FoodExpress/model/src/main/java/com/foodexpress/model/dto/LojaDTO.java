package com.foodexpress.model.dto;
import java.util.ArrayList;
import java.util.List;

public class LojaDTO {
    private int id;
    private String nome;
    private String descricao;
    private double avaliacao;
    private int qtdAvaliacoes;
    private int somaAvaliacoes;
    private String idUser;
    private List<ProdutoDTO> cardapio;
    private boolean aberto;

    //Resgatar do bd
    public LojaDTO(int id, String nome, String descricao, double avaliacao, String idUser, int qtdAvaliacoes, int somaAvaliacoes) {
        this();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.idUser = idUser;
        this.qtdAvaliacoes = qtdAvaliacoes;
        this.somaAvaliacoes = somaAvaliacoes;
    }

    //Salvar no bd
    public LojaDTO(String nome, String descricao, double avaliacao, String idUser) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.idUser = idUser;
    }
    
    //Criar objeto
    public LojaDTO(){
        aberto = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getQtdAvaliacoes() {
        return qtdAvaliacoes;
    }

    public void setQtdAvaliacoes(int qtdAvaliacoes) {
        this.qtdAvaliacoes = qtdAvaliacoes;
    }

    public int getSomaAvaliacoes() {
        return somaAvaliacoes;
    }

    public void setSomaAvaliacoes(int somaAvaliacoes) {
        this.somaAvaliacoes = somaAvaliacoes;
    }

    public boolean getAberto() { return aberto; }

    public void setAberto(boolean aberto) { this.aberto = aberto; }
}
