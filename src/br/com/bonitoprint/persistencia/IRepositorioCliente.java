/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Cliente;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;

/**
 *
 * @author Vinicius
 */
public interface IRepositorioCliente {
    
    public void adicionar(Cliente cliente) throws ErroInternoException;
    public Cliente consultar(String cpf)throws UsuarioInexistenteException;
}
