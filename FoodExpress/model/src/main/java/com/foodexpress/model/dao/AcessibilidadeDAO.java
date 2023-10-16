package com.foodexpress.model.dao;

import com.foodexpress.model.dto.AcessibilidadeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class AcessibilidadeDAO extends DAOTemplate<AcessibilidadeDTO> {
    private static AcessibilidadeDAO instance = null;

    private AcessibilidadeDAO() { super(); }

    public static synchronized AcessibilidadeDAO getInstance() {
        if(instance == null)
            instance = new AcessibilidadeDAO();

        return instance;
    };

    @Override
    protected AcessibilidadeDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        AcessibilidadeDTO item = null;

        try {
            item = new AcessibilidadeDTO();

            item.setIdUser(rs.getString("id_usuario"));
            item.setTemaEscuro(rs.getBoolean("tema_escuro"));
            item.setContraste(rs.getBoolean("contraste"));
            item.setVisibilidadeTexto(rs.getBoolean("visibilidade_texto"));
            item.setTamanhoTexto(rs.getInt("tamanho_texto"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return item;
    }

    public boolean inserirConfiguracoes(String idUsuario) {
        String sql = "INSERT INTO acessibilidade (id_usuario, tema_escuro, contraste, visibilidade_texto, tamanho_texto) VALUE (?, ?, ?, ?, ?)";

        return executeUpdate(sql, idUsuario, false, false, false, 100);
    }

    public boolean atualizarConfiguracoes(AcessibilidadeDTO obj) {
        String sql = "UPDATE acessibilidade SET tema_escuro = ?, contraste = ?, visibilidade_texto = ?, tamanho_texto = ? WHERE id_usuario = ?";

        return executeUpdate(sql, obj.getTemaEscuro(), obj.getContraste(), obj.getVisibilidadeTexto(), obj.getTamanhoTexto(), obj.getIdUser());
    }

    public AcessibilidadeDTO getConfiguracoes(String idUsuario) {
        String sql = "SELECT * FROM acessibilidade WHERE id_usuario = ?";

        List<AcessibilidadeDTO> configuracoes = executeQuery(sql, idUsuario);

        return configuracoes.isEmpty() ? null : configuracoes.get(0);
    }
}
