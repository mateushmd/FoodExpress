/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.dao;

import com.foodexpress.model.dto.LojaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author washi
 */
public class LojaDAO extends DAOTemplate<LojaDAO> {
    private static LojaDAO instance = null;
    
    private LojaDTO loja;
    
    private LojaDAO() {
        super();
    }
    
    public static synchronized LojaDAO getInstance(){
        if(instance == null)
            instance = new LojaDAO();
        
        return instance;
    }
    
    @Override
    protected LojaDAO mapResultSetToObject(ResultSet rs) throws SQLException {
        LojaDTO loja = null;
        
        try{
            loja = new LojaDTO();
            
            loja.setId(rs.getInt("id"));
            loja.setNome(rs.getString("nome"));
            loja.setDescricao(rs.getString("descricao"));
            loja.setAvaliacao(rs.getDouble("avaliacao"));
            loja.setIdUser(rs.getString("id_user"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(LojaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loja;
    }
    
    public boolean cadastrar(LojaDTO obj){
        String sql = "INSERT INTO lojas (id, nome, descricao, avaliacao, id_usuario) VALUES (?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getId(), obj.getNome(), obj.getDescricao(), obj.getAvaliacao(), obj.getIdUser());
    }
    
    public int login(String idUser){
        String sql = "SELECT * FROM lojas WHERE id_user = ?";
        
        List<LojaDTO> lojas = executeQuery(sql, idUser);
        
        //Loja não cadastrada
        if(lojas.isEmpty())
            return -1;
        
        LojaDTO loja = lojas.get(0);
    }
}
