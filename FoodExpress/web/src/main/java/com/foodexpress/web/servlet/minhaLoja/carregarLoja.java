/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.minhaLoja;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;

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

        AgendaLojaService agendaLojaService = AgendaLojaService.getInstance();
        ArrayList<AgendaLojaDTO> agenda;

        PontoEncontroService pontoEncontroService = PontoEncontroService.getInstance();
        ArrayList<ArrayList<PontoEncontroDTO>> pontos;

        PedidoService pedidoService = PedidoService.getInstance();
        ArrayList<PedidoDTO> pedidos;

        categorias = (ArrayList<CategoriaDTO>) categoriaService.listarCompleto(loja.getId());

        avaliacoes = (ArrayList<AvaliacaoDTO>) avaliacaoService.getAvaliacaoByIdLoja(loja.getId());

        agenda = (ArrayList<AgendaLojaDTO>) agendaLojaService.getAgendasByLoja(loja.getId());

        pontos = pontoEncontroService.getByLoja(loja.getId());

        pedidos = (ArrayList<PedidoDTO>) pedidoService.getPedidosLoja(loja.getId());

        session.setAttribute("loja", loja);
        session.setAttribute("categorias", categorias);
        session.setAttribute("avaliacoes", avaliacoes);
        session.setAttribute("agenda", agenda);
        session.setAttribute("pontosEncontro", pontos);
        session.setAttribute("pedidos", pedidos);

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
}
