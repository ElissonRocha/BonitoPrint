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
public class Administrador {
    
    private double id_adm;
    private String nome;
    private String email;
    private String senha;
    private String csenha;
    
    
    public String getCsenha() {
        return csenha;
    }

    public void setCsenha(String csenha) {
        this.csenha = csenha;
    }
   

    public double getId_adm() {
        return id_adm;
    }

    public void setId_adm(double id_adm) {
        this.id_adm = id_adm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Administrador(String nome, String email, String senha,String csenha) {
        
        this.csenha=csenha;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Administrador() {
        
    }
   
   
}
