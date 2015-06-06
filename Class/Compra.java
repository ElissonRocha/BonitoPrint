/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ElissonRocha
 */
public class Compra {
    private int codigo;
    private Timestamp data;
    private int cpf_c;
    private float preco_final;
    private boolean isEntrega;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCpf_c() {
        return cpf_c;
    }

    public void setCpf_c(int cpf_c) {
        this.cpf_c = cpf_c;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public float getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(float preco_final) {
        this.preco_final = preco_final;
    }

    public boolean isIsEntrega() {
        return isEntrega;
    }

    public void setIsEntrega(boolean isEntrega) {
        this.isEntrega = isEntrega;
    }
    
    
}
