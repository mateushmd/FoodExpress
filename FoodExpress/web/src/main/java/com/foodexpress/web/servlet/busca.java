package com.foodexpress.web.servlet;

import com.foodexpress.model.dao.LojaDAO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.service.LojaService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "busca", urlPatterns = {"/busca"})
public class busca extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");

        String busca = request.getParameter("s");

        LojaService lojaService = LojaService.getInstance();

        ArrayList<LojaDTO> resultado = (ArrayList<LojaDTO>) lojaService.buscarLoja(busca);

        request.setAttribute("busca", busca);
        request.setAttribute("resultado", resultado);

        RequestDispatcher rd = request.getRequestDispatcher("busca.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
