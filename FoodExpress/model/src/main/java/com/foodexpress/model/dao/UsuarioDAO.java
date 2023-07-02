package com.foodexpress.model.dao;

import com.foodexpress.model.encoder.Argon2Encoder;
import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends DAOTemplate<UsuarioDTO> {
    
    private static UsuarioDAO instance = null;
    
    private UsuarioDTO user;

    private UsuarioDAO() {
        super();
    }
    
    public static synchronized UsuarioDAO getInstance() {
        if(instance == null)
            instance = new UsuarioDAO();
        
        return instance;
    }

    public void insert(UsuarioDTO obj) {
        System.out.println("passei aqui");

        Argon2Encoder encoder = Argon2Encoder.getEncoder();

        String sqlInsert = "INSERT INTO usuarios (email, nome, senha, telefone, tipo, verificado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getEmail());
            st.setString(2, obj.getNome());
            st.setString(3, encoder.encode(obj.getSenha()));
            st.setString(4, obj.getTelefone());
            st.setInt(5, obj.getTipo());
            st.setBoolean(6, false);

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                ConexaoBD.closeResultSet(rs);
            } else {
                throw new SQLException("Erro inesperado, nehuma linha foi afetada!");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int login(String email, String senha) {
        Argon2Encoder encoder = Argon2Encoder.getEncoder();

        String sql = "SELECT * FROM usuarios WHERE email = ?";

        ResultSet r = null;

        try {
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, email);

            r = st.executeQuery();
            while (r.next()) {
                user = new UsuarioDTO(r.getString("email"), r.getString("nome"), r.getString("senha"), r.getString("telefone"), r.getInt("tipo"), r.getBoolean("verificado"));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!encoder.check(senha, user.getSenha()) || user == null) {
                System.out.println("Login não encontrado!");
                return -1;
            }

            if (!user.getVerificado()) {
                System.out.println("O email associado a esta conta não foi verificado.");
                return 0;
            }

            System.out.println("nome " + user.getNome() + " senha: " + user.getSenha() + " Tipo: " + user.getTipo());
            return 1;
        }
    }
    
    public boolean updateVerificacao(String email) {
        String sqlUpdate = "UPDATE usuarios SET verificado = ? WHERE email = ?";
        
        int affectedLines = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
            
            st.setBoolean(1, true);
            st.setString(2, email);
                        
            affectedLines = st.executeUpdate();
            
            System.out.println("updateVerificacao(): affectedLines " + affectedLines);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return affectedLines > 0;
        }
    }

    public boolean update(UsuarioDTO obj) {
        
        String sqlUpdate = "UPDATE usuarios SET nome = ?, telefone = ? WHERE email = ?";
        
        int affectedLines = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getTelefone());
            st.setString(3, obj.getEmail());

            affectedLines = st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return affectedLines > 0;
        }
    }

    public UsuarioDTO getUsuario(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        PreparedStatement st = null;
        ResultSet rs = null;
        
        UsuarioDTO obj = null;
        
        try {
            st = conn.prepareStatement(sql);

            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()) {
                obj = new UsuarioDTO();
                obj.setEmail(rs.getString("email"));
                obj.setNome(rs.getString("nome"));
                obj.setSenha(null);
                obj.setTelefone(rs.getString("telefone"));
                obj.setTipo(rs.getInt("tipo"));
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
            
            return obj;
        }
    }
    
    public boolean redefinirSenha(String email, String senha) {
        Argon2Encoder encoder = Argon2Encoder.getEncoder();
        
        String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
        
        int affectedLines = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, encoder.encode(senha));
            st.setString(2, email);
            
            affectedLines = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return affectedLines > 0;
        }
    }
    
    @Override
    public boolean delete(UsuarioDTO obj) {
        String sqlDelete = "DELETE FROM usuarios WHERE email = ?";
        
        int affectedLines = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            
            st.setString(1, obj.getEmail());
            
            affectedLines = st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return affectedLines > 0;
        }
    }
    
   
    public List<UsuarioDTO> ListarUsuarios() throws SQLException {
        List<UsuarioDTO> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM usuarios " + "ORDER BY nome");
            rs = st.executeQuery();

            while (rs.next()) {
                UsuarioDTO obj = new UsuarioDTO();
                obj.setEmail(rs.getString("email"));
                obj.setNome(rs.getString("nome"));
                obj.setSenha(rs.getString("senha"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTipo(rs.getInt("tipo"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    public UsuarioDTO getUser() {
        return user;
    }
}
