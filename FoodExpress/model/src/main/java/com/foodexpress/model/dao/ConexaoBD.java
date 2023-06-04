package com.foodexpress.model.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_4f92f1c6b3d797c?autoReconnect=true&useSSL=false", "b4ef7c73d61cc7", "c101e0f6");
            } catch (SQLException e) {
                try {
                    throw new DbException(e.getMessage());
                } catch (DbException ex) {
                    Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                try {
                    throw new DbException(e.getMessage());
                } catch (DbException ex) {
                    Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("conexao.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            try {
                throw new DbException(e.getMessage());
            } catch (DbException ex) {
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                try {
                    throw new DbException(e.getMessage());
                } catch (DbException ex) {
                    Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                try {
                    throw new DbException(e.getMessage());
                } catch (DbException ex) {
                    Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}