package uz.pdp;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetMethods {

    public static Namoz get() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://islomapi.uz/api/present/day?region=Toshkent"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Namoz namoz = gson.fromJson(response.body(), Namoz.class);
        return namoz;
    }


    public static ListNamoz[] getWeekly() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://islomapi.uz/api/present/week?region=Toshkent"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ListNamoz[] namoz = gson.fromJson(response.body(), ListNamoz[].class);
        return namoz;
    }

    public static ListNamoz[] getMonthly() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://islomapi.uz/api/monthly?region=Toshkent&month=4"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ListNamoz[] namoz = gson.fromJson(response.body(), ListNamoz[].class);
        return namoz;
    }
}
