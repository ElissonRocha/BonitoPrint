/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;


import br.com.bonitoprint.entidades.Cliente;
import br.com.bonitoprint.entidades.Telefone;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Vinicius
 */
public class RepositorioCliente implements IRepositorioCliente {
   
   
    /**
     * 
     * @param cliente 
     * @throws br.com.bonitoprint.execao.ErroInternoException 
     */
    @Override
    public void adicionar(Cliente cliente) throws ErroInternoException {
        
        
        ResultSet rs;
        System.out.println("Entrou no Repositorio");
        PreparedStatement stmt = null;
        String sql = "INSERT INTO MAE(CODIGO,EMAIL,CPF_CNPJ,NOME,RUA,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,ESTADO)VALUES(CODIGO.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        String sql1= "SELECT CODIGO.CURRVAL FROM MAE";
        String sql2= "INSERT INTO CLIENTE(CODIGO_MAE_CL)VALUES(?)";
        String sql3=" INSERT INTO TELEFONE(CODIGO_MAE_TEL,TELEFONE)VALUES(?,?)";
        Connection com = Conexao.ObterConexao();
        try{
            System.out.println(""+cliente.getTelefone1());
            System.out.println("Entrou no Repositorio2");
            stmt=com.prepareStatement(sql);
            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getCpf_Cnpj());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getRua());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getComplemento());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getCidade()); 
            stmt.setString(9, cliente.getEstado()); 
            System.out.println("Entrou no Repositorio3");
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio4");
            stmt=com.prepareStatement(sql1);
            rs = stmt.executeQuery();
            if(rs.next()){
                cliente.setCodigo(rs.getInt("CURRVAL"));
            }
            stmt=com.prepareStatement(sql2);
            stmt.setInt(1, cliente.getCodigo());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio5");
            stmt=com.prepareStatement(sql3);
            stmt.setInt(1, cliente.getCodigo());
            stmt.setString(2, cliente.getTelefone1());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio6");
            System.out.println(""+cliente.getTelefone2());
            if(cliente.getTelefone2().length()>0){
            System.out.println("Entro no telefone 2 ");
            stmt=com.prepareStatement(sql3);
            stmt.setInt(1, cliente.getCodigo());
            stmt.setString(2, cliente.getTelefone2());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio7");
            }
            stmt.close();
            com.close();
            
            
        }catch(SQLException e){
             e.printStackTrace();
              throw new ErroInternoException("Erro ao adicionar usuario: ");
        }finally{
                try{
                    stmt.close();
                }catch(SQLException e){
                   e.printStackTrace();
                   throw new ErroInternoException("Erro ao adicionar usuario: ");
                    
                }   
        }
        
    }
    /**
     * 
     * @param cpf
     * @return Cliente
     * @throws br.com.bonitoprint.execao.UsuarioInexistenteException
     */
    @Override
    public Cliente consultar(String cpf) throws UsuarioInexistenteException{
    
    Cliente temp = new Cliente();
    
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();
    String sql = "SELECT * FROM MAE WHERE CPF_CNPJ = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
        System.out.println(""+cpf);
        stmt.setString(1,cpf);
        rs= stmt.executeQuery();
      
        if(rs.next()){
            temp.setCodigo(rs.getInt("CODIGO"));
            temp.setNome(rs.getString("NOME"));
            temp.setEmail(rs.getString("EMAIL"));
            temp.setCpf_Cnpj(rs.getString("CPF_CNPJ"));
            temp.setRua(rs.getString("RUA"));
            temp.setComplemento(rs.getString("COMPLEMENTO"));
            temp.setBairro(rs.getString("BAIRRO"));
            temp.setCidade(rs.getString("CIDADE"));
            temp.setNumero(rs.getInt("NUMERO"));
            temp.setEstado(rs.getString("ESTADO"));
            stmt.close();
            connection.close();
        }else{
           System.out.println("entrou no usuario");
           System.out.println(""+temp.getCpf_Cnpj());
           throw new UsuarioInexistenteException();
        }
        }catch(UsuarioInexistenteException e){
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

    
    
    
   