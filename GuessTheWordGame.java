import java.util.Random;
import java.util.Scanner;

public class GuessTheWordGame {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "grape", "watermelon", "pineapple", "strawberry"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Word Game!");
        System.out.println("Try to guess the word.");

        String randomWord = words[random.nextInt(words.length)];
        char[] guessedWord = new char[randomWord.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 7;
        boolean guessed = false;

        while (attempts > 0 && !guessed) {
            System.out.print("Word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println("\nAttempts left: " + attempts);

            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            guess = Character.toLowerCase(guess);

            boolean correctGuess = false;
            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
            }

            if (String.valueOf(guessedWord).equals(randomWord)) {
                guessed = true;
            }
        }

        if (guessed) {
            System.out.println("\nCongratulations! You guessed the word: " + randomWord);
        } else {
            System.out.println("\nGame over! The word was: " + randomWord);
        }

        scanner.close();
    }
}
