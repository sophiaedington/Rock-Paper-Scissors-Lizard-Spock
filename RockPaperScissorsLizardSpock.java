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
        
        Choice computerChoice = getRandomChoice();
        
        System.out.println(player.getName() + " chose: " + playerChoice.getName());
        System.out.println(computer.getName() + " chose: " + computerChoice.getName());
        
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
        
        printScore();
    }
    
    private Choice getChoice(String choice) {
        choice = choice.toLowerCase();
        
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
                return null;
        }
    }
    
    private Choice getRandomChoice() {
        
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
    
    public void startGame() {
        boolean keepPlaying = true;
 
        while (keepPlaying) {
            
            player.resetWins();
            computer.resetWins();
 
            System.out.print("New Game\n");
            
            while (player.getWins() < minWins && computer.getWins() < minWins) {
                playRound();
            }
            
            announceGameWinner();
            
            keepPlaying = askPlayAgain();
            System.out.println();
        }
 
        System.out.println("Thanks for playing, " + player.getName() + "! Goodbye!");
    }
    
    private void printScore() {
        System.out.printf("Score: %s: %d | %s: %d %n %n",
                player.getName(), player.getWins(),
                computer.getName(), computer.getWins());
    }
    
    private void announceGameWinner() {
        System.out.println("Game Over");
        if (player.getWins() >= minWins) {
            System.out.println(player.getName() + " wins the game!");
        } else {
            System.out.println("Computer wins the game!");
        }

        System.out.println();
    }
    
    private boolean askPlayAgain() {
        System.out.println("Would you like to play again? (yes / no):");
        String response = scanner.nextLine().trim().toLowerCase();
        
        while (!response.startsWith("y") && !response.startsWith("n")) {
            System.out.println("Please enter 'yes' or 'no':");
            response = scanner.nextLine().trim().toLowerCase();
        }
 
        return response.startsWith("y");
    }
    
    public static void main(String[] args) {
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock();
        game.startGame();
        game.scanner.close();
    }
}
