package br.edu.ifg.model.entities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class MenuPrincipal extends JFrame {

    private String nomeJogador;
    private JButton btnMostrarHerois;
    private JButton btnMostrarViloes;
    private JButton btnConfronto;
    private JButton btnSair;

    public MenuPrincipal(String nomeJogador) {
        this.nomeJogador = nomeJogador;
        initComponents();
        setupListeners();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setSize(400, 200);
        setLocationRelativeTo(null);



        setVisible(true);


    }

    private void initComponents() {
        btnMostrarHerois = new JButton("Mostrar todos os super-heróis");
        btnMostrarViloes = new JButton("Mostrar todos os vilões");
        btnConfronto = new JButton("Confronto");
        btnSair = new JButton("Sair");
    }

    private void setupListeners() {
        btnMostrarHerois.addActionListener(e -> mostrarHerois());
        btnMostrarViloes.addActionListener(e -> mostrarViloes());
        btnConfronto.addActionListener(e -> confronto());
        btnSair.addActionListener(e -> finalizarGame());
    }

    private void setupLayout() {
        JPanel panel = new JPanel();
        panel.add(btnMostrarHerois);
        panel.add(btnMostrarViloes);
        panel.add(btnConfronto);
        panel.add(btnSair);
        add(panel);
    }


    protected void mostrarHerois() {
        // Lógica para mostrar todos os super-heróis
        JOptionPane.showMessageDialog(null, "Mostrar todos os super-heróis");
    }

    protected void mostrarViloes() {
        // Lógica para mostrar todos os vilões
        JOptionPane.showMessageDialog(null, "Mostrar todos os vilões");
    }

    protected void confronto() {
        // Lógica para o confronto
        JOptionPane.showMessageDialog(null, "Confronto");
    }

    protected void finalizarGame() {
        // Lógica para finalizar o jogo
        System.exit(0);
    }
}
