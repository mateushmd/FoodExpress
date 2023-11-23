/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.autenticacao;

import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.UsuarioService;
import com.google.api.client.json.Json;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "cadastrar", urlPatterns = {"/cadastrar"})
public class cadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        UsuarioService uservice = UsuarioService.getInstance();
        UsuarioDTO uDTO = new UsuarioDTO();

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("senha");
        String phone = request.getParameter("telefone");
        int tipo = Integer.parseInt(request.getParameter("tipo"));

        uDTO.setNome(nome);
        uDTO.setEmail(email);
        uDTO.setSenha(password);
        uDTO.setTelefone(phone);
        uDTO.setTipo(tipo);

        int check = uservice.cadastrar(uDTO);

        if(check == 0) {
            responseData.addProperty("responseType", "error");
            responseData.addProperty("message", "Este endereço de e-mail já está associado a uma conta.");
            response.getWriter().write(responseData.toString());
            return;
        }

        responseData.addProperty("responseType", "redirect");

        responseData.addProperty("redirect", "verificacao.jsp");

        session.setAttribute("email", uDTO.getEmail());

        response.getWriter().write(responseData.toString());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
