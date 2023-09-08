package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemPedidoDTO;
import com.foodexpress.model.dto.ProdutoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class ItemPedidoDAO extends DAOTemplate<ItemPedidoDTO> {
    private static ItemPedidoDAO instance = null;
    
    private ItemPedidoDAO() {
        super();
    }
    
    public static synchronized ItemPedidoDAO getInstance(){
        if(instance == null)
            instance = new ItemPedidoDAO();
        
        instance.setConnection();
        
        return instance;
    }

    @Override
    protected ItemPedidoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        ItemPedidoDTO item = null;
        
        try{
            item = new ItemPedidoDTO();
            
            item.setId(rs.getInt("id"));
            item.setIdProduto(rs.getInt("id_produto"));
            item.setIdPedido(rs.getInt("id_pedido"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setPrecoTotal(rs.getDouble("preco_total"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return item;
    }
    
    public List<ItemPedidoDTO> getItensPedidoById(int id){
        String sql = "SELEECT * FROM itens_pedido WHERE id = ?";
        
        List<ItemPedidoDTO> prod = executeQuery(sql, id);
        
        return prod.isEmpty() ? null : prod;
    }
    
    public void addItens(List<ItemPedidoDTO> itens, int idPedido){
        for(ItemPedidoDTO i: itens){
            String sql = "INSERT INTO itens_pedido (id_produto, id_pedido, quantidade, preco_total) VALUES (?, ?, ?, ?)";
            
            executeUpdate(sql, i.getIdProduto(), idPedido, i.getQuantidade(), i.getPrecoTotal());
        }
    }
    
    public List<ItemPedidoDTO> getItensPedidoByPedido(int idPedido){
        String sql = "SELEECT * FROM itens_pedido WHERE id_pedido = ?";
        
        List<ItemPedidoDTO> prod = executeQuery(sql, idPedido);
        
        return prod.isEmpty() ? null : prod;
    }
}
