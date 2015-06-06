/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Fornecedor;
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
public class RepositorioFornecedor implements IRepositorioFornecedor{
    
   

    @Override
    public void adicionar(Fornecedor fornecedor) throws ErroInternoException {
       
        ResultSet rs;
               
        System.out.println("Entrou no Repositorio") ;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO MAE(CODIGO,EMAIL,CPF_CNPJ,NOME,RUA,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,ESTADO)VALUES(CODIGO.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        String sql1= "SELECT CODIGO.CURRVAL FROM MAE ";
        String sql2= "INSERT INTO FORNECEDOR(CODIGO_MAE_FOR)VALUES(?)";
        String sql3=" INSERT INTO TELEFONE(CODIGO_MAE_TEL,TELEFONE)VALUES(?,?)";
        Connection com = Conexao.ObterConexao();
        try{
            System.out.println("Entrou no Repositorio2");
            stmt=com.prepareStatement(sql);
            System.out.println("" + fornecedor.getEmail());
            stmt.setString(1, fornecedor.getEmail());
            stmt.setString(2, fornecedor.getCpf_Cnpj());
            stmt.setString(3, fornecedor.getNome());
            stmt.setString(4, fornecedor.getRua());
            stmt.setInt(5, fornecedor.getNumero());
            stmt.setString(6, fornecedor.getComplemento());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getCidade()); 
            stmt.setString(9, fornecedor.getEstado()); 
            System.out.println("Entrou no Repositorio3");
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio4");
            stmt=com.prepareStatement(sql1);
            rs = stmt.executeQuery();
            if(rs.next()) {
                fornecedor.setCodigo(rs.getInt("CURRVAL"));
                
            }
            stmt=com.prepareStatement(sql2);
            stmt.setInt(1,fornecedor.getCodigo());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio5");
            stmt=com.prepareStatement(sql3);
            stmt.setInt(1, fornecedor.getCodigo());
            stmt.setString(2, fornecedor.getTelefone1());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio6");
            if(fornecedor.getTelefone2().length() > 0 ){
            System.out.println("Entrou no Repositorio7");    
            stmt=com.prepareStatement(sql3);
            stmt.setInt(1, fornecedor.getCodigo());
            stmt.setString(2, fornecedor.getTelefone2());
            stmt.executeUpdate();
            System.out.println("Entrou no Repositorio7");
            }
            stmt.close();
            com.close();
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
    public Fornecedor consultar(String cpf) throws UsuarioInexistenteException {
   
    Fornecedor temp = new Fornecedor();
    
    PreparedStatement stmt = null;
    ResultSet rs;
    Connection connection = Conexao.ObterConexao();
    String sql = "SELECT * FROM MAE WHERE CPF_CNPJ = ?";
    
    try{
        stmt=connection.prepareStatement(sql);
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
    
    
    
    @Override
    public List<Fornecedor> listar() {
        
        Connection connection = Conexao.ObterConexao();
        List<Fornecedor> resultados = new ArrayList<Fornecedor>();
        PreparedStatement stmt = null;
        ResultSet rs;
        String sql= "SELECT M.NOME,M.CPF_CNPJ FROM FORNECEDOR F,MAE M WHERE F.CODIGO_MAE_FOR = M.CODIGO ORDER BY NOME";
                
        
        try{
            System.out.println("Entrou listar 1");
            stmt=connection.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Fornecedor temp = new Fornecedor();
                temp.setNome(rs.getString("NOME"));
                System.out.println(""+temp.getNome());
              //  temp.setEmail(rs.getString("EMAIL"));
                temp.setCpf_Cnpj(rs.getString("CPF_CNPJ"));
              //  temp.setRua(rs.getString("RUA"));
              //  temp.setNumero(rs.getInt("NUMERO"));
              //  temp.setBairro(rs.getString("BAIRRO"));
              //  temp.setEstado(rs.getString("ESTADO"));
              //  temp.setComplemento(rs.getString("COMPLEMENTO"));
              //  temp.setCidade(rs.getString("CIDADE"));
              //  temp.setCodigo(rs.getInt("CODIGO"));
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
    
}
