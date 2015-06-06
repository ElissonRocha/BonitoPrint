/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Cliente;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.negocio.NegocioCliente;

/**
 *
 * @author Vinicius
 */
public class ClienteController {

    private NegocioCliente ncliente;
    
    public ClienteController(){
        this.ncliente= new NegocioCliente();
    }
    
    public void adicionar(Cliente cliente) throws ErroInternoException, UsuarioExistenteException, CampoObrigatorioException{
        try{
            if(cliente.getNome().length()<=0 || cliente.getEmail().length()<=0 || cliente.getTelefone1().length()<=0
                    || cliente.getCpf_Cnpj().length()<=0 || cliente.getBairro().length()<=0 || cliente.getCidade().length()<=0 
                    || cliente.getRua().length()<=0 || cliente.getEstado().length()<=0){
            throw new CampoObrigatorioException("Campos de preechimento Obrigatorio");
            }else{
                ncliente.adicionar(cliente);
            }
        }catch(CampoObrigatorioException ex){
            throw ex;
        }
    }
}
