package com.foodexpress.web.servlet.favoritos;

import com.foodexpress.model.dto.FavoritosDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.FavoritosService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.core.Request;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="meus-favoritos", urlPatterns = {"/meus-favoritos"})
public class meusFavoritos extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String idUsuario = ((UsuarioDTO) session.getAttribute("usuario")).getEmail();

        FavoritosService fservice = FavoritosService.getInstance();

        ArrayList<LojaDTO> favoritos = (ArrayList<LojaDTO>) fservice.getLojasFavoritos(idUsuario);

        request.setAttribute("favoritos", favoritos);

        RequestDispatcher rd = request.getRequestDispatcher("favoritos.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
