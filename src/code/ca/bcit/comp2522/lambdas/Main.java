package ca.bcit.comp2522.lambdas;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BiFunction;

/**
 * Main class for running tests for comp 2522 lab 6
 *
 * @author David Martinez
 * @author Daniel Do
 * @version 1.0
 */
public class Main
{
    private static final int MIN_ALLOWABLE_AGE = 20;
    private static final int MIN_GOALS_THRESHOLD = 15;
    private static final int HIGH_SCORING_THRESHOLD = 20;
    static final String FORWARD = "F";
    static final String DEFENCE = "D";
    static final String GOALIE  = "G";

    /**
     * Returns a new sample team
     *
     * @return a new sample team
     */
    private static HockeyTeam sampleTeam() {
        final List<HockeyPlayer> ps;

        ps = new ArrayList<>();
        ps.add(new HockeyPlayer("Alex Morgan", FORWARD, 2002, 21));
        ps.add(new HockeyPlayer("Ben Carter",  DEFENCE, 1999, 6));
        ps.add(new HockeyPlayer("Casey Young", FORWARD, 2004, 28));
        ps.add(new HockeyPlayer("Drew Singh",  GOALIE,  2000, 0));
        ps.add(new HockeyPlayer("Eva Chen",    DEFENCE, 2001, 5));

        return new HockeyTeam("BCIT Blizzards", ps);
    }

    /**
     * Runner class for Main
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final int currentYear;
        final HockeyTeam team;
        final List<HockeyPlayer> roster;

        currentYear = 2025;
        team = sampleTeam();
        roster = team.getRoster();

        // 1. Write a Supplier
        /*
        - Write a Supplier<HockeyPlayer> that creates a “call-up” player (a new
        HockeyPlayer instance).
        - Add this new player to the team’s roster.
         */
        System.out.println("1. Supplier - call-up player (creates new player)");
        final String fullName;
        final String position;
        final int yearOfBirth;
        final int goalsScored;
        final Supplier<HockeyPlayer> callUp;

        fullName = "John Smith";
        position = "F";
        yearOfBirth = 2000;
        goalsScored = 0;

        callUp = () -> new HockeyPlayer(fullName, position, yearOfBirth, goalsScored);

        roster.add(callUp.get());

        // Space separator
        System.out.println();

        /*
        2. Predicate
        - Write a Predicate<HockeyPlayer> that checks if a player is a Forward.
        - Write another Predicate<HockeyPlayer> that checks if a player has 20 or
        more goals.
        - Use these predicates in a loop to print only forwards with 20+ goals.
        */
        System.out.println("2. Predicate - checks for forward and checks for >= 20 goals");
        final Predicate<HockeyPlayer> isForward;
        final Predicate<HockeyPlayer> highScorer;

        isForward = p -> p.getPosition().equalsIgnoreCase(FORWARD);
        highScorer = p -> p.getGoalsScored() >= HIGH_SCORING_THRESHOLD;

        System.out.println("Printing players that are forwards AND have >= 20 goals");
        for (final HockeyPlayer p : roster)
        {
            if (isForward.test(p) && highScorer.test(p))
            {
                System.out.println(p.getFullName());
                System.out.println(p.getPosition());
                System.out.println(p.getGoalsScored());
            }
        }

        // Space separator
        System.out.println();

        /*
        3. Function
        - Write a Function<HockeyPlayer, String> that maps a player to a label string,
        e.g.:
        - Alex Morgan — 21G
        */
        System.out.println("3. Function - Applies label to player");
        final Function<HockeyPlayer, String> labeler;
        labeler = (p) -> p.getFullName() + " - " + p.getGoalsScored() + " Goals";

        System.out.println("Printing players with a label of how many goals they have:");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(labeler.apply(p));
        }

        // Space separator
        System.out.println();

        /*
        4. Consumer
        - Write a Consumer<HockeyPlayer> that prints just the player’s name.
        - Loop through the roster and apply it.
        */
        System.out.println("4. Consumer - Prints player's name");
        final Consumer<HockeyPlayer> namePrinter;
        namePrinter = p -> System.out.println(p.getFullName());

        for (final HockeyPlayer p : roster)
        {
            namePrinter.accept(p);
        }

        // Space separator
        System.out.println();

        /*
        5. UnaryOperator
        - Write a UnaryOperator<String> that converts a string to uppercase.
        - Use it to print all player names in uppercase.
        */
        System.out.println("5. UnaryOperator - print all names to uppercase");

        final UnaryOperator<String> namesToUpper;
        namesToUpper = name -> name.toUpperCase();

        for (final HockeyPlayer p : roster)
        {
            System.out.println(namesToUpper.apply(p.getFullName()));
        }
        // Space separator
        System.out.println();

        /*
        6. Comparator
        - Write a Comparator<HockeyPlayer> (as a lambda) that sorts players by
        goals descending.
        - Sort the roster and print the results.
         */
        System.out.println("6. Comparator - Sort all players in descending num of goals");

        final Comparator<HockeyPlayer> hockeyPlayerComparator;
        hockeyPlayerComparator = (p, o) -> o.getGoalsScored() - p.getGoalsScored();

        System.out.println("BEFORE sort:");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getFullName() + " goals: " + p.getGoalsScored());
        }
        System.out.println();

        Collections.sort(roster, hockeyPlayerComparator);

        System.out.println("AFTER sort:");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getFullName() + " goals: " + p.getGoalsScored());
        }
        // Space separator
        System.out.println();

        /*
        7. Aggregation (loop-based)
        - Using a plain loop, calculate and print the team’s total goals.
        */
        System.out.println("7. Aggregation (loop-based)");

        final BiFunction<Integer, Integer, Integer> goalAdder;
        int goalSum = 0;

        goalAdder  = (goals, runningTotal) -> goals + runningTotal;

        for (final HockeyPlayer p : roster)
        {
            final int playerGoals;
            playerGoals = p.getGoalsScored();

            goalSum = goalAdder.apply(playerGoals, goalSum);
        }

        System.out.println("Team total goals = " + goalSum);
        // Space separator
        System.out.println();

        /*
        8. Custom Functional Interface
        - Define your own @FunctionalInterface called EligibilityRule.
        It should declare a method:
        - boolean test(HockeyPlayer player, int minAge, int minGoals, int currentYear);
        - Implement it with a lambda that says a player is eligible if:
            > their age (derived from yearOfBirth) is at least minAge
            > and they have at least minGoals.
        - Test it by printing all eligible players when minAge = 20 and minGoals = 15
         */
        System.out.println("8. Custom Functional Interface, EligibilityRule interface:");
        final int minAge;
        final int minGoals;
        final EligibilityRule eligiblePlayer;

        minAge   = MIN_ALLOWABLE_AGE;
        minGoals = MIN_GOALS_THRESHOLD;

        eligiblePlayer = (player,
                          ageReq, goalsReq,
                          year) ->
        {
            final int playerAge;
            playerAge = year - player.getYearOfBirth();

            if (player.getGoalsScored() < goalsReq)
            {
                return false;
            }

            if (playerAge < ageReq)
            {
                return false;
            }

            return true;
        };

        for (final HockeyPlayer p : roster)
        {
            final String statement;
            statement = eligiblePlayer.test(p, minAge, minGoals, currentYear) ? "\b" : "NOT";

            System.out.println("Player '"       +
                                p.getFullName() +
                                "' is "         +
                                statement       +
                                " eligible");
        }
    }
}
