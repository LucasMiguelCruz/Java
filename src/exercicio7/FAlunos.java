package exercicio7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FAlunos {
    private JPanel PPrincipal;
    private JButton gestaoDeAlunosButton;
    private JTextField textFieldAreaNotas;
    private JTextField textFieldNota;
    private JButton gerarDisciplinasButton;
    private JButton guardarButton;
    private JTextField textFieldNNegativas;
    private JTextField textFieldMedia;
    private JTextField textFieldIdentAluno;
    private JButton adicionarButton;
    private JTextArea textAreaNotas;
    private JButton novoAlunoButton;
    private JTextField textFieldAlunoAPesquisar;
    private JTextField textFieldAlNome;
    private JTextField textFieldAlMedia;
    private JButton pesquisarButton;
    private JTextArea textAreaAlNotas;
    private JTextField textFieldAINNeg;
    private JButton AlterarButton;
    private JTextArea textArea1;
    private JButton encontrarAlunoButton;
    private JTextField textFieldNomeEncontrado;
    private JTextField textFieldMediaEncontrado;
    private JTextField textFieldNNegativasEncontradas;
    private JTextField textFieldNomeAlunoApagar;
    private JButton turmaAposApagarButton;
    private JTextArea textArea2;

    short nDscp=10;
    public int[] notas= new int[nDscp];
    short ap =0;

    public static ArrayList<Aluno> turma=new ArrayList<Aluno>();
    public static Aluno al,alu;
     public FAlunos() {
        gerarDisciplinasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rnd=new Random();
                short nNeg=0;

                textAreaNotas.setText("");
                for(int i=0;i<nDscp;i++)
                {
                    notas[i]=rnd.nextInt(21);

                    textAreaNotas.append(notas[i] + "\n");

                }


            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldIdentAluno.getText()!="" && textAreaNotas.getText()!=""
                        && textFieldMedia.getText()!="" && textFieldNNegativas.getText()!=""){
                     alu = new Aluno();
                    alu.setIdentificacao(textFieldIdentAluno.getText());
                    alu.setNotas(notas);

                    textFieldMedia.setText(String.valueOf(alu.Media()));
                    textFieldNNegativas.setText(String.valueOf(alu.NNegativas()));
                    turma.add(alu);
                    JOptionPane.showMessageDialog(null, "Aluno: guardado com sucesso! " + alu.getIdentificacao());

                }
                else
                    JOptionPane.showMessageDialog(null, "Dados incompletos! Por favor, complete os dados");
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldNota.getText()!="") {
                    textAreaNotas.append(textFieldNota.getText()+"\n");
                    notas[ap] = Integer.parseInt((textFieldNota.getText()));

                }
                ap++;
            }
        });
         novoAlunoButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 textFieldIdentAluno.setText("");
                 textFieldAreaNotas.setText("");
                 textFieldNNegativas.setText("");
                 textFieldMedia.setText("");
                 textFieldNota.setText("");
                    textAreaNotas.setText("");
             }
         });
         pesquisarButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String nome=textFieldAlunoAPesquisar.getText();
                 for(Aluno a: turma)
                     if(al.Identificacao.equals(nome))
                     {
                         textFieldAlNome.setText(al.getIdentificacao());
                         for(int nota: al.getNotas())
                             textAreaAlNotas.append(nota +"\n");
                         textFieldAlMedia.setText(String.valueOf(al.Media()));
                         textFieldNNegativas.setText(String.valueOf(al.NNegativas()));

                     }
             }
         });
         AlterarButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 al.setIdentificacao(textFieldAlNome.getText());
                 String[] newStr=textAreaAlNotas.getText().split("\n");
                 int[] arNotas=new int[newStr.length];
                 for(int i=0; i< newStr.length;i++)
                     arNotas[i]=Integer.parseInt(newStr[i]);
                 al.Notas=arNotas.clone();
                 textFieldAlMedia.setText(String.valueOf(al.Media()));
                 textFieldNNegativas.setText(String.valueOf(al.NNegativas()));
                 JOptionPane.showMessageDialog(null, "Dados do aluno guardados com sucesso" );
             }


         });
         encontrarAlunoButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String nome=textFieldNomeAlunoApagar.getText();
                 for(Aluno aluno: turma)
                 {
                     if(al.getIdentificacao().equals(nome))
                     {
                         textFieldNomeEncontrado.setText(al.getIdentificacao());
                         textFieldMediaEncontrado.setText(String.valueOf(al.Media()));
                         textFieldNNegativas.setText(String.valueOf(al.NNegativas()));

                         int res = JOptionPane.showConfirmDialog(null, "Tem a certeza que deseja eliminar os dados do aluno" + al.getIdentificacao());
                         if(res==0)
                         {
                             turma.remove(al);
                             JOptionPane.showConfirmDialog(null, "Dados do aluno eliminados com sucesso");
                         }
                     }
                 }
             }
         });
         turmaAposApagarButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 textArea2.append(al.toString() + "\"");
                 textFieldNomeAlunoApagar.setText("");
                 textFieldNomeEncontrado.setText("");
                 textFieldMediaEncontrado.setText("");
                 textFieldNNegativas.setText("");

             }
         });
     }

    public static void setVisible(boolean b){
        JFrame frame= new JFrame("Gestao de Alunos");
        frame.setContentPane(new FAlunos().PPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

