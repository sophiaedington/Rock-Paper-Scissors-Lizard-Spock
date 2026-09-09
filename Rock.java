package Choices;

public class Rock extends Choice {

    // Implement a specific version of getName() for each choice
    // Hint: Make use of GameChoices to get a nice representation of the name!
    @Override
    public String getName() {
        return GameChoices.ROCK;
    }

    // Implement a specific version of competeExplanation() for each choice
    // Should return a String of the game round's explanation (e.g., "Rock crushes Lizard")
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Rock)     return "It's a draw, both chose " + GameChoices.ROCK + "!";
        if (other instanceof Lizard)   return GameChoices.ROCK + " crushes " + GameChoices.LIZARD;
        if (other instanceof Scissors) return GameChoices.ROCK + " breaks " + GameChoices.SCISSORS;
        if (other instanceof Paper)    return GameChoices.PAPER + " covers " + GameChoices.ROCK;
        if (other instanceof Spock)    return GameChoices.SPOCK + " vaporizes " + GameChoices.ROCK;
        return "Unknown matchup.";
    }

    // Implement a specific version of determineWin() for each choice
    /*
     * Compares the choice with the other player's choice
     * - Should return an `int`:
     * - `0`: choice is equal to otherPlayerChoice
     * - `1`: choice wins agains otherPlayerChoice
     * - `-1`: choice looses to otherPlayerChoice
     */
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Rock)     return 0;   // draw
        if (other instanceof Lizard)   return 1;   // Rock crushes Lizard (win)
        if (other instanceof Scissors) return 1;   // Rock breaks Scissors (win)
        if (other instanceof Paper)    return -1;  // Paper covers Rock (loss)
        if (other instanceof Spock)    return -1;  // Spock vaporizes Rock (loss)
        return 0;
    }
}

