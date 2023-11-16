/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.vendedor;

import com.foodexpress.model.dto.AvaliacaoDTO;
import com.foodexpress.model.dto.CategoriaDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.AvaliacaoService;
import com.foodexpress.model.service.CategoriaService;
import com.foodexpress.model.service.LojaService;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author chsdi
 */
@WebServlet(name = "carregar-loja", urlPatterns = {"/carregar-loja"})
public class carregarLoja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

        if(session.getAttribute("usuario") == null) {
            response.sendRedirect("logout");
            return;
        }

        LojaService lojaService = LojaService.getInstance();
        LojaDTO loja;

        loja = lojaService.getLoja(usuario.getEmail());

        if(loja.getNome() == null) {
            response.sendRedirect("boas-vindas.jsp");
            return;
        }

        CategoriaService categoriaService = CategoriaService.getInstance();
        ArrayList<CategoriaDTO> categorias;

        AvaliacaoService avaliacaoService = AvaliacaoService.getInstance();
        ArrayList<AvaliacaoDTO> avaliacoes;

        categorias = (ArrayList<CategoriaDTO>) categoriaService.listarCompleto(loja.getId());

        avaliacoes = (ArrayList<AvaliacaoDTO>) avaliacaoService.getAvaliacaoByIdLoja(loja.getId());

        session.setAttribute("loja", loja);
        session.setAttribute("categorias", categorias);
        session.setAttribute("avaliacoes", avaliacoes);

        response.sendRedirect("minha-loja.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
