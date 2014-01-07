
/**
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

Answer: 26033

@author Westy92
*/

public class Prob60 extends Euler
{
   public static void main(String args[])
   {
      startTiming();

      // generate primes
      int numPrimes = 1229; // 1229 primes < 10000
      int[] primes = new int[numPrimes];
      primes[0] = 2;
      int count = 1;
      for ( int i = 3; i < 10000; i += 2 )
         if ( isPrime(i) )
            primes[count++] = i;

      // generate pairs
      boolean[][] pairable = new boolean[10000][10000];
      for ( int i = 0; i < numPrimes; ++i )
         for ( int j = i + 1; j < numPrimes; ++j )
         {
            pairable[i][j] =
                  isPrime(concat(primes[i],primes[j])) &&
                  isPrime(concat(primes[j],primes[i]));
            pairable[j][i] = pairable[i][j];
         }

      loop:
      for ( int a = 0; a < 10000; ++a )
      for ( int b = 0; b < a; ++b ) if ( pairable[a][b] )
      for ( int c = 0; c < b; ++c ) if ( pairable[a][c] && pairable[b][c] )
      for ( int d = 0; d < c; ++d ) if ( pairable[a][d] && pairable[b][d] && pairable[c][d] )
      for ( int e = 0; e < d; ++e ) if ( pairable[a][e] && pairable[b][e] && pairable[c][e] && pairable[d][e] )
      {
         System.out.println(primes[a] + primes[b] + primes[c] + primes[d] + primes[e]);
         break loop;
      }

      stopTiming();
   }
}
