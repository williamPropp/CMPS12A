//Roots.java
//William Propp
//wpropp
//pa4
//a real roots calculator for polynomials in a specified range

import java.util.Scanner;
class Roots{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      double tolerance = Math.pow(10, -11), threshold = Math.pow(10, -3), a = 0, b = 0, root;
      char temp;

      System.out.println("Enter the degree:");
      int degree = sc.nextInt();
      double coefs[] = new double[degree+1];
      System.out.println("Enter "+(degree+1)+" coefficients:");
      for(int i = 0 ; i < coefs.length ; i++){
         coefs[i] = sc.nextDouble();
      }
      double deriv[] = diff(coefs);
      while(true){
         System.out.println("Enter endpoints, or q to quit:");
         if(sc.hasNextDouble()){
            a = sc.nextDouble();
            b = sc.nextDouble();
         } else {
            temp = sc.next().charAt(0);
            if(temp == 'q' || temp == 'Q'){
               System.out.println("bye!");
               break;
            }
         }
         if((poly(coefs, a)*poly(coefs, b))<=0){
            root = findRoot(coefs, a, b, tolerance);
            System.out.print("   Odd root found in ["+a+", "+b+"] found at: ");
            System.out.printf("%.10f%n", root);
         } else if((poly(deriv, a)>0 && poly(deriv, b)<0) || (poly(deriv, a)<0 && poly(deriv, b)>0)){
            root = findRoot(deriv, a, b, tolerance);
            if(Math.abs(poly(deriv, root)) < threshold){
               System.out.print("   Even root found in ["+a+", "+b+"] found at: ");
               System.out.printf("%.10f%n", root);
            }
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
      double deriv[] = new double[C.length];
      for(int i = 1 ; i < C.length ; i++){
         deriv[i] = C[i]*(i);
      }
      return deriv;
   }

   static double findRoot(double[] C, double a, double b, double tolerance){
      double foundRoot = 0;
         while(Math.abs(a-b)>=tolerance){
         	foundRoot = (a+b)/2;
            if((poly(C, a)*poly(C, foundRoot))<=0){
               b = foundRoot;
            } else {
               a = foundRoot;
            }
         }
      return foundRoot;
   } 
}
