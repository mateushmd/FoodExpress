package com.foodexpress.web.servlet.sacola;

import com.foodexpress.model.dto.*;
import com.foodexpress.model.service.*;
import com.foodexpress.model.util.JsonHandler;
import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "adicionar-sacola", urlPatterns = {"/sacola/adicionar-sacola"})
public class adicionarSacola extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        HttpSession session = request.getSession();

        JsonObject responseData = new JsonObject();

        String idCliente = ((UsuarioDTO) session.getAttribute("usuario")).getEmail();

        int idProduto = Integer.parseInt(request.getParameter("idProduto"));

        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        ProdutoService produtoService = ProdutoService.getInstance();

        ProdutoDTO produto = produtoService.getProdutoById(idProduto);

        SacolaViewDTO sacola = (SacolaViewDTO) session.getAttribute("sacola");

        if(sacola.getIdLoja() != -1 && produto.getIdLoja() != sacola.getIdLoja()) {
            responseData.addProperty("responseType", "error");
            responseData.addProperty("msg", "Não é possível adicionar produtos de lojas diferentes na mesma sacola. Faça o pedido ou remova todos os itens antes de adicionar algum produto desta loja.");

            response.getWriter().write(responseData.toString());

            return;
        }

        double precoItem = produto.getPreco();

        double precoTotal = precoItem * quantidade;

        ItemSacolaDTO item = new ItemSacolaDTO();
        item.setIdUsuario(idCliente);
        item.setIdProduto(idProduto);
        item.setQuantidade(quantidade);
        item.setPrecoItem(precoItem);
        item.setPrecoTotal(precoTotal);

        ItemSacolaService iService = ItemSacolaService.getInstance();

        int check = iService.addItem(item);

        if(check == -1) {
            responseData.addProperty("responseType ", "error");
            responseData.addProperty("msg", "Cada item só pode conter um máximo de 10 unidades por pedido.");
        }

        ItemSacolaViewDTO itemAdicionado = iService.getItemNovo(idCliente, sacola.getItens());

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

            PontoEncontroService pontoEncontroService = PontoEncontroService.getInstance();

            ArrayList<PontoEncontroDTO> pontos = (ArrayList<PontoEncontroDTO>) pontoEncontroService.getCliente(loja.getId());

            if(pontos != null) {
                JsonArray jsonArray = new JsonArray();

                for(PontoEncontroDTO ponto : pontos) {
                    JsonObject pontoJson = new JsonObject();

                    pontoJson.addProperty("nome", ponto.getNome());
                    pontoJson.addProperty("id", ponto.getId());

                    jsonArray.add(pontoJson);
                }

                responseData.add("pontos", jsonArray);
            }

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
