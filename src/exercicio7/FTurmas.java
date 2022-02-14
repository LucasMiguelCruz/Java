package exercicio7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FTurmas {
    private JTextArea textAreaDadosAlunos;
    private JButton atribuirAlunosButton;
    private JTextField textFieldDesigTurma;
    private JTextField textFieldNAlunos;
    private JTextField textFieldMediaTurma;
    private JTextField textFieldNNegativas;
    private JTextField textFieldMaisAlta;
    private JButton guardarTurmaButton;

    public void setVisible(boolean b)
    {
        JFrame frame=new JFrame("Gestao de turmas");
        frame.setLocationRelativeTo(null);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public FTurmas() {
        atribuirAlunosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Aluno a: FAlunos.turma)
                {
                    textAreaDadosAlunos.append(a.toString()+ "\n");

                }
            }
        });
        guardarTurmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textAreaDadosAlunos.getText()!="" && textFieldDesigTurma.getText()!="")
                {
                    Turma t= new Turma();
                    t.setDesignacao(textFieldDesigTurma.getText());
                    t.setAlunos(FAlunos.turma);

                    textFieldNAlunos.setText(String.valueOf(t.Alunos));
                    textFieldMediaTurma.setText(String.valueOf(t.Mediaturma()));
                    textFieldNNegativas.setText(String.valueOf(t.MNegativas()));
                    textFieldMaisAlta.setText(String.valueOf(t.MediaAlta()));
                    JOptionPane.showMessageDialog(null, "Turma " + t.getDesignacao() + " guardada com sucesso");
                }
            }
        });
    }
}
