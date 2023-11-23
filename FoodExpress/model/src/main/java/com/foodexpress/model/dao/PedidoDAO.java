package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemPedidoDTO;
import com.foodexpress.model.dto.PedidoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PedidoDAO extends DAOTemplate<PedidoDTO> {

    private static PedidoDAO instance = null;

    private PedidoDAO() {
        super();
    }

    public static synchronized PedidoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoDAO();
        }

        return instance;
    }

    @Override
    protected PedidoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        PedidoDTO pedido = null;

        try {
            pedido = new PedidoDTO();

            pedido.setId(rs.getInt("id"));
            pedido.setIdLoja(rs.getInt("id_loja"));
            pedido.setIdCliente(rs.getString("id_cliente"));
            pedido.setDhPedido(rs.getTimestamp("data_hora_pedido"));
            pedido.setlEntrega(rs.getString("local_entrega"));
            pedido.setpTotal(rs.getDouble("preco_total"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PedidoDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }

    public boolean realizarPedido(PedidoDTO obj) {
        String sql = "INSERT INTO pedidos (id_cliente, id_loja, local_entrega, preco_total) VALUES (?, ?, ?, ?)";

        return executeUpdate(sql, obj.getIdCliente(), obj.getIdLoja(), obj.getlEntrega(), obj.getpTotal());
    }

    public double calculaValorTotal(List<ItemPedidoDTO> itens) {
        double total = 0;
        
        for(ItemPedidoDTO p: itens)
            total += p.getPrecoTotal();

        return total;
    }

    private boolean updateValorTotal(double valor, int idPedido) {
        String sql = "UPDATE pedidos SET preco_total = ? WHERE id = ?";

        return executeUpdate(sql, valor, idPedido);
    }

    public PedidoDTO getPedidoById(int id_pedido) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";

        List<PedidoDTO> pedidos = executeQuery(sql, id_pedido);

        return pedidos.isEmpty() ? null : pedidos.get(0);
    }

    public List<PedidoDTO> getPedidoByIdCliente(String idUser) {
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ?";

        List<PedidoDTO> pedidos = executeQuery(sql, idUser);

        return pedidos.isEmpty() ? null : pedidos;
    }

    public List<PedidoDTO> getPedidoByIdLoja(int idUser) {
        String sql = "SELECT * FROM pedidos WHERE id_loja = ?";

        List<PedidoDTO> pedidos = executeQuery(sql, idUser);

        return pedidos.isEmpty() ? null : pedidos;
    }

    public PedidoDTO getPedidoByIdLojaCliente(int idLoja, String idCliente) {
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ? AND id_loja = ?";

        List<PedidoDTO> pedido = executeQuery(sql, idCliente, idLoja);

        return pedido.isEmpty() ? null : pedido.get(0);
    }
    
    public PedidoDTO getPedidoByIdLojaClienteStatus(int idLoja, String idCliente, String status) {
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ? AND id_loja = ? AND status = ?";

        List<PedidoDTO> pedido = executeQuery(sql, idCliente, idLoja, status);

        return pedido.isEmpty() ? null : pedido.get(0);
    }
    
    public boolean cancelarPedido(int idPedido, String dhCancelamento, String razaoC){
        boolean aux = false;
        String sql = "UPDATE pedidos SET status = ? WHERE id = ?";
        
        aux = executeUpdate(sql, "Cancelado", idPedido);
        if(aux){
            sql = "UPDATE pedidos SET razao_cancelamento = ?, data_hora_fechamento = ? WHERE id = ?";
            aux = executeUpdate(sql, razaoC, dhCancelamento, idPedido);
        }
            
        return aux;
    }
    
    public boolean confirmarEntrega(int idPedido, String dhEntregue){
        boolean aux = false;
        String sql = "UPDATE pedidos SET status = ? WHERE id = ?";
        
        aux = executeUpdate(sql, "Entregue", idPedido);
        if(aux){
            sql = "UPDATE pedidos SET data_hora_fechamento = ? WHERE id = ?";
            aux = executeUpdate(sql, dhEntregue, idPedido);
        }
            
        return aux;
    }
    
    public boolean confirmarPedido(int idPedido, String dhConfirmacao){
        boolean aux = false;
        String sql = "UPDATE pedidos SET status = ? WHERE id = ?";
        
        aux = executeUpdate(sql, "Confirmado", idPedido);
        if(aux){
            sql = "UPDATE pedidos SET data_hora_fechamento = ? WHERE id = ?";
            aux = executeUpdate(sql, dhConfirmacao, idPedido);
        }
            
        return aux;
    }

    public int getPedidoId() {
        String sql = "SELECT * FROM pedidos WHERE id = LAST_INSERT_ID()";

        ArrayList<PedidoDTO> pedido = (ArrayList<PedidoDTO>) executeQuery(sql);

        return pedido.isEmpty() ? -1 : pedido.get(0).getId();
    }
}
