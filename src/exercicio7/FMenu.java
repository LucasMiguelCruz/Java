package exercicio7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FMenu {

    private JPanel PMenuP;
    private JButton buttonAlunos;
    private JButton buttonTurmas;

    public static void setVisible(boolean b){
        JFrame frame= new JFrame("Gestao de Alunos e Turmas");
        frame.setContentPane(new FMenu().PMenuP);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FMenu() {
        buttonAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            FAlunos.setVisible(true);
            }
        });
        buttonTurmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
