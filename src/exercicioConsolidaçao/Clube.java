package exercicioConsolidaçao;

import java.util.ArrayList;

public class Clube {
    public String Designaçao;
    public ArrayList<Jogadores> Jogadores;

    public Clube(){}


        public Clube(String designaçao, ArrayList<Jogadores> conjogadores)
        {
            this.Designaçao = designaçao;
            this.Jogadores = (ArrayList) conjogadores.clone();
        }
        public String getDesignaçao(){
            return this.Designaçao;
        }
        public void setDesignaçao(String designaçao)
        {
            this.Designaçao = designaçao;
        }

    public ArrayList<exercicioConsolidaçao.Jogadores> getJogadores() {
        return Jogadores;
    }

    public void setJogadores(ArrayList<exercicioConsolidaçao.Jogadores> jogadores) {
        Jogadores = jogadores;
    }

    @Override
    public String toString() {
        return "Jogadores do clube: " +
                "Designaçao='" + Designaçao + '\'' +
                ", Jogadores=" + Jogadores +
                '}';
    }
}
