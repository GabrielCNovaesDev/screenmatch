package br.com.gabrielcostanovaes.screenmatch.modelos;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    //getters
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
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

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void imprimeFichaTecnica(){
        System.out.println("Nome: "+nome);
        System.out.println("Ano de lançamento: "+anoDeLancamento);
        System.out.println("Duração: "+duracaoEmMinutos);
    }

    public void avaliaFilme(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double mediaAvaliacoes(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
