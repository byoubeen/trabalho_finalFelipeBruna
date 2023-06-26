package br.edu.ifg.model.entities;

import br.edu.ifg.model.entities.enums.CategoriaPoder;
import br.edu.ifg.exceptions.PersonagemException;
import br.edu.ifg.utils.MensagensUtils;

import java.util.Arrays;
import java.util.Objects;

public class Personagem {
    private int id;
    private String nome;
    private String nomeVidaReal;
    protected final SuperPoder[] poderes = new SuperPoder[4];

    public Personagem(int id, String nome, String nomeVidaReal) {
        this.id = id;
        this.nome = nome;
        this.nomeVidaReal = nomeVidaReal;
    }

    protected void adicionaSuperPoder(SuperPoder sp) {
        int posicao = verificarPosicoesVazias();

        if (posicao == -1)
            throw new PersonagemException(MensagensUtils.msgErrorPoderes(this.getClass().getSimpleName()));
        else
            poderes[posicao] = sp;
    }

    private Integer verificarPosicoesVazias() {
        int posicao = -1;
        for (int i = 0; i < poderes.length; i++) {
            if (poderes[i] == null)
                return i;
        }

        return posicao;
    }

    protected Double getPoderTotal() {
        return Arrays.stream(poderes)
                .filter(Objects::nonNull)
                .map(SuperPoder::getCategoria)
                .map(CategoriaPoder::getValor)
                .reduce(0.0, Double::sum);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeVidaReal() {
        return nomeVidaReal;
    }

    public void setNomeVidaReal(String nomeVidaReal) {
        this.nomeVidaReal = nomeVidaReal;
    }

    public SuperPoder[] getPoderes() {
        return poderes;
    }
}
