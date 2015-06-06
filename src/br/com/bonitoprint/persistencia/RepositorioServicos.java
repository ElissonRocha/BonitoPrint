/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Servicos;
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
public class RepositorioServicos implements IRepositorioServicos{
    

    @Override
    public void adicionar(Servicos servicos) throws ErroInternoException {
        
        System.out.println("Entrou no Repositorio");
        PreparedStatement stmt = null;
        String sql = "INSERT INTO SERVICOS(CODIGO_SER,NOME,PRECO)VALUES(CODIGO_SER.NEXTVAL,?,?)";
        Connection connection = Conexao.ObterConexao();
        try{
            stmt=connection.prepareStatement(sql);
            stmt.setString(1, servicos.getNome());
            stmt.setDouble(2,servicos.getPreco());
            System.out.println("Entrou no Repositorio3");
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }catch(SQLException e){
             e.fillInStackTrace();
               throw new ErroInternoException("Erro ao adicionar o Serviço: ");
        }finally{
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.fillInStackTrace();
                throw new ErroInternoException("Erro ao adicionar o Serviço : ");
                    
                }   
        }
    }

    @Override
    public Servicos consultar(String nome) throws UsuarioInexistenteException {
    
    System.out.println(""+nome);
    Servicos temp = new Servicos();
    System.out.println("entrou no consultar");
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();
    
    String sql = "SELECT * FROM SERVICOS WHERE NOME = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
        stmt.setString(1,nome);
        rs= stmt.executeQuery();
       
        
        if(rs.next()){
            temp.setCodigo(rs.getDouble("CODIGO_SER"));
            temp.setNome(rs.getString("NOME"));
            temp.setPreco(rs.getDouble("PRECO"));
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
