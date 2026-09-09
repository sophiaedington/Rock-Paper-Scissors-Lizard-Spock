package Choices;

public class Rock extends Choice {
    
    @Override
    public String getName() {
        return GameChoices.ROCK;
    }
    
    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Rock) {
            return "It's a draw, both chose " + GameChoices.ROCK + "!";
        }
        
        if (other instanceof Lizard) {
            return GameChoices.ROCK + " crushes " + GameChoices.LIZARD;
        }
        
        if (other instanceof Scissors) {
            return GameChoices.ROCK + " breaks " + GameChoices.SCISSORS;
        }
        
        if (other instanceof Paper) {
            return GameChoices.PAPER + " covers " + GameChoices.ROCK;
        }
        
        if (other instanceof Spock) {
            return GameChoices.SPOCK + " vaporizes " + GameChoices.ROCK;
        }
        
        return "Unknown matchup.";
    }

    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Rock) {
            return 0;
        }
        
        if (other instanceof Lizard) {
            return 1;
        }
        
        if (other instanceof Scissors) {
            return 1;
        }
        
        if (other instanceof Paper) {
            return -1;
        }
        
        if (other instanceof Spock) {
            return -1;
        }
        
        return 0;
    }
}

