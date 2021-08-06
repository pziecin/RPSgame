package com.pziecin.Service;

import com.pziecin.Events.Event;
import com.pziecin.Events.Player;
import com.pziecin.Events.Type;
import com.pziecin.GUI.Mode;
import com.pziecin.Mechanic.Predictor;
import com.pziecin.Mechanic.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {

    public String solveState(List<String> names, List<String> playerEvents){
        State state = new State();
        HashMap<Player, Event> playerStates = new HashMap<>();
        playerStates.put(new Player(names.get(0), false), new Event(Type.valueOf(playerEvents.get(0))));
        playerStates.put(new Player(names.get(1), false), new Event(Type.valueOf(playerEvents.get(1))));
        state.setStates(playerStates);
        return Predictor.solveStatesFor2Players(state);
    }
}
