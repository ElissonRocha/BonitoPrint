/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Status;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class RepositorioStatus implements IRepositorioStatus {

    
    @Override
    public void adicionar(Status status) throws ErroInternoException {
        
     System.out.println("Entrou no Repositorio");
        PreparedStatement stmt = null;
        String sql = "INSERT INTO STATUS(ID_ST,STATUS)VALUES(ID_ST.NEXTVAL,?)";
        Connection connection = Conexao.ObterConexao();
        try{
            stmt=connection.prepareStatement(sql);
            stmt.setString(1, status.getStatus());
            System.out.println("Entrou no Repositorio3");
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }catch(SQLException e){
             e.printStackTrace();
               throw new ErroInternoException("Erro ao adicionar usuario: ", e);
        }finally{
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
            throw new ErroInternoException("Erro ao adicionar usuario: ", e);
                    
                }   
        }
    }

     @Override
    public Status consultar(String nome) throws UsuarioInexistenteException {
    
    Status temp = new Status();
    
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();

    String sql = "SELECT * FROM STATUS WHERE STATUS = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
        stmt.setString(1,nome);
        rs= stmt.executeQuery();
       
        
        if(rs.next()){
            temp.setId(rs.getDouble("ID_ST"));
            temp.setStatus(rs.getString("STATUS"));
            stmt.close();
            connection.close();
        }else{
            throw new UsuarioInexistenteException();
        }
        }catch(UsuarioInexistenteException ex){
            throw ex;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                stmt.close();
                connection.close();
               }catch(SQLException e){
                e.printStackTrace();
                }        
        }
        return temp;
          
        
    }
    
    
}
