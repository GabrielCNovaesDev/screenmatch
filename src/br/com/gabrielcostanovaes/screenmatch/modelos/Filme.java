package br.com.gabrielcostanovaes.screenmatch.modelos;

public class Filme extends Titulo implements Classificacao{
    private String diretor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getAvaliacao() {
        return (int) mediaAvaliacoes() / 2; //Divide por 2 porque ele quer o numero de estrelas
    }
}
