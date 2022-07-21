package com.qa.dbconnection;

import java.sql.*;
public class DBConnection{

    

    // DB parameters
    private static final String URL = "jdbc:mysql://localhost:3306/" ;
    private static final String USER = "root" ;
    private static final String PASSWORD = "root" ;
    private static final String DBNAME = "DMS";


    // Connection
    public static Connection getConnection(){
       Connection conn = null;

       try{
           conn = DriverManager.getConnection((URL+DBNAME), USER, PASSWORD);

       }catch(Exception e){
           e.printStackTrace();
       }

       return conn;
    }

public static void disconnect(Connection conn){
    try{
        if(conn != null){
            conn.close();
        }

        }catch(Exception e){
        e.printStackTrace();

        }
        }

        public static void main(String[] args){
    Connection conn = getConnection();

    if (conn !=null){
        System.out.println("Connection Successful.");

        }else{
        System.out.println("Connection Failed.");
        }
        }
}
       
