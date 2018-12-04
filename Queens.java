//Queens.java
//William Propp
//wpropp
//pa5
//an n-Queens problem solution finder

import.java.util Scanner
class Queens{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int numArgs = args.length, n, numSolutions;
      boolean verbose = false;
      for(int i=0 ; i<n ; i++){
         try{
            n = Integer.parseInteger(args[i])
            break;
         }catch(NumberFormatException e1){
            try{
               String v = String.parseString(args[i]);
               if(v != "-v"){
                  System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
                  break;
               }
            }catch(NumberFormatException e2){
               System.out.println("Usage: Queens [-v] number\nOption: -v verbose output, print all solutions");
            }
         }
      }
      int[] perm1 = new int[n+1]
      for(int j = 1 ; j<=n ; j++){
         perm1[j] = j;
      }
   }
   static void nextPermutation(int[] A){
      for(int x = A.length-1 ; x>=1 ; x--){
         int pivot, temp;
         if(A[x-1]<A[x]){
         	pivot = x-1
            temp = A[x];
            A[x] = A[x-1];
            A[x-1] = temp;
         }

      }
   }
   static boolean isSolution(int[] A){
      for(int y = 1 ; y<A.length ; y++){
         for(int z = y+1 ; z<=A.length ; z++){
         	if(Math.abs(A[y]-A[z]) == Math.abs(y-z)){
         	   return false;
         	}
         }
      }
      return true;
   }
}