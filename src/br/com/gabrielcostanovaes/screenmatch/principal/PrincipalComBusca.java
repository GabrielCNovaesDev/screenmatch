package br.com.gabrielcostanovaes.screenmatch.principal;

import br.com.gabrielcostanovaes.screenmatch.formatacao.FormatacaoJSON;
import br.com.gabrielcostanovaes.screenmatch.formatacao.TituloOmdb;
import br.com.gabrielcostanovaes.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.Properties;


public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        FormatacaoJSON format = new FormatacaoJSON();
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/config.properties"));


        String apiKey = properties.getProperty("tmdb_api_key");

        System.out.println("Digite o filme desejado");
        var busca = scanner.nextLine();
        busca = format.formataQuery(busca," ","+");

        String infoFilme = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query="+busca;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(infoFilme))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        String firstResult = format.extractFirstResult(responseBody);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        //Titulo meuTitulo = gson.fromJson(firstResult, Titulo.class);
        TituloOmdb meuTituloOMDB = gson.fromJson(firstResult, TituloOmdb.class);

        if(meuTituloOMDB != null) {
            // String anoFormatado = format.formataQuery(meuTitulo.getDataDeLancamento(),"-","/");
            System.out.println(meuTituloOMDB);
        }else {
            System.out.println("Nenhum titulo encontrado");
        }

    }

}


