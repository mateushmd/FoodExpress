/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.foodexpress.model.dao;

import java.sql.Connection;


public abstract class DAOTemplate<E> {
    protected final Connection conn;

    protected DAOTemplate() {
        conn = ConexaoBD.getConnection();
    }
    
    public abstract void insert(E obj);
    
    public abstract boolean delete(E obj);
}
