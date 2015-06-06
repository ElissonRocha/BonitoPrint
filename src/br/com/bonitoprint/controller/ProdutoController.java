/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Produto;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.negocio.NegocioProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class ProdutoController {
    
    private NegocioProduto nproduto;
    
    public ProdutoController(){
     nproduto= new NegocioProduto();  
    }
   
    public void adicionar(Produto produto) throws ErroInternoException,UsuarioExistenteException,CampoObrigatorioException{
       
       try{
           if(produto.getNome().length()<=0){
           throw new CampoObrigatorioException("Campos Obrigatorios");
           }else{
               nproduto.adicionar(produto);
           }
       }catch(CampoObrigatorioException ce){
           throw ce;
       }
        
    }
    
    public Produto consultar(String nome) throws UsuarioInexistenteException{
        return nproduto.consultar(nome);
    }
    public List<Produto> listar(String pesquisar){
     System.out.println("Entrou listar 3");
     return nproduto.listar(pesquisar);
    }
    public void atualizar(Produto produto) throws ErroInternoException{
        nproduto.atualizar(produto);
    }
<<<<<<< HEAD
    public void deletar(Produto produto) throws ErroInternoException, UsuarioInexistenteException{
        nproduto.deletar(produto);
=======
    public void deletar(String nome) throws ErroInternoException, UsuarioInexistenteException{
        nproduto.deletar(nome);
>>>>>>> origin/master
    }
    
}
