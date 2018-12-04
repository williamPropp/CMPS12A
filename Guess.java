// Guess.java
// Guess.java
// William Propp
// wpropp
// pa2
// a number guessing game
import java.util.Scanner;
import java.lang.Math;

class Guess{
   public static void main(String[] args){
      System.out.println("I'm thinking of an integer in the range 1 to 10. You have three guesses.");
      Scanner sc = new Scanner(System.in);
      double randDouble = Math.random();
	  randDouble *= 10;
      randDouble += 1;
      int randInt = (int) randDouble;
	  int guessNum;
      while(guessNum <= 3){
	     guessNum++;
	     System.out.print("Enter your "+(guess == 1 ? "first" : (guess == 2 ? "second" : "third"))+" guess: ";
		 int guess = sc.nextInt();
		 if (guess < RandInt){
		    System.out.println("Your guess is too low.");
         } else if (guess > RandInt(){
		    System.out.println("Your guess is too high.");
	     } else {
		    System.out.println("You win!");
			guess = 4;
      }
	  if(guess == 4){
	     System.out.println("You lose. The number was "+randInt);
      }
   }
}
		 
		 
   
      