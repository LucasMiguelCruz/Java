package Entidades;

public class Funcionario {

    public String name;
    public double grossSalary;
    public double tax;
    public double per;
    public double sal;
    public double NetSalary()
    {
        return grossSalary-tax;
    }
    public double IncreaseSalary()
    {
        return((per/100)*grossSalary) + sal;
    }
}
