package Entidades;

import java.util.Scanner;

public class exercicioStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock p= new Stock();

        System.out.println("Dados do produto em stock");
        System.out.print("Nome: ");
        p.Nome=sc.nextLine();

        System.out.print("Preço: ");
        p.Preço=sc.nextDouble();

        System.out.print("Quantidade: ");
        p.Quantidade=sc.nextInt();

        System.out.printf("Dados do produto: " );
        System.out.printf("Nome: %s, Preço: %.2f, Quantidade: %d, Total em Stock: %.2f", p.Nome,p.Preço,p.Quantidade,p.ValorEmStock());

        //entrada em stock

        System.out.println("\nEntrada em stock");
        System.out.print("Quantidade: ");
        int qt=sc.nextInt();
        p.AdicionarProdutos(qt);

        //saida em stock

        System.out.printf("\nDados do produto depois de adicionar stock: " );
        System.out.printf("Nome: %s, Preço: %.2f, Quantidade: %d, Total em Stock: %.2f", p.Nome,p.Preço,p.Quantidade,p.ValorEmStock());
        System.out.println("\nEntrada em stock");
        System.out.print("Quantidade: ");
            qt=sc.nextInt();
        p.RemoverProdutos(qt);
        System.out.printf("\nDados do produto depois de remover stock: " );
        System.out.printf("Nome: %s, Preço: %.2f, Quantidade: %d, Total em Stock: %.2f", p.Nome,p.Preço,p.Quantidade,p.ValorEmStock());

    }
}
