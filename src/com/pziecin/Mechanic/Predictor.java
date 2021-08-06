package com.pziecin.Mechanic;

import com.pziecin.Events.Event;
import com.pziecin.Events.Player;
import com.pziecin.Events.Type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Predictor {

    private static final String WINSENTENCE = " won";

    public static String solveStatesFor2Players(State states) {
        Iterator<Map.Entry<Player, Event>> entry = states.getStates().entrySet().iterator();
        Map.Entry<Player, Event> p1 = entry.next();
        Map.Entry<Player, Event> p2 = entry.next();
        Event eventPlayer1 = p1.getValue();
        String player1Name = p1.getKey().getName();
        Event eventPlayer2 = p2.getValue();
        String player2Name = p2.getKey().getName();

        if(eventPlayer1.getType() == eventPlayer2.getType()){
            return "Draw";
        } else if(eventPlayer1.getType() == Type.ROCK){
            if(eventPlayer2.getType() == Type.PAPER){
                return player2Name + WINSENTENCE;
            } else if(eventPlayer2.getType() == Type.SCISORS){
                return player1Name + WINSENTENCE;
            }
        } else if(eventPlayer1.getType() == Type.PAPER){
            if(eventPlayer2.getType() == Type.ROCK){
                return player1Name + WINSENTENCE;
            } else if ( eventPlayer2.getType() == Type.SCISORS){
                return player2Name + WINSENTENCE;
            }
        }else if(eventPlayer1.getType() == Type.SCISORS){
            if(eventPlayer2.getType() == Type.ROCK){
                return player2Name + WINSENTENCE;
            } else if ( eventPlayer2.getType() == Type.PAPER){
                return player1Name + WINSENTENCE;
            }
        }
        return "Ups";
    }

//    public static String solveStates(State states){
//        if(states.getStates().containsValue(new Event(Type.PAPER)) && states.getStates().containsValue(new Event(Type.SCISORS)) && states.getStates().containsValue(new Event(Type.ROCK))){
//            return new String("Draw");
//        }
//        for(Map.Entry<?, ?> move : states.getStates().entrySet()){
//
//        }
//    }
}
