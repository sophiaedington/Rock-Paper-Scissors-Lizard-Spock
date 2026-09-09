package Choices;

public class Lizard extends Choice {

    // Implement a specific version of getName() for each choice
    @Override
    public String getName() {
        return GameChoices.LIZARD;
    }

    // Implement a specific version of competeExplanation() for each choice
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Lizard)   return "It's a draw, both chose " + GameChoices.LIZARD + "!";
        if (other instanceof Spock)    return GameChoices.LIZARD + " poisons " + GameChoices.SPOCK;
        if (other instanceof Paper)    return GameChoices.LIZARD + " eats " + GameChoices.PAPER;
        if (other instanceof Rock)     return GameChoices.ROCK + " crushes " + GameChoices.LIZARD;
        if (other instanceof Scissors) return GameChoices.SCISSORS + " decapitates " + GameChoices.LIZARD;
        return "Unknown matchup!";
    }

    // Implement a specific version of determineWin() for each choice
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Lizard)   return 0;   // draw
        if (other instanceof Spock)    return 1;   // Lizard poisons Spock (win)
        if (other instanceof Paper)    return 1;   // Lizard eats Paper (win)
        if (other instanceof Rock)     return -1;  // Rock crushes Lizard (loss)
        if (other instanceof Scissors) return -1;  // Scissors decapitates Lizard (loss)
        return 0;
    }
}