/*
 *  To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;

import br.com.bonitoprint.entidades.Cliente;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioCliente;
import br.com.bonitoprint.persistencia.RepositorioCliente;
/**
 *
 * @author Vinicius
 */
public class NegocioCliente {
 
    private IRepositorioCliente rpcliente;
    
    public NegocioCliente(){
        this.rpcliente= new RepositorioCliente();
    }
    
    public void adicionar(Cliente cliente) throws ErroInternoException,UsuarioExistenteException{
        
        try{
           Cliente c = rpcliente.consultar(cliente.getCpf_Cnpj());
           throw new UsuarioExistenteException("Usuario Existente no Sistema");
        }catch(UsuarioInexistenteException e){
        System.out.println("Entrou em negocio");
        rpcliente.adicionar(cliente);
        } 
    
    }
}