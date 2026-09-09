package Choices;

public class Lizard extends Choice {
    
    @Override
    public String getName() {
        return GameChoices.LIZARD;
    }

    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Lizard) {
            return "It's a draw, both chose " + GameChoices.LIZARD + "!";
        }
        
        if (other instanceof Spock) {
            return GameChoices.LIZARD + " poisons " + GameChoices.SPOCK;
        }
        
        if (other instanceof Paper) {
            return GameChoices.LIZARD + " eats " + GameChoices.PAPER;
        }
        
        if (other instanceof Rock) {
            return GameChoices.ROCK + " crushes " + GameChoices.LIZARD;
        }
        
        if (other instanceof Scissors) {
            return GameChoices.SCISSORS + " decapitates " + GameChoices.LIZARD;
        }
        
        return "Unknown matchup!";
    }

    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Lizard) {
            return 0;
        }
        
        if (other instanceof Spock) {
            return 1;
        }
        
        if (other instanceof Paper) {
            return 1;
        }
        
        if (other instanceof Rock) {
            return -1;
        }
        
        if (other instanceof Scissors) {
            return -1;
        }
        
        return 0;
    }
}
