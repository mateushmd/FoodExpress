package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemPedidoDTO;
import com.foodexpress.model.dto.ItemSacolaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;

public class ItemSacolaDAO extends DAOTemplate<ItemSacolaDTO> {

    private static ItemSacolaDAO instance = null;

    private ItemSacolaDAO() { super(); }

    public static synchronized ItemSacolaDAO getInstance(){
        if(instance == null)
            instance = new ItemSacolaDAO();

        return instance;
    }

    @Override
    protected ItemSacolaDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        ItemSacolaDTO item = null;

        try{
            item = new ItemSacolaDTO();

            item.setId(rs.getInt("id"));
            item.setIdUsuario(rs.getString("id_usuario"));
            item.setIdProduto(rs.getInt("id_produto"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setPrecoItem(rs.getDouble("preco_item"));
            item.setPrecoTotal(rs.getDouble("preco_total"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public void addItem(ItemSacolaDTO item) {
        String sql = "INSERT INTO itens_sacola (id_usuario, id_produto, quantidade, preco_item, preco_total) VALUES(?, ?, ?, ?, ?)";

        executeUpdate(sql, item.getIdUsuario(), item.getIdProduto(), item.getQuantidade(), item.getPrecoItem(), item.getPrecoTotal());
    }

    public void removerItem(int id) {
        String sql = "DELETE FROM itens_sacola WHERE id = ?";

        executeUpdate(sql, id);
    }

    public List<ItemSacolaDTO> getItens(String idUsuario) {
        String sql = "SELECT * FROM itens_sacola WHERE id_usuario = ?";

        List<ItemSacolaDTO> lista = executeQuery(sql, idUsuario);

        return lista.isEmpty() ? null : lista;
    }


}
