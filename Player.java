public final class Player {
    private final String name;
 
    private int wins;
 
    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name must not be null or blank.");
        }

        this.name = name.trim();
        this.wins = 0;
    }
 
    public String getName() {
        return name;
    }
 
    public int getWins() {
        return wins;
    }
 
    public void addWin() {
        wins++;
    }
 
    public void resetWins() {
        wins = 0;
    }
 
    @Override
    public String toString() {
        return name + " (wins: " + wins + ")";
    }
}
