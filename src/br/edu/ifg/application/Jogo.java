package br.edu.ifg.application;

import br.edu.ifg.model.entities.Game;

import javax.swing.*;

public class Jogo {

    public static void main(String[] args) {

        String nomeJogador;

        do {
            nomeJogador = JOptionPane.showInputDialog(null, "Digite o seu nome:");

            if (nomeJogador == null) {
                System.exit(0); // Encerra o programa
            }

            if (!nomeJogador.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Digite apenas letras");
            }
        } while (!nomeJogador.matches("[a-zA-Z]+"));

        JOptionPane.showMessageDialog(null, "Bem-vindo " + nomeJogador + "! Boa Sorte!");
        Game game = new Game(nomeJogador);
    }
}
