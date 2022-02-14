package Aulas;

import javax.swing.*;
import java.util.Random;

public class exercicioAdivinharNumero {

    public static void main(String[] args)
    {
        Random rnd=new Random();
        int numEscondido=rnd.nextInt(100);
        int num;
        int tentativas =0;
        JOptionPane.showMessageDialog( null, "Tente advinhar o numero inteiro até 100");
        do {
            num = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero: "));
            if (num > numEscondido){
                JOptionPane.showMessageDialog(null, "Tente um numero menor!");
                tentativas++;
            }

            else if (num < numEscondido) {
                JOptionPane.showMessageDialog(null, "Tente um numero maior  ");
                tentativas++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Parabens! Acertou o numero " + num + " em " + tentativas+ " tentativas ");
                System.exit(0);
            }

        } while(true);
    }
}
