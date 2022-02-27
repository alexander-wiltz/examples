package itanalyst.jsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.List;

public class jsondemo {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();

        Gson gson = builder.create();

        Person paul = new Person("Paul", 10, Collections.emptyList());
        Person klaus = new Person("Klaus", 10, List.of(paul));

        System.out.println(gson.toJson(paul));
        System.out.println();
        System.out.println(gson.toJson(klaus));

        String jsonString = "{\"name\":\"Klaus\",\"alter\":10,\"gehasstePersonen\":[{\"name\":\"Paul\",\"alter\":10,\"gehasstePersonen\":[]}]}";
        Person klausFromJson = gson.fromJson(jsonString, Person.class);
        System.out.println(klausFromJson);

    }
}
