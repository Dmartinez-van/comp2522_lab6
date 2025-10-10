package ca.bcit.comp2522.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hockey team
 * Has a team name (String)
 * Has a team rooster (List)
 *
 * @author David Martinez
 *         Daniel Do
 * @version 1.0
 */
public class HockeyTeam
{
    private final String teamName;
    private final List<HockeyPlayer> teamRooster;

    /**
     * Full constructor
     *
     * @param teamName This team's name
     */
    HockeyTeam(final String teamName,
               final List<HockeyPlayer> teamRooster)
    {
        checkString(teamName);

        this.teamName = teamName;
        this.teamRooster = teamRooster;
    }

    /*
    Check for null string and blankness, invalid if true
    Throws new IllegalArgumentException
     */
    private void checkString(final String s)
    {
        if (s == null || s.isBlank())
        {
            throw new IllegalArgumentException("string cannot be null or blank");
        }
    }

    /**
     * Getter for team's roster
     *
     * @return the team roster list
     */
    public List<HockeyPlayer> getRoster()
    {
        return teamRooster;
    }
}
