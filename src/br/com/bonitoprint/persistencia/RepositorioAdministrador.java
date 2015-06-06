/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Administrador;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import static br.com.bonitoprint.persistencia.Conexao.ObterConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class RepositorioAdministrador implements IRepositorioAdministrador {

 
    @Override
    public void adicionar(Administrador adm)throws ErroInternoException {
        
        System.out.println("Entrou no Repositorio");
        PreparedStatement stmt = null;
        String sql = "INSERT INTO ADMINISTRADOR(ID_ADM,NOME,EMAIL,SENHA)VALUES(ID_ADM.NEXTVAL,?,?,?)";
        Connection com = Conexao.ObterConexao();
        try{
            stmt=com.prepareStatement(sql);
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getEmail());
            stmt.setString(3, adm.getSenha());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio2");
            stmt.close();
            com.close();
            System.out.println("Entrou no Repositorio3");
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
    public Administrador consultar(String email) throws UsuarioInexistenteException{
         
    Administrador temp = new Administrador();
    
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();
    String sql = "SELECT * FROM ADMINISTRADOR WHERE EMAIL = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
        stmt.setString(1,email);
        rs= stmt.executeQuery();
       
        
        if(rs.next()){
            temp.setId_adm(rs.getDouble("ID_ADM"));
            temp.setNome(rs.getString("NOME"));
            temp.setEmail(rs.getString("EMAIL"));
            temp.setSenha(rs.getString("SENHA"));
            stmt.close();
            connection.close();
        }else{
            throw new UsuarioInexistenteException();
        }
        }catch( UsuarioInexistenteException e){
            throw e;
        }catch(SQLException e){
            e.fillInStackTrace();
        }finally{
            try{
                stmt.close();
                connection.close();
               }catch(SQLException e){
                e.fillInStackTrace();
                }        
        }
        return temp;
    }
    }
    
    

