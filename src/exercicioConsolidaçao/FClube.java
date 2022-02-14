package exercicioConsolidaçao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FClube {
    private JPanel PanelClube;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldDesignação;
    private JButton adicionarJogadoresButton;
    private JTextArea textArea1;
    private JButton gravarButton;
    private JTextField textFieldNomeClube;
    private JButton mostrarButton;
    private JTextArea textArea2;

    public static Clube clubes;
    public static ArrayList<Clube> clu=new ArrayList<Clube>();

    public FClube() {
        adicionarJogadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                for(Jogadores J: FJogadores.jogadores){
                    textArea1.append(J.toString());
                }
            }
        });
        gravarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldDesignação.getText()!="" && textArea1.getText()!=""){
                    clubes = new Clube();
                    clubes.setDesignaçao(textFieldDesignação.getText());
                    clubes.Jogadores.add(FJogadores.jogador);
                    clu.add(clubes);



                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Clube C: clu){
                    textArea2.append(C.toString());
                }

            }
        });
    }

    public static void setVisible(boolean a)
    {
        JFrame frame = new JFrame("Jogadores");
        frame.setContentPane(new FClube().PanelClube);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
