/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Produto;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class RepositorioProduto implements IRepositorioProduto {

    
    @Override
    public void adicionar(Produto produto) throws ErroInternoException {
        System.out.println("Entrou no Repositorio");
        PreparedStatement stmt = null;
        ResultSet rs;
        String sql = "INSERT INTO PRODUTO(CODIGO_PRO,NOME,QUANTIDADE,PRECO,CODIGO_MAE_FOR)VALUES(CODIGO_PRO.NEXTVAL,?,?,?,?)";
        String sql1 = "SELECT CODIGO FROM MAE WHERE NOME = ?  "; 
        Connection connection = Conexao.ObterConexao();
        try{
            stmt=connection.prepareStatement(sql1);
            stmt.setString(1,produto.getNomef());
            rs= stmt.executeQuery();
            System.out.println("Entrou no repositorio 2");
            if(rs.next()){
              produto.setCodigo_for(rs.getInt("CODIGO"));
            }
            stmt=connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3,produto.getPreco());
            stmt.setInt(4,produto.getCodigo_for());
            System.out.println("Entrou no Repositorio3");
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        }catch(SQLException e){
             e.fillInStackTrace();
             throw new ErroInternoException("Erro ao Adicionar Produto: ");
        }finally{
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.fillInStackTrace();
             throw new ErroInternoException("Erro ao Adicionar Produto: ");
                    
                }   
        }
        
    }

    @Override
    public Produto consultar(String nome) throws UsuarioInexistenteException {
        
    Produto temp = new Produto();
    
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();
    String sql = "SELECT * FROM PRODUTO WHERE NOME = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
        stmt.setString(1,nome);
        rs= stmt.executeQuery();
       
        
        if(rs.next()){
            temp.setCodigo(rs.getInt("CODIGO_PRO"));
            temp.setNome(rs.getString("NOME"));
            temp.setQuantidade(rs.getInt("QUANTIDADE"));
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
    
    @Override
    public List<Produto> listar(String nome) {
        
        Connection connection = Conexao.ObterConexao();
        List<Produto> resultados = new ArrayList<Produto>();
        PreparedStatement stmt = null;
        ResultSet rs;
        String sql= "SELECT * FROM PRODUTO WHERE NOME LIKE '"+nome+"%' ORDER BY NOME";
                
        
        try{
            System.out.println("Entrou listar 1");
            stmt=connection.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Produto temp = new Produto();
                temp.setNome(rs.getString("NOME"));
                System.out.println(""+temp.getNome());
                temp.setQuantidade(rs.getInt("QUANTIDADE"));
                temp.setPreco(rs.getDouble("PRECO"));
                temp.setNomef(rs.getString("CODIGO_MAE_FOR"));
                resultados.add(temp);
            }
            stmt.close();
            connection.close();
            return resultados;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void atualizar(Produto produto) throws ErroInternoException{
        
        Connection connection = Conexao.ObterConexao();
        PreparedStatement stmt = null;
       
    
        String sql = "UPDATE PRODUTO SET NOME=?,QUANTIDADE=?,PRECO=? WHERE NOME = ? ";
   
       try{
            System.out.println("Entrou no atualizar 1");
            stmt=connection.prepareStatement(sql);
            System.out.println("Entrou no atualizar 2");
            stmt.setString(1,produto.getNome());
            stmt.setInt(2,produto.getQuantidade());
            stmt.setDouble(3,produto.getPreco());
            stmt.setString(4,produto.getNome());
            System.out.println("Entrou no atualizar 3");
            stmt.executeUpdate();
            stmt.close();
            connection.close();
       }catch(SQLException ex){
           throw new ErroInternoException("Erro ao atualizar o produto");
       }   
    }
    @Override
    public void deletar(String nome) throws ErroInternoException{
       
        Connection connection = Conexao.ObterConexao();
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM PRODUTO WHERE NOME='?' ";
        
        try{
            System.out.print("Entrou no deletar 1");
            stmt = connection.prepareStatement(sql);
            stmt.setString(1,nome);
            System.out.print("Entrou no deletar 2");
        }catch(SQLException e){
            throw new ErroInternoException("Erro ao deletar o usuario"); 
        }
          
    }
}
