/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.foodexpress.web.servlet.usuario;

import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.UsuarioService;
import com.google.gson.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "redefinir-senha", urlPatterns = {"/redefinir-senha"})
public class redefinirSenha extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

        UsuarioService uservice = UsuarioService.getInstance();
        
        String senha = request.getParameter("senha");
        
        boolean check = uservice.redefinirSenha(usuario.getEmail(), senha);

        if(!check)
        {
            responseData.addProperty("responseType", "error");

            response.getWriter().write(responseData.toString());

            return;
        }

        session.invalidate();

        responseData.addProperty("responseType", "success");
        responseData.addProperty("redirect", "login.jsp");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
