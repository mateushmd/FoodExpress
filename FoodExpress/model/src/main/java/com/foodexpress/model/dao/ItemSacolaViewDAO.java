package com.foodexpress.model.dao;

import com.foodexpress.model.dto.ItemSacolaDTO;
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

            item.setItemSacolaId(rs.getInt("item_id"));
            item.setProdutoId(rs.getInt("produto_id"));
            item.setProdutoNome(rs.getString("produto_nome"));
            item.setProdutoDescricao(rs.getString("produto_rdescricao"));
            item.setPreco(rs.getDouble("produto_preco"));
            item.setQuantidade(rs.getInt("item_quantidade"));
            item.setPrecoTotal(rs.getDouble("item_preco_total"));

        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public List<ItemSacolaViewDTO> getItensView(String idUsuario) {
        String sql = """
                SELECT
                    p.id AS produto_id,
                    p.nome AS produto_nome,
                    p.descricao AS produto_descricao,
                    p.id_loja AS produto_id_loja,
                    p.preco AS produto_preco,
                    i.id AS item_id,
                    i.quantidade AS item_quantidade,
                    i.preco_total AS item_preco_total
                FROM
                    Produtos p
                JOIN
                    Itens_sacola i ON p.id = i.id_produto
                WHERE
                    i.id_usuario = ?;
                    """;

        List<ItemSacolaViewDTO> lista = executeQuery(sql, idUsuario);

        return lista.isEmpty() ? null : lista;
    }

    public List<ItemSacolaViewDTO> getNovoItens() {
        return null;
    }
}
