package com.example.katiacibele.comprefacil.model;

/**
 * Created by katia cibele on 29/03/2016.
 */
public class Produto {
    int id;
    int quantidade;
    Float preço;
    String nome,marca;
    String imagem;
    int selecionado,carrinho;
    public enum Categoria{
       Limpeza,HortiFruti,Congelados,Higiene,Padaria,Básicos,Frios,Outros;


    }


    public Produto(int id, int quantidade, Float preço, String nome, String marca, int selecionado, int carrinho) {
        this.id = id;
        this.quantidade = quantidade;
        this.preço = preço;
        this.nome = nome;
        this.marca = marca;

        this.selecionado = selecionado;
        this.carrinho = carrinho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreço() {
        return preço;
    }

    public void setPreço(Float preço) {
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(int selecionado) {
        this.selecionado = selecionado;
    }

    public int getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(int carrinho) {
        this.carrinho = carrinho;
    }

    public Float calculaPreço(Produto a){
        return a.getPreço() * a.getQuantidade();
    }

    public String getCategoria(Produto a){
        return getCategoria(a);
    }
}
