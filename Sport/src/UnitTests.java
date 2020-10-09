/*
* The Unit Test has 5 tests. 1player() (runs through 1 baseball player and 1 soccer player),
* testingBinarySearch() (Runs through and searches for a specific number of HomeRuns)
* fullTeamBaseball() (runs through a full team of Baseball Players)
* fullTeamSoccer() (runs through a full team of Soccer Players)
* testingHashMap(); (Tests the HashMap of Players and Players numbers)
*/
public class UnitTests {
    public static void main(String[] args) {
        onePlayer();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        testingBinarySearch();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        testingHashMap();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        fullTeamBaseball();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        fullTeamSoccer();
    }

    public static void onePlayer(){
        BaseballPlayer b = new BaseballPlayer("Jeff");
        b.addNumSingles(5);
        b.addNumDoubles(5);
        b.addNumStrikeOuts(4);
        b.addPNumStrikeOuts(3);
        b.addNumWalks(12);
        b.addEarnedRuns(12);
        b.addNumGames(4);
        //edge case divide by 0
        b.addInningsPitched(0);
        b.printAll(b);
        System.out.println();
        b.addInningsPitched(9);
        System.out.println("ERA after updating Innings Pitched: " + b.ERA());
        b.addNumSacF(5);
        //Adding Sac Flies should lower OBP and keep BA the same.
        System.out.println("BA after updating Sac Flies: " + b.BA());
        System.out.println("OBP after updating Sac Flies: " + b.OBP());

        System.out.println();
        System.out.println();
        Baseball team = new Baseball();
        //adds player
        team.addPlayer(b);
        //tests for the sport
        System.out.println(team.getSport() + " team w/ one player");
        team.setTeamName("Twizzlers");
        System.out.println("Team Name: " + team.getTeamName());
        //Team captain not set yet
        System.out.println("Team Captain: " + team.getTeamCaptain());
        //Team captain set but not a player on the team
        team.setTeamCaptain("Hi");
        System.out.println("Team Captain: " + team.getTeamCaptain());
        //Team captain set to player on the team
        team.setTeamCaptain("Jeff");
        System.out.println("Team Captain: " + team.getTeamCaptain());
        System.out.println();
        System.out.print("Meet the Team: ");
        System.out.println(team.getTeam());
        System.out.println();
        //print number not set
        System.out.print("Team with numbers: ");
        team.printHash(team.getPlayerNumber());
        System.out.println();
        team.addToField(b);
        //no position assigned
        team.printField();
        System.out.println();
        b.setPosition("P");
        team.addToField(b);
        team.printField();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //no name to start
        SoccerPlayer s = new SoccerPlayer();
        s.setPosition("Forward");
        s.printAll(s);
        System.out.println();
        Soccer sTeam = new Soccer();
        sTeam.addPlayer(s);
        sTeam.addToField442(s);
        sTeam.printField();
    }

    public static void fullTeamBaseball(){
        BaseballPlayer a = new BaseballPlayer("Ben");
        a.setPosition("P");
        a.addInningsPitched(12);
        a.addEarnedRuns(12);
        a.addNumWalks(33);
        a.addNumSingles(14);
        a.addNumDoubles(3);
        a.addNumTriples(43);
        a.addNumHomeRuns(13);
        a.addFieldersChoice(1);
        a.addGroundOut(33);
        a.addFlyOut(32);

        BaseballPlayer b = new BaseballPlayer("Joe");
        b.setPosition("C");
        b.addInningsPitched(23);
        b.addEarnedRuns(15);
        b.addNumWalks(3);
        b.addNumHBP(55);
        b.addNumSingles(5);
        b.addPopOut(37);

        //only hits or walks
        BaseballPlayer c = new BaseballPlayer("Alex");
        c.setPosition("1B");
        c.addInningsPitched(54);
        c.addEarnedRuns(2);
        c.addNumDoubles(49);

        BaseballPlayer d = new BaseballPlayer("John");
        d.setPosition("2B");
        d.addInningsPitched(12);
        d.addEarnedRuns(12);
        d.addNumWalks(13);
        d.addNumDoubles(1);
        d.addLineDrive(5);

        //only hits
        BaseballPlayer e = new BaseballPlayer("Jack");
        e.setPosition("SS");
        e.addNumHomeRuns(330);

        BaseballPlayer f = new BaseballPlayer("Robert");
        f.setPosition("3B");
        f.addReachOnError(67);
        f.addNumTriples(6);
        f.addNumDoubles(8);

        //noName = Bob && no hits + sac flies
        BaseballPlayer g = new BaseballPlayer();
        g.setPosition("RF");
        g.addNumWalks(46);
        g.addNumSacF(22);

        //no at Bats
        BaseballPlayer h = new BaseballPlayer("Jagger");
        h.setPosition("CF");

        BaseballPlayer i = new BaseballPlayer("Jupiter");
        i.setPosition("LF");
        e.setPosition("SS");
        e.addPNumWalks(4);
        e.addNumWalks(46);
        e.addLineDrive(56);
        e.addNumDoubles(30);
        e.addPopOut(22);

        Baseball team = new Baseball();
        team.addPlayer(a);
        team.addPlayer(b);
        team.addPlayer(c);
        team.addPlayer(d);
        team.addPlayer(e);
        team.addPlayer(f);
        team.addPlayer(g);
        team.addPlayer(h);
        team.addPlayer(i);

        //ERA
        for (int x = 0; x < team.getTeam().size(); x++) {
            System.out.println(team.getTeam().get(x) + "'s ERA " + team.getTeam().get(x).ERA());
        }
        System.out.println();
        System.out.println(team.bestERA(team.getTeam()));
        System.out.println("The player with the best Era is: " + team.bestPlayerERA((team.getTeam())));

        //BA
        System.out.println();
        System.out.println();
        for (int x = 0; x < team.getTeam().size(); x++) {
            System.out.println(team.getTeam().get(x) + "'s BA " + team.getTeam().get(x).BA());
        }
        System.out.println();
        System.out.println(team.bestBa(team.getTeam()));
        System.out.println("The player with the best BA is: " + team.bestPlayerBA((team.getTeam())));

        //OBP
        System.out.println();
        System.out.println();
        for (int x = 0; x < team.getTeam().size(); x++) {
            System.out.println(team.getTeam().get(x) + "'s OBP " + team.getTeam().get(x).OBP());
        }
        System.out.println();
        System.out.println(team.bestOBP(team.getTeam()));
        System.out.println("The player with the best OBP is: " + team.bestPlayerOBP((team.getTeam())));

        //Slugging
        System.out.println();
        System.out.println();
        for (int x = 0; x < team.getTeam().size(); x++) {
            System.out.println(team.getTeam().get(x) + "'s Slugging " + team.getTeam().get(x).Slugging());
        }
        System.out.println();
        System.out.println(team.bestSlugging(team.getTeam()));
        System.out.println("The player with the best Slugging is: " + team.bestPlayerSlugging(team.getTeam()));
    }

    public static void fullTeamSoccer(){
        //not Actual position
        SoccerPlayer a = new SoccerPlayer("Ben");
        a.setPosition("P");
        a.addGoals(12);

        SoccerPlayer b = new SoccerPlayer("Joe");
        b.setPosition("Forward");
        b.addGoals(12);

        SoccerPlayer c = new SoccerPlayer("Alex");
        c.setPosition("Forward");
        c.addGoals(4);

        //third same position
        SoccerPlayer d = new SoccerPlayer("John");
        d.setPosition("Forward");
        d.addGoals(14);

        SoccerPlayer e = new SoccerPlayer("Jack");
        e.setPosition("Goal Keeper");

        SoccerPlayer f = new SoccerPlayer("Rat");
        f.setPosition("MidField");

        SoccerPlayer g = new SoccerPlayer("Dawg");
        g.setPosition("MidField");
        g.addGoals(1);

        SoccerPlayer h = new SoccerPlayer("Jose");
        h.setPosition("MidField");
        h.addGoals(12);

        SoccerPlayer i = new SoccerPlayer("Ray");
        i.setPosition("MidField");

        SoccerPlayer j = new SoccerPlayer("Cyrus");
        j.setPosition("Defender");

        SoccerPlayer k = new SoccerPlayer("Vara");
        k.setPosition("Defender");
        k.addGoals(1);

        SoccerPlayer l = new SoccerPlayer("Ghost");
        l.setPosition("Defender");

        SoccerPlayer m = new SoccerPlayer("Alien");
        m.setPosition("Defender");

        Soccer team = new Soccer();
        team.addPlayer(a);
        team.addPlayer(b);
        team.addPlayer(c);
        team.addPlayer(d);
        team.addPlayer(e);
        team.addPlayer(f);
        team.addPlayer(g);
        team.addPlayer(h);
        team.addPlayer(i);
        team.addPlayer(j);
        team.addPlayer(k);
        team.addPlayer(l);
        team.addPlayer(m);

        //Goals
        for (int x = 0; x < team.getTeam().size(); x++) {
            System.out.println(team.getTeam().get(x) + "'s Goals " + team.getTeam().get(x).getTotalGoals());
        }
        System.out.println();
        System.out.println(team.highestScore(team.getTeam()));
        System.out.println("The player with the most Goals is: " + team.bestPlayerGoals((team.getTeam())));

        System.out.println();
        System.out.println();


        team.addToField442(a);
        team.addToField442(b);
        team.addToField442(c);
        team.addToField442(d);
        team.addToField442(e);
        team.addToField442(f);
        team.addToField442(g);
        team.addToField442(h);
        team.addToField442(i);
        team.addToField442(j);
        team.addToField442(k);
        team.addToField442(l);
        team.addToField442(m);
        team.printField();
    }

    public static void testingHashMap(){
        //two of the same number
        BaseballPlayer a = new BaseballPlayer("Shane");
        a.setNumber(12);
        BaseballPlayer b = new BaseballPlayer("Sawyer");
        a.setNumber(12);

        //no number
        BaseballPlayer c = new BaseballPlayer("Sam");
        BaseballPlayer d = new BaseballPlayer("Sally");
        BaseballPlayer e = new BaseballPlayer("Storm");

        //random numbers
        BaseballPlayer f = new BaseballPlayer("Stallion");
        a.setNumber(13);
        BaseballPlayer g = new BaseballPlayer("Superman");
        a.setNumber(24);
        BaseballPlayer h = new BaseballPlayer("SpiderMan");
        a.setNumber(56);

        //Robinson's Number
        BaseballPlayer i = new BaseballPlayer("Stump");
        a.setNumber(42);
        Baseball t = new Baseball();
        t.addPlayer(a);
        t.addPlayer(b);
        t.addPlayer(c);
        t.addPlayer(d);
        t.addPlayer(e);
        t.addPlayer(f);
        t.addPlayer(g);
        t.addPlayer(h);
        t.addPlayer(i);
        t.printHash(t.getPlayerNumber());

        //two of the same number
        SoccerPlayer j = new SoccerPlayer("Abe");
        j.setNumber(12);
        SoccerPlayer k = new SoccerPlayer("Stanly");
        k.setNumber(12);

        //no number
        SoccerPlayer l = new SoccerPlayer("Abby");

        //random numbers
        SoccerPlayer m = new SoccerPlayer("May");
        m.setNumber(13);

        //Ranaldo's Number
        SoccerPlayer n = new SoccerPlayer("April");
        n.setNumber(7);

        Soccer team = new Soccer();
        team.addPlayer(j);
        team.addPlayer(k);
        team.addPlayer(l);
        team.addPlayer(m);
        team.addPlayer(n);
        team.printHash(team.getPlayerNumber());
    }

    public static void testingBinarySearch(){
        BaseballPlayer a = new BaseballPlayer("Jeff");
        a.setPosition("P");
        BaseballPlayer b = new BaseballPlayer("Joe");
        b.setPosition("C");
        b.addNumHomeRuns(10);
        BaseballPlayer c = new BaseballPlayer("Jack");
        c.setPosition("1B");
        BaseballPlayer d = new BaseballPlayer("John");
        d.setPosition("2B");
        BaseballPlayer e = new BaseballPlayer("Jen");
        e.setPosition("SS");
        BaseballPlayer f = new BaseballPlayer("JoeMama");
        f.setPosition("3B");
        BaseballPlayer g = new BaseballPlayer("Jillian");
        g.setPosition("RF");
        BaseballPlayer h = new BaseballPlayer("Jagger");
        h.setPosition("CF");
        BaseballPlayer i = new BaseballPlayer("Jupiter");
        i.setPosition("LF");

        Baseball t = new Baseball();
        t.addPlayer(a);
        t.addPlayer(b);
        t.addPlayer(c);
        t.addPlayer(d);
        t.addPlayer(e);
        t.addPlayer(f);
        t.addPlayer(g);
        t.addPlayer(h);
        t.addPlayer(i);
        //empty field
        System.out.println("This player has 10 HRs: " +
                           t.searchFullFieldHR(10,t.getField(),0,7));
        t.addToField(a);
        //when the field is not full
        System.out.println("This player has 10 HRs: " +
                           t.searchFullFieldHR(10,t.getField(),0,7));
        t.addToField(b);
        t.addToField(c);
        t.addToField(d);
        t.addToField(e);
        t.addToField(f);
        t.addToField(g);
        t.addToField(h);
        t.addToField(i);
        //when 1 person has the number of HR
        System.out.println("This player has 10 HRs: " +
                            t.searchFullFieldHR(10,t.getField(),0,7));
        //when nobody has the number of HR
        System.out.println("This player has 2 HRs: "+
                           t.searchFullFieldHR(2,t.getField(),0,7));
        d.addNumHomeRuns(10);
        //when more than one person has the number of HR
        System.out.println("This player has 10 HRs: " +
                           t.searchFullFieldHR(10,t.getField(),0,7));
    }

}
