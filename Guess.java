// Guess.java
// William Propp
// wpropp
// pa2
// a number guessing game
import java.util.Scanner;

class Guess{
   public static void main(String[] args){
      System.out.println("\nI'm thinking of an integer in the range 1 to 10. You have three guesses.\n");
      Scanner sc = new Scanner(System.in);
      double randDouble = Math.random();
      randDouble *= 10;
      randDouble += 1;
      int randInt = (int) randDouble;
      int guessNum = 0;
      boolean win = false;
      while(guessNum < 3){
         guessNum++;
         System.out.print("Enter your "+(guessNum == 1 ? "first" : (guessNum == 2 ? "second" : "third"))+" guess: ");
         int guess = sc.nextInt();
         if (guess < randInt){
            System.out.println("Your guess is too low.\n");
         } else if (guess > randInt){
            System.out.println("Your guess is too high.\n");
         } else {
            System.out.println("You win!\n");
            win = true;
            break;
         }
      }
      if(!win){
         System.out.println("You lose. The number was "+randInt+".\n");
      }
   }
} 
