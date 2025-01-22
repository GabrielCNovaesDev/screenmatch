package br.com.gabrielcostanovaes.screenmatch.formatacao;

public class FormatacaoJSON {
    public String extractFirstResult(String jsonResponse) {
        String resultsStart = "\"results\":[";
        int startIndex = jsonResponse.indexOf(resultsStart);
        if (startIndex == -1) {
            return null;
        }

        startIndex += resultsStart.length();
        int endIndex = jsonResponse.indexOf("},", startIndex);
        if (endIndex == -1) {
            return null;
        }

        return jsonResponse.substring(startIndex, endIndex + 1);
    }

    public String formataQuery(String query) {
        query  = query.replaceAll(" ","+");
        return query;
    }
}
