/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;

import br.com.bonitoprint.entidades.Administrador;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioAdministrador;
import br.com.bonitoprint.persistencia.RepositorioAdministrador;

/**
 *
 * @author Vinicius
 */
public class NegocioAdministrador {
    
    private IRepositorioAdministrador rpadministrador;
    
    public NegocioAdministrador(){
        this.rpadministrador= new RepositorioAdministrador(); 
    }
    
    public void adicionar(Administrador adm) throws UsuarioExistenteException,ErroInternoException{
       
        try{
             Administrador administrador = rpadministrador.consultar(adm.getEmail());
             throw new UsuarioExistenteException("Administrador existente no sistema");
        }catch(UsuarioInexistenteException ex){
              System.out.println("Entrou no negocio");
              rpadministrador.adicionar(adm);
             
        }
       
    }
    
    public Administrador consultar(String email) throws UsuarioInexistenteException{
        Administrador adm=rpadministrador.consultar(email);
        return adm;
    }
            
}
