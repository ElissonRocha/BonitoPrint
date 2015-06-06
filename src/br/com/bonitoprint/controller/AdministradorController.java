/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Administrador;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.negocio.NegocioAdministrador;

/**
 *
 * @author Vinicius
 */
public class AdministradorController {
    
    private NegocioAdministrador negocioadm;

    public AdministradorController(){
        this.negocioadm = new NegocioAdministrador();
    }
    
    public void adicionar(Administrador adm) throws ErroInternoException,UsuarioExistenteException, CampoObrigatorioException{
        try{
            if(adm.getNome().length()<=0 || adm.getEmail().length()<=0 || adm.getSenha().length()<=0 ||adm.getCsenha().length()<=0)
            throw new CampoObrigatorioException("Campos de preechimento Obrigatorio");
            else{
                negocioadm.adicionar(adm);
            }
        }catch(CampoObrigatorioException ex){
            throw ex;
        }
        
        
    }
    public Administrador consultar(String email) throws UsuarioInexistenteException{
        
        Administrador adm = negocioadm.consultar(email);
        return adm;
    }


}


