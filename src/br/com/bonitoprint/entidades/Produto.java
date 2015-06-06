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
public class Produto {
    private int codigo_for;
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;
    private String nomef;
    
    
    public Produto() {
    }

    public String getNomef() {
        return nomef;
    }

    public void setNomef(String nomef) {
        this.nomef = nomef;
    }
    
    public int getCodigo_for() {
        return codigo_for;
    }

    public void setCodigo_for(int codigo_for) {
        this.codigo_for = codigo_for;
    }
   
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto( String nome, int quantidade,double preco,String nomef) {
        this.nomef=nomef;
        this.codigo_for = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco=preco;
    }
    public Produto( String nome, int quantidade,double preco) {

        this.codigo_for = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco=preco;
    }
    
    
    
    
}
