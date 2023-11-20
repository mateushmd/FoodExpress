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
            agenda.setDiaSemana(rs.getInt("dia_semana"));
            agenda.setAbertura(rs.getTime("abertura"));
            agenda.setFechamento(rs.getTime("fechamento"));
            agenda.setCampus1(rs.getBoolean("campus_1"));
            agenda.setCampus2(rs.getBoolean("campus_2"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(AgendaLojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return agenda;
    }
    
    public boolean cadastrar(AgendaLojaDTO obj){
        String sql = "INSERT INTO agenda_lojas (id_loja, dia_semana, abertura, fechamento, campus_1, campus_2) VALUES (?, ?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getDiaSemana(), obj.getAbertura(), obj.getFechamento(), obj.isCampus1(), obj.isCampus2());
    }
    
    public List<AgendaLojaDTO> getAgendas(){
        String sql = "SELECT * FROM agenda_lojas ORDER BY id_loja";
        
        return executeQuery(sql);
    }
    
    public List<AgendaLojaDTO> getAgendasByLoja(int idLoja){
        String sql = "SELECT * FROM agenda_lojas WHERE id_loja = ?";
        
        return executeQuery(sql, idLoja);
    }

    public AgendaLojaDTO getAgendaByLojaAndDia(int idLoja, int diaSemana) {
        String sql = "SELECT * FROM agenda_lojas WHERE id_loja = ? AND dia_semana = ?";

        List<AgendaLojaDTO> agenda = executeQuery(sql, idLoja, diaSemana);

        return agenda.isEmpty() ? null : agenda.get(0);
    }
    
    public List<AgendaLojaDTO> getAgendasByDiaSemana(String dia){
        String sql = "SELECT * FROM agenda_lojas WHERE dia_semana = ?";
        
        return executeQuery(sql, dia);
    }
    
    public List<AgendaLojaDTO> getAgendaCampus1(){
        String sql = "SELECT * FROM agenda_lojas WHERE campus_1 = true";
        
        return executeQuery(sql);
    }
    
    public List<AgendaLojaDTO> getAgendaCampus2(){
        String sql = "SELECT * FROM agenda_lojas WHERE campus_1 = true";
        
        return executeQuery(sql);
    }

    public boolean resetarAgenda(int idLoja) {
        String sql = "DELETE FROM agenda_lojas WHERE id_loja = ?";

        return executeUpdate(sql, idLoja);
    }
    
    public boolean updateAbertura(AgendaLojaDTO ag, String ab){
        String sql = "UPDATE agenda_lojas SET abertura = ? WHERE id_loja = ?";
        
        return executeUpdate(sql, ab, ag.getIdLoja());
    }
    
    public boolean updateFechamento(AgendaLojaDTO ag, String fc){
        String sql = "UPDATE agenda_lojas SET fechamento = ? WHERE id_loja = ?";
        
        return executeUpdate(sql, fc, ag.getIdLoja());
    }
    
    public boolean updateDiaSemana(AgendaLojaDTO ag, String dia){
        String sql = "UPDATE agenda_lojas SET dia_semana = ? WHERE id_loja = ?";
        
        return executeUpdate(sql, dia, ag.getIdLoja());
    }
    
    //Alterna entre true e false
    public boolean switchCampus1(AgendaLojaDTO ag){
        String sql = "UPDATE agenda_lojas SET campus_1 = ? WHERE id_loja = ?";
        
        return executeUpdate(sql, !ag.isCampus1(), ag.getIdLoja());
    }
    
    //Alterna entre true e false
    public boolean switchCampus2(AgendaLojaDTO ag){
        String sql = "UPDATE agenda_lojas SET campus_2 = ? WHERE id_loja = ?";
        
        return executeUpdate(sql, !ag.isCampus2(), ag.getIdLoja());
    }
}
