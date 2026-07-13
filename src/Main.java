import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          Hangman Game");
        System.out.println("=======================================");
        System.out.println("\nLet's guess a Washington State city!");

        Scanner input = new Scanner(System.in);
        Scoreboard scoreboard = new Scoreboard();

        Game game = new Game(input, scoreboard);
        game.newGame();
        game.play();
    }
}