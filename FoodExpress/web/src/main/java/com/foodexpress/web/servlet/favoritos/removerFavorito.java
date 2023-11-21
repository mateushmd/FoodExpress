package com.foodexpress.web.servlet.favoritos;

import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.FavoritosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="remover-favorito", urlPatterns = {"/favoritos/remover-favorito"})
public class removerFavorito extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String idCliente = ((UsuarioDTO) session.getAttribute("usuario")).getEmail();

        int idLoja = Integer.parseInt(request.getParameter("idLoja"));

        FavoritosService fservice = FavoritosService.getInstance();

        fservice.removerFavorito(idCliente, idLoja);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
