package com.foodexpress.web.servlet;

import com.foodexpress.model.dto.TokenVerificacaoDTO;
import com.foodexpress.model.dto.UsuarioDTO;
import com.foodexpress.model.service.AcessibilidadeService;
import com.foodexpress.model.service.LojaService;
import com.foodexpress.model.service.TokenVerificacaoService;
import com.foodexpress.model.service.UsuarioService;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "confirmar-email", urlPatterns = {"/confirmar-email"})
public class confirmarEmail extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        JsonObject responseData = new JsonObject();

        HttpSession session = request.getSession();

        String email = (String) session.getAttribute("email");

        String token = request.getParameter("codigo");

        TokenVerificacaoService tokenVerificacaoService = TokenVerificacaoService.getInstance();

        TokenVerificacaoDTO tDTO = new TokenVerificacaoDTO();

        tDTO.setEmailUsuario(email);
        tDTO.setToken(token);

       boolean check = tokenVerificacaoService.validarToken(tDTO);

        if(!check) {
            responseData.addProperty("responseType", "error");
            responseData.addProperty("message", "Código inválido.");

            response.getWriter().write(responseData.toString());

            return;
        }

        UsuarioService usuarioService = UsuarioService.getInstance();

        UsuarioDTO usuario = usuarioService.getUsuario(email);

        session.setAttribute("usuario", usuario);

        responseData.addProperty("responseType", "redirect");
        responseData.addProperty("redirect", "redefinir-senha.jsp");

        session.removeAttribute("email");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
