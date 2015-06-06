/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.entidades;

/**
 *
 * @author Alexandre,Elisson e Vinicius
 */
public class Status {

    private double id;
    private String status;

    public Status() {

    }
 
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 
     * @param status 
     */
    public Status( String status) {
        this.status = status;
    } 

    
}
