package com.pziecin.Service;

import com.pziecin.Events.Event;
import com.pziecin.Events.Type;
import com.pziecin.GUI.Menu;
import com.pziecin.GUI.Mode;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jdk.nashorn.internal.parser.JSONParser;
import sun.security.util.ManifestEntryVerifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    HttpServer server;
    Service service;
    Random random;

    public Server (int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        this.service = new Service();
        this.random = new Random();
    }

    public void start(){
        server.createContext("/predict", exchange -> {
            System.out.println(exchange.getRequestMethod());
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, x-requested-with");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST");
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().add("Access-Control-Max-Age", "86400");

            if(exchange.getRequestMethod().equals("POST")) {
                System.out.println("dziala");
                InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
                BufferedReader br = new BufferedReader(isr);
                String value = br.readLine();
                String result;
                HashMap<String, String> parsedResponse = parseResponse(value);
                System.out.println(parsedResponse);
                if(parsedResponse.get("mode").equals(Mode.PVP.name())){
                    if(parsedResponse.get("p1") == null || parsedResponse.get("p1") == null){
                        exchange.sendResponseHeaders(400, 0);
                        exchange.getResponseBody().write("Ups".getBytes(StandardCharsets.UTF_8));
                    }
                    result = service.solveState(createListNames(parsedResponse.get("p1Name"), parsedResponse.get("p2Name")), createListEvents(parsedResponse.get("p1"), parsedResponse.get("p2")));
                    exchange.sendResponseHeaders(200, 0);
                    exchange.getResponseBody().write(result.getBytes(StandardCharsets.UTF_8));
                    exchange.getResponseBody().close();
                }else if(parsedResponse.get("mode").equals(Mode.PVE.name())){
                    System.out.println("elo");
                    if(parsedResponse.get("p1") == null){
                        System.out.println("elo");
                        exchange.sendResponseHeaders(400, 0);
                        exchange.getResponseBody().write("Ups".getBytes(StandardCharsets.UTF_8));
                    }
                    result = service.solveState(createListNames(parsedResponse.get("p1Name"), "BOT"), createListEventsWithBot(parsedResponse.get("p1")));
                    System.out.println(result);
                    exchange.sendResponseHeaders(200, 0);
                    exchange.getResponseBody().write(result.getBytes(StandardCharsets.UTF_8));
                    exchange.getResponseBody().close();
                }
            }
            exchange.sendResponseHeaders(400, 0);
            exchange.getResponseBody().write("Wrong Request".getBytes(StandardCharsets.UTF_8));
            exchange.getResponseBody().close();
        });
        server.createContext("/solve", exchange -> {
            if(exchange.getRequestMethod().equals("GET")) {
                System.out.println(exchange.getRequestMethod());
                exchange.sendResponseHeaders(200, 0);
            }
        });
        server.setExecutor(null);
        server.start();
    }

    private List<String> createListNames(String p1Name, String p2Name){
        List<String> names = new ArrayList<>();
        if(p1Name != null){
            names.add(p1Name);
        }else {
            names.add("Player 1");
        }
        if(p2Name != null){
            names.add(p2Name);
        }else {
            names.add("Player 2");
        }
        return names;
    }

    private List<String> createListEvents(String p1, String p2){
        List<String> events = new ArrayList<>();
        events.add(p1);
        events.add(p2);
        return events;
    }

    private List<String> createListEventsWithBot(String p1){
        List<String> events = new ArrayList<>();
        events.add(p1);
        System.out.println(getComputerMove().getType().toString());
        events.add(getComputerMove().getType().toString());
        return events;
    }

    private Event getComputerMove(){
        Type[] valuse = Type.values();
        int length = valuse.length;
        int rand = random.nextInt(length);
        return new Event(valuse[rand]);
    }

    private HashMap<String, String> parseResponse(String body){
        HashMap<String,String> params = new HashMap<>();
        String[] pairs = body.split(",");
        for (String t : pairs) {
            String[] tmpSplitedPair = t.split(":");
            params.put(tmpSplitedPair[0], tmpSplitedPair[1]);
        }
        return params;
    }
}
