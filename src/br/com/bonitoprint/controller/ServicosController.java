/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.controller;

import br.com.bonitoprint.entidades.Servicos;
import br.com.bonitoprint.execao.CampoObrigatorioException;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.negocio.NegocioServicos;

/**
 *
 * @author Vinicius
 */
public class ServicosController {
    private NegocioServicos nservicos;
    
    public ServicosController(){
       this.nservicos= new NegocioServicos(); 
    }
    public void adicionar(Servicos servicos) throws ErroInternoException, UsuarioExistenteException, CampoObrigatorioException{
        
        try{
            if(servicos.getNome().length()<=0){
              throw new CampoObrigatorioException("Campos Obrigatorios");
            }else{
                System.out.println("Entrou no controller");
                nservicos.adicionar(servicos);
            }
        }catch(CampoObrigatorioException ce){
            throw ce;
        }
        
    }
}
