package ca.bcit.comp2522.lambdas;

/**
 * Represents a hockey player with Their full name,
 * the position they play, ("F"oward, "D"efence, or "G"oalie)
 * their year of birth, and the amount of goals they've scored.
 *
 * @author David Martinez
 *         Daniel Do
 * @version 1.0
 */
public class HockeyPlayer
{
    private static final int MIN_YEAR_OF_BIRTH = 1800;
    private static final int MAX_YEAR_OF_BIRTH = 2025;
    private static final int MIN_ALLOWABLE_GOAL_COUNT = 0;
    private static final int YEAR_ZERO = 0;

    // Position strings should be enums
    private static final String FORWARD = "F";
    private static final String DEFENCE = "D";
    private static final String GOALIE  = "G";

    private final String fullName;
    private final String position;
    private final int    yearOfBirth;
    private final int    goalsScored;

    /**
     * Full constructor.
     *
     * @param fullName This player's full name
     * @param position This player's position ("F", "D", or "G")
     * @param yearOfBirth This player's year of birth
     * @param goalsScored This player's amount of goals scored
     */
    HockeyPlayer(final String fullName,
                 final String position,
                 final int yearOfBirth,
                 final int goalsScored)
    {
        checkString(fullName);
        checkPosition(position);
        checkYearOfBirth(yearOfBirth);
        checkGoals(goalsScored);

        this.fullName = fullName;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
        this.goalsScored = goalsScored;
    }

    /*
    Checks goals for negative, if goals negative it is invalid
    Throws new IllegalArgumentException
     */
    private void checkGoals(final int goalsScored)
    {
        if (goalsScored < MIN_ALLOWABLE_GOAL_COUNT)
        {
            throw new IllegalArgumentException("goalsScored cannot be negative");
        }
    }

    /*
    Check year of birth, we only care about those born after 1800
    Throws new IllegalArgumentException
     */
    private void checkYearOfBirth(final int yearOfBirth)
    {
        if (yearOfBirth < YEAR_ZERO)
        {
            throw new IllegalArgumentException("yearOfBirth cannot be negative");
        }

        if (yearOfBirth < MIN_YEAR_OF_BIRTH ||  yearOfBirth > MAX_YEAR_OF_BIRTH)
        {
            throw new IllegalArgumentException("Year of birth must be between " +
                                                MIN_YEAR_OF_BIRTH +
                                                " and " +
                                                MAX_YEAR_OF_BIRTH);
        }
    }

    /*
    Check for null string and blankness, invalid if true
    Check for valid position, must be in set of {"F", "D", "G"}
    Throws new IllegalArgumentException
     */
    private void checkPosition(final String position)
    {
        checkString(position);

        if (!position.equalsIgnoreCase(FORWARD) &&
            !position.equalsIgnoreCase(DEFENCE) &&
            !position.equalsIgnoreCase(GOALIE))
        {
            throw new  IllegalArgumentException("position must be either 'F' or 'D' or 'G'");
        }
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
     * Getter for full name
     * @return this player's full name as String
     */
    public String getFullName()
    {
        return fullName;
    }

    /**
     * Getter for position
     * @return this player's position as String
     */
    public String getPosition()
    {
        return position;
    }

    /**
     * Getter for year of birth
     * @return this player's year of birth as int
     */
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    /**
     * Getter for position
     * @return this player's goals score as int
     */
    public int getGoalsScored()
    {
        return goalsScored;
    }

}
