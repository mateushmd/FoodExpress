/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.foodexpress.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class DAOTemplate<T> {
    private Connection conn;
    
    protected abstract T mapResultSetToObject(ResultSet rs) throws SQLException;
    
    protected List<T> executeQuery(String sql, Object... params) {
        List<T> results = new ArrayList<>();
        ResultSet rs = null;
        
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            setStatementParameters(st, params);
            rs = st.executeQuery();
            while (rs.next()) {
                results.add(mapResultSetToObject(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.closeResultSet(rs);
        }
        return results;
    }
    
    protected boolean executeUpdate(String sql, Object... params) {
        int affectedLines = 0;
        
        try(PreparedStatement st = conn.prepareStatement(sql)) {
            setStatementParameters(st, params);
            
            affectedLines = st.executeUpdate();
        } catch(SQLException ex) {
            Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return affectedLines > 0;
    }
    
    private void setStatementParameters(PreparedStatement st, Object... params) throws SQLException {
        for(int i = 0; i < params.length; i++) {
            st.setObject(i + 1, params[i]);
        }
    }
    
    protected final void setConnection() {
        Connection connection = null;
        
        try {
            connection = ConnectionPoolManager.getDataSource().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn = connection;
    }
}
