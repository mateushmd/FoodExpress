package com.foodexpress.model.dao;

import com.foodexpress.model.dto.AvaliacaoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class AvaliacaoDAO extends DAOTemplate<AvaliacaoDTO> {
    private static AvaliacaoDAO instance = null;
    
    private AvaliacaoDAO() {
        super();
    }
    
    public static synchronized AvaliacaoDAO getInstance(){
        if(instance == null)
            instance = new AvaliacaoDAO();
        
        return instance;
    }
    
    @Override
    protected AvaliacaoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        AvaliacaoDTO item = null;
        
        try{
            item = new AvaliacaoDTO();
            
            item.setId(rs.getInt("id"));
            item.setIdCliente(rs.getString("id_cliente"));
            item.setIdLoja(rs.getInt("id_loja"));
            item.setNota(rs.getInt("nota"));
            item.setComentario(rs.getString("comentario"));
            item.setData(rs.getDate("data_hora_comentario"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return item;
    }
    
    public boolean cadastrarAvaliacao(AvaliacaoDTO obj){
        String sql = "INSERT INTO avaliacoes (id_cliente, id_loja, nota, comentario, data_hora_comentario) VALUE (?, ?, ?, ?, ?)";
        
        Date data = new Date();
        
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
        
        if(obj.getNota() > 5)
            return false;
        
        return executeUpdate(sql, obj.getIdCliente(), obj.getIdLoja(), obj.getNota(), obj.getComentario(), date);
    }
    
    public AvaliacaoDTO getAvaliacaoById(int id){
        String sql = "SELECT * FROM avaliacoes WHERE id = ?";
        
        List<AvaliacaoDTO> avaliacoes = executeQuery(sql, id);
        
        return avaliacoes.isEmpty() ? null : avaliacoes.get(0);
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdCliente(String id){
        String sql = "SELECT * FROM avaliacoes WHERE id_cliente = ?";
        
        List<AvaliacaoDTO> avaliacoes = executeQuery(sql, id);
        
        return avaliacoes.isEmpty() ? null : avaliacoes;
    }
    
    public List<AvaliacaoDTO> getAvaliacaoByIdLoja(int id){
        String sql = "SELECT * FROM avaliacoes WHERE id_loja = ?";
        
        List<AvaliacaoDTO> avaliacoes = executeQuery(sql, id);
        
        return avaliacoes.isEmpty() ? null : avaliacoes;
    }
    
    public AvaliacaoDTO getAvaliacaoByIdLojaCliente(int idLoja, String idCliente){
        String sql = "SELECT * FROM avaliacoes WHERE id_loja = ? AND id_cliente = ?";
        
        List<AvaliacaoDTO> avaliacoes = executeQuery(sql, idLoja, idCliente);
        
        return avaliacoes.isEmpty() ? null : avaliacoes.get(0);
    }
    
    public boolean updateNota(int nota, int idAvaliacao){
        String sql = "UPDATE avaliacoes SET nota = ? WHERE id = ?";
        
        return executeUpdate(sql, nota, idAvaliacao);
    }
    
    public boolean updateComentario(String comentario, int idAvaliacao){
        String sql = "UPDATE avaliacoes SET comentario = ? WHERE id = ?";
        
        return executeUpdate(sql, comentario, idAvaliacao);
    }
    
    public boolean updateNotaComentario(int nota, String comentario, int idAvaliacao){
        String sql = "UPDATE avaliacoes SET nota = ?, comentario = ?, data_hora_comentario = ? WHERE id = ?";

        Date data = new Date();

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);

        return executeUpdate(sql, nota, comentario, date, idAvaliacao);
    }
    
    public boolean comentou(String idCliente, int idLoja) {
        String sql = "SELECT * FROM avaliacoes WHERE id_cliente = ? AND id_loja = ?";
        
        List<AvaliacaoDTO> avaliacao = executeQuery(sql, idCliente, idLoja);
        
        return !avaliacao.isEmpty();
    }

    public boolean removerAvaliacao(int idAvaliacao) {
        String sql = "DELETE FROM avaliacoes WHERE id = ?";

        return executeUpdate(sql, idAvaliacao);
    }
}