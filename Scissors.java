package Choices;

public class Scissors extends Choice {

    // Implement a specific version of getName() for each choice
    @Override
    public String getName() {
        return GameChoices.SCISSORS;
    }

    // Implement a specific version of competeExplanation() for each choice
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Scissors) return "It's a draw, both chose " + GameChoices.SCISSORS + "!";
        if (other instanceof Paper)    return GameChoices.SCISSORS + " cuts " + GameChoices.PAPER;
        if (other instanceof Lizard)   return GameChoices.SCISSORS + " decapitates " + GameChoices.LIZARD;
        if (other instanceof Rock)     return GameChoices.ROCK + " breaks " + GameChoices.SCISSORS;
        if (other instanceof Spock)    return GameChoices.SPOCK + " smashes " + GameChoices.SCISSORS;
        return "Unknown matchup!";
    }

    // Implement a specific version of determineWin() for each choice
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Scissors) return 0;   // draw
        if (other instanceof Paper)    return 1;   // Scissors cuts Paper (win)
        if (other instanceof Lizard)   return 1;   // Scissors decapitates Lizard (win)
        if (other instanceof Rock)     return -1;  // Rock breaks Scissors (loss)
        if (other instanceof Spock)    return -1;  // Spock smashes Scissors (loss)
        return 0;
    }
}