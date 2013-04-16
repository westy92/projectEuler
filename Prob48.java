/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.


Answer: 9110846700

@author Westy92
*/

public class Prob48 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long solution = 0;
      long mod = 10000000000L; // need last 10 digits (10^10).
      for ( int i = 1; i <= 1000; ++i )
      {
         long temp = i;
         for ( int j = 1; j < i; ++j )
            temp = (temp * i) % mod;
         solution = (solution + temp) % mod;
      }
      System.out.println(solution);
      stopTiming();
   }
}
