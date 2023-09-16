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
    
    private ProdutoDAO pdao;
    
    private static LojaService instance = null;
    
    private LojaService(){
        ldao = LojaDAO.getInstance();
        
        pdao = ProdutoDAO.getInstance();
    }
    
    public static LojaService getInstance(){
        if(instance == null)
            instance = new LojaService();
        
        return instance;
    }
    
    public int login(String idUser){
        int check = ldao.login(idUser);
        System.out.println(check);
        
        return check;
    }
    
    public LojaDTO getLoja(String idUser) {
        return ldao.getLoja(idUser);
    }
    
    public LojaDTO getLojaById(int idLoja) {
        return ldao.getLojaById(idLoja);
    }
    
    public boolean updateNomeDescricao(LojaDTO obj){
        return ldao.updateND(obj);
    }
    
    public boolean updateAvaliacao(LojaDTO obj, int novaAvaliacao){
        DecimalFormat df = new DecimalFormat("#.#");
        
        obj.setQtdAvaliacoes(obj.getQtdAvaliacoes() + 1);
        
        obj.setSomaAvaliacoes(obj.getSomaAvaliacoes() + novaAvaliacao);
        
        obj.setAvaliacao((double) obj.getSomaAvaliacoes() / (double) obj.getQtdAvaliacoes());
        
        return ldao.updateAvaliacao(obj);
    }
    
    public void cadastrar(LojaDTO obj){
        ldao.cadastrar(obj);
    }
    
    public List<LojaDTO> listarLojas() {
        return ldao.ListarLojas();
    }
    
    public boolean adicionarProduto(ProdutoDTO obj){
        return pdao.cadastrar(obj);
    }
    
    public ArrayList<ProdutoDTO> listarProdutos(int idLoja) {
        return (ArrayList) pdao.listar(idLoja);
    } 
    
    public boolean editarProduto(ProdutoDTO obj) {
        return pdao.update(obj);
    }
}
