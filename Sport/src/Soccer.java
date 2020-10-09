/*
* The Soccer class implements all SportTeam methods and has certain searches and sorts that only apply to a Baseball
* such as sort based on Goals as well as creating a heatMap of playerNumbers. It also adds or removes up to the 11
* players that can be found on the Soccer field.
*/

import java.util.ArrayList;
import java.util.*;

public class Soccer implements SportTeam {
    private ArrayList<SoccerPlayer> team = new ArrayList<>();
    private HashMap<Integer, SoccerPlayer> playerNumber = new HashMap<>();
    private SoccerPlayer[] field = new SoccerPlayer[11];

    @Override
    public String getSport() {
        return "Soccer";
    }

    @Override
    public String getTeamName() {
        return null;
    }

    @Override
    public void setTeamName(String teamName) {

    }

    @Override
    public int getNumGames() {
        return 0;
    }

    @Override
    public void addNumTies(int numTies) {

    }

    @Override
    public int getNumTies() {
        return 0;
    }

    @Override
    public void addNumWins(int numWins) {

    }

    @Override
    public int getNumWins() {
        return 0;
    }

    @Override
    public void addNumLosses(int numLosses) {

    }

    @Override
    public int getNumLosses() {
        return 0;
    }

    @Override
    public String getTeamCaptain() {
        return null;
    }

    @Override
    public void setTeamCaptain(String teamCaptain) {

    }

    public ArrayList<SoccerPlayer> getTeam() {
        return team;
    }

    public void addPlayer(SoccerPlayer player) {
        team.add(player);
        player.setNumber(checkForSameNumber(player.getNumber()));
        playerNumber.put(player.getNumber(), player);
    }

    //Bubble Sort
    public  ArrayList<SoccerPlayer> highestScore(ArrayList<SoccerPlayer> team){
        SoccerPlayer temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < team.size()-1; i++) {
                if (team.get(i).getTotalGoals() > team.get(i + 1).getTotalGoals()) {
                    temp = team.get(i);
                    team.set(i, team.get(i + 1));
                    team.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return team;
    }

    public SoccerPlayer bestPlayerGoals(ArrayList<SoccerPlayer> team){
        return highestScore(team).get(highestScore(team).size()-1);
    }

    public void printHash(HashMap<Integer, SoccerPlayer> playerNumber)
    {
        if (playerNumber.isEmpty()) {
            System.out.println("map is empty");

        } else {
            System.out.println(playerNumber);
        }
        if (playerNumber.containsKey(7)) {
            System.out.println(playerNumber.get(7) + ", do Cristiano Ronaldo proud.");
        }
    }

    public int checkForSameNumber(int num){
        while(playerNumber.containsKey(num)){
            num++;
        }
        return num;
    }

    public HashMap<Integer, SoccerPlayer> getPlayerNumber() {
        return playerNumber;
    }

    //Search
    public boolean search442(String position, SoccerPlayer[] playerPosition){
        int positionCount=0;
        for (SoccerPlayer player : playerPosition) {
            if(player == null){
                return false;
            }
            if (player.getPosition().equalsIgnoreCase(position)) {
                positionCount++;
            }
        }
        if(position.equalsIgnoreCase("GoalKeeper") && positionCount>0){
            return true;
        }
        if(position.equalsIgnoreCase("Defender") && positionCount>3){
            return true;
        }
        if(position.equalsIgnoreCase("Forward") && positionCount>1){
            return true;
        }
        if(position.equalsIgnoreCase("MidField") && positionCount>3){
            return true;
        }
        return false;
    }

    public void addToField442(SoccerPlayer player){
        String position = player.getPosition();
        if(!position.equalsIgnoreCase("No Position")) {
            if (!search442(player.getPosition(), field)) {
                if (position.equalsIgnoreCase("Goal Keeper")) {
                    field[0]=player;
                }
                if (position.equalsIgnoreCase("Defender")) {
                    for (int i = 1; i < 5; i++) {
                        if(field[i] == null){
                            field[i]=player;
                            break;
                        }
                    }
                }
                if (position.equalsIgnoreCase("MidField")) {
                    for (int i = 5; i < 9; i++) {
                        if(field[i] == null){
                            field[i]=player;
                            break;
                        }
                    }
                }
                if (position.equalsIgnoreCase("Forward")) {
                    for (int i = 9; i < 11; i++) {
                        if(field[i] == null){
                            field[i]=player;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Already a player in that position.");
            }
        }
    }

    public void removeFromField(SoccerPlayer player){
        for (int i = 0; i < field.length; i++) {
            if(player.equals(field[i])){
                field[i] = null;
                break;
            }
        }
    }

    public SoccerPlayer[] getField(){
        return field;
    }

    public void printField(){
        System.out.println("Goal Keeper: " + field[0]);
        System.out.println("Defender: " + field[1]);
        System.out.println("Defender: " + field[2]);
        System.out.println("Defender " + field[3]);
        System.out.println("Defender " + field[4]);
        System.out.println("Midfield: " + field[5]);
        System.out.println("Midfield: " + field[6]);
        System.out.println("Midfield: " + field[7]);
        System.out.println("Midfield: " + field[8]);
        System.out.println("Forward: " + field[9]);
        System.out.println("Forward: " + field[10]);
    }

}
