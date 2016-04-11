package com.example.katiacibele.comprefacil.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by katia cibele on 29/03/2016.
 */
public class Lista {

    int id;
    String descrição;
    ArrayList<Produto> produtos;
    Date dataDeCriação;
    int ativo;

    public Lista(int id, int ativo, Date dataDeCriação, ArrayList<Produto> produtos, String descrição) {
        this.id = id;
        this.ativo = ativo;
        this.dataDeCriação = dataDeCriação;
        this.produtos = produtos;
        this.descrição = descrição;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Date getDataDeCriação() {
        return dataDeCriação;
    }

    public void setDataDeCriação(Date dataDeCriação) {
        this.dataDeCriação = dataDeCriação;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

}
