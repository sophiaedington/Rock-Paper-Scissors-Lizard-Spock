package Choices;

public class Spock extends Choice {

    @Override
    public String getName() {
        return GameChoices.SPOCK;
    }

    @Override
    protected String competeExplanation(Choice other) {
        if (other instanceof Spock) {
            return "It's a draw, both chose " + GameChoices.SPOCK + "!";
        }
        
        if (other instanceof Scissors) {
            return GameChoices.SPOCK + " smashes " + GameChoices.SCISSORS;
        }
        
        if (other instanceof Rock) {
            return GameChoices.SPOCK + " vaporizes " + GameChoices.ROCK;
        }
        
        if (other instanceof Lizard) {
            return GameChoices.LIZARD + " poisons " + GameChoices.SPOCK;
        }
        
        if (other instanceof Paper) {
            return GameChoices.PAPER + " disproves " + GameChoices.SPOCK;
        }
        
        return "Unknown matchup!";
    }

    @Override
    protected int determineWin(Choice other) {
        if (other instanceof Spock) {
            return 0;
        }
        
        if (other instanceof Scissors) {
            return 1;
        }
        
        if (other instanceof Rock) {
            return 1;
        }
        
        if (other instanceof Lizard) {
            return -1;
        }
        if (other instanceof Paper) {
            return -1;
        }
        
        return 0;
    }
}
