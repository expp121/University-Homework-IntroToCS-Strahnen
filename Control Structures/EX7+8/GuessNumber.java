import java.util.Scanner;

public class GuessNumber{

public static Scanner input = new Scanner(System.in);

    public static void main(String args[]){
        int secretNum = (int)(Math.random()*100) + 1;
        int playerGuess;
        int guessesNeeded = 0;
        long timeTaken = 0;
                
        System.out.println("Welcome to \"Guess Numbers\"\nI have recorded a secret number between 1 and 100 ...");
        
        timeTaken = System.currentTimeMillis();
        do {
            System.out.print("Your Guess? ");
            playerGuess = input.nextInt();

            guessesNeeded++;

            if (playerGuess > secretNum)
                System.out.println(playerGuess + " is too big!");

            if (playerGuess < secretNum)
                System.out.println(playerGuess + " is too small!");

            if (playerGuess == secretNum)
            {
                timeTaken = Math.abs(timeTaken - System.currentTimeMillis());
                System.out.println(playerGuess + " is my secret number --- number of guesses: " + guessesNeeded +
                " --- time used: " + (timeTaken/1000.0) +"s ... \nOnce again ?");
                input.nextLine();
                if (input.nextLine().toString().equals("yes")){
                    playerGuess = -1;
                    guessesNeeded = 0;
                    secretNum = (int)(Math.random()*100) + 1;
                    timeTaken = 0;
                }
                else break;
            }
        } while (playerGuess != secretNum);     

  }
}