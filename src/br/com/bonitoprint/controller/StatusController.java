/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Status;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.negocio.NegocioStatus;

/**
 *
 * @author Vinicius
 */
public class StatusController {
    
    private NegocioStatus nstatus;
    
    public StatusController(){
        this.nstatus = new NegocioStatus();
    }
    public void adicionar(Status status) throws ErroInternoException,UsuarioExistenteException, CampoObrigatorioException{
       
        try{
            if(status.getStatus().length()<=0){
               throw new CampoObrigatorioException("Campos Obrigatorios");
            }else
                nstatus.adicionar(status);
        }catch(CampoObrigatorioException ce){
            throw ce;
        }
         
    }
    
}
