package com.pziecin;

import com.pziecin.Mechanic.GameInitializer;

public class Main {

    public static void main(String[] args){
        System.out.println("Server Works!");
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.run();
    }
}