/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.service;

import com.foodexpress.model.dao.AvaliacaoDAO;
import com.foodexpress.model.dto.AvaliacaoDTO;
import java.util.List;

/**
 *
 * @author washi
 */
public class AvaliacaoService {
    private AvaliacaoDAO dao;
    
    private static AvaliacaoService instance = null;
    
    private AvaliacaoService() {
        dao = AvaliacaoDAO.getInstance();
    }
    
    public static AvaliacaoService getInstance() {
        if(instance == null)
            instance = new AvaliacaoService();
        
        return instance;
    }
    
    public boolean cadastrarAvaliacao(AvaliacaoDTO obj){
        return dao.cadastrarAvaliacao(obj);
    }
    
    public AvaliacaoDTO getAvaliacaoById(int id){
        return dao.getAvaliacaoById(id);
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdCliente(String id){
        
        return dao.getAvaliacaoByIdCliente(id);
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdLoja(int id){
        
        return dao.getAvaliacaoByIdLoja(id);
    }
    
    public AvaliacaoDTO getAvaliacaoByIdLojaCliente(int idLoja, String idCliente){
        
        return dao.getAvaliacaoByIdLojaCliente(idLoja, idCliente);
    }
    
    public boolean updateNota(int nota, int idAvaliacao){
        
        return dao.updateNota(nota, idAvaliacao);
    }
    
    public boolean updateComentario(String comentario, int idAvaliacao){
        
        return dao.updateComentario(comentario, idAvaliacao);
    }
    
    public boolean updateNotaComentario(int nota, String comentario, int idAvaliacao){
        
        return dao.updateNotaComentario(nota, comentario, idAvaliacao);
    }
}
