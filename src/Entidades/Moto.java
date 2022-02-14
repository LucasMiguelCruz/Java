package Entidades;

public class Moto {
    public String Marca;
    public String Modelo;
    public double Custo;

    public Moto(){}

    public Moto(String marca, String modelo, double custo){
        this.Marca=marca;
        this.Modelo=modelo;
        this.Custo=custo;
    }
    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public double getCusto() {
        return Custo;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public void setCusto(double custo) {
        Custo = custo;
    }
}
