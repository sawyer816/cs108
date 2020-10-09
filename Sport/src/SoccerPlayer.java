/*
* The SoccerPlayer class describes a player and creates methods add and get the different statistics of a
* SoccerPlayer player such as NumGoals as well as a choice of different positions that can be found on a Soccer Field
* such as Forward or Goal Keeper.
*/
import java.util.ArrayList;
import java.util.Arrays;

public class SoccerPlayer extends Player {
    private final String[] positions = {"Goal Keeper","Defender","MidField", "Forward"};
    private int totalScore;
    private String position;
    private int number;

    public SoccerPlayer(){
        super();
        position = "No Position";
    }
    public SoccerPlayer(String name){
        super.setname(name);
        position = "No Position";
    }

    @Override
    public void setPosition(String position) {
        ArrayList<String> positionList = new ArrayList<String>(Arrays.asList(positions));
        for(String aPosition : positionList) {
            if(position.equalsIgnoreCase(aPosition)) {
                this.position = position;
                break;
            }
        }
    }

    public int getTotalGoals() {
        return totalScore;
    }

    public void addGoals(int totalScore){
        this.totalScore=totalScore;
    }

    public String getPosition(){
        return position;
    }

    public void printAll(SoccerPlayer s){
        System.out.println("Name: " + s.getName());
        System.out.println("Position " + s.getPosition());
        System.out.println("Number " + s.getNumber());
        System.out.println("NumberOfGoals " + s.getTotalGoals());
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String toString() {
        return getName();
    }
}
