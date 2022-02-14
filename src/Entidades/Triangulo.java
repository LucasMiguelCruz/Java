package Entidades;

import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        exercicioTriangulo t1, t2, t3;
        t1=new exercicioTriangulo();
        t2=new exercicioTriangulo();
        t3= new exercicioTriangulo();


        System.out.println("1º Triangulo: ");
        System.out.println("Lado A: ");
        t1.lA=sc.nextDouble();

        System.out.println("Lado B: ");
        t1.lB=sc.nextDouble();

        System.out.println("Lado C: ");
        t1.lC=sc.nextDouble();

        System.out.printf("Area do Triangulo: %.2f%n", t1.Area());
        System.out.printf("Perimetro do Triangulo: %.2f%n", t1.Perimetro());

        System.out.println("2º Triangulo: ");
        System.out.println("Lado A: ");
        t2.lA=sc.nextDouble();

        System.out.println("Lado B: ");
        t2.lB=sc.nextDouble();

        System.out.println("Lado C: ");
        t3.lC=sc.nextDouble();

        System.out.printf("Area do Triangulo: %.2f%n", t2.Area());
        System.out.printf("Perimetro do Triangulo: %.2f%n", t2.Perimetro());

        System.out.println("3º Triangulo: ");
        System.out.println("Lado A: ");
        t3.lA=sc.nextDouble();

        System.out.println("Lado B: ");
        t3.lB=sc.nextDouble();

        System.out.println("Lado C: ");
        t3.lC=sc.nextDouble();

        System.out.printf("Area do Triangulo: %.2f%n", t3.Area());
        System.out.printf("Perimetro do Triangulo: %.2f%n", t3.Perimetro());
    }
}
