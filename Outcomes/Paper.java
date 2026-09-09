package Choices;

public class Paper extends Choice {

    @Override
    public String getName() {
        return GameChoices.PAPER;
    }

    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Paper) {
            return "It's a draw, both chose " + GameChoices.PAPER + "!";
        }
        
        if (other instanceof Rock) {
            return GameChoices.PAPER + " covers " + GameChoices.ROCK;
        }
        
        if (other instanceof Spock) {
            return GameChoices.PAPER + " disproves " + GameChoices.SPOCK;
        }
        
        if (other instanceof Scissors) {
            return GameChoices.SCISSORS + " cuts " + GameChoices.PAPER;
        }
        
        if (other instanceof Lizard) {
            return GameChoices.LIZARD + " eats " + GameChoices.PAPER;
        }
        
        return "Unknown matchup!";
    }

    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Paper) {
            return 0;
        }
        
        if (other instanceof Rock) {
            return 1;
        }
        
        if (other instanceof Spock) {
            return 1;
        }
        
        if (other instanceof Scissors) {
            return -1;
        }
        if (other instanceof Lizard) {
            return -1;
        }
        
        return 0;
    }
}
