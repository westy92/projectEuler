/*
The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28. In fact, there are exactly four numbers below fifty that can be expressed in such a way:

28 = 2^2 + 2^3 + 2^4
33 = 3^2 + 2^3 + 2^4
49 = 5^2 + 2^3 + 2^4
47 = 2^2 + 3^3 + 2^4

How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?

Answer: 1097343

@author Westy92
*/

public class Prob87 extends Euler
{
   public static void main(String[] args)
   {      
      startTiming();
      int max = 50000000;
      boolean[] used = new boolean[max];
      int[] squares = new int[1000];
      int[] cubes = new int[1000];
      int[] fours = new int[1000];
      int count = 0, numSquares = 0, numCubes = 0, numFours = 0;
      for ( int i = 2; i <= 7071; i++ ) { // 50,000,000^(1/2)
         if ( isPrime(i) ) {
            squares[numSquares++] = i*i;
            if ( i <= 368 ) { // 50,000,000^(1/3)
               cubes[numCubes++] = squares[numSquares - 1]*i;
               if ( i <= 84 ) { // 50,000,000^(1/4)
                  fours[numFours++] = cubes[numCubes - 1]*i;
               }
            }
         }
      }

      for ( int i = 0; i < numSquares; i++ ) {
         for ( int j = 0; j < numCubes; j++ ) {
            if ( squares[i] + cubes[j] > max )
               break;
            for ( int k = 0; k < numFours; k++ ) {
               int temp = squares[i] + cubes[j] + fours[k];
               if ( temp > max )
                  break;
               if ( used[temp] )
                  continue;
               used[temp] = true;
               count++;
            }
         }
      }
      
      System.out.println(count);
      stopTiming();
   }

}