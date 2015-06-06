/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.negocio;
import br.com.bonitoprint.entidades.Produto;
import br.com.bonitoprint.entidades.Fornecedor;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioExistenteException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import br.com.bonitoprint.persistencia.IRepositorioFornecedor;
import br.com.bonitoprint.persistencia.RepositorioFornecedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class NegocioFornecedor {
    
    private IRepositorioFornecedor rpfornecedor;
    
    public NegocioFornecedor(){
        this.rpfornecedor= new RepositorioFornecedor();
    }
    
    public void adicionar(Fornecedor fornecedor) throws UsuarioExistenteException,ErroInternoException {
        System.out.println("entrou3");
        try{
            Fornecedor f = rpfornecedor.consultar(fornecedor.getCpf_Cnpj());
            throw new UsuarioExistenteException("Fornecedor Existente no Sistema ");    
        }catch(UsuarioInexistenteException ex){
            System.out.println("Entrou em negocio");
            rpfornecedor.adicionar(fornecedor);
        }
        
    }
     public List<Fornecedor> listar(){
     System.out.println("Entrou listar 2");    
     List<Fornecedor> f = new ArrayList <Fornecedor>();
     f = rpfornecedor.listar();
     return f;
   }
    
}
