public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          Hangman Game");
        System.out.println("=======================================");
        System.out.println("\nLet's guess a Washington State city!");

        Game game = new Game();
        game.newGame();
        game.play();
    }
}