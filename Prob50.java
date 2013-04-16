/**
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

Answer: 997651

@author Westy92
*/

public class Prob50 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      int answer = 0;
      int answerTerms = 0;

      // Calculate first 1000 primes
      int primes [] = new int[1000];
      primes[0] = 2;
      int primeCount = 1;
      for ( int i = 3; primeCount < primes.length; i += 2 )
         if ( isPrime(i) )
            primes[primeCount++] = i;

      for ( int i = 0; i < 5; ++i ) // offset to start at
      {
         int sum = 0;
         int j;
         for ( j = 0; sum + primes[i+j] < 1000000; ++j )
            sum += primes[i+j];
         if ( isPrime(sum) && j > answerTerms )
         {
            answer = sum;
            answerTerms = j;
         }
      }
      System.out.println(answer);
      stopTiming();
   }
}
