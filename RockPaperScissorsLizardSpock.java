// Just to note my output doesn't print emojis but instead shows them as questions marks

import java.util.Random;
import java.util.Scanner;
import Choices.*;

public class RockPaperScissorsLizardSpock {

    private Player player;
    private Player computer;

    private final int minWins = 2;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    protected RockPaperScissorsLizardSpock() {
        System.out.print("Player 1, please enter your name: ");
        this.player = new Player(scanner.nextLine());
        System.out.println();
        this.computer = new Player("Computer");
    }

    // NOTE: You may define additional methods to provide a better, cleaner structure!
    // Implement playRound and round win check here
    public void playRound() {
        System.out.printf(player.getName() + ", please enter %s, %s, %s, %s, or %s: %n",
                GameChoices.ROCK, GameChoices.PAPER, GameChoices.SCISSORS, GameChoices.LIZARD, GameChoices.SPOCK);

        String input = scanner.nextLine().trim();
        Choice playerChoice = getChoice(input);

        while (playerChoice == null) {
            System.out.println("Invalid input. Please enter rock, paper, scissors, lizard, or spock:");
            input = scanner.nextLine().trim();
            playerChoice = getChoice(input);
        }
 
        // Computer picks randomly
        Choice computerChoice = getRandomChoice();
 
        // Shows choices
        System.out.println(player.getName() + " chose: " + playerChoice.getName());
        System.out.println(computer.getName() + " chose: " + computerChoice.getName());
 
        // Find round winner
        int result = playerChoice.compete(computerChoice);

        if (result == 1) {
            System.out.print(player.getName() + " wins this round!\n");
            player.addWin();
        } else if (result == -1) {
            System.out.print(computer.getName() + " wins this round!\n");
            computer.addWin();
        } else {
            System.out.print("It's a draw, no point awarded.\n");
        }
 
        // Prints current score
        printScore();
    }

    // Implement a method to convert the player's input into a choice
    private Choice getChoice(String choice) {
        choice = choice.toLowerCase();
        // Check the passed string and return a Choice object (i.e., Rock, Paper, Scissors, Lizard, or Spock)
        // Pick a default case
        switch (choice) {
            case "rock":
                return new Rock();
            case "paper":
                return new Paper();
            case "scissors":
                return new Scissors();
            case "lizard":
                return new Lizard();
            case "spock":
                return new Spock();
            default:
                // Input does not match
                return null;
        }
    }

    // Implement a method to get a random choice for the computer
    private Choice getRandomChoice() {
        // Based on a random number, return a Choice object (i.e., Rock, Paper, Scissors, Lizard, or Spock)
        // Pick a default case
        int roll = random.nextInt(5);
 
        switch (roll) {
            case 0:  return new Rock();
            case 1:  return new Spock();
            case 2:  return new Paper();
            case 3:  return new Lizard();
            case 4:  return new Scissors();
            default: return new Rock();
        }
    }

    // Implement the main game loop and overall game win check here
    public void startGame() {
        boolean keepPlaying = true;
 
        while (keepPlaying) {
            // Reset scores
            player.resetWins();
            computer.resetWins();
 
            System.out.print("New Game\n");
 
            // Play rounds until someone wins
            while (player.getWins() < minWins && computer.getWins() < minWins) {
                playRound();
            }
 
            // Overall game winner
            announceGameWinner();
 
            // Asks for another game
            keepPlaying = askPlayAgain();
            System.out.println();
        }
 
        System.out.println("Thanks for playing, " + player.getName() + "! Goodbye!");
    }

    // Prints the current round win totals
    private void printScore() {
        System.out.printf("Score: %s: %d | %s: %d %n %n",
                player.getName(), player.getWins(),
                computer.getName(), computer.getWins());
    }
 
    // Prints which player won the overall game
    private void announceGameWinner() {
        System.out.println("Game Over");
        if (player.getWins() >= minWins) {
            System.out.println(player.getName() + " wins the game!");
        } else {
            System.out.println("Computer wins the game!");
        }

        System.out.println();
    }

    // Play again
    private boolean askPlayAgain() {
        System.out.println("Would you like to play again? (yes / no):");
        String response = scanner.nextLine().trim().toLowerCase();
 
        // Accept any input starting with 'y'
        while (!response.startsWith("y") && !response.startsWith("n")) {
            System.out.println("Please enter 'yes' or 'no':");
            response = scanner.nextLine().trim().toLowerCase();
        }
 
        return response.startsWith("y");
    }

    // NO NEED TO TOUCH main()
    public static void main(String[] args) {
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock();
        game.startGame();
        game.scanner.close();
    }
}