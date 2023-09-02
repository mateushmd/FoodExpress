package com.foodexpress.model.dao;

import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class ProdutoDAO extends DAOTemplate<ProdutoDTO>{
    private static ProdutoDAO instance = null;
    
    private ProdutoDAO() {
        super();
    }
    
    public static synchronized ProdutoDAO getInstance() {
        if(instance == null)
            instance = new ProdutoDAO();
        
        instance.setConnection();
        
        return instance;
    }

    @Override
    protected ProdutoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        ProdutoDTO produto = null;
        
        try{
            produto = new ProdutoDTO();
            
            produto.setId(rs.getInt("id"));
            produto.setIdLoja(rs.getInt("id_loja"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setDisponivel(rs.getBoolean("disponivel"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(LojaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public boolean cadastrar(ProdutoDTO obj){
        String sql = "INSERT INTO produtos (id_loja, nome, preco, descricao, disponivel) VALUES (?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getNome(), obj.getPreco(), obj.getDescricao(), obj.getDisponivel());
    }
    
    public boolean update(ProdutoDTO obj) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, descricao = ?, disponivel = ? WHERE id = ?";
        
        return executeUpdate(sql, obj.getNome(), obj.getPreco(), obj.getDescricao(), obj.getDisponivel(), obj.getId());
    }
    
    public List<ProdutoDTO> listar(int idLoja) {
        String sql = "SELECT * FROM produtos WHERE id_loja = ? ORDER BY nome";
        
        return executeQuery(sql, idLoja);
    }
}
