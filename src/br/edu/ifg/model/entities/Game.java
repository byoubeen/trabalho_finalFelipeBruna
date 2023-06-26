package br.edu.ifg.model.entities;

import br.edu.ifg.exceptions.*;
import br.edu.ifg.model.entities.enums.CategoriaPoder;
import br.edu.ifg.utils.MensagensUtils;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Game extends MenuPrincipal{

    private List<Personagem> personagens;

    private Scanner scanner;

    private Boolean loadSuccessful;

    private String url = "jdbc:mariadb://localhost:3306/personagens";
    private String user = "root";
    private String senha = "";

    public Game(String nomeJogador) {
        super(nomeJogador);
        this.personagens = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.scanner.useLocale(new Locale("pt", "BR"));
        this.loadSuccessful = false;
        carregarSuperHerois();
        carregarViloes();
    }


    @Override
    protected void mostrarHerois() {
        List<SuperHeroi> herois = getHerois();
        JTextArea textArea = new JTextArea();

        for (Personagem heroi : herois) {
            Document document = textArea.getDocument();
            try {
                document.insertString(document.getLength(), "Nome do herói: " + heroi.getNome() + "\n", null);
                document.insertString(document.getLength(), "Nome do herói na vida real: " + heroi.getNomeVidaReal()
                        + "\n", null);
                document.insertString(document.getLength(), "Superpoderes do herói:\n", null);

                for (int j = 0; j < heroi.poderes.length; j++) {
                    if (heroi.poderes[j] != null) {
                        document.insertString(document.getLength(), "Nome do poder: " + heroi.poderes[j].getNome() +
                                "\n", null);
                        document.insertString(document.getLength(), "Categoria do poder: " + String.format("%.0f",
                                heroi.poderes[j].getCategoria().getValor()) + "\n", null);
                    }
                }

                document.insertString(document.getLength(), "\n", null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Define o tamanho do JScrollPane conforme necessário

        JOptionPane.showMessageDialog(null, scrollPane, "Heróis", JOptionPane.INFORMATION_MESSAGE);
    }

    private List<SuperHeroi> mostrarHeroisComCodigo() {
        List<SuperHeroi> herois = getHerois();

        return herois;
    }
    @Override
    protected void mostrarViloes() {
        List<Vilao> viloes = getViloes();
        JTextArea textArea = new JTextArea();

        for (Vilao vilao : viloes) {
            Document document = textArea.getDocument();
            try {
                document.insertString(document.getLength(), "Nome do vilão: " + vilao.getNome() + "\n", null);
                document.insertString(document.getLength(), "Nome do vilão na vida real: " + vilao.getNomeVidaReal()
                        + "\n", null);
                document.insertString(document.getLength(), "Superpoderes do vilão:\n", null);

                for (int j = 0; j < vilao.poderes.length; j++) {
                    if (vilao.poderes[j] != null) {
                        document.insertString(document.getLength(), "Nome do poder: " + vilao.poderes[j].getNome()
                                + "\n", null);
                        document.insertString(document.getLength(), "Categoria do poder: " + String.format("%.0f",
                                vilao.poderes[j].getCategoria().getValor()) + "\n", null);
                    }
                }

                document.insertString(document.getLength(), "\n", null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Define o tamanho do JScrollPane conforme necessário

        JOptionPane.showMessageDialog(null, scrollPane, "Vilões", JOptionPane.INFORMATION_MESSAGE);
    }


    private List<Vilao> mostrarViloesComCodigo() {
        List<Vilao> viloes = getViloes();

        return viloes;
    }

    @Override
    protected void confronto() {
        StringBuilder sb = new StringBuilder();

        sb.append("Heróis disponíveis:\n");
        List<SuperHeroi> herois = mostrarHeroisComCodigo();
        for (int i = 0; i < herois.size(); i++) {
            SuperHeroi heroi = herois.get(i);
            sb.append((i + 1)).append(" - ").append(heroi.getNome()).append("\n");
        }
        Integer posHeroi = null;
        String inputPosHeroi;

        while (posHeroi == null) {
            inputPosHeroi = JOptionPane.showInputDialog(null, sb + "Informe o código do herói:");

            if (inputPosHeroi == null) {
                // O usuário clicou em "cancel"
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
                return; // Encerra o método
            }

            try {
                posHeroi = Integer.parseInt(inputPosHeroi);

                if (posHeroi < 1 || posHeroi > herois.size()) {
                    JOptionPane.showMessageDialog(null, "Posição do super-herói não encontrada");
                    posHeroi = null; // Define como null para continuar o loop
                }
            } catch (NumberFormatException e) {
                // O valor digitado não é um número válido
                JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número válido.");
            }
        }

        SuperHeroi heroi = herois.get(posHeroi - 1);
        JOptionPane.showMessageDialog(null, "O super-herói " + heroi.getNome() + " foi escolhido");

        sb.setLength(0);

        sb.append("Vilões disponíveis:\n");
        List<Vilao> viloes = mostrarViloesComCodigo();
        for (int i = 0; i < viloes.size(); i++) {
            Vilao vilao = viloes.get(i);
            sb.append((i + 1)).append(" - ").append(vilao.getNome()).append("\n");
        }

        Integer posVilao = null;
        String inputPosVilao;

        while (posVilao == null) {
            inputPosVilao = JOptionPane.showInputDialog(null, sb + "Informe o código do vilão:");

            if (inputPosVilao == null) {
                // O usuário clicou em "cancel"
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
                return;
            }

            try {
                posVilao = Integer.parseInt(inputPosVilao);

                if (posVilao < 1 || posVilao > viloes.size()) {
                    JOptionPane.showMessageDialog(null, "Posição do vilão não encontrada");
                    posVilao = null; // Define como null para continuar o loop
                }
            } catch (NumberFormatException e) {
                // O valor digitado não é um número válido
                JOptionPane.showMessageDialog(null, "Valor inválido. Digite um número válido.");
            }
        }

        Vilao vilao = viloes.get(posVilao - 1);
        JOptionPane.showMessageDialog(null, "O vilão " + vilao.getNome() + " foi escolhido");

        Confronto confronto = new Confronto();
        Integer resultado = confronto.executar(heroi, vilao);

        if (resultado.equals(0))
            JOptionPane.showMessageDialog(null, "O confronto terminou em empate!");
        else if (resultado.equals(1))
            JOptionPane.showMessageDialog(null, "O super-herói " + heroi.getNome() + " ganhou!");
        else if (resultado.equals(2))
            JOptionPane.showMessageDialog(null, "O vilão " + vilao.getNome() + " ganhou!");
        else
            throw new ConfrontoException("Resultado inválido!");
    }

    private List<Vilao> getViloes() {
        List<Vilao> viloes = new ArrayList<>();

        personagens.stream()
                .filter(x -> x instanceof Vilao)
                .map(x -> viloes.add((Vilao) x))
                .collect(Collectors.toList());
        return viloes;
    }

    private List<SuperHeroi> getHerois() {
        List<SuperHeroi> herois = new ArrayList<>();

        personagens.stream()
                .filter(x -> x instanceof SuperHeroi)
                .map(x -> herois.add((SuperHeroi) x))
                .collect(Collectors.toList());
        return herois;
    }

    @Override
    protected void finalizarGame() {
        JOptionPane.showMessageDialog(null, "Obrigado por jogar!");
        System.exit(0);
    }

    private void carregarSuperHerois() {
        try {
            // Configurar a conexão com o banco de dados MariaDB
            Connection connection = DriverManager.getConnection(url, user, senha);

            // Criar a declaração SQL para recuperar os dados dos superherois
            String query = "SELECT id, nome, nome_vida_real, quantidadePoderes FROM superheroi";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processar cada linha do resultado e criar os objetos correspondentes
            while (resultSet.next()) {
                String nomeHeroi = resultSet.getString("nome");
                String nomeHeroiVidaReal = resultSet.getString("nome_vida_real");
                Integer id = resultSet.getInt("id");

                SuperHeroi superHeroi = new SuperHeroi(id, nomeHeroi, nomeHeroiVidaReal);
                adicionarPoderes(superHeroi, connection);

                personagens.add(superHeroi);
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private void carregarViloes() {
        try {
            // Configurar a conexão com o banco de dados MariaDB
            Connection connection = DriverManager.getConnection(url, user, senha);

            // Criar a declaração SQL para recuperar os dados dos viloes
            String query = "SELECT id, nome, nome_vida_real, tempo_prisao, quantidadePoderes FROM vilao";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Processar cada linha do resultado e criar os objetos correspondentes
            while (resultSet.next()) {
                String nomeVilao = resultSet.getString("nome");
                String nomeVilaoVidaReal = resultSet.getString("nome_vida_real");
                Integer tempoDePrisao = resultSet.getInt("tempo_prisao");
                int quantidadePoderesVilao = resultSet.getInt("quantidadePoderes");
                Integer id = resultSet.getInt("id");

                Vilao vilao = new Vilao(id, nomeVilao, nomeVilaoVidaReal, tempoDePrisao);
                adicionarPoderesVilao(vilao, connection);

                personagens.add(vilao);
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private void adicionarPoderes(Personagem personagem, Connection connection) {
        try {
            // Consultar o banco de dados para buscar os detalhes dos poderes
            String query = "SELECT superheroi.nome, superpoder.nome, superheroi_superpoder.categoria_poder " +
                    "FROM superheroi " +
                    "JOIN superheroi_superpoder ON superheroi.id = superheroi_superpoder.id_superheroi " +
                    "JOIN superpoder superpoder ON superheroi_superpoder.id_superpoder = superpoder.id " +
                    "WHERE superheroi.id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, personagem.getId());
            ResultSet resultSet = statement.executeQuery();

            // Verificar se encontrou poderes no banco de dados
            while (resultSet.next()) {
                String nomePoder = resultSet.getString("superpoder.nome");
                Double categoriaPoder = resultSet.getDouble("superheroi_superpoder.categoria_poder");

                // Criar o objeto SuperPoder e adicioná-lo ao personagem
                SuperPoder superPoder = new SuperPoder(nomePoder, CategoriaPoder.ofDouble(categoriaPoder));
                personagem.adicionaSuperPoder(superPoder);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private void adicionarPoderesVilao(Personagem personagem, Connection connection) {
        try {
            // Consultar o banco de dados para buscar os detalhes dos poderes
            String query = "SELECT vilao.nome, superpoder.nome, vilao_superpoder.categoria_poder " +
                    "FROM vilao " +
                    "JOIN vilao_superpoder ON vilao.id = vilao_superpoder.id_vilao " +
                    "JOIN superpoder superpoder ON vilao_superpoder.id_superpoder = superpoder.id " +
                    "WHERE vilao.id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, personagem.getId());
            ResultSet resultSet = statement.executeQuery();

            // Verificar se encontrou poderes no banco de dados
            while (resultSet.next()) {
                String nomePoder = resultSet.getString("superpoder.nome");
                Double categoriaPoder = resultSet.getDouble("vilao_superpoder.categoria_poder");

                // Criar o objeto SuperPoder e adicioná-lo ao personagem
                SuperPoder superPoder = new SuperPoder(nomePoder, CategoriaPoder.ofDouble(categoriaPoder));
                personagem.adicionaSuperPoder(superPoder);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

}

