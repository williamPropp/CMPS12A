// Lawn.java
// William Propp
// wpropp
// pa1
// a lawn mowing calculator
import java.util.Scanner;

class Lawn{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
         System.out.print("Enter the length and width of the lot, in feet: ");
         double lotL = sc.nextDouble();
	 double lotW = sc.nextDouble();
	 double lotA = lotL * lotW;
	  
	 System.out.print("Enter the length and width of the house, in feet: ");
	 double houseL = sc.nextDouble();
	 double houseW = sc.nextDouble();
	 double houseA = houseL * houseW;
         double  lawnA = lotA - houseA;
	  
         System.out.println("The lawn area is "+lawnA+" square feet.");
	 System.out.print("Enter the mowing rate, in square feet per second: ");
	 double mowRate = sc.nextDouble();
	  
	 int mowTime = (int) Math.round(lawnA/mowRate);
	 int mowHours = (mowTime/60)/60;
         int mowMinutes = (mowTime/60)-(mowHours*60);
	 int mowSeconds = mowTime-(mowMinutes*60)-(mowHours*60*60);
	  
	 System.out.print("The mowing time is ");
         System.out.print(mowHours+" hour"+(mowHours==1? " " : "s "));
         System.out.print(mowMinutes+" minute"+(mowMinutes==1? " " : "s "));
         System.out.println(mowSeconds+" second"+(mowSeconds==1? " " : "s."));
   }
}	  
