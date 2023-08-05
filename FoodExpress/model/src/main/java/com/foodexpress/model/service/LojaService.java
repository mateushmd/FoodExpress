package com.foodexpress.model.service;

import com.foodexpress.model.dao.LojaDAO;
import com.foodexpress.model.dto.LojaDTO;
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
    
    public LojaDTO getLoja(String email) {
        return dao.getLoja(email);
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
}
