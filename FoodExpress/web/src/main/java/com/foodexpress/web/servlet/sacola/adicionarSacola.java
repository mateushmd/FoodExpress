package com.foodexpress.web.servlet.sacola;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.ItemSacolaService;
import com.foodexpress.model.service.LojaService;
import com.foodexpress.model.service.ProdutoService;
import com.foodexpress.model.util.JsonHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "adicionar-sacola", urlPatterns = {"/sacola/adicionar-sacola"})
public class adicionarSacola extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        String idCliente = ((UsuarioDTO) session.getAttribute("usuario")).getEmail();

        int idProduto = Integer.parseInt(request.getParameter("idProduto"));

        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        ProdutoService produtoService = ProdutoService.getInstance();

        ProdutoDTO produto = produtoService.getProdutoById(idProduto);

        double precoItem = produto.getPreco();

        double precoTotal = precoItem * quantidade;

        ItemSacolaDTO item = new ItemSacolaDTO();
        item.setIdUsuario(idCliente);
        item.setIdProduto(idProduto);
        item.setQuantidade(quantidade);
        item.setPrecoItem(precoItem);
        item.setPrecoTotal(precoTotal);

        ItemSacolaService iService = ItemSacolaService.getInstance();

        iService.addItem(item);

        SacolaViewDTO sacola = (SacolaViewDTO) session.getAttribute("sacola");

        ItemSacolaViewDTO itemAdicionado = iService.getItemNovo(idCliente, sacola.getItens());

        JsonObject responseData = new JsonObject();

        if(itemAdicionado == null) {
            sacola.updateItem(item.getIdProduto(), item.getQuantidade(), item.getPrecoTotal());

            session.setAttribute("sacola", sacola);

            responseData.addProperty("responseType", "atualizar");
            responseData.addProperty("idProduto", item.getIdProduto());
            responseData.addProperty("quantidade", item.getQuantidade());
            responseData.addProperty("precoTotal", item.getPrecoTotal());

            System.out.println("atualizando item");

            response.getWriter().write(responseData.toString());

            return;
        }

        if(sacola.getIdLoja() == -1) {
            responseData.addProperty("responseType", "gerarSacola");

            LojaService lojaService = LojaService.getInstance();

            LojaDTO loja = lojaService.getLojaById(produto.getIdLoja());

            responseData.addProperty("idLoja", loja.getId());
            responseData.addProperty("nomeLoja", loja.getNome());

            sacola.setIdLoja(loja.getId());
            sacola.setNomeLoja(loja.getNome());

            System.out.println("gerando sacola");
        } else {
            responseData.addProperty("responseType", "adicionar");

            System.out.println("adicionando à sacola");
        }

        sacola.addItem(itemAdicionado);

        session.setAttribute("sacola", sacola);

        responseData = JsonHandler.addToJson(itemAdicionado, responseData);

        response.getWriter().write(responseData.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
