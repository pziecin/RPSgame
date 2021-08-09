package com.pziecin;

import com.pziecin.Events.Event;
import com.pziecin.Events.Player;
import com.pziecin.Events.Type;
import com.pziecin.Mechanic.Predictor;
import com.pziecin.Mechanic.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class PredictorTest {

    @Test
    void solveStatesFor2PlayersTwoRock() {
        State state = new State();
        HashMap<Player, Event> playerStates = new HashMap<>();
        playerStates.put(new Player("BOT", true), new Event(Type.ROCK));
        playerStates.put(new Player("BOT", true), new Event(Type.ROCK));
        state.setStates(playerStates);
        Assertions.assertEquals("Draw", Predictor.solveStatesFor2Players(state));
    }

    @Test
    void solveStatesFor2Players1R2P() {
        State state = new State();
        HashMap<Player, Event> playerStates = new HashMap<>();
        playerStates.put(new Player("1", true), new Event(Type.ROCK));
        playerStates.put(new Player("2", true), new Event(Type.PAPER));
        state.setStates(playerStates);
        Assertions.assertEquals("2 won", Predictor.solveStatesFor2Players(state));
    }

    @Test
    void solveStatesFor2Players1P2R() {
        State state = new State();
        HashMap<Player, Event> playerStates = new HashMap<>();
        playerStates.put(new Player("1", true), new Event(Type.PAPER));
        playerStates.put(new Player("2", true), new Event(Type.ROCK));
        state.setStates(playerStates);
        Assertions.assertEquals("1 won", Predictor.solveStatesFor2Players(state));
    }

    @Test
    void solveStatesFor2Players1S2R() {
        State state = new State();
        HashMap<Player, Event> playerStates = new HashMap<>();
        playerStates.put(new Player("1", true), new Event(Type.SCISORS));
        playerStates.put(new Player("2", true), new Event(Type.ROCK));
        state.setStates(playerStates);
        Assertions.assertEquals("2 won", Predictor.solveStatesFor2Players(state));
    }
}