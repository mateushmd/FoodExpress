package com.foodexpress.model.service;

import com.foodexpress.model.dao.LojaDAO;
import com.foodexpress.model.dao.ProdutoDAO;
import com.foodexpress.model.dto.AvaliacaoDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LojaService {
    private LojaDAO ldao;
    
    private static LojaService instance = null;
    
    private LojaService(){
        ldao = LojaDAO.getInstance();
    }
    
    public static LojaService getInstance(){
        if(instance == null)
            instance = new LojaService();
        
        return instance;
    }
    
    public LojaDTO getLoja(String idUser) {
        return ldao.getLoja(idUser);
    }
    
    public LojaDTO getLojaById(int idLoja) {
        return ldao.getLojaById(idLoja);
    }
    
    public boolean updateNomeDescricao(int id, String nome, String descricao){
        return ldao.updateNomeDescricao(id, nome, descricao);
    }

    public boolean updateNome(int id, String nome) {
        return ldao.updateNome(id, nome);
    }
    
    public boolean updateAvaliacao(LojaDTO obj, int novaAvaliacao){
        obj.setQtdAvaliacoes(obj.getQtdAvaliacoes() + 1);
        
        obj.setSomaAvaliacoes(obj.getSomaAvaliacoes() + novaAvaliacao);
        
        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());
        
        return ldao.updateAvaliacao(obj);
    }

    public boolean mudarAvaliacao(LojaDTO obj, int avaliacaoAntiga, int novaAvaliacao)
    {
        obj.setSomaAvaliacoes((obj.getSomaAvaliacoes() - avaliacaoAntiga) + novaAvaliacao);

        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());

        return ldao.updateAvaliacao(obj);
    }

    public boolean removerAvaliacao(LojaDTO obj, int avaliacao)
    {
        obj.setSomaAvaliacoes(obj.getSomaAvaliacoes() - avaliacao);

        obj.setQtdAvaliacoes(obj.getQtdAvaliacoes() - 1);

        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());

        return ldao.updateAvaliacao(obj);
    }
    
    public void cadastrar(String email){
        ldao.cadastrar(email);
    }
    
    public List<LojaDTO> listarLojas() {
        return ldao.ListarLojas();
    }
}
