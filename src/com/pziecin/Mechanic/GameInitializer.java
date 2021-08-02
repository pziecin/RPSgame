package com.pziecin.Mechanic;

import com.pziecin.Events.Player;
import com.pziecin.GUI.Menu;
import com.pziecin.GUI.Mode;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class GameInitializer implements Runnable {

    private Menu menu;
    private List<Player> players;
    private boolean active = true;

    public GameInitializer(){
        this.menu = new Menu();
        this.players = new ArrayList<>();
    }

    @Override
    public void run() {
        Mode mode = menu.gameMode();
        players.addAll(menu.getPlayers(mode));
        while (active) {
            State state = new State();
            state.setStates(menu.takeMoves(players));
            menu.showResults(Predictor.solveStatesFor2Players(state));
            active = menu.continueGame();
        }
        menu.close();
    }
}
