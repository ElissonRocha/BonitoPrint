/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;

import br.com.bonitoprint.entidades.Fornecedor;
import br.com.bonitoprint.entidades.Produto;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioProduto;
import br.com.bonitoprint.persistencia.RepositorioFornecedor;
import br.com.bonitoprint.persistencia.RepositorioProduto;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Vinicius
 */
public class NegocioProduto {
    
    private IRepositorioProduto rpproduto;
 
    
    public NegocioProduto(){
        rpproduto= new RepositorioProduto();
    }
    public void adicionar(Produto produto)throws ErroInternoException,UsuarioExistenteException{
       try{
           Produto p = rpproduto.consultar(produto.getNome());
           throw new UsuarioExistenteException("Produto Existente no Sistema"); 
       }catch(UsuarioInexistenteException ex){ 
       rpproduto.adicionar(produto);
       }
   }
    public Produto consultar(String nome) throws UsuarioInexistenteException{
        return rpproduto.consultar(nome);
    }
    public List<Produto> listar(String pesquisar){
     System.out.println("Entrou listar 2");    
     List<Produto> f = new ArrayList <Produto>();
     f = rpproduto.listar(pesquisar);
     return f;
   }
    public void atualizar(Produto produto) throws ErroInternoException{
       rpproduto.atualizar(produto);
   }
    public void deletar(String nome) throws ErroInternoException, UsuarioInexistenteException{
       try{
           Produto p  = rpproduto.consultar(nome);
           rpproduto.deletar(nome);
         }catch(UsuarioInexistenteException ex){
             throw ex;
         }   
    }
}
