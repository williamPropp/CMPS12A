// Lawn.java
// William Propp
// wpropp
// pa1
// a lawn mowing calculator
import java.util.Scanner;

class Lawn{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
	  System.out.println("Enter the length and width of the lot, in feet: ");
	  double lotL = sc.nextDouble();
	  double lotW = sc.nextDouble();
	  double lotA = lotL * lotW;
	  
	  System.out.println("Enter the length and width of the house, in feet: ");
	  double houseL = sc.nextDouble();
	  double houseW = sc.nextDouble();
	  double houseA = houseL * houseW;
	  lawnA = lotA - houseA;
	  
	  System.out.println("The lawn area is "+lawnA+" square feet.");
	  System.out.println("Enter the mowing rate, in square feet per second: ");
	  double mowRate = sc.nextDouble();
	  
	  int mowTime = (int)(lawnA/mowRate);
	  int mowHours = (mowTime/60)/60;
	  int mowMinutes = (mowTime/60)-(mowHours*60);
	  int mowSeconds = mowTime-(mowMinutes*60)-(mowHours*60*60);
	  
	  System.out.print("The mowing time is "+mowHours);
	  if(mowHours == 1) System.out.print(" hour "+mowMinutes);
	  else System.out.print(" hours "+mowMinutes);
	  if(mowMinutes == 1) System.out.print(" minute "+mowSeconds);
	  else System.out.print(" minutes "+mowSeconds);
	  if(mowSeconds == 1) System.out.print(" second.");
	  else System.out.print(" minutes.");
   }
}	  