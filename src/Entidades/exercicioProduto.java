package Entidades;

import java.util.Scanner;

public class exercicioProduto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos produtos: ");
        int N = sc.nextInt();
        sc.nextLine();

        Produto[] produtos = new Produto[N];
        for (int i = 0; i < N; i++) {
            System.out.print("Nome do " + (i+1) + "º Produto: ");
            String nome=sc.nextLine();
            System.out.print("Preço do " + (i+1) + "º Produto: ");
            double preço=sc.nextDouble();
            sc.nextLine();
            Produto p=new Produto(nome, preço);
            produtos[i]=p;

        }
        double total=0;
        for(int i=0; i<N; i++)
        {
            System.out.println("Dados do: " + (i+1)+ "Produto: (" + produtos[i].getNome() + " , " + produtos[i].getPreço() + " )");
            total +=produtos[i].getPreço();

        }
        double media=total/N;
        System.out.printf("Valor medio dos produtos: %.2f%n", media);
    }

}
