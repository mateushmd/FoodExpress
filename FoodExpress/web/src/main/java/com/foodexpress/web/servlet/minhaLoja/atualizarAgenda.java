package com.foodexpress.web.servlet.minhaLoja;

import com.foodexpress.model.dto.AgendaLojaDTO;
import com.foodexpress.model.dto.LojaDTO;
import com.foodexpress.model.service.AgendaLojaService;
import com.foodexpress.model.util.JsonObjectToList;
import com.foodexpress.model.util.TimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;


@WebServlet(name = "atualizar-agenda", urlPatterns = {"/minha-loja/atualizar-agenda"})
public class atualizarAgenda extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        LojaDTO loja = (LojaDTO) session.getAttribute("loja");

        BufferedReader reader = request.getReader();

        StringBuilder stringBuilder = new StringBuilder();

        String line;

        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Time.class, new TimeDeserializer())
                .create();

        JsonObjectToList<AgendaLojaDTO> objectList = gson.fromJson(stringBuilder.toString(), new TypeToken<JsonObjectToList<AgendaLojaDTO>>() {}.getType());

        ArrayList<AgendaLojaDTO> novaAgenda = (ArrayList<AgendaLojaDTO>) objectList.getLista();

        AgendaLojaService agendaLojaService = AgendaLojaService.getInstance();

        ArrayList<AgendaLojaDTO> agenda = (ArrayList<AgendaLojaDTO>) agendaLojaService.updateAgenda(loja.getId(), novaAgenda);

        session.setAttribute("agenda", agenda);

        responseData.addProperty("responseType", "success");

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
