// GCD.java
// William Propp
// wpropp
// pa3
// Greatest Common Divisor Calculator

import java.util.Scanner; public class GCD{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int int1, int2, div, remPrev, remNew, gcd;
      System.out.print("Enter a positive integer: ");
      while(true){
         while(!sc.hasNextInt()){
            sc.next();
            System.out.print("Please enter a positive integer: ");
         }
         int1 = sc.nextInt();
         if(int1  > 0){
            break;
         }
         System.out.print("Please enter a positive integer: ");
      }
      System.out.print("Enter another positive integer: ");
      while(true){
         while(!sc.hasNextInt()){
            sc.next();
            System.out.print("Please enter a positive integer: ");
         } 
         int2 = sc.nextInt();
         if(int2 > 0){
            break;
         }
         System.out.print("Please enter a positive integer: ");
      }
      while(true){
         if(int1 > int2){
            remPrev = int2;
            div  = int1;
         } else{
            remPrev = int1;
            div = int2;
         }
         while(true){
            remNew = remPrev%div;
            if(remNew == 0){
               gcd = div;
               break;
            }
            remPrev = div;
            div = remNew;
         }
         System.out.println("The GCD of "+int1+" and "+int2+" is "+gcd);
         break;
      }   
   }
}
