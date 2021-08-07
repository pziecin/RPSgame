package com.pziecin;

import com.pziecin.Events.Player;
import com.pziecin.Mechanic.GameInitializer;
import com.pziecin.Service.Server;

public class Main {

    public static void main(String[] args){
        System.out.println("Server Works!");
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.run();
    }
}