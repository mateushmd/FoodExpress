/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author chsdi
 */
@WebServlet(name = "editarPerfil", urlPatterns = {"/editarPerfil"})
public class editarPerfil extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        
        String email = request.getParameter("defMail");
        
        String submit = request.getParameter("submit");
        
        if(submit.equals("ALTERAR SENHA")) {
            request.setAttribute("email", email);
            
            rd = request.getRequestDispatcher("confirmarsenha.jsp");
            
            rd.forward(request, response);
            
            return;
        }
        
        UsuarioService uservice = new UsuarioService();
        
        UsuarioDTO uDTO;
        
        String nome = request.getParameter("name");
        
        String telefone = request.getParameter("tel");
        
        String defaultNome = request.getParameter("defName");
        
        String defaultTel = request.getParameter("defTel");
        
        if(nome == null || nome.isBlank() || nome.isEmpty()) {
            nome = defaultNome;
        }
        
        if(telefone == null || telefone.length() < 18 || telefone.isBlank()) {
            telefone = defaultTel;
        }
        
        uDTO = new UsuarioDTO();
        
        uDTO.setNome(nome);
        uDTO.setTelefone(telefone);
        uDTO.setEmail(email);
        
        System.out.println(uservice.update(uDTO));
        
        uDTO = uservice.getUsuario(email);
        
        request.setAttribute("usuario", uDTO);
        
        rd = request.getRequestDispatcher("perfil.jsp");
        rd.forward(request, response);
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
        processRequest(request, response);
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
