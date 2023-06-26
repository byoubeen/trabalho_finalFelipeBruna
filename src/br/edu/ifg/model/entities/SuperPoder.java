package br.edu.ifg.model.entities;

import br.edu.ifg.model.entities.enums.CategoriaPoder;

public class SuperPoder {

    private String nome;

    private CategoriaPoder categoria;


    public SuperPoder(String nome, CategoriaPoder categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaPoder getCategoria() {
        return categoria;
    }
}
