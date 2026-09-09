package Choices;

public class Scissors extends Choice {

    @Override
    public String getName() {
        return GameChoices.SCISSORS;
    }

    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Scissors) {
            return "It's a draw, both chose " + GameChoices.SCISSORS + "!";
        }
        
        if (other instanceof Paper) {
            return GameChoices.SCISSORS + " cuts " + GameChoices.PAPER;
        }
        
        if (other instanceof Lizard) {
            return GameChoices.SCISSORS + " decapitates " + GameChoices.LIZARD;
        }
        
        if (other instanceof Rock) {
            return GameChoices.ROCK + " breaks " + GameChoices.SCISSORS;
        }
        
        if (other instanceof Spock) {
            return GameChoices.SPOCK + " smashes " + GameChoices.SCISSORS;
        }
        
        return "Unknown matchup!";
    }
    
    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Scissors) {
            return 0;
        }
        
        if (other instanceof Paper) {
            return 1;
        }

        if (other instanceof Lizard) {
            return 1;
        }
        
        if (other instanceof Rock) {
            return -1;
        }
        if (other instanceof Spock) {
            return -1;
        }
        
        return 0;
    }
}
