package com.foodexpress.model.dao;

import com.foodexpress.model.dto.PedidoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class PedidoDAO extends DAOTemplate<PedidoDTO> {
    private static PedidoDAO instance = null;
    ItemPedidoDAO itemDAO;
    
    private PedidoDAO() {
        super();
        itemDAO = ItemPedidoDAO.getInstance();
    }
    
    public static synchronized PedidoDAO getInstance(){
        if(instance == null)
            instance = new PedidoDAO();
        
        return instance;
    }
    
    @Override
    protected PedidoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        PedidoDTO pedido = null;
        
        try{
            pedido = new PedidoDTO();
            
            pedido.setId(rs.getInt("id"));
            pedido.setIdLoja(rs.getInt("id_loja"));
            pedido.setIdCliente(rs.getInt("id_cliente"));
            pedido.setDhPedido(rs.getString("data_hora_pedido"));
            pedido.setlEntrega(rs.getString("local_entrega"));
            pedido.setpTotal(rs.getDouble("preco_total"));
            pedido.setStatus(rs.getString("status"));
            pedido.setrCancelamento(rs.getString("razao_cancelamento"));
            pedido.setDhFechamento(rs.getString("data_hora_fechamento"));
            pedido.addProduto(itemDAO.getItensPedidoById(rs.getInt("id")));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(PedidoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pedido;
    }
    
    public boolean realizarPedido(PedidoDTO obj){
        String sql = "INSERT INTO pedidos (id_cliente, id_loja, data_hora_pedido, local_entrega, preco_total, status, razao_cancelamento, data_hora_fechamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getIdCliente(), obj.getIdLoja(), obj.getDhPedido(), obj.getlEntrega(), obj.getpTotal(), obj.getStatus(), obj.getrCancelamento(), obj.getDhFechamento());
    }
    
    public PedidoDTO getPedidoById(int id_pedido){
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        
        List<PedidoDTO> pedidos = executeQuery(sql, id_pedido);
        
        return pedidos.isEmpty() ? null : pedidos.get(0);
    }
    
    public List<PedidoDTO> getPedidoByIdCliente(int idUser) {
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ?";
        
        List<PedidoDTO> pedidos = executeQuery(sql, idUser);
        
        return pedidos.isEmpty() ? null : pedidos;
    }
    
    public List<PedidoDTO> getPedidoByIdLoja(int idUser) {
        String sql = "SELECT * FROM pedidos WHERE id_loja = ?";
        
        List<PedidoDTO> pedidos = executeQuery(sql, idUser);
        
        return pedidos.isEmpty() ? null : pedidos;
    }
}
