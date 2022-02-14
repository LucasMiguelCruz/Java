package exercicio7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private JPanel panelLogin;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JButton buttonCancel;
    private JButton buttonOK;
    private JPanel jPanel;


    public Login() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUser=textFieldUsername.getText();
                String txtPass=textFieldPassword.getText();


                try{

                    Connection conn=Conexao.createConnection();
                    String sql="SELECT NOME, USERNAME, PASSWRD FROM USER";
                    PreparedStatement ps=conn.prepareStatement(sql);
                    ResultSet rs=ps.executeQuery();
                    boolean fg=false;

                    while(rs.next())
                    {
                        String nome=rs.getString(1);
                        String user=rs.getString("USERNAME");
                        String pass=rs.getString("PASSWORD");
                        //System.out.println(nome + " - " + user + " - " + pass);

                        if((txtUser.equals(user)) && (txtPass.equals(pass))){

                            new FMenu().setVisible(true);
                            fg = true;
                        }
                    }
                    if(!fg)
                    {
                        JOptionPane.showMessageDialog(null,"Login errado! username/password errados");
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }






            }
        });
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("Login");
        frame.setContentPane(new Login().panelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
