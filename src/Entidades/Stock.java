package Entidades;

public class Stock {

    public String Nome = "Torradeira";
    public double Preço = 399.99;
    public int Quantidade = 50;


    public double ValorEmStock()
    {
        double total = Preço*Quantidade;
        return total;

    }

    public void AdicionarProdutos(int quant)
    {
        this.Quantidade += quant; //<=> this.Quantidade = this.Quantidade + quant;

    }
    public void RemoverProdutos(int quant)
    {
        this.Quantidade -= quant; //<=> this.Quantidade = this.Quantidade + quant;

    }


}
