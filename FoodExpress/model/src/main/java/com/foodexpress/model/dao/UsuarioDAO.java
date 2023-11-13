package com.foodexpress.model.dao;

import com.foodexpress.model.encoder.Argon2Encoder;
import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class UsuarioDAO extends DAOTemplate<UsuarioDTO> {
    private static UsuarioDAO instance = null;
    
    private final Argon2Encoder encoder;

    private UsuarioDAO() {
        super();
        
        encoder = Argon2Encoder.getEncoder();
    }
    
    public static synchronized UsuarioDAO getInstance() {
        if(instance == null)
            instance = new UsuarioDAO();
        
        return instance;
    }
    
    @Override
    protected UsuarioDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        
        UsuarioDTO user = null;
        
        try {
            user = new UsuarioDTO();
            
            user.setEmail(rs.getString("email"));
            user.setNome(rs.getString("nome"));
            user.setSenha(rs.getString("senha")); // Decode the hashed password if needed.
            user.setTelefone(rs.getString("telefone"));
            user.setTipo(rs.getInt("tipo"));
            user.setVerificado(rs.getBoolean("verificado"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }

    public int cadastrar(UsuarioDTO obj) {
        UsuarioDTO usuario = getUsuario(obj.getEmail());

        if(usuario != null) {
            if(!usuario.getVerificado())
                return -1; //Remover Token e usuário para refazer o cadastro
            else
                return 0;
        }

        String sql = "INSERT INTO usuarios (email, nome, senha, telefone, tipo, verificado) VALUES (?, ?, ?, ?, ?, ?)";
        
        return executeUpdate(sql, obj.getEmail(), obj.getNome(), encoder.encode(obj.getSenha()), obj.getTelefone(), obj.getTipo(), obj.getVerificado()) ? 1 : 0;
    }

    public int login(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        List<UsuarioDTO> users = executeQuery(sql, email);
        
        //Login não encontrado
        if (users.isEmpty()) {
            return -1;
        }
        
        UsuarioDTO user = users.get(0);
        
        //Senha incorreta
        if (!encoder.check(senha, user.getSenha())) {
            return -1;
        }
        
        //Email não verificado
        if (!user.getVerificado()) {
            return 0;
        }

        return 1;
    }
    
    public boolean updateVerificacao(String email) {
        String sqlUpdate = "UPDATE usuarios SET verificado = ? WHERE email = ?";
        
        return executeUpdate(sqlUpdate, true, email);
    }

    public boolean alterarDados(String email, String novoNome, String novoTelefone) {
        String sqlUpdate = "UPDATE usuarios SET nome = ?, telefone = ? WHERE email = ?";
        
        return executeUpdate(sqlUpdate, novoNome, novoTelefone, email);
    }

    public UsuarioDTO getUsuario(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        List<UsuarioDTO> users = executeQuery(sql, email);
        
        return users.isEmpty() ? null : users.get(0);
    }
    
    public boolean redefinirSenha(String email, String senha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
        
        return executeUpdate(sql, encoder.encode(senha), email);
    }
    
    public boolean abrirLoja(String email) {
        String sql = "UPDATE usuarios SET tipo = 2 WHERE email = ?";
        
        return executeUpdate(sql, email);
    }
   
    public List<UsuarioDTO> ListarUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuarios ORDER BY nome";
        
        return executeQuery(sql);
    }

    public boolean removerUsuario(String email) {
        String sql = "DELETE FROM usuarios WHERE email = ?";

        return executeUpdate(sql, email);
    }

    protected boolean existeUsuario(String email) {
        String sql = "SELECT 1 FROM usuarios WHERE email = ?";

        return executeExist(sql, email);
    }
}
