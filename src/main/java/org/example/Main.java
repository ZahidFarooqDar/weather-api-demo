package org.example;
import org.json.JSONString;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            fetchData();
        } catch (IOException var2) {
            System.out.println("Something went wrong");
            var2.printStackTrace();
        } catch (InterruptedException var3) {
            System.out.println("Something went wrong");
            var3.printStackTrace();
        }

    }

    public static void fetchData() throws IOException, InterruptedException {
        String url = "https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key=668066f5f22b4f3b844f77d2b7cb15e6&include=minutely";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(httpResponse.statusCode());
        System.out.println((String)httpResponse.body());
        System.out.println("finished");
    }
}