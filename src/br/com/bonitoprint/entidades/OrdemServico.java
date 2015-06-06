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
public class OrdemServico {
    private double id_ser;
    private int quantidade;
    private double total;
    private Date dia;
    private Produto codigo;
    private Cliente cod;

    public double getId_ser() {
        return id_ser;
    }

    public void setId_ser(double id_ser) {
        this.id_ser = id_ser;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Produto getCodigo() {
        return codigo;
    }

    public void setCodigo(Produto codigo) {
        this.codigo = codigo;
    }

    public Cliente getCod() {
        return cod;
    }

    public void setCod(Cliente cod) {
        this.cod = cod;
    }

    public OrdemServico(double id_ser, int quantidade, double total, Date dia, Produto codigo, Cliente cod) {
        this.id_ser = id_ser;
        this.quantidade = quantidade;
        this.total = total;
        this.dia = dia;
        this.codigo = codigo;
        this.cod = cod;
    }
    
    
    
}
