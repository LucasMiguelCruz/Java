package Entidades;

import java.util.Scanner;

public class exercicioVeiculos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Valor do combustivel:  ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Quantos carros? ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.println("Quantas motas? ");
        int m = sc.nextInt();
        sc.nextLine();

        Automovel[] automovel = new Automovel[a];
        Moto[] moto = new Moto[m];

        for(int i = 0; i<a; i++)
        {
            System.out.println("Qual é a marca do"+ (i+1) + "º carro ?");
                String marca = sc.next();
                sc.nextLine();
            System.out.println("Qual é o modelo do"+ (i+1) + "º carro ?");
            String modelo = sc.next();
            System.out.println("Qual é o custo do"+ (i+1) + "º carro ?");
            double preço = sc.nextDouble();
            sc.nextLine();

            Automovel carro = new Automovel(marca,modelo,preço);
            automovel[i]= carro;
        }
        for(int i = 0; i<m; i++)
        {
            System.out.println("Qual é a marca do"+ (i+1) + "º carro ?");
            String marca = sc.next();
            sc.nextLine();
            System.out.println("Qual é o modelo do"+ (i+1) + "º carro ?");
            String modelo = sc.next();
            System.out.println("Qual é o custo do"+ (i+1) + "º carro ?");
            double preço = sc.nextDouble();
            sc.nextLine();

            Moto motos = new Moto(marca,modelo,preço);
            moto[i]= motos;
        }





    }
}
