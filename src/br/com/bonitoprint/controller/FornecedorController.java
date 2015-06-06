/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Fornecedor;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.negocio.NegocioFornecedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class FornecedorController {

    private NegocioFornecedor nfornecedor;
    
    public FornecedorController(){
        this.nfornecedor= new NegocioFornecedor();
    }
    
    public void adicionar(Fornecedor fornecedor) throws ErroInternoException,UsuarioExistenteException, CampoObrigatorioException{
      
        try{
            if(fornecedor.getNome().length()<=0 || fornecedor.getEmail().length()<=0 || fornecedor.getTelefone1().length()<=0
                    || fornecedor.getCpf_Cnpj().length()<=0 || fornecedor.getBairro().length()<=0 || fornecedor.getCidade().length()<=0 
                    || fornecedor.getRua().length()<=0 || fornecedor.getEstado().length()<=0){
            throw new CampoObrigatorioException("Campos de preechimento Obrigatorio");
            }else{
                nfornecedor.adicionar(fornecedor);
            }
        }catch(CampoObrigatorioException ex){
            throw ex;
      }
    }
    public List<Fornecedor> listar(){
     System.out.println("Entrou listar 3");
     List<Fornecedor> f = new ArrayList<Fornecedor>();
     f = nfornecedor.listar();
     return f;
    }
    
 } 


