package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemSacolaViewDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class ItemSacolaViewDAO extends DAOTemplate<ItemSacolaViewDTO> {

    private static ItemSacolaViewDAO instance = null;

    private ItemSacolaViewDAO() { super(); }

    public static synchronized ItemSacolaViewDAO getInstance() {
        if(instance == null)
            instance = new ItemSacolaViewDAO();

        return instance;
    }

    @Override
    protected ItemSacolaViewDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        ItemSacolaViewDTO item = null;

        try{
            item = new ItemSacolaViewDTO();

            item.setUsuarioId(rs.getString("usuario_id"));
            item.setItemSacolaId(rs.getInt("item_id"));
            item.setProdutoId(rs.getInt("produto_id"));
            item.setProdutoNome(rs.getString("produto_nome"));
            item.setProdutoDescricao(rs.getString("produto_descricao"));
            item.setPreco(rs.getDouble("produto_preco"));
            item.setQuantidade(rs.getInt("item_quantidade"));
            item.setPrecoTotal(rs.getDouble("item_preco_total"));

        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public List<ItemSacolaViewDTO> getItensView(String idUsuario) {
        String sql = "SELECT * from item_sacola_view WHERE usuario_id = ?";

        List<ItemSacolaViewDTO> lista = executeQuery(sql, idUsuario);

        return lista.isEmpty() ? null : lista;
    }

    public ItemSacolaViewDTO getItemNovo(String idUsuario, List<ItemSacolaViewDTO> itensAtuais) {
        List<ItemSacolaViewDTO> lista;

        if(itensAtuais.isEmpty()) {
            lista = getItensView(idUsuario);
            return lista != null ? lista.get(0) : null;
        }

        StringBuilder sql = new StringBuilder("SELECT * from item_sacola_view WHERE usuario_id = ? AND item_id NOT IN (");

        for(int i = 0; i < itensAtuais.size(); i++) {
            sql.append(itensAtuais.get(i).getItemSacolaId());

            if(i < itensAtuais.size() - 1) sql.append(", ");
        }

        sql.append(")");

        lista = executeQuery(sql.toString(), idUsuario);

        return lista.isEmpty() ? null : lista.get(0);
    }
}
