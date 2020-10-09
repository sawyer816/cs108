/*
* The Baseball Player class describes a player and creates methods to add and get the different statistics of a
* Baseball player such as NumHomeRuns or Batting Average as well as a choice of different positions that can be
* found on a Baseball Field such as P or 1B.
* */

import java.util.ArrayList;
import java.util.Arrays;

public class BaseballPlayer extends Player{
   private String position;
   private int numAtBats;
   private int numSingles;
   private int numDoubles;
   private int numTriples;
   private int numHomeRuns;
   private int numWalks;
   private int numStrikeOuts;
   private final String[] positions = {"P","C","1B", "2B", "3B", "SS", "LF", "CF", "RF"};
   private int pNumWalks;
   private int pNumStrikeouts;
   private int numGames;
   private int inningsPitched;
   private int earnedRuns;
   private int numSacF;
   private int numHBP;
   private int groundOut;
   private int flyOut;
   private int lineDrive;
   private int fieldersChoice;
   private int popOut;
   private int reachOnError;
   private int plateAppearances;
   private int number;

   public BaseballPlayer(){
      super();
      position = "No Position";
   }

   public BaseballPlayer(String name){
      super.setname(name);
      position = "No Position";
   }

   @Override
   public void setPosition(String position) {
      ArrayList<String> positionList = new ArrayList<String>(Arrays.asList(positions));
      for(String aPosition : positionList) {
         if(position.equalsIgnoreCase(aPosition)) {
            this.position = position;
         }
      }
   }

   public double ERA() {
      if(inningsPitched>0) {
         return 9 * (((double) getEarnedRuns()) / getInningsPitched());
      }
      return 0;
   }

   public double Slugging() {
      return ((double) bases()) / getNumAtBats();
   }

   public double OBP() {
      return ((double)(hits()+getNumWalks()+getNumHBP()))/(getNumAtBats()+getNumWalks()+getNumHBP()+getNumSacF());
   }

   public double BA(){
      return ((double)hits())/numAtBats;
   }


   public int getNumSingles() {
      return numSingles;
   }
   public int getNumDoubles() {
      return numDoubles;
   }
   public int getNumTriples() {
      return numTriples;
   }
   public int getNumHomeRuns() {
      return numHomeRuns;
   }
   public int getNumStrikeOuts() {
      return numStrikeOuts;
   }
   public int getNumWalks() {
      return numWalks;
   }
   public int getPNumStrikeouts() {
      return pNumStrikeouts;
   }
   public int getPNumWalks() {
      return pNumWalks;
   }
   public int getNumAtBats(){return numAtBats;}
   public int getNumGames(){return numGames;}
   public int getInningsPitched() {
      return inningsPitched;
   }
   public int getEarnedRuns(){return earnedRuns;}
   public int getNumSacF(){return numSacF;}
   public int getNumHBP(){return numHBP;}
   public int getFieldersChoice() {
      return fieldersChoice;
   }
   public int getGroundOut() {
      return groundOut;
   }
   public int getLineDrive() {
      return lineDrive;
   }
   public int getFlyOut() {
      return flyOut;
   }
   public int getPopOut() {
      return popOut;
   }
   public int getReachOnError() {
      return reachOnError;
   }
   public int getNumber(){
      return number;
   }
   public int getPlateAppearances() {
      return plateAppearances;
   }
   public String getPosition(){
      return position;
   }

   public void addNumSingles(int numSingles) {
      this.numSingles += numSingles;
      numAtBats+=numSingles;
      plateAppearances+=numSingles;
   }
   public void addNumDoubles(int numDoubles) {
      this.numDoubles += numDoubles;
      numAtBats+=numDoubles;
      plateAppearances+=numDoubles;
   }
   public void addNumTriples(int numTriples) {
      this.numTriples += numTriples;
      numAtBats+=numTriples;
      plateAppearances+=numTriples;
   }
   public void addNumHomeRuns(int numHomeRuns) {
      this.numHomeRuns += numHomeRuns;
      numAtBats+=numHomeRuns;
      plateAppearances+=numHomeRuns;
   }
   public void addNumStrikeOuts(int numStrikeOuts) {
      this.numStrikeOuts += numStrikeOuts;
      numAtBats+=numStrikeOuts;
      plateAppearances+=numStrikeOuts;
   }
   public void addNumWalks(int numWalks) {
      this.numWalks += numWalks;
      plateAppearances+=numWalks;
   }
   public void addNumSacF(int numSacF) {
      this.numSacF += numSacF;
      plateAppearances+=numSacF;
   }
   public void addNumHBP(int numHBP) {
      this.numHBP += numHBP;
      plateAppearances+=numHBP;
   }
   public void addPNumWalks(int pNumWalks) {
      this.pNumWalks += pNumWalks;
   }
   public void addPNumStrikeOuts(int pNumStrikeouts) {
      this.pNumStrikeouts += pNumStrikeouts;
   }
   public void addNumGames(int numGames) {
      this.numGames += numGames;
   }
   public void addInningsPitched(int inningsPitched) {
      this.inningsPitched+=inningsPitched;
   }
   public void addEarnedRuns(int earnedRuns){
      this.earnedRuns += earnedRuns;
   }
   public void addFlyOut(int flyOut){
      this.flyOut += flyOut;
      numAtBats+=flyOut;
      plateAppearances+=flyOut;
   }
   public void addPopOut(int popOut){
      this.popOut += popOut;
      numAtBats+=popOut;
      plateAppearances+=popOut;
   }
   public void addLineDrive(int lineDrive){
      this.lineDrive += lineDrive;
      numAtBats+=lineDrive;
      plateAppearances+=lineDrive;
   }
   public void addFieldersChoice(int fieldersChoice){
      this.fieldersChoice += fieldersChoice;
      numAtBats+=fieldersChoice;
      plateAppearances+=fieldersChoice;
   }
   public void addGroundOut(int groundOut){
      this.groundOut += groundOut;
      numAtBats+=groundOut;
      plateAppearances+=groundOut;
   }
   public void addReachOnError(int reachOnError){
      this.reachOnError += reachOnError;
      numAtBats+=reachOnError;
      plateAppearances+=reachOnError;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public int bases(){
      return getNumSingles() + (2 * getNumDoubles()) + (3 * getNumTriples()) + (4 * getNumHomeRuns());
   }
   public int hits(){
      return getNumSingles()+getNumDoubles()+getNumTriples()+getNumHomeRuns();
   }

   public void printAll(BaseballPlayer b){
      System.out.println("Name: " + b.getName());
      System.out.println("Number: " + b.getNumber());
      System.out.println("Games: " + b.getNumGames());
      System.out.println("Position " + b.getPosition());

      System.out.println();
      System.out.println("Hitting Stats");
      System.out.println("Batting Average: " + b.BA());
      System.out.println("On Base Percentage: " + b.OBP());
      System.out.println("Slugging: " + b.Slugging());
      System.out.println("At Bats: " + b.getNumAtBats());
      System.out.println("PlateAppearance: " + b.getPlateAppearances());
      System.out.println("Singles: " + b.getNumSingles());
      System.out.println("Doubles: " + b.getNumDoubles());
      System.out.println("Triples: " + b.getNumTriples());
      System.out.println("HomeRuns: " + b.getNumHomeRuns());
      System.out.println("Strikeouts: " + b.getNumStrikeOuts());
      System.out.println("Walks: " + b.getNumWalks());
      System.out.println("Fielder's Choice: " + b.getFieldersChoice());
      System.out.println("HBP" + b.getNumHBP());
      System.out.println("Sac Flies: " + b.getNumSacF());
      System.out.println("Fly Outs: " + b.getFlyOut());
      System.out.println("Pop Outs: " + b.getPopOut());
      System.out.println("Line Outs: " + b.getLineDrive());
      System.out.println("Ground Outs: " + b.getGroundOut());
      System.out.println("Reach on Errors: " + b.getReachOnError());


      System.out.println();
      System.out.println("Pitching Stats");
      System.out.println("Era: " + b.ERA() + " IP: " + b.getInningsPitched() + " Earned Runs: " + b.getEarnedRuns());
      System.out.println("Strikeouts:" + b.getPNumStrikeouts());
      System.out.println("Walks:" + b.getPNumWalks());
   }

   public String toString() {
      return getName();
   }
}
