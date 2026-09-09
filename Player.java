public final class Player {
    // Implement
    private final String name;
 
    // Number of rounds won
    private int wins;
 
    // Creates a new player
    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name must not be null or blank.");
        }

        this.name = name.trim();
        this.wins = 0;
    }
 
    /// Getters
    public String getName() {
        return name;
    }
 
    public int getWins() {
        return wins;
    }
 
    // Round win counter
    public void addWin() {
        wins++;
    }
 
    // Resets the round win counter
    public void resetWins() {
        wins = 0;
    }
 
    @Override
    public String toString() {
        return name + " (wins: " + wins + ")";
    }
}