package com.aluracursos.mymoneyconverter.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaValorMoneda {

        public Moneda consultaMoneda(String baseCode, String targetCode, double amount) throws IOException, InterruptedException {

                String apiKey = "e4dcb6bd01da0991c324e6c1";

                URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCode + "/" + targetCode + "/" + amount);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .build();

                try {
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());
                        
                        return new Gson().fromJson(response.body(), Moneda.class);
                } catch (Exception e) {
                        throw new RuntimeException("Moneda no encontrada: " + e.getMessage());
                }
        }
}
