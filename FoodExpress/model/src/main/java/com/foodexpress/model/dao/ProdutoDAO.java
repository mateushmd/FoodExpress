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
            produto.setQuantidade(rs.getInt("quantidade"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(LojaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public boolean cadastrar(ProdutoDTO obj){
        String sql = "INSERT INTO produtos (id_loja, nome, preço, descricao, quantidade) VALUES (?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getNome(), obj.getPreco(), obj.getDescricao(), obj.getQuantidade());
    }
    
    public List<ProdutoDTO> ListarPorLoja(int idLoja) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE id_loja = ? ORDER BY nome";
        
        return executeQuery(sql, idLoja);
    }
    
    public List<ProdutoDTO> Listar() throws SQLException {
        String sql = "SELECT * FROM produtos ORDER BY nome";
        
        return executeQuery(sql);
    }
}
