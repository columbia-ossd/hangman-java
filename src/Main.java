import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          Hangman Game");
        System.out.println("=======================================");

        Scanner input = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();

        Game game = new Game(input, scoreboard);
        System.out.println("\nLet's play Hangman!");
    
        game.newGame();
        game.play();
    }
}



