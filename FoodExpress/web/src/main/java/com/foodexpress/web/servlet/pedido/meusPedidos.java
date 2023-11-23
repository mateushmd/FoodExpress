package com.foodexpress.web.servlet.pedido;

import com.foodexpress.model.dto.PedidoDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.PedidoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "meus-pedidos", urlPatterns = {"/meus-pedidos"})
public class meusPedidos extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

        PedidoService pedidoService = PedidoService.getInstance();

        ArrayList<PedidoDTO> pedidos = (ArrayList<PedidoDTO>) pedidoService.getPedidosCliente(usuario.getEmail());

        request.setAttribute("pedidos", pedidos);

        RequestDispatcher rd = request.getRequestDispatcher("pedidos.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
