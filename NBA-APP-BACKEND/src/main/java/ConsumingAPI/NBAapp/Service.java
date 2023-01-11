package ConsumingAPI.NBAapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service

public class Service {


    public List<Game>getAllLive() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://api-nba-v1.p.rapidapi.com/games?live=all"))
                .headers("X-RapidAPI-Key","d0c6833c06msh06ea34a74efce1cp188948jsn79cae407c02c","X-RapidAPI-Host","api-nba-v1.p.rapidapi.com")
                .build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(response.body());
        JsonNode gamenode=rootNode.path("response");

        List<Game> games= new ArrayList<>();
        for(JsonNode node : gamenode){
            String date =  node.path("date").path("start").asText();

            String Awayteam = node.path("teams").path("visitors").path("name").asText();
            String Hometeam = node.path("teams").path("home").path("name").asText();
            int awayscore= node.path("scores").path("visitors").path("points").asInt();
            int Homescore= node.path("scores").path("home").path("points").asInt();
            games.add(new Game(date,Hometeam,Awayteam,Homescore,awayscore));
        }
        return  games;
    }

    public  List<Game>   date() throws URISyntaxException, IOException, InterruptedException {
        String url="https://api-nba-v1.p.rapidapi.com/games?date=";
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today = LocalDate.now( zonedId );
        url=url+today;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(url))
                .headers("X-RapidAPI-Key","d0c6833c06msh06ea34a74efce1cp188948jsn79cae407c02c","X-RapidAPI-Host","api-nba-v1.p.rapidapi.com")
                .build();
        HttpResponse<String> response= HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(url);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(response.body());
        JsonNode gamenode=rootNode.path("response");

        List<Game> games= new ArrayList<>();
        for(JsonNode node : gamenode){
            String date =  node.path("date").path("start").asText();

            String Awayteam = node.path("teams").path("visitors").path("name").asText();
            String Hometeam = node.path("teams").path("home").path("name").asText();
            int awayscore= node.path("scores").path("visitors").path("points").asInt();
            int Homescore= node.path("scores").path("home").path("points").asInt();
            games.add(new Game(date,Hometeam,Awayteam,Homescore,awayscore));
        }

        return games;

    }



}
