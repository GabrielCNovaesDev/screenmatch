package br.com.gabrielcostanovaes.screenmatch.modelos;

import br.com.gabrielcostanovaes.screenmatch.formatacao.TituloOmdb;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("original_title")
    private String nome;
    @SerializedName("release_date")
    private String dataDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    private double mediaDasAvaliacoes = somaDasAvaliacoes / totalDeAvaliacoes;

    public Titulo(String nome, String dataDeLancamento) {
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOMDB) {
        this.nome = meuTituloOMDB.original_title();
        this.dataDeLancamento = meuTituloOMDB.release_date();
        this.mediaDasAvaliacoes = Double.parseDouble(meuTituloOMDB.vote_average());
    }

    public String getNome() {
        return nome;
    }

    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + dataDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return mediaDasAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Título original: " + nome +" / "+ "Data de lançamento: "+ dataDeLancamento + " / "+" Média de avaliações: "
                + mediaDasAvaliacoes;
    }
}
