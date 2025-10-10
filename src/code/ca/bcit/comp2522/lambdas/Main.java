package ca.bcit.comp2522.lambdas;

import java.util.List;
import java.util.ArrayList;

/**
 * Main class for running tests for comp 2522 lab 6
 *
 * @author David Martinez
 *         Daniel Do
 * @version 1.0
 */
public class Main
{
    /**
     * Returns a new sample team
     *
     * @return a new sample team
     */
    private static HockeyTeam sampleTeam() {
        final List<HockeyPlayer> ps;
        ps = new ArrayList<>();
        ps.add(new HockeyPlayer("Alex Morgan", "F", 2002, 21));
        ps.add(new HockeyPlayer("Ben Carter", "D", 1999, 6));
        ps.add(new HockeyPlayer("Casey Young", "F", 2004, 28));
        ps.add(new HockeyPlayer("Drew Singh", "G", 2000, 0));
        ps.add(new HockeyPlayer("Eva Chen", "D", 2001, 5));

        return new HockeyTeam("BCIT Blizzards", ps);
    }

    /**
     * Runner class for Main
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final int currentYear = 2025;
        final HockeyTeam team;
        final List<HockeyPlayer> roster;

        team = sampleTeam();
        roster = team.getRoster();
    }


}
