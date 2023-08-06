package com.foodexpress.model.service;

import com.foodexpress.model.dao.LojaDAO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import java.sql.SQLException;
import java.util.List;

public class LojaService {
    private LojaDAO dao;
    
    private static LojaService instance = null;
    
    private LojaService(){
        dao = LojaDAO.getInstance();
    }
    
    public static LojaService getinstance(){
        if(instance == null)
            instance = new LojaService();
        
        return instance;
    }
    
    public int login(String idUser){
        int check = dao.login(idUser);
        System.out.println(check);
        
        return check;
    }
    
    public LojaDTO getLoja(String idUser) {
        return dao.getLoja(idUser);
    }
    
    public boolean updateND(LojaDTO obj){
        return dao.updateND(obj);
    }
    
    public boolean updateA(LojaDTO obj){
        return dao.updateA(obj);
    }
    
    public void cadastrar(LojaDTO obj){
        dao.cadastrar(obj);
    }
    
    public List<LojaDTO> listarLojas() throws SQLException{
        return dao.ListarLojas();
    }
    
    public LojaDTO getLoja(){
        return dao.getLoja();
    }
    
    public boolean adicionarAoCard(ProdutoDTO obj){
        return dao.adicionarAoCard(obj);
    }
    
    public List<ProdutoDTO> listarCard(int idLoja) throws SQLException{
        return dao.listarCard(idLoja);
    }
    
    public List<ProdutoDTO> listarProd() throws SQLException{
        return dao.listarProd();
    }
    
}
