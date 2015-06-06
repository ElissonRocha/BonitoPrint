/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bonitoprint.entidades;

import java.util.Date;

/**
 *
 * @author Alexandre,Elisson e Vinicius
 */
public class Pedidos {
    
    private Produto codigo;
    private double total;
    private Date data;
    private Fornecedor cod;
    private double id;

    public Produto getCodigo() {
        return codigo;
    }

    public void setCodigo(Produto codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedor getCod() {
        return cod;
    }

    public void setCod(Fornecedor cod) {
        this.cod = cod;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Pedidos(Produto codigo, double total, Date data, Fornecedor cod, double id) {
        this.codigo = codigo;
        this.total = total;
        this.data = data;
        this.cod = cod;
        this.id = id;
    }
    
    
}
