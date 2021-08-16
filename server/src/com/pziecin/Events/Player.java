package com.pziecin.Events;

public class Player {
    private String name;
    private boolean bot;

    public Player(String name, boolean bot){
        this.name = name;
        this.bot = bot;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }
}
