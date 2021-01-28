package com.example.Practice6.DAO;

import java.sql.*;

public class DaoFactory {
    static{
        try{
            Class.forName(ConnectionMetaData.Load_MySql_JDBC_Driver).getDeclaredConstructor().newInstance();
        } catch (Exception e){
            System.out.println("Connection failed, " + e);
        }
    }

    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(ConnectionMetaData.URL, ConnectionMetaData.USER, ConnectionMetaData.PASSWORD);
        return conn;
    }
}
