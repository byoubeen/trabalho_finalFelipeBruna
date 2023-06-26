package br.edu.ifg.model.entities;

public class Confronto {

    public Integer executar(SuperHeroi superHeroi, Vilao vilao) {
        Double superHeroiPoderTotal = superHeroi.getPoderTotal();
        Double vilaoPoderTotal = vilao.getPoderTotal();

        if (superHeroiPoderTotal < vilaoPoderTotal)
            return 2;
        else if (superHeroiPoderTotal > vilaoPoderTotal)
            return 1;
        else
            return 0;
    }
}
