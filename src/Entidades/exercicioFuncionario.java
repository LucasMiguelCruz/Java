package Entidades;

import java.util.Scanner;

public class exercicioFuncionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario f = new Funcionario();

        System.out.println("Dados do funcionario");
        System.out.print("Nome: ");
        f.name=sc.nextLine();

        System.out.print("Salario Bruto: ");
        f.grossSalary=sc.nextDouble();

        System.out.print("Impostos: ");
        f.tax=sc.nextDouble();

        f.sal=f.NetSalary();
        System.out.printf("Dados do funcionario: " );
        System.out.printf("Nome: " + f.name + ", Salario Bruto: " + f.sal );

        System.out.printf("\nQuer aumentar o salario em quanta percentagem: " );

        f.per=sc.nextDouble();
        f.sal=f.IncreaseSalary();
        System.out.printf("Dados atualizados: Nome: "  + f.name + ", Salario Bruto: " + f.sal );



    }
}
