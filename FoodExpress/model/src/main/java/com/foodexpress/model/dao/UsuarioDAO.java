package com.foodexpress.model.dao;

import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.Random;


public class UsuarioDAO {

    private Connection conn;
    
    private static UsuarioDTO user;
    private static String codigoRec;

    UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public UsuarioDAO() {
    }
    
    public void insert(UsuarioDTO obj) {
        System.out.println("passei aqui");
        String sqlInsert = "INSERT INTO usuarios (email, nome, senha, telefone, tipo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getEmail());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getSenha());
            st.setString(4, obj.getTelefone());
            st.setInt(5, obj.getTipo());

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
    
    public static boolean Login(String email, String senha){
        Connection conn = ConexaoBD.getConnection();
        String consulta = "SELECT * FROM usuarios WHERE email = '" + email + "' AND senha = '" + senha + "'";
        ResultSet r = null;
        Statement stm = null;
        
        try{
            stm = conn.createStatement();
            r = stm.executeQuery(consulta);
            while(r.next()){
                user = new UsuarioDTO(r.getString("email"), r.getString("nome"), r.getString("senha"), r.getString("telefone"), r.getInt("tipo"));
            }
        }catch (SQLException ex) {
            System.out.println("Login não encontrado.");
        } finally {
            ConexaoBD.closeStatement(stm);
            ConexaoBD.closeResultSet(r);
            if(user == null){
                System.out.println("Login não encontrado!");
                return false;
            } else{
                System.out.println("nome " + user.getNome() + " senha: " + user.getSenha() + " Tipo: " + user.getTipo());
                return true;
            }
        }
    }
    
    
    public static void recoverCod(String email){
        codigoRec = "";
        Random gerador = new Random();
        
        for(int i = 0; i < 6; i++){
            codigoRec += gerador.nextInt();
        }
    }

    public void update(UsuarioDTO obj) {
        String sqlUpdate = "UPDATE usuarios "
                + "SET email = ?, nome = ?, senha = ?, telefone = ?, tipo = ?"
                + "WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, obj.getEmail());
            st.setString(2, obj.getNome());
            st.setString(3, obj.getSenha());
            st.setString(4, obj.getTelefone());
            st.setInt(5, obj.getTipo());
            st.setString(6, obj.getEmail());// 

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteByEmail(String email) {
        String sqlDelete = "DELETE FROM usuarios WHERE email = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setString(1, email);// 
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UsuarioDTO findByEmail(String email) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM usuarios "
                    + "WHERE codigo = ?");

            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()) {
                UsuarioDTO obj = new UsuarioDTO();
                obj.setEmail(rs.getString("email"));
                obj.setNome(rs.getString("nome"));
                obj.setSenha(rs.getString("senha"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTipo(rs.getInt("tipo"));

                return obj;
            }

            return null;

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
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

    public UsuarioDTO validaUsuario(UsuarioDTO obj) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT login, senha, tipo FROM usuarios "
                    + "WHERE email = ?, senha = ?, tipo = ? ");

            st.setString(1, obj.getEmail());
            st.setString(2, obj.getSenha());
            st.setInt(3, obj.getTipo());

            rs = st.executeQuery();

            if (rs.next()) {
                UsuarioDTO c = new UsuarioDTO();
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setTipo(rs.getInt("tipo"));
                return c;
            }

            return null;

        }  catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } finally {
            ConexaoBD.closeStatement(st);
            ConexaoBD.closeResultSet(rs);
        }
    }

    public static UsuarioDTO getUser() {
        return user;
    }
}
