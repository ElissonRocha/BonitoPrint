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
public class Fornecedor extends Mae {
    
    private String nomef;
    
    
    public void setNomef(String nome){
        this.nomef = nome;
        System.out.println("sodkskdoskdokso");
        System.out.println(""+nomef);
    }
    
    public String getNomef(){
        return nomef;
    }
    
    
    
    /**
     *
     * @param codigo
     * @param nome
     * @param email
     * @param cpf_cnpj
     * @param rua
     * @param numero
     * @param complemento
     * @param bairro
     * @param cidade
     * @param estado
     */
    public Fornecedor(String tel1, String tel2, String nome,String email,String cpf_cnpj,String rua,int numero,String complemento,String bairro,String cidade,String estado){
        
        this.telefone1=tel1;
        this.telefone2=tel2;
        this.nome=nome;
        this.email=email;
        this.cpf_cnpj=cpf_cnpj;
        this.rua=rua;
        this.numero=numero;
        this.complemento=complemento;
        this.bairro=bairro;
        this.cidade=cidade;
        this.estado=estado;
        
        
    }
     public Fornecedor(){
     
     }
 }


