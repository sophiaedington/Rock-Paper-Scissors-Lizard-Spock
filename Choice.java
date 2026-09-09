package Choices;

public abstract class Choice {
    public abstract String getName();

    protected abstract String competeExplanation(Choice otherPlayerChoice);

    protected abstract int determineWin(Choice otherPlayerChoice);

    public int compete(Choice otherPlayerChoice) {
        System.out.println("Outcome: " + competeExplanation(otherPlayerChoice));
        return determineWin(otherPlayerChoice);
    }
}
