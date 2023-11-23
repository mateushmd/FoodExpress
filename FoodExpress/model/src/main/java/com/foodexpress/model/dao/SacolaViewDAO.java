package com.foodexpress.model.dao;

import com.foodexpress.model.dto.SacolaViewDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SacolaViewDAO extends DAOTemplate<SacolaViewDTO> {

    public static SacolaViewDAO instance = null;

    private SacolaViewDAO() { super(); }

    public static synchronized SacolaViewDAO getInstance() {
        if(instance == null)
            instance = new SacolaViewDAO();

        return instance;
    }

    @Override
    protected SacolaViewDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        SacolaViewDTO sacola = new SacolaViewDTO();

        sacola.setIdLoja(rs.getInt("id_loja"));
        sacola.setNomeLoja(rs.getString("nome_loja"));

        return sacola;
    }

    public SacolaViewDTO getSacola(String idUsuario) {
        String sql = "SELECT * FROM sacola_view WHERE id_usuario = ?";

        List<SacolaViewDTO> lista = executeQuery(sql, idUsuario);

        return lista.isEmpty() ? null : lista.get(0);
    }
}
