/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.execao;

/**
 *
 * @author Vinicius
 */
public class UsuarioInexistenteException extends Exception {
    
    public UsuarioInexistenteException() {
    super();
}
    public UsuarioInexistenteException(String message) {
    super(message);
}
    
}
