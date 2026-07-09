import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final int MAX_ERRORS = 6;

    private final Dictionary dictionary;
    private String wordToFind;
    private char[] wordFound;
    private int numberOfErrors;
    private ArrayList<String> guessedLetters;

    public Game() {
        dictionary = new Dictionary();
        guessedLetters = new ArrayList<>();
    }

    public void newGame() {
        numberOfErrors = 0;
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
        try (Scanner input = new Scanner(System.in)) {
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
            } else {
                System.out.println("\nOh no! The hangman is complete.");
                System.out.println("The city was: " + wordToFind);
            }
        }
    }

    private void processGuess(String userInput) {
        if (guessedLetters.contains(userInput)) {
            System.out.println("You already guessed '" + userInput + "'. Try another letter.");
            return;
        }

        guessedLetters.add(userInput);

        if(Character.isUpperCase(userInput.charAt(0))){
            userInput = userInput.toLowerCase();
            guessedLetters.add(userInput);
        }

        if (wordToFind.contains(userInput)) {
            int index = wordToFind.indexOf(userInput);

            while (index >= 0) {
                wordFound[index] = userInput.charAt(0);
                index = wordToFind.indexOf(userInput, index + 1);
            }
        } else {
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

