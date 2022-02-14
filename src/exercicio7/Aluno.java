package exercicio7;

public class Aluno {
    public String Identificacao;
    public int[] Notas;

    public Aluno(){}

    public Aluno(String identificacao,int[] notas){
        this.Identificacao=identificacao;
        this.Notas=notas;

    }

    public String getIdentificacao() {
        return this.Identificacao;
    }

    public int[] getNotas() {
        return this.Notas;
    }

    public void setIdentificacao(String identificacao) {
        this.Identificacao = identificacao;
    }

    public void setNotas(int[] notas) {
        this.Notas = notas;
    }
    public double Media()
    {
        double total=0;
        for(int i=0; i<Notas.length;i++)
            total += Notas[i];
        return (total/Notas.length);
    }
    public int NNegativas(){
        int nneg=0;
        for(int i=0;i<Notas.length;i++)
            if(Notas[i]<10)
                nneg++;
            return nneg;
    }
    public String toString()
    {
        String s=this.getIdentificacao() + ", Notas: ";
                for(int i=0; i<Notas.length;i++)
                    String.valueOf(Notas[i] + ", ");
                s+= "Média: " + this.Media();
                s+= ",Nº Negativas: " + this.NNegativas();
                return s;
    }
}
