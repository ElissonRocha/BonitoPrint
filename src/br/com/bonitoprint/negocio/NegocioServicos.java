/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;

import br.com.bonitoprint.entidades.Servicos;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioServicos;
import br.com.bonitoprint.persistencia.RepositorioServicos;

/**
 *
 * @author Vinicius
 */
public class NegocioServicos {
    
    private IRepositorioServicos rpservicos;
   
    public  NegocioServicos(){
        this.rpservicos = new RepositorioServicos();
    }
    public void adicionar(Servicos servicos) throws ErroInternoException,UsuarioExistenteException{
        
        try{
            System.out.println("Entrou no negocio2");
            System.out.println(""+servicos.getNome());
            Servicos ser = rpservicos.consultar(servicos.getNome());
            throw new UsuarioExistenteException("Servico existente no Sistema");
        }catch(UsuarioInexistenteException ex){
          System.out.println("Entrou no negocio3");
          rpservicos.adicionar(servicos); 
        }      
    } 
}
 
