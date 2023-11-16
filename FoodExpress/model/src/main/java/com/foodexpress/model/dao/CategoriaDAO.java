package com.foodexpress.model.dao;

import com.foodexpress.model.dto.CategoriaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class CategoriaDAO extends DAOTemplate<CategoriaDTO> {
    private static CategoriaDAO instance = null;

    private CategoriaDAO() { super(); }

    public static synchronized  CategoriaDAO getInstance() {
        if(instance == null)
            instance = new CategoriaDAO();

        return instance;
    }

    @Override
    protected CategoriaDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        CategoriaDTO categoria = null;

        try {
            categoria = new CategoriaDTO();

            categoria.setId(rs.getInt("id"));
            categoria.setIdLoja(rs.getInt("id_loja"));
            categoria.setNome(rs.getString("nome "));
        } catch(SQLException ex) {
            java.util.logging.Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoria;
    }

    public boolean inserir(CategoriaDTO obj) {
        String sql = "INSERT INTO categorias (id_loja, nome) VALUES (?, ?)";

        return executeUpdate(sql, obj.getIdLoja(), obj.getNome());
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

        return executeUpdate(sql, id);
    }

    public List<CategoriaDTO> listar(int idLoja) {
        String sql = "SELECT * FROM categorias WHERE id_loja = ?";

        List<CategoriaDTO> categorias = executeQuery(sql, idLoja);
        
        return categorias.isEmpty() ? null : categorias;
    }

    public CategoriaDTO getUltimaCategoria() {
        String sql = "SELECT * FROM categorias WHERE id = LAST_INSERT_ID()";

        List<CategoriaDTO> categoria = executeQuery(sql);

        return categoria.isEmpty() ? null : categoria.get(0);
    }
}
