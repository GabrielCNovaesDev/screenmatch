package br.com.gabrielcostanovaes.screenmatch.calculo;

import br.com.gabrielcostanovaes.screenmatch.modelos.Titulo;

public class CalculadoraTempo {
    private int tempoTotal;


    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo titulo){
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
