package ca.bcit.comp2522.lambdas;

/**
 * Tests whether a player is eligible to play in league or not based on
 * the following rules: </br>
 * <ul>
 *     <li>
 *         Player is above a minimum age
 *     </li>
 *     <li>
 *         Player has at least a certain amount of goals
 *     </li>
 * </ul>
 *
 * @author David Martinez
 * @author Daniel Do
 * @version 1.0
 */
@FunctionalInterface
public interface EligibilityRule
{
    /**
     * Eligibility method.
     *
     * @param player A hockey player
     * @param minAge Some minimum age requirement
     * @param minGoals Some amount of goals requirement
     * @param currentYear The current year
     * @return True or False. True if player is eligible, false otherwise.
     */
    boolean test(HockeyPlayer player,
                 Integer minAge,
                 Integer minGoals,
                 Integer currentYear);
}
