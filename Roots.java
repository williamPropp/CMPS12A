//Roots.java
//William Propp
//wpropp
//pa4
//a real roots calculator for polynomials in a specified range

import java.util.Scanner
class Roots{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      double tolerance = Math.pow(10, -11), threshold = Math.pow(10, -3), root;

      System.out.println("Enter the degree:");
      int degree = sc.nextInt();
      double coefs[] = new double[degree+1];
      System.out.println("Enter "+(degree+1)+" coefficients:");
      for(int i = 0 ; i < coefs.length ; i++){
         coefs[i] = sc.nextDouble;
      }
      double deriv[] = diff(coefs[]);
      while(TRUE){
         System.out.println("Enter endpoints, or q to quit:")
         if(sc.hasNextDouble()){
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            findRoot(deriv[], a, b, tolerance);
         } else if(sc.hasNextChar()){
            char temp = sc.nextChar();
            if(temp == "q" || temp == "Q"){
               System.out.println("bye!");
               break;
            }
         }
         if((poly(coefs, a)>0 && poly(coefs, b)<0) || (poly(coefs, a)<0 && poly(coefs, b)>0)){
            root = findRoot(coefs, a, b, tolerance);
            System.out.println("   Odd root found in ["+a+", "+b+"] found at: %.10f%n"+root);
         } else if((poly(deriv, a)>0 && poly(deriv, b)<0) || (poly(deriv, a)<0 && poly(deriv, b)>0)){
            root = findRoot(deriv, a, b, tolerance);
            System.out.println("   Even root found in ["+a+", "+b+"] found at: %.10f%n",root);
         } else {
            System.out.println("   No root found in ["+a+", "+b+"]");
         }
      } 
   }

   static double poly(double[] C, double x){
      double poly = 0;
      for(int i = 0 ; i < C.length ; i++){
         poly += C[i]*(Math.pow(x, i));
      }
      return poly;
   }

   static double[] diff(double[] C){
      double deriv[] = new double[C.length]
      for(int i = 1 ; i < C.length ; i++){
         deriv[i] = C[i]*(i);
      }
      return deriv[];
   }

   static double findRoot(double[] C, double a, double b, double tolerance){
      double foundRoot = 0;
         while(Math.abs(a-b)>=tolerance){
         	foundRoot = (a+b)/2
            if((poly(C, a)*poly(C, foundRoot)<=0) ){
               b = foundRoot;
            } else {
               a = foundRoot;
            }
         }
      return foundRoot;
   } 
}