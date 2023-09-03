package com.foodexpress.model.dao;
import com.foodexpress.model.dto.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class teste {
    public static void main(String[] args) throws SQLException {
        PedidoDAO ped = PedidoDAO.getInstance();
        List<ItemPedidoDTO> itens = new ArrayList<>();
        itens.add(new ItemPedidoDTO(144, 2, 12.00));
        
        ped.realizarPedido(new PedidoDTO(14, "washingtonwagner2020@gmail.com", "2023-09-02", "p20", 0, "Pendente"), itens);
    }
}
