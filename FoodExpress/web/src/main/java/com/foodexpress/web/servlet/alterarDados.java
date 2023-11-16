package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.FavoritosService;
import com.foodexpress.model.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="alterar-dados", urlPatterns = {"/alterar-dados"})
public class alterarDados extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

        String idCliente = usuario.getEmail();

        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        UsuarioService uService = UsuarioService.getInstance();

        if(uService.alterarDados(idCliente, nome, telefone)) {
            usuario.setNome(nome);
            usuario.setTelefone(telefone);
            session.setAttribute("usuario", usuario);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
