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

@WebServlet(name = "remover-ponto-encontro", urlPatterns = {"/minha-loja/pontos/remover-ponto-encontro"})
public class removerPontoEncontro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        int id = Integer.parseInt(request.getParameter("id"));

        int campus = Integer.parseInt(request.getParameter("campus"));

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        PontoEncontroService pontoEncontroService = PontoEncontroService.getInstance();

        pontoEncontroService.remover(loja.getId(), id);

        @SuppressWarnings("unchecked")
        ArrayList<ArrayList<PontoEncontroDTO>> pontos = (ArrayList<ArrayList<PontoEncontroDTO>>) session.getAttribute("pontosEncontro");

        ArrayList<PontoEncontroDTO> pontosCampus = pontos.get(campus - 1);

        for(PontoEncontroDTO ponto : pontosCampus) {
            if(ponto.getId() == id) {
                pontosCampus.remove(ponto);
                break;
            }
        }

        session.setAttribute("pontosEncontro", pontos);

        responseData.addProperty("responseType", "success");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
