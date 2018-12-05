//Complex.java
//William Propp
//wpropp
//pa6
//Represents complex numbers as a pair of doubles

import java.util.Scanner;
class Complex{

   //--------------------------------------------------------------------------
   // Private Data Fields 
   //--------------------------------------------------------------------------
   private double re;
   private double im;
   
   //--------------------------------------------------------------------------
   // Public Constant Fields 
   //--------------------------------------------------------------------------
   public static final Complex ONE = Complex.valueOf(1,0);
   public static final Complex ZERO = Complex.valueOf(0,0);
   public static final Complex I = Complex.valueOf(0,1);

   //--------------------------------------------------------------------------
   // Constructors 
   //--------------------------------------------------------------------------
   Complex(double a, double b){
      this.re = a;
      this.im = b;
   }

   Complex(double a){
      this.re = a;
      this.im = 0;
   }

   Complex(String s){
      double[] part = new double[2];
      String str = s.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      this.re = part[0];
      this.im = part[1];
   }

   //---------------------------------------------------------------------------
   // Public methods 
   //---------------------------------------------------------------------------

   // Complex arithmetic -------------------------------------------------------

   // copy()
   // Return a new Complex equal to this Complex
   Complex copy(){
      return new Complex(re, im);
   }
   
   // add()
   // Return a new Complex representing the sum this plus z.
   Complex add(Complex z){
      double reNew, imNew;
      reNew = this.re + z.re;
      imNew = this.im + z.im;
      return new Complex(reNew, imNew);
   }
   
   // negate()
   // Return a new Complex representing the negative of this.
   Complex negate(){
      double reNeg, imNeg;
      reNeg = -this.re;
      imNeg = -this.im;
      return new Complex(reNeg, imNeg);
   }

   // sub()
   // Return a new Complex representing the difference this minus z.
   Complex sub(Complex z){
      double reNew, imNew;
      reNew = this.re - z.re;
      imNew = this.im - z.im;
      return new Complex(reNew, imNew);
   }

   // mult()
   // Return a new Complex representing the product this times z.
   Complex mult(Complex z){
      double reNew, imNew;
      reNew = this.re * z.re;
      imNew = this.im * z.im;
      return new Complex(reNew, imNew);
   }

   // recip()
   // Return a new Complex representing the reciprocal of this.
   // Throw an ArithmeticException with appropriate message if 
   // this.equals(Complex.ZERO).
   Complex recip(){
      double div;
      div = (this.re * re) + (this.im * im);
      if(this.equals(Complex.ZERO)){
         throw new ArithmeticException("Cannot devide by zero.");
      } else {
         return new Complex(re/div, -im/div);
      }
   }

   // div()
   // Return a new Complex representing the quotient of this by z.
   // Throw an ArithmeticException with appropriate message if 
   // z.equals(Complex.ZERO).
   Complex div(Complex z){
      if(z.equals(Complex.ZERO)){
         throw new ArithmeticException("Cannot devide by zero.");
      } else {
         return new Complex(re/z.re, im/z.im);
      }
   }

   // conj()
   // Return a new Complex representing the conjugate of this Complex.
   Complex conj(){
      return new Complex(re, -im);
   }
   
   // Re()
   // Return the real part of this.
   double Re(){
      return re;
   }

   // Im()
   // Return the imaginary part of this.
   double Im(){
      return im;
   }

   // abs()
   // Return the modulus of this Complex, i.e. the distance between 
   // points (0, 0) and (re, im).
   double abs(){
      double dist;
      dist = Math.sqrt(Math.pow(re, 2)+Math.pow(im, 2));
      return dist;
   }

   // arg()
   // Return the argument of this Complex, i.e. the angle this Complex
   // makes with positive real axis.
   double arg(){
      return Math.atan2(im, re);
   }

   // Other functions ---------------------------------------------------------
   
   // toString()
   // Return a String representation of this Complex. The real and imaginary
   // parts will be rounded to 8 decimal places, and trailing zeros will be
   // truncated from the two parts. The String returned will be readable by 
   // the constructor Complex(String s)
   public String toString(){
      if(im == 0){
         return re + "";
      }else if(re == 0){
         return im + "i";
      }else if(im < 0){
         return re + "-" + Math.abs(im) + "i";
      }else if(re < 0){
         return "-" + Math.abs(re) + "+" + im + "i";
      }return re + "+" + im + "i";
   }

   // equals()
   // Return true iff this and obj have the same real and imaginary parts.
   public boolean equals(Object obj){
      boolean equals = false;
      Complex x;
      if(obj instanceof Complex){
          x = (Complex) obj;
          if(this.re == x.re&& this.im == x.im){
             equals = true;
          }
      }return equals;
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part b.
   static Complex valueOf(double a, double b){
      return new Complex(a, b);
   }

   // valueOf()
   // Return a new Complex with real part a and imaginary part 0.
   static Complex valueOf(double a){
      return new Complex(a, 0);
   }

   // valueOf()
   // Return a new Complex constructed from s.
   static Complex valueOf(String s){
      return new Complex(s);
   }
}
