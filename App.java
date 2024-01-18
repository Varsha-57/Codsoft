import java.util.Scanner;
import java.util.Random;

public class App {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess;
        int attempts = 0;
        boolean isPlaying = true;
        
        while (isPlaying) {
            
            System.out.println("Welcome to the number guessing game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            
            while (true) {
                
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
                
                if (attempts == 5) {
                    System.out.println("You've reached the maximum number of attempts. Game over.");
                    break;
                }
            }
            
            System.out.println("The correct number is " + numberToGuess + ".");
            
            System.out.print("Would you like to play again? (yes/no): ");
            String answer = scanner.next();
            
            if (answer.equalsIgnoreCase("no")) {
                isPlaying = false;
            } else {
                numberToGuess = random.nextInt(100) + 1;
                attempts = 0;
            }
        }
        
        System.out.println("Thank you for playing! Goodbye.");
        
        scanner.close();
    }
}