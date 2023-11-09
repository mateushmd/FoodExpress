package com.foodexpress.model.dao;

import com.foodexpress.model.dto.PontoEncontroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class PontoEncontroDAO extends DAOTemplate<PontoEncontroDTO> {
    private static PontoEncontroDAO instance = null;
    
    private PontoEncontroDAO(){
        super();
    }
    
    public static synchronized PontoEncontroDAO getInstance(){
        if(instance == null)
            instance = new PontoEncontroDAO();
        
        return instance;
    }
    
    protected PontoEncontroDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        PontoEncontroDTO loja = null;
        
        try{
            loja = new PontoEncontroDTO();
            
            loja.setId(rs.getInt("id"));
            loja.setIdLoja(rs.getInt("id_loja"));
            loja.setNome(rs.getString("nome"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(PontoEncontroDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loja;
    }
    
    public boolean cadastrar(PontoEncontroDTO obj){
        String sql = "INSERT INTO pontos_encontro (id_loja, nome) VALUES (?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getNome());
    }
    
    public List<PontoEncontroDTO> listarPontos(){
        String sql = "SELECT * FROM pontos_encontro ORDER BY nome";
        
        return executeQuery(sql);
    }
    
    public List<PontoEncontroDTO> getById(int id){
        String sql = "SELECT * FROM pontos_encontro WHERE id = ?";
        
        return executeQuery(sql, id);
    }
    
    public List<PontoEncontroDTO> getByLoja(int idLoja){
        String sql = "SELECT * FROM pontos_encontro WHERE id_loja = ?";
        
        return executeQuery(sql, idLoja);
    }
}
