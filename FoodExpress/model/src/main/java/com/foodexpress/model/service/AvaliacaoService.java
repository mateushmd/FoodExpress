package com.foodexpress.model.service;

import com.foodexpress.model.dao.AvaliacaoDAO;
import com.foodexpress.model.dto.AvaliacaoDTO;
import com.foodexpress.model.dto.LojaDTO;
import java.util.List;

public class AvaliacaoService {
    private AvaliacaoDAO dao;
    
    private LojaService lService = null;
    
    private static AvaliacaoService instance = null;
    
    private AvaliacaoService() {
        dao = AvaliacaoDAO.getInstance();
        lService = LojaService.getInstance();
    }
    
    public static AvaliacaoService getInstance() {
        if(instance == null)
            instance = new AvaliacaoService();
        
        return instance;
    }
    
    public boolean cadastrarAvaliacao(AvaliacaoDTO avaliacao, LojaDTO loja){
        boolean check = dao.cadastrarAvaliacao(avaliacao);
        
        if(!check)
            return check;
        
        check = lService.updateAvaliacao(loja, avaliacao.getNota());
        
        return check;
    }
    
    public AvaliacaoDTO getAvaliacaoById(int id){
        return dao.getAvaliacaoById(id);
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdCliente(String id){
        
        return dao.getAvaliacaoByIdCliente(id);
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdLoja(int idLoja){
        
        return dao.getAvaliacaoByIdLoja(idLoja);
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
    
    public boolean updateNotaComentario(AvaliacaoDTO avaliacao, LojaDTO loja, int avaliacaoAntiga){
        boolean check = dao.updateNotaComentario(avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getId());

        if(!check)
            return check;

        return lService.mudarAvaliacao(loja, avaliacaoAntiga, avaliacao.getNota());
    }
    
    public boolean comentou(String idCliente, int idLoja) {
        return dao.comentou(idCliente, idLoja);
    }

    public boolean removerAvaliacao(AvaliacaoDTO avaliacao, LojaDTO loja)
    {
        boolean check = dao.removerAvaliacao(avaliacao.getId());

        if(!check)
            return check;

        return lService.removerAvaliacao(loja, avaliacao.getNota());
    }
}