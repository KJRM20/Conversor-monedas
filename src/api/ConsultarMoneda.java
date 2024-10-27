package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public Moneda obtenerMoneda(String monedaActual){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e0ee77579b057f37fb41ace8/latest/"+monedaActual);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            return gson.fromJson(json,Moneda.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
