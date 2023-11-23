package com.foodexpress.model.dao;

import com.foodexpress.model.dto.PontoEncontroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    @Override
    protected PontoEncontroDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        PontoEncontroDTO pe = null;
        
        try{
            pe = new PontoEncontroDTO();
            
            pe.setId(rs.getInt("id"));
            pe.setIdLoja(rs.getInt("id_loja"));
            pe.setCampus(rs.getInt("campus"));
            pe.setNome(rs.getString("nome"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(PontoEncontroDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pe;
    }
    
    public boolean adicionar(PontoEncontroDTO obj){
        String sql = "INSERT INTO pontos_encontro (id_loja, campus, nome) VALUES (?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getCampus(), obj.getNome());
    }

    public boolean remover(int idLoja, int id) {
        String sql = "DELETE FROM pontos_encontro WHERE id = ? AND id_loja = ?";

        return executeUpdate(sql, id, idLoja);
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

    public PontoEncontroDTO getInserted(int idLoja) {
        String sql = "SELECT * FROM pontos_encontro WHERE id_loja = ? AND id = LAST_INSERT_ID()";

        ArrayList<PontoEncontroDTO> lista = (ArrayList<PontoEncontroDTO>) executeQuery(sql, idLoja);

        return lista.isEmpty() ? null : lista.get(0);
    }

    public List<PontoEncontroDTO> getByLojaAndCampus(int idLoja, int campus) {
        String sql = "SELECT * FROM pontos_encontro WHERE id_loja = ? AND campus = ?";

        ArrayList<PontoEncontroDTO> lista = (ArrayList<PontoEncontroDTO>) executeQuery(sql, idLoja, campus);

        return lista.isEmpty() ? null : lista;
    }
}
