//Roots.java
//William Propp
//wpropp
//pa4
//a real roots calculator for polynomials in a specified range

import.java.util Scanner
class Roots{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      double tolerance = 0.00000000001, threshold = 0.001; 
      System.out.println("Enter the degree: ");
      int degree = sc.nextDouble();
      double poly[] = new double[degree+1];
      System.out.println("Enter "+(degree+1)+" coefficients: ");
      for(int i = 1 ; i <= poly.length ; i++){
         poly[i] = sc.nextDouble;
      }
      diff(poly[]);
      while(TRUE){
         if(sc.hasNextDouble()){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            break;
         } else if(sc.hasNextChar()){
            char temp = sc.nextChar();
            if(temp == "q" || temp == "Q"){
               System.out.println("bye!");
               break;
            }
         }
      }
   }
   static double poly(double[] C, double x){

   }
   static double[] diff(double[] C){
      double deriv[] = new double[C.length]
      for(int i = 1 ; i <= C.length){
         deriv[i] = C[i]*i;
      }
   }
   static double findRoot(double[] C, double a, double b, double tolerance){

   } 
}