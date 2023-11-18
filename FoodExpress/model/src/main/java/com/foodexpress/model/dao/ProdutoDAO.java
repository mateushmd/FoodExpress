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
            produto.setIdCategoria(rs.getInt("id_categoria"));
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
        String sql = "INSERT INTO produtos (id_loja, id_categoria, nome, preco) VALUES (?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdLoja(), obj.getIdCategoria(), obj.getNome(), obj.getPreco());
    }
    
    public boolean update(ProdutoDTO obj) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, descricao = ?, disponivel = ? WHERE id = ?";
        
        return executeUpdate(sql, obj.getNome(), obj.getPreco(), obj.getDescricao(), obj.getDisponivel(), obj.getId());
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        return executeUpdate(sql, id);
    }

    public boolean removerByCategoria(int idCategoria) {
        String sql = "DELETE FROM produtos WHERE id_categoria = ?";

        return executeUpdate(sql, idCategoria);
    }
    
    public List<ProdutoDTO> listar(int idLoja) {
        String sql = "SELECT * FROM produtos WHERE id_loja = ? ORDER BY nome";
        
        return executeQuery(sql, idLoja);
    }

    public ProdutoDTO getProdutoById(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";

        List<ProdutoDTO> produto = executeQuery(sql, id);

        return produto.isEmpty() ? null : produto.get(0);
    }

    public List<ProdutoDTO> getProdutosByCategoria(int idCategoria) {
        String sql = "SELECT * FROM produtos WHERE id_categoria = ?";

        List<ProdutoDTO> produtos = executeQuery(sql, idCategoria);

        return produtos.isEmpty() ? null : produtos;
    }

    public ProdutoDTO getUltimoProduto() {
        String sql = "SELECT * FROM produtos WHERE id = LAST_INSERT_ID()";

        List<ProdutoDTO> produto = executeQuery(sql);

        return produto.isEmpty() ? null : produto.get(0);
    }
}
