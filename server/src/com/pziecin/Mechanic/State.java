package com.pziecin.Mechanic;

import com.pziecin.Events.Event;
import com.pziecin.Events.Player;

import java.util.HashMap;

public class State {
    private HashMap<Player, Event> states;

    public State(){}

    public State(HashMap<Player, Event> states) {
        this.states = states;
    }

    public HashMap<Player, Event> getStates() {
        return states;
    }

    public void setStates(HashMap<Player, Event> states) {
        this.states = states;
    }

}
