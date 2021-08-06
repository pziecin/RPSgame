package com.pziecin.GUI;

import com.pziecin.Events.Event;
import com.pziecin.Events.Player;
import com.pziecin.Events.Type;

import java.util.*;

public class Menu{

    private final Scanner sc;
    private Random random;

    public Menu(){
        this.sc = new Scanner(System.in);
        random = new Random();
    }

    public Mode gameMode(){
        String modeString;
        while(true){
            System.out.println("Type: " + Mode.PVP + " or " + Mode.PVE + " to choose game mode.");
            modeString = sc.nextLine();
            if(modeString.equals(Mode.PVP.name()) || modeString.equals(Mode.PVE.name())){
                break;
            }
            else {
                System.out.print("Error... Wrong mode... press any button to type again");
                sc.nextLine();
            }
        }
        return Mode.valueOf(modeString);
    }

    public List<Player> getPlayers(Mode mode) {
        List<Player> players = new ArrayList<>();
        String playerName;
        int numberOfPlayers = 2;
        if (mode.equals(Mode.PVP)) {
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Type " + i + " player name");
                playerName = sc.nextLine();
                players.add(createPlayer(playerName, false));
            }
        }
        if(mode.equals(Mode.PVE)) {
            for (int i = 0; i < numberOfPlayers; i++) {
                if(i == 0){
                    System.out.println("Type " + i + " player name");
                    playerName = sc.nextLine();
                    players.add(createPlayer(playerName, false));
                    continue;
                }
                players.add(createPlayer("Bot" + i, true));
            }
        }
        System.out.println(players);
        return players;
    }

    private Player createPlayer(String name, boolean bot){
        return new Player(name, bot);
    }

    public HashMap<Player, Event> takeMoves(List<Player> players){
        HashMap<Player, Event> events = new HashMap<>();
        for(Player player: players){
            if(player.isBot()){
                events.put(player, getComputerMove());
            }else {
                events.put(player, getPlayerMove(player));
            }
        }
        return events;
    }

    private Event getPlayerMove(Player player){
        String eventType;
        while (true){
            System.out.println(player.getName() + " choose your move (" + Type.ROCK + " : " + Type.PAPER + " : " + Type.SCISORS + ")");
            eventType = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (eventType.equals(Type.ROCK.name()) || eventType.equals(Type.PAPER.name()) || eventType.equals(Type.SCISORS.name())) {
                break;
            } else {
                System.out.print("Error... Wrong number ... press any button to type again");
                sc.nextLine();
            }
        }
        return new Event(Type.valueOf(eventType));
    }

    private Event getComputerMove(){
        Type[] valuse = Type.values();
        int length = valuse.length;
        int rand = random.nextInt(length);
        return new Event(valuse[rand]);
    }

    public void showResults(String result){
        System.out.println(result);
    }

    public boolean continueGame(){
        String decision;
        while(true){
            System.out.println("Do you want to continue game? y or n");
            decision = sc.nextLine();
            if(decision.equals("y") || decision.equals("n")){
                return decision.equals("y");
            }
            else {
                System.out.print("Error... press any button to type again");
                sc.nextLine();
            }
        }
    }

    public void close(){
        sc.close();
    }
}
