import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final int MAX_ERRORS = 6;

    private final Dictionary dictionary;
    private final Scanner input;
    private final Scoreboard scoreboard;
    private String wordToFind;
    private char[] wordFound;
    private int numberOfErrors;
    private ArrayList<String> guessedLetters;
    private int citySet;

    public Game(Scanner input, Scoreboard scoreboard) {
        this.input = input;
        this.scoreboard = scoreboard;
        dictionary = new Dictionary(citySet);
        guessedLetters = new ArrayList<>();
    }

    public void newGame() {
        numberOfErrors = 0;
        System.out.print("\nEnter a letter: ");
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
        
        guessedLetters.clear();

        wordToFind = dictionary.getRandomWord();
        wordFound = new char[wordToFind.length()];

        wordFound[0] = wordToFind.charAt(0);

        for (int i = 1; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }

        System.out.println("\nHint: the " + dictionary.getCategory()
                + " starts with " + wordToFind.charAt(0));
    }

    public void play() {
        while (numberOfErrors < MAX_ERRORS && !wordFound()) {
            System.out.print("\nEnter a letter: ");
            String userInput = input.next();

            if (userInput.length() > 1) {
                userInput = userInput.substring(0, 1);
            }

            processGuess(userInput);

            System.out.println(Drawing.getDrawing(numberOfErrors));
            System.out.println(wordFoundContent());
            System.out.println("Remaining tries: " + (MAX_ERRORS - numberOfErrors));
        }

        if (wordFound()) {
            System.out.println("\nCongratulations! You win!");
            scoreboard.recordWin();
        } else {
            System.out.println("\nOh no! The hangman is complete.");
            System.out.println("The city was: " + wordToFind);
            scoreboard.recordLoss();
        }

        scoreboard.display();
        playAgain();
    }

    public void playAgain() {
        System.out.print("\nPlay again? (y/n): ");
        String userInput = input.next();

        if (userInput.equals("y") || userInput.equals("Y")) {
            Game game = new Game(input, scoreboard);
            game.newGame();
            game.play();
        } else if (userInput.equals("n") || userInput.equals("N")) {
            System.out.println("\nThanks for playing!");
        } else {
            System.out.println("Please enter 'y' or 'n'.");
            playAgain();
        }
    }

    private int findLetters(char letter){

        String userInput = String.valueOf(letter);

        if (wordToFind.contains(userInput)) {
            int index = wordToFind.indexOf(userInput);

            while (index >= 0) {
                wordFound[index] = userInput.charAt(0);
                index = wordToFind.indexOf(userInput, index + 1);
            }

            return 1;
        } 

        guessedLetters.add(userInput);

        return 0;
    }



    private void processGuess(String userInput) {
        if (guessedLetters.contains(userInput)) {
            System.out.println("You already guessed '" + userInput + "'. Try another letter.");
            return;
        }

        String alt = ""; 

        if(Character.isUpperCase(userInput.charAt(0))){
            alt = userInput.toLowerCase();
        } 

        if(Character.isLowerCase(userInput.charAt(0))){
            alt = userInput.toUpperCase();
        }

        if (findLetters(userInput.charAt(0)) == 0 
            && findLetters(alt.charAt(0)) == 0){
            numberOfErrors++;
        }
    }

    private boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);

            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}

