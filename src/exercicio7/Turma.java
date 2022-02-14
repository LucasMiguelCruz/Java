package exercicio7;

import java.util.ArrayList;

public class Turma {
    public String Designacao;
    public ArrayList<Aluno> Alunos;

    public Turma(){}

    public Turma(String design,ArrayList<Aluno> alunos){
        this.Designacao=design;
        this.Alunos=(ArrayList<Aluno>) alunos.clone();
    }
    public double Mediaturma()
    {
        double media=0;
        double total=0;
        for(Aluno a: this.Alunos)
            total +=a.Media();
        media=total/Alunos.size();
        return media;
    }

    public String getDesignacao() {
        return Designacao;
    }

    public ArrayList<Aluno> getAlunos() {
        return Alunos;
    }



    public void setDesignacao(String designacao) {
        Designacao = designacao;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        Alunos = alunos;
    }


    public double MNegativas(){
      int nAlunos=0;
      for(Aluno a: this.Alunos)
      {
          if(a.NNegativas()>=3)
                nAlunos++;
      }
      return nAlunos;
    }
    public double MediaAlta(){
        double media = 0;
        for(Aluno a: this.Alunos)
        {
            if(a.Media()>media)
                media = a.Media();
        }
        return media;
    }
}
