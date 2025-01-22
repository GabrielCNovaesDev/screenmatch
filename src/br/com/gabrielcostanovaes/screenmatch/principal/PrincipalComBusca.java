package br.com.gabrielcostanovaes.screenmatch.principal;

import br.com.gabrielcostanovaes.screenmatch.formatacao.FormatacaoJSON;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        FormatacaoJSON format = new FormatacaoJSON();

        System.out.println("Digite o filme desejada");
        var busca = scanner.nextLine();
        busca = format.formataQuery(busca);

        String infoFilme = "https://api.themoviedb.org/3/search/movie?api_key=&query="+busca;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(infoFilme))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        String firstResult = format.extractFirstResult(responseBody);

        System.out.println(firstResult);
    }

}


