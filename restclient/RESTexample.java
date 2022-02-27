package itanalyst.restclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.*;
import feign.gson.GsonDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RESTexample {

    interface StarWarsClient {
        @RequestLine("GET /")
        @Headers("Content-Type: application/json")
        Response getAPIroot();

        @RequestLine("GET /people/{id}")
        @Headers("Content-Type: application/json")
        Actor getActor(@Param("id") int personId);

        @RequestLine("GET /people/{id}")
        @Headers("Content-Type: application/json")
        Response getSchauspielerRAW(@Param("id") int personId);
    }

    public static void main(String[] args) throws IOException {
        StarWarsClient client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(StarWarsClient.class, "https://swapi.dev/api");

        Response response = client.getAPIroot();
        System.out.println("Status: " + response.status());
        System.out.println("Reason: " + response.reason());

        Actor lukas = client.getActor(1);
        System.out.println(lukas);
        Actor person = client.getActor(10);
        System.out.println(person);

        // flexibles reinstreamen von JSON Strings und dann eingeben über gson package
        InputStreamReader inputstream = new InputStreamReader(client.getSchauspielerRAW(1).body().asInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputstream);
        String jsonString = bufferedReader.lines().collect(Collectors.joining("\n"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Actor a = gson.fromJson(jsonString, Actor.class);
        System.out.println("Body: " + a);
    }
}
