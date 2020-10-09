/*
* The Baseball class implements all SportTeam methods and has certain searches and sorts that only apply to a Baseball
* team such as sort based on BA or Slugging or search for a certain number of HomeRuns as well as creating a heatMap of
* playerNumbers. It also adds or removes up to the 9 players that can be found on the Baseball field.
*/
import java.util.ArrayList;
import java.util.HashMap;

public class Baseball implements SportTeam {
    private ArrayList<BaseballPlayer> team = new ArrayList<>();
    private int numGames;
    private int numTies;
    private int numWins;
    private int numLosses;
    private String TeamCaptain;
    private String teamName;
    private HashMap<Integer, BaseballPlayer> playerNumber = new HashMap<>();
    private BaseballPlayer[] field = new BaseballPlayer[9];

    public Baseball(){
        TeamCaptain = "No Captain";
    }
    @Override
    public String getSport() {
        return "Baseball";
    }

    @Override
    public String getTeamName() {
        return teamName;
    }
    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int getNumGames() {
        return numGames;
    }

    @Override
    public void addNumTies(int numTies) {
        this.numTies += numTies;
        this.numGames += numTies;
    }
    @Override
    public int getNumTies() {
        return numTies;
    }

    @Override
    public void addNumWins(int numWins) {
        this.numWins += numWins;
        this.numWins += numWins;
    }
    @Override
    public int getNumWins() {
        return numWins;
    }

    @Override
    public void addNumLosses(int numLosses) {
        this.numLosses += numLosses;
        this.numLosses += numLosses;
    }
    @Override
    public int getNumLosses() {
        return numLosses;
    }
    @Override

    public String getTeamCaptain() {
        return TeamCaptain;
    }
    @Override
    public void setTeamCaptain(String teamCaptain) {
        for (BaseballPlayer baseballPlayer : team) {
            if (baseballPlayer.getName().equalsIgnoreCase(teamCaptain)) {
                this.TeamCaptain = teamCaptain;
                break;
            }
        }
    }
    public ArrayList<BaseballPlayer> getTeam() {
        return team;
    }

    public void addPlayer(BaseballPlayer player) {
        team.add(player);
        player.setNumber(checkForSameNumber(player.getNumber()));
        playerNumber.put(player.getNumber(), player);
    }

    //Selection Sort
    public  ArrayList<BaseballPlayer> bestBa(ArrayList<BaseballPlayer> team){
        double smallDouble = 0;
        int j=0;
        int smallDoubleIndex = 0;

        for(int i=0;i<team.size() - 1;i++){
            smallDouble = team.get(i).BA();
            smallDoubleIndex = i;
            for(j=i+1;j<team.size();j++){
                if(team.get(j).BA()<smallDouble){
                    smallDouble = team.get(j).BA();
                    smallDoubleIndex = j;
                }
            }
            if (i != smallDoubleIndex) {
                BaseballPlayer temp = team.get(smallDoubleIndex);
                team.set(smallDoubleIndex, team.get(i));
                team.set(i, temp);
            }
        }
        return team;
    }

    public BaseballPlayer bestPlayerBA(ArrayList<BaseballPlayer> team){
        return bestBa(team).get(bestBa(team).size()-1);
    }

    //Insertion Sort
    public  ArrayList<BaseballPlayer> bestOBP(ArrayList<BaseballPlayer> team){
        for (int i = 1; i < team.size(); i++) {
            BaseballPlayer tmp = team.get(i);
            int j = i;
            /*move elements of team.get(0..i-1), that are
            greater than key, to one position ahead
            of their current position */
            while ((j > 0) && (team.get(j - 1).OBP() > tmp.OBP())) {
                team.set(j, team.get(j - 1));
                j--;
            }
            team.set(j, tmp);
        }
        return team;
    }

    public BaseballPlayer bestPlayerOBP(ArrayList<BaseballPlayer> team){
        return bestOBP(team).get(bestOBP(team).size()-1);
    }

    //Selection Sort
    public  ArrayList<BaseballPlayer> bestERA(ArrayList<BaseballPlayer> team){
        double smallDouble = 0;
        int j=0;
        int smallDoubleIndex = 0;

        for(int i=0;i<team.size() - 1;i++){
            smallDouble = team.get(i).ERA();
            smallDoubleIndex = i;
            for(j=i+1;j<team.size();j++){
                if(team.get(j).ERA()<smallDouble){
                    smallDouble = team.get(j).ERA();
                    smallDoubleIndex = j;
                }
            }
            if (i != smallDoubleIndex) {
                BaseballPlayer temp = team.get(smallDoubleIndex);
                team.set(smallDoubleIndex, team.get(i));
                team.set(i, temp);
            }
        }
        return team;
    }

    public BaseballPlayer bestPlayerERA(ArrayList<BaseballPlayer> team){
        for (int i = 0; i < team.size(); i++) {
            if(team.get(i).getInningsPitched()>0){
                return team.get(i);
            }
        }
        return null;
    }

    //Insertion Sort
    public  ArrayList<BaseballPlayer> bestSlugging(ArrayList<BaseballPlayer> team){
        for (int i = 1; i < team.size(); i++) {
            BaseballPlayer tmp = team.get(i);
            int j = i;
            /*move elements of team.get(0..i-1), that are
            greater than key, to one position ahead
            of their current position */
            while ((j > 0) && (team.get(j - 1).Slugging() > tmp.Slugging())) {
                team.set(j, team.get(j - 1));
                j--;
            }
            team.set(j, tmp);
        }
        return team;
    }

    public BaseballPlayer bestPlayerSlugging(ArrayList<BaseballPlayer> team){
        return bestSlugging(team).get(bestSlugging(team).size()-1);
    }

    public HashMap<Integer, BaseballPlayer> getPlayerNumber() {
        return playerNumber;
    }

    public int checkForSameNumber(int num){
        while(playerNumber.containsKey(num)){
            num++;
        }
        return num;
    }
    public ArrayList<BaseballPlayer> mostHomeRuns(ArrayList<BaseballPlayer> team){
        for (int i = 1; i < team.size(); i++) {
            BaseballPlayer tmp = team.get(i);
            int j = i;
            /*move elements of team.get(0..i-1), that are
            greater than key, to one position ahead
            of their current position */
            while ((j > 0) && (team.get(j - 1).getNumHomeRuns() > tmp.getNumHomeRuns())) {
                team.set(j, team.get(j - 1));
                j--;
            }
            team.set(j, tmp);
        }
        return team;
    }

    public boolean isPositionOpen(BaseballPlayer[] field, String position){
        for (int i = 0; i < field.length; i++) {
            if(field[i]!= null && field[i].getPosition().equalsIgnoreCase(position)){
                return false;
            }
        }
        return true;
    }

    public void addToField(BaseballPlayer player){
        String position = player.getPosition();
        if(!position.equalsIgnoreCase("No Position")) {
            if (isPositionOpen(field, player.getPosition())) {
                if (position.equalsIgnoreCase("P")) {
                    field[0]=player;
                }
                if (position.equalsIgnoreCase("C")) {
                    field[1]=player;
                }
                if (position.equalsIgnoreCase("1B")) {
                    field[2]=player;
                }
                if (position.equalsIgnoreCase("2B")) {
                    field[3]=player;
                }
                if (position.equalsIgnoreCase("3B")) {
                    field[4]=player;
                }
                if (position.equalsIgnoreCase("SS")) {
                    field[5]=player;
                }
                if (position.equalsIgnoreCase("LF")) {
                    field[6]=player;
                }
                if (position.equalsIgnoreCase("CF")) {
                    field[7]=player;
                }
                if (position.equalsIgnoreCase("RF")) {
                    field[8]=player;
                }
            } else {
                System.out.println("Already a player in that position.");
            }
        }
    }

    public void removeFromField(BaseballPlayer player){
        for (int i = 0; i < field.length; i++) {
            if(player.equals(field[i])){
                field[i] = null;
                break;
            }
        }
    }

    public BaseballPlayer[] getField(){
        return field;
    }

    public void printField(){
        System.out.println("Pitcher: " + field[0]);
        System.out.println("First Base: " + field[1]);
        System.out.println("Second Base: " + field[2]);
        System.out.println("Third Base: " + field[3]);
        System.out.println("Fourth Base: " + field[4]);
        System.out.println("Short Stop: " + field[5]);
        System.out.println("Left Field: " + field[6]);
        System.out.println("Center Field: " + field[7]);
        System.out.println("Right Field: " + field[8]);
    }

    //BinarySearch Num Homeruns if the field is full.
    public BaseballPlayer searchFullFieldHR(int numHR, BaseballPlayer[] field, int beginning, int end){
        if(end>=beginning) {
            int mid = beginning + (end - beginning) / 2;
            if (field[mid] == null) {
                System.out.println("Not a full field");
                return null;
            }
            if (field[mid].getNumHomeRuns() == numHR) {
                return field[mid];
            }
            if (field[mid].getNumHomeRuns() < numHR) {
                return searchFullFieldHR(numHR, field, beginning, mid - 1);
            } else if (team.get(mid).getNumHomeRuns() > numHR) {
                return searchFullFieldHR(numHR, field, mid+1, end);
            }
        }
        return null;
    }

    //HashMap
    public void printHash(HashMap<Integer, BaseballPlayer> playerNumber)
    {
        if (playerNumber.isEmpty()) {
            System.out.println("map is empty");

        } else {
            System.out.println(playerNumber);
        }
        if (playerNumber.containsKey(42)) {
            System.out.println(playerNumber.get(42) + ", do Jackie Robinson proud.");
        }
    }
}

