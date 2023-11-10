package com.foodexpress.model.dao;

import com.foodexpress.model.dto.AgendaLojaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class AgendaLojaDAO extends DAOTemplate<AgendaLojaDTO>{
    private static AgendaLojaDAO instance = null;
    
    private AgendaLojaDAO(){
        super();
    }
    
    public static synchronized AgendaLojaDAO getInstance(){
        if(instance == null)
            instance = new AgendaLojaDAO();
        
        return instance;
    }
    
    @Override
    protected AgendaLojaDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        AgendaLojaDTO agenda = null;
        
        try{
            agenda = new AgendaLojaDTO();
            
            agenda.setIdLoja(rs.getInt("id_loja"));
            agenda.setDiaSemana(rs.getString("dia_semana"));
            agenda.setAbertura(rs.getString("abertura"));
            agenda.setFechamento(rs.getString("fechamento"));
            agenda.setCampus1(rs.getBoolean("campus_1"));
            agenda.setCampus2(rs.getBoolean("campus_2"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(AgendaLojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agenda;
    }
    
    public boolean cadastrar(AgendaLojaDTO obj){
        String sql = "INSERT INTO pontos_encontro (id_loja, dia_semana, abertura, fechamento, campus_1, campus_1) VALUES (?, ?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getDiaSemana(), obj.getAbertura(), obj.getFechamento(), obj.isCampus1(), obj.isCampus2());
    }
}
