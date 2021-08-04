package com.pziecin.Service;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    HttpServer server;

    public Server (int port) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
    }

    public void start(){
        server.createContext("/predict", exchange -> {
            System.out.println(exchange.getRequestMethod());
            exchange.getResponseHeaders().add("Content-length", Integer.toString(0));
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers","Content-Type, x-requested-with");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods","GET,POST");
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin","*");
            exchange.getResponseHeaders().add("Access-Control-Max-Age","86400");
            exchange.sendResponseHeaders(200,0);
            exchange.getResponseBody().write("IT works".getBytes(StandardCharsets.UTF_8));
            exchange.getResponseBody().close();
        });
        server.createContext("/solve", exchange -> {
            System.out.println(exchange.getRequestMethod());
            exchange.sendResponseHeaders(200,0);
        });
        server.start();
    }
}
