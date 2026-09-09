package Choices;

public class Spock extends Choice {

    // Implement a specific version of getName() for each choice
    @Override
    public String getName() {
        return GameChoices.SPOCK;
    }

    // Implement a specific version of competeExplanation() for each choice
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Spock)    return "It's a draw, both chose " + GameChoices.SPOCK + "!";
        if (other instanceof Scissors) return GameChoices.SPOCK + " smashes " + GameChoices.SCISSORS;
        if (other instanceof Rock)     return GameChoices.SPOCK + " vaporizes " + GameChoices.ROCK;
        if (other instanceof Lizard)   return GameChoices.LIZARD + " poisons " + GameChoices.SPOCK;
        if (other instanceof Paper)    return GameChoices.PAPER + " disproves " + GameChoices.SPOCK;
        return "Unknown matchup!";
    }

    // Implement a specific version of determineWin() for each choice
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Spock)    return 0;   // draw
        if (other instanceof Scissors) return 1;   // Spock smashes Scissors (win)
        if (other instanceof Rock)     return 1;   // Spock vaporizes Rock (win)
        if (other instanceof Lizard)   return -1;  // Lizard poisons Spock (loss)
        if (other instanceof Paper)    return -1;  // Paper disproves Spock (loss)
        return 0;
    }
}