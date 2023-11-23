/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodexpress.model.dao;

import com.foodexpress.model.dto.LojaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class LojaDAO extends DAOTemplate<LojaDTO> {
    private static LojaDAO instance = null;
    
    private LojaDTO loja;
    
    private LojaDAO() {
        super();
    }
    
    public static synchronized LojaDAO getInstance(){
        if(instance == null)
            instance = new LojaDAO();
        
        return instance;
    }
    
    @Override
    protected LojaDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        LojaDTO loja = null;
        
        try{
            loja = new LojaDTO();
            
            loja.setId(rs.getInt("id"));
            loja.setNome(rs.getString("nome"));
            loja.setDescricao(rs.getString("descricao"));
            loja.setAvaliacao(rs.getDouble("avaliacao"));
            loja.setIdUser(rs.getString("id_usuario"));
            loja.setQtdAvaliacoes(rs.getInt("qtd_avaliacoes"));
            loja.setSomaAvaliacoes(rs.getInt("soma_avaliacoes"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(LojaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loja;
    }
    
    public boolean cadastrar(String email){
        String sql = "INSERT INTO lojas (id_usuario) VALUES (?)";
        
        return executeUpdate(sql, email);
    }
    
    public LojaDTO getLoja(String idUser) {
        String sql = "SELECT * FROM lojas WHERE id_usuario = ?";
        
        List<LojaDTO> lojas = executeQuery(sql, idUser);
        
        return lojas.isEmpty() ? null : lojas.get(0);
    }
    
    public LojaDTO getLojaById(int idLoja) {
        String sql = "SELECT * FROM lojas WHERE id = ?";
        
        List<LojaDTO> lojas = executeQuery(sql, idLoja);
        
        return lojas.isEmpty() ? null : lojas.get(0);
    }

    public List<LojaDTO> buscarLoja(String b){
        String busca = "%" + b + "%";
        String sql = "SELECT * FROM foodexpress.lojas WHERE nome LIKE ? ORDER BY nome";

        return executeQuery(sql, busca);
    }

    public boolean updateNomeDescricao(int id, String nome, String descricao){
        String sqlUpdate = "UPDATE lojas SET nome = ?, descricao = ? WHERE id = ?";
        
        return executeUpdate(sqlUpdate, nome, descricao, id);
    }

    public boolean updateNome(int id, String nome) {
        String sql = "UPDATE lojas SET nome = ? WHERE id = ?";

        return executeUpdate(sql, nome, id);
    }

    public boolean updateAvaliacao(LojaDTO obj){
        String sqlUpdate = "UPDATE lojas SET avaliacao = ?, qtd_avaliacoes = ?, soma_avaliacoes = ? WHERE id = ?";
        
        return executeUpdate(sqlUpdate, obj.getAvaliacao(), obj.getQtdAvaliacoes(), obj.getSomaAvaliacoes(), obj.getId());
    }

    public List<LojaDTO> getMaisBemAvaliadas() {
        String sql = "SELECT * FROM lojas ORDER BY avaliacao DESC LIMIT 5";

        return executeQuery(sql);
    }

    public List<LojaDTO> getMaisRecentes() {
        String sql = "SELECT * FROM lojas WHERE data_criacao >= NOW() - INTERVAL 2 WEEK ORDER BY data_criacao DESC LIMIT 10";

        return executeQuery(sql);
    }

    public List<LojaDTO> listarLojas(int offSet) {
        String sql = "SELECT * FROM lojas WHERE nome IS NOT NULL LIMIT 8 OFFSET " + offSet;
        
        return executeQuery(sql);
    }
    
    public LojaDTO getLoja(){
        return loja;
    }

    public boolean insertLojaTest(String idUsuario, String nomeLoja) {
        String sql = "INSERT INTO lojas (id_usuario, nome) VALUES (?, ?)";

        return executeUpdate(sql, idUsuario, nomeLoja);
    }

    public int getTotalLojas() {
        String sql = "SELECT COUNT(*) AS total FROM lojas";

        return count(sql);
    }


}
