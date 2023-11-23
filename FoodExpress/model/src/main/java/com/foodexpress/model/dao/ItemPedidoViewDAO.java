package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemPedidoDTO;
import com.foodexpress.model.dto.ItemSacolaViewDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class ItemPedidoViewDAO extends DAOTemplate<ItemPedidoDTO> {

    private static ItemPedidoViewDAO instance = null;

    private ItemPedidoViewDAO() { super(); }

    public static synchronized ItemPedidoViewDAO getInstance() {
        if(instance == null)
            instance = new ItemPedidoViewDAO();

        return instance;
    }

    @Override
    protected ItemPedidoDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        ItemPedidoDTO item = null;

        try{
            item = new ItemPedidoDTO();

            item.setNome(rs.getString("produto_nome"));
            item.setId(rs.getInt("id_item"));
            item.setIdProduto(rs.getInt("id_produto"));
            item.setIdPedido(rs.getInt("id_pedido"));
            item.setQuantidade(rs.getInt("item_quantidade"));
            item.setPrecoTotal(rs.getDouble("item_preco_total"));

        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public List<ItemPedidoDTO> getItensView(int idPedido) {
        String sql = "SELECT * from itens_pedido_view WHERE id_pedido = ?";

        List<ItemPedidoDTO> lista = executeQuery(sql, idPedido);

        return lista.isEmpty() ? null : lista;
    }
}
