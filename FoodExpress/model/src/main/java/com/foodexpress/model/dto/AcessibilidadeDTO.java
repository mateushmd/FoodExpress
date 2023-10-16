package com.foodexpress.model.dto;

public class AcessibilidadeDTO {
    private String idUser;
    private boolean temaEscuro;
    private boolean contraste;
    private boolean visibilidadeTexto;
    private int tamanhoTexto;

    public AcessibilidadeDTO() {};

    public AcessibilidadeDTO(String idUser, boolean temaEscuro, boolean contraste, boolean visibilidadeTexto, int tamanhoTexto) {
        this.idUser = idUser;
        this.temaEscuro = temaEscuro;
        this.contraste = contraste;
        this.visibilidadeTexto = visibilidadeTexto;
        this.tamanhoTexto = tamanhoTexto;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean getTemaEscuro() {
        return temaEscuro;
    }

    public void setTemaEscuro(boolean temaEscuro) {
        this.temaEscuro = temaEscuro;
    }

    public boolean getContraste() {
        return contraste;
    }

    public void setContraste(boolean contraste) {
        this.contraste = contraste;
    }

    public boolean getVisibilidadeTexto() {
        return visibilidadeTexto;
    }

    public void setVisibilidadeTexto(boolean visibilidadeTexto) {
        this.visibilidadeTexto = visibilidadeTexto;
    }

    public int getTamanhoTexto() {
        return tamanhoTexto;
    }

    public void setTamanhoTexto(int tamanhoTexto) {
        this.tamanhoTexto = tamanhoTexto;
    }
}
