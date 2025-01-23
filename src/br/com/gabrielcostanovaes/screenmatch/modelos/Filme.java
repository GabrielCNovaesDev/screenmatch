package br.com.gabrielcostanovaes.screenmatch.modelos;

import br.com.gabrielcostanovaes.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, String dataDeLancamento) {
        super(nome, dataDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getDataDeLancamento() + ")";
    }
}
