package com.foodexpress.model.dao;

import com.foodexpress.model.dto.FavoritosDTO;
import com.foodexpress.model.dto.LojaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class FavoritosDAO extends DAOTemplate<FavoritosDTO> {
    private static FavoritosDAO instance = null;
    
    private FavoritosDAO() {
        super();
    }
    
    public static synchronized FavoritosDAO getInstance(){
        if(instance == null)
            instance = new FavoritosDAO();
        
        return instance;
    }
    
    @Override
    protected FavoritosDTO mapResultSetToObject(ResultSet rs) throws SQLException {
        FavoritosDTO fav = null;
        
        try{
            fav = new FavoritosDTO();
            
            fav.setIdCliente(rs.getString("id_cliente"));
            fav.setIdLoja(rs.getInt("id_loja"));
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(LojaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fav;
    }
    
    public boolean adicionarFav(String cliente, int loja){
        String sql = "INSERT INTO favoritos (id_cliente, id_loja) VALUES (?, ?)";
        
        return executeUpdate(sql, cliente, loja);
    }

    public boolean removerFav(String cliente, int loja) {
        String sql = "DELETE FROM favoritos WHERE id_cliente = ? AND id_loja = ?";

        return executeUpdate(sql, cliente, loja);
    }
    
    public List<FavoritosDTO> getFav(String cliente){
        String sql = "SELECT * FROM favoritos WHERE id_cliente = ?";
        
        return executeQuery(sql, cliente);
    }
    
    public FavoritosDTO searchFav(String cliente, int loja){
        String sql = "SELECT * FROM favoritos WHERE id_cliente = ? AND id_loja = ?";
        
        List<FavoritosDTO> favs = executeQuery(sql, cliente, loja);
        
        return favs.isEmpty() ? null : favs.get(0);
    }
}
