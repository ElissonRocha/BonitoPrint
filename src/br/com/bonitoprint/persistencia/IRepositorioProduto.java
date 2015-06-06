/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.persistencia;

import br.com.bonitoprint.entidades.Produto;
import br.com.bonitoprint.execao.ErroInternoException;
import br.com.bonitoprint.execao.UsuarioInexistenteException;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public interface IRepositorioProduto {
    
    public List<Produto> listar(String nome);
    public void adicionar(Produto produto) throws ErroInternoException;
    public Produto consultar(String nome) throws UsuarioInexistenteException;
    public void atualizar(Produto produto)throws ErroInternoException;  
    public void deletar(String nome) throws ErroInternoException;
}
