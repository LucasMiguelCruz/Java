package exercicioConsolidaçao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FMenu {
    private JButton buttonClube;
    private JButton buttonJogadores;
    private JPanel PMenuP;

    public static void setVisible(boolean a)
    {
        JFrame frame = new JFrame("Jogadores");
        frame.setContentPane(new FMenu().PMenuP);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public FMenu() {
        buttonClube.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FClube.setVisible(true);

            }
        });

        buttonJogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FJogadores.setVisible(true);
            }
        });
    }
}
