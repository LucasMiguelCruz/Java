package Aulas;

import javax.swing.*;
import java.util.Random;

public class exercicioLuckySeven {


    public static void main(String[] argas)
    {
        Random rnd=new Random();

        int input=0;

        do{
            JOptionPane.showMessageDialog( null, "Vão ser gerados 3 numeros aleatorios de 1 a 7");

            int num1=rnd.nextInt(7)+1;
            int num2=rnd.nextInt(7)+1;
            int num3=rnd.nextInt(7)+1;

            if (num1==7 && num2==7 && num3==7){
                JOptionPane.showMessageDialog(null, "Parabens ganhou o primeiro premio!" + "(" + num1 + "," + num2 + "," + num3 + ")");
            }
            else if((num1==7 && num2==7) || (num2==7 && num3==7) || (num3==7 && num1==7))
            {
                JOptionPane.showMessageDialog(null, "Parabens ganhou o segundo premio!" + "(" + num1 + "," + num2 + "," + num3 + ")");
            }
            else if((num1==7) || (num2==7) || (num3==7))
            {
                JOptionPane.showMessageDialog(null, "Parabens ganhou o terceiro premio!" + "(" + num1 + "," + num2 + "," + num3 + ")");
            }
            else if(num1+num2+num3==7)
            {
                JOptionPane.showMessageDialog(null, "Parabens ganhou o quarto premio!" + "(" + num1 + "," + num2 + "," + num3 + ")");

            }
            else {
                JOptionPane.showMessageDialog(null, "és burro");
            }
            input = JOptionPane.showConfirmDialog(null,
                    "Deseja Continuar", "Continuar",JOptionPane.YES_NO_CANCEL_OPTION);

            // 0=yes, 1=no, 2=cancel
            System.out.println(input);

        }while (input == 0);

        System.exit(0);

    }
}
