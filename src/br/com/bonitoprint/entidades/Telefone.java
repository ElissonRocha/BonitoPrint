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
public class Telefone {
    
    private String telefone;
    private Mae codigo;
    private String telefone2;
     
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Mae getCodigo() {
        return codigo;
    }

    public void setCodigo(Mae codigo) {
        this.codigo = codigo;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
  
    public Telefone(String telefone,String telefone2){
        this.telefone=telefone;
        this.telefone2=telefone2;
    }
    
    public Telefone(){
        System.out.println(""+telefone);
    }
  
    
}
