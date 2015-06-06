/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Fornecedor;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IRepositorioFornecedor  {
    
    
    public void adicionar(Fornecedor fornecedor) throws ErroInternoException;
    public Fornecedor consultar(String cpf) throws UsuarioInexistenteException;
    public List<Fornecedor> listar();
}
