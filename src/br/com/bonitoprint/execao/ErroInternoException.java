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
public class ErroInternoException extends Exception {
    
    public ErroInternoException() {
        super();
    }
    
    public ErroInternoException(String message) {
        super(message);
    }
    
    public ErroInternoException(String message, Throwable cause) {
        super(message, cause);
    }
}
