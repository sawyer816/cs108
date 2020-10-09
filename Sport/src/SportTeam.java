/*
* The SportTeam Interface displays methods that must be implemented by a specific Sport.
*/

public interface SportTeam {
    public String getSport();
    public String getTeamName();
    public void setTeamName(String teamName);
    public int getNumGames();
    public void addNumTies(int numTies);
    public int getNumTies();
    public void addNumWins(int numWins);
    public int getNumWins();
    public void addNumLosses(int numLosses);
    public int getNumLosses();
    public String getTeamCaptain();
    public void setTeamCaptain(String teamCaptain);
}
