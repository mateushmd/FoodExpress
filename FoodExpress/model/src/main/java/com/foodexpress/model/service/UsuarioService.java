package com.foodexpress.model.service;

import com.foodexpress.model.dao.UsuarioDAO;
import com.foodexpress.model.dao.DAOFactory;
import com.foodexpress.model.dto.UsuarioDTO;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao = DAOFactory.createUsuarioDAO();

    public void login(String email, String senha){
        dao.Login(email, senha);
    }
    
    public void update(UsuarioDTO obj) {
        dao.update(obj);
    }

    public void delete(String email) {
        dao.deleteByEmail(email);
    }

    public UsuarioDTO validaUsuario(UsuarioDTO obj) throws SQLException {
        return dao.validaUsuario(obj);
    }

    public UsuarioDTO findByLogin(String email) throws SQLException {
        return dao.findByEmail(email);
    }

    public void cadastrar(UsuarioDTO obj) {
        dao.insert(obj);
    }

    public List<UsuarioDTO> ListarUsuario() throws SQLException {
        return dao.ListarUsuarios();
    }
    
    public UsuarioDTO getUser(){
        return dao.getUser();
    }

}
