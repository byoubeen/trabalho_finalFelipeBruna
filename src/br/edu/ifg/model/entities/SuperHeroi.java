package br.edu.ifg.model.entities;

import br.edu.ifg.model.entities.enums.CategoriaPoder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SuperHeroi extends Personagem {

    public SuperHeroi(int id, String nome, String nomeVidaReal) {
        super(id, nome, nomeVidaReal);
    }

    /**
     *
     * @return acrescenta um inflator de 10% aos poderes dos personagens super-heróis.
     */
    @Override
    public Double getPoderTotal() {
        return Arrays.stream(poderes)
                .filter(Objects::nonNull)
                .map(SuperPoder::getCategoria)
                .map(CategoriaPoder::getValor)
                .map(x -> x * 1.1)
                .reduce(0.0, Double::sum);
    }

    @Override
    public void adicionaSuperPoder(SuperPoder sp) {
        super.adicionaSuperPoder(sp);
    }
}
