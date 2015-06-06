/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;

import br.com.bonitoprint.entidades.Status;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioStatus;
import br.com.bonitoprint.persistencia.RepositorioStatus;

/**
 *
 * @author Vinicius
 */
public class NegocioStatus {
    
    private IRepositorioStatus rpstatus;
    
    public NegocioStatus(){
        System.out.println("Entrou no negocio");
        this.rpstatus= new RepositorioStatus();
    }
    public void adicionar(Status status) throws UsuarioExistenteException, ErroInternoException {
        
        try{
            Status st = rpstatus.consultar(status.getStatus());
            throw new UsuarioExistenteException("Status existente no Sistema");
            }catch(UsuarioInexistenteException ex){
            rpstatus.adicionar(status);   
            }
      
    }
    
}
