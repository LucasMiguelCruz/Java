package exercicioConsolidaçao;

import exercicio7.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class FJogadores {
    private javax.swing.JPanel PanelJogadores;
    private JButton gestaoDeJogadoresButton;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldMorada;
    private JTextField textFieldPeso;
    private JTextField textFieldAltura;
    private JTextField textFieldNumeroCamisa;
    private JTextField textFieldPosiçaoCampo;
    private JTextField textFieldRemuneraçao;
    private JTextField textFieldAPesquisar;
    private JButton pesquisarJogadorButton1;
    private JTextField textFieldANome;
    private JTextField textFieldAIdade;
    private JTextField textFieldAMorada;
    private JTextField textFieldAPeso;
    private JTextField textFieldAAltura;
    private JTextField textFieldANumeroCamisa;
    private JTextField textFieldAPosiçaoCampo;
    private JTextField textFieldARemuneração;
    private JButton buttonGravar;
    private JButton guardarButton;
    private JTextArea textArea1;
    private JTextField textFieldJogadorApagar;
    private JButton pesquisarJogadorButton;
    private JTextArea textAreaApagarJogador;
    private JButton apagarButton;
    private JPanel labelIMC;
    private JPanel panel;
    private JLabel labelAIMC;
    private JLabel labelIIMC;
    private JLabel labelASalarioAnual;
    private JLabel labelSalarioAtual;
    private JLabel labelCSalarioAnual;
    private JLabel labelCIMC;

    public static  Jogadores jogador;
    public static ArrayList<Jogadores> jogadores =  new ArrayList<Jogadores>();

    public static void setVisible(boolean a){
        JFrame frame = new JFrame("Jogadores");
        frame.setContentPane(new FJogadores().PanelJogadores);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public FJogadores() {
        buttonGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldNome.getText()!="" && textFieldIdade.getText()!="" && textFieldMorada.getText()!="" &&
                        textFieldPeso.getText()!="" && textFieldAltura.getText()!="" && textFieldNumeroCamisa.getText()!="" &&
                        textFieldPosiçaoCampo.getText()!="" && textFieldRemuneraçao.getText()!=""){

                    jogador = new Jogadores();
                    jogador.Nome = textFieldNome.getText();
                    jogador.Idade = Integer.valueOf(textFieldIdade.getText());
                    jogador.Morada = textFieldMorada.getText();
                    jogador.Peso = Double.valueOf(textFieldPeso.getText());
                    jogador.Altura = Double.valueOf(textFieldAltura.getText());
                    jogador.NumeroCamisa = Integer.valueOf(textFieldNumeroCamisa.getText());
                    jogador.Posiçao= textFieldPosiçaoCampo.getText();
                    jogador.Remuneraçao = Double.valueOf(textFieldRemuneraçao.getText());
                    labelIIMC.setText(String.valueOf(jogador.MassaCorporal()));
                    labelSalarioAtual.setText(String.valueOf(jogador.SalarioAnual()));
                    jogadores.add(jogador);

                    JOptionPane.showMessageDialog(null, "Jogador guardado com sucesso! " + jogador.getNome());

                    textFieldNome.setText("");
                    textFieldIdade.setText("");
                    textFieldMorada.setText("");
                    textFieldAltura.setText("");
                    textFieldPeso.setText("");
                    textFieldNumeroCamisa.setText("");
                    textFieldPosiçaoCampo.setText("");
                    textFieldRemuneraçao.setText("");


                }
            }
        });

        pesquisarJogadorButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldAPesquisar.getText();
                for(Jogadores J: jogadores){

                    textFieldANome.setText(J.getNome());
                    textFieldAIdade.setText(String.valueOf(J.getIdade()));
                    textFieldAMorada.setText(J.getMorada());
                    textFieldAPeso.setText(String.valueOf(J.getPeso()));
                    textFieldAAltura.setText(String.valueOf(J.getAltura()));
                    textFieldANumeroCamisa.setText(String.valueOf(J.getNumeroCamisa()));
                    textFieldAPosiçaoCampo.setText(J.getPosiçao());
                    textFieldARemuneração.setText(String.valueOf(J.getRemuneraçao()));
                    jogador = J;
                    labelAIMC.setText(String.valueOf(jogador.MassaCorporal()));
                    labelASalarioAnual.setText(String.valueOf(jogador.SalarioAnual()));


                }
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldAPesquisar.getText();
                if (textFieldANome.getText() != "" && textFieldAIdade.getText() != "" && textFieldAMorada.getText() != "" &&
                        textFieldAPeso.getText() != "" && textFieldAAltura.getText() != "" && textFieldANumeroCamisa.getText() != "" &&
                        textFieldAPosiçaoCampo.getText() != "" && textFieldARemuneração.getText() != "") {

                    for (Jogadores J : jogadores) {
                        if (J.getNome().equals(nome)) {
                            J.Nome = textFieldANome.getText();
                            J.Idade = Integer.valueOf(textFieldAIdade.getText());
                            J.Morada = textFieldAMorada.getText();
                            J.Peso = Double.valueOf(textFieldAPeso.getText());
                            J.Altura = Double.valueOf(textFieldAAltura.getText());
                            J.NumeroCamisa = Integer.valueOf(textFieldANumeroCamisa.getText());
                            J.Posiçao = textFieldAPosiçaoCampo.getText();
                            J.Remuneraçao = Double.valueOf(textFieldARemuneração.getText());
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Jogador alterado com sucesso! " + jogador.getNome());
                }


            }
        });


        textArea1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            textFieldNome.setText("");
            textFieldIdade.setText("");
            textFieldMorada.setText("");
            textFieldAltura.setText("");
            textFieldPeso.setText("");
            textFieldNumeroCamisa.setText("");
            textFieldPosiçaoCampo.setText("");
            textFieldRemuneraçao.setText("");
            textArea1.setText("");

            textFieldANome.setText("");
            textFieldAIdade.setText("");
            textFieldAMorada.setText("");
            textFieldAAltura.setText("");
            textFieldAPeso.setText("");
            textFieldANumeroCamisa.setText("");
            textFieldAPosiçaoCampo.setText("");
            textFieldARemuneração.setText("");

            for(Jogadores J : jogadores){
                textArea1.append(J.toString());
                labelCIMC.setText(String.valueOf(jogador.MassaCorporal()));
                labelCSalarioAnual.setText(String.valueOf(jogador.SalarioAnual()));
            }

            }
        });
        pesquisarJogadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldAPesquisar.getText();
                for(Jogadores J: jogadores){
                    textAreaApagarJogador.setText("");
                    textAreaApagarJogador.setText(J.toString());
                    jogador = J;


                }
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldAPesquisar.getText();
                for(Jogadores J: jogadores){
                    jogadores.remove(J);
                    textAreaApagarJogador.setText("");
                    textFieldJogadorApagar.setText("");
                    JOptionPane.showMessageDialog(null, "Jogador apagado com sucesso");
                }
            }
        });
    }
}