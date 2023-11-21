package com.foodexpress.web.servlet.minhaLoja.pontos;

import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.dto.PontoEncontroDTO;
import com.foodexpress.model.service.PontoEncontroService;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "adicionar-ponto-encontro", urlPatterns = {"/minha-loja/pontos/adicionar-ponto-encontro"})
public class adicionarPontoEncontro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int campus = Integer.parseInt(request.getParameter("campus"));

        String nome = request.getParameter("nome");

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        PontoEncontroService pontoEncontroService = PontoEncontroService.getInstance();
        PontoEncontroDTO pontoEncontro = new PontoEncontroDTO(loja.getId(), campus, nome);

        pontoEncontro = pontoEncontroService.adicionar(pontoEncontro);

        @SuppressWarnings("unchecked")
        ArrayList<ArrayList<PontoEncontroDTO>> pontos = (ArrayList<ArrayList<PontoEncontroDTO>>) session.getAttribute("pontosEncontro");

        pontos.get(pontoEncontro.getCampus() - 1).add(pontoEncontro);

        session.setAttribute("pontosEncontro", pontos);

        responseData.addProperty("responseType", "success");
        responseData.addProperty("id", pontoEncontro.getId());

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
