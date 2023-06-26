package br.edu.ifg.model.entities.enums;

import java.util.Arrays;

public enum CategoriaPoder {
    UM(1.0, "mais fraco"),
    DOIS(2.0, "fraco"),
    TRES(3.0, "mediano"),
    QUATRO(4.0, "forte"),
    CINCO(5.0, "mais forte"),
    NULL(-1.0, "Nulo");


    private final Double valor;
    private final String descricao;

    CategoriaPoder(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public static CategoriaPoder ofDouble(Double valor) {
        return Arrays.stream(CategoriaPoder.values())
                .filter(x -> x.getValor().equals(valor))
                .findFirst()
                .orElse(NULL);
    }

    public Double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
