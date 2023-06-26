package br.edu.ifg.model.entities;

import br.edu.ifg.exceptions.PersonagemException;

import java.util.Arrays;

public class Vilao  extends Personagem {

    private Integer tempoDePrisao;

    public Vilao(int id, String nome, String nomeVidaReal, Integer tempoDePrisao) {
        super(id, nome, nomeVidaReal);
        this.tempoDePrisao = tempoDePrisao;
    }

    @Override
    public Double getPoderTotal() {
        return super.getPoderTotal();
    }

    @Override
    public void adicionaSuperPoder(SuperPoder sp) throws PersonagemException {
        super.adicionaSuperPoder(sp);
    }

    public Integer getTempoDePrisao() {
        return tempoDePrisao;
    }

    public void setTempoDePrisao(Integer tempoDePrisao) {
        this.tempoDePrisao = tempoDePrisao;
    }
}
