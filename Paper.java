package Choices;

public class Paper extends Choice {

    // Implement a specific version of getName() for each choice
    @Override
    public String getName() {
        return GameChoices.PAPER;
    }

    // Implement a specific version of competeExplanation() for each choice
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Paper)    return "It's a draw, both chose " + GameChoices.PAPER + "!";
        if (other instanceof Rock)     return GameChoices.PAPER + " covers " + GameChoices.ROCK;
        if (other instanceof Spock)    return GameChoices.PAPER + " disproves " + GameChoices.SPOCK;
        if (other instanceof Scissors) return GameChoices.SCISSORS + " cuts " + GameChoices.PAPER;
        if (other instanceof Lizard)   return GameChoices.LIZARD + " eats " + GameChoices.PAPER;
        return "Unknown matchup!";
    }

    // Implement a specific version of determineWin() for each choice
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Paper)    return 0;   // draw
        if (other instanceof Rock)     return 1;   // Paper covers Rock (win)
        if (other instanceof Spock)    return 1;   // Paper disproves Spock (win)
        if (other instanceof Scissors) return -1;  // Scissors cuts Paper (loss)
        if (other instanceof Lizard)   return -1;  // Lizard eats Paper (loss)
        return 0;
    }
}