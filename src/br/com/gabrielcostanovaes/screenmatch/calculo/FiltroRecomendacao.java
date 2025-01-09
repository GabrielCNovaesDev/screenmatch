package br.com.gabrielcostanovaes.screenmatch.calculo;

import br.com.gabrielcostanovaes.screenmatch.modelos.Classificacao;

public class FiltroRecomendacao {

    public void recomendacao(Classificacao classificavel) {
        if(classificavel.getAvaliacao() >= 4){
            System.out.println("filme bom para assistir");
        } else if (classificavel.getAvaliacao() < 4 && classificavel.getAvaliacao() >= 2) {
            System.out.println("Filme mais ou menos, bom para matar o tempo!");
        }else {
            System.out.println("Coloque na sua lista e veja depois.");
        }

    }
}
