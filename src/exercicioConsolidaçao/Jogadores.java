package exercicioConsolidaçao;


public class Jogadores {
    public String Nome;
    public int Idade;
    public String Morada;
    public double Peso;
    public double Altura;
    public int NumeroCamisa;
    public String Posiçao;
    public double Remuneraçao;

    public Jogadores(){}

    public Jogadores(String nome, int idade, String morada, double peso, double altura, int numeroCamisa, String posiçao, double remuneraçao)
    {
        this.Nome = nome;
        this.Idade = idade;
        this.Morada = morada;
        this.Peso = peso;
        this.Altura = altura;
        this.NumeroCamisa = numeroCamisa;
        this.Posiçao = posiçao;
        this.Remuneraçao= remuneraçao;
    }

    public String getNome(){
        return this.Nome;
    }
    public void setNome(String nome){
        this.Nome = nome;

    }
    public int getIdade(){
        return this.Idade;
    }
    public void setIdade(int idade){
        this.Idade = idade;
    }
    public String getMorada()
    {
        return this.Morada;
    }
    public void setMorada(String morada)
    {
        this.Morada = morada;
    }
    public double getPeso(){
        return this.Peso;
    }
    public void setPeso(double peso){
        this.Peso=peso;

    }
    public double getAltura()
    {
        return this.Altura;
    }
    public void setAltura(double altura){
        this.Altura = altura;
    }
    public int getNumeroCamisa(){
        return this.NumeroCamisa;
    }
    public void setNumeroCamisa(int numeroCamisa)
    {
        this.NumeroCamisa=numeroCamisa;
    }
    public String getPosiçao(){
        return this.Posiçao;
    }
    public void setPosiçao(String posiçao){
        this.Posiçao = posiçao;
    }
    public double getRemuneraçao(){
        return this.Remuneraçao;
    }
    public void setRemuneraçao(double remuneraçao){
        this.Remuneraçao = remuneraçao;
    }

    public double MassaCorporal(){
        double imc=0;
        imc=(Peso+(Altura*Altura));
        return imc;
    }
    public double SalarioAnual(){
        double sa=0;
        sa=Remuneraçao*14;
        return sa;
    }

    @Override
    public String toString() {
        return "Jogadores:\n" +
                "\n Nome=" + Nome + "\n Idade=" + Idade + "\n Morada=" + Morada  + "\n Peso=" + Peso + "\n Altura=" + Altura +  "\n NumeroCamisa=" + NumeroCamisa + "\n Posiçao=" + Posiçao + "\n Remuneraçao=" + Remuneraçao + "\n";
    }
}