package com.pziecin.Service;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    HttpServer server;
    Service service;

    public Server (int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
        this.service = new Service();
    }

    public void start(){
        server.createContext("/predict", exchange -> {
            System.out.println(exchange.getRequestMethod());
            if(exchange.getRequestMethod().equals("POST")) {
                Headers headers = exchange.getRequestHeaders();
                InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
                BufferedReader br = new BufferedReader(isr);
                String value = br.readLine();
                System.out.println(value);
                HashMap<String, String> parsedResponse = parseResponse(value);
                exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, x-requested-with");
                exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST");
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().add("Access-Control-Max-Age", "86400");
                if(parsedResponse.get("p1") == null || parsedResponse.get("p1") == null){
                    exchange.sendResponseHeaders(400, 0);
                    exchange.getResponseBody().write("Ups".getBytes(StandardCharsets.UTF_8));
                    exchange.getResponseBody().close();
                }
                String result = service.solveState(createListNames(parsedResponse.get("p1Name"), parsedResponse.get("p2Name")), createListEvents(parsedResponse.get("p1"), parsedResponse.get("p2")));
                exchange.sendResponseHeaders(200, 0);
                exchange.getResponseBody().write(result.getBytes(StandardCharsets.UTF_8));
                exchange.getResponseBody().close();
            }else{
                exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, x-requested-with");
                exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST");
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().add("Access-Control-Max-Age", "86400");
                exchange.sendResponseHeaders(400, 0);
                exchange.getResponseBody().write("Wrong Request".getBytes(StandardCharsets.UTF_8));
                exchange.getResponseBody().close();
            }
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
