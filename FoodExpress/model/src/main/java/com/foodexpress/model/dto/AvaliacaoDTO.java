package com.foodexpress.model.dto;

import java.util.Date;

public class AvaliacaoDTO {
    int id;
    int idLoja;
    String idCliente;
    int nota;
    String comentario;
    Date horario;

    public AvaliacaoDTO(int id, int idLoja, String idCliente, int nota, String comentario, Date horario) {
        this.id = id;
        this.idLoja = idLoja;
        this.idCliente = idCliente;
        this.nota = nota;
        this.comentario = comentario;
        this.horario = horario;
    }

    public AvaliacaoDTO(int idLoja, String idCliente, int nota, String comentario) {
        this.idLoja = idLoja;
        this.idCliente = idCliente;
        this.nota = nota;
        this.comentario = comentario;
    }

    public AvaliacaoDTO() {
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }
    
    
}
