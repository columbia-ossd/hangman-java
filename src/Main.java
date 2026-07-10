import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("          Hangman Game");
        System.out.println("=======================================");
        int stateSet = chooseState();

        System.out.println("\nLet's play Hangman!");
        Game game = new Game(stateSet);
        game.newGame();
        game.play();
    }
        private static int chooseState() {
            Scanner input = new Scanner(System.in);
            int choice = 0;
            
            while (choice != 1 && choice != 2) {
                System.out.println("\n Choose a State:");
                System.out.println("1. Washington State");
                System.out.println("2. New York State");
                System.out.print("Enter your choice: ");
                    if (input.hasNextInt()) {
                        choice = input.nextInt();
                    } else {
                        input.next();
                    }
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            }

            if (choice == 2){
                return Dictionary.NEW_YORK;
            }else{
                 return Dictionary.WASHINGTON;
            } 
        }

    
}
