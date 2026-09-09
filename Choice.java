package Choices;

// Implement Choice
// Choice should function as the Base class for all the choices
// There is no default Choice!

// Rock was already partially implemented as an example
// You may make changes to the structure and type of both classes!

public abstract class Choice {
    // Returns the display name
    public abstract String getName();

    // Returns the outcome of the gesture
    protected abstract String competeExplanation(Choice otherPlayerChoice);

    // Compares this gesture to players choice
    protected abstract int determineWin(Choice otherPlayerChoice);

    // NO NEED TO TOUCH compete()
    public int compete(Choice otherPlayerChoice) {
        System.out.println("Outcome: " + competeExplanation(otherPlayerChoice));
        return determineWin(otherPlayerChoice);
    }
}