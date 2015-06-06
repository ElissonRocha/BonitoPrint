/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vinicius
 */
public class Conexao {
    
    private static Connection connection= null;
    private PreparedStatement statement= null;
    private ResultSet result=null;
    private Statement stm=null;
    
    public static Connection ObterConexao(){
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
               connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BONITOPRINT","123456");
        }catch(SQLException e ){
            e.printStackTrace();   
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();       
        }
        System.out.println("Conectado");
        return connection;
        }
    }

