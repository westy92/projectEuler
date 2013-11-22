/*
The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

How many n-digit positive integers exist which are also an nth power?

Answer: 49

Note: You know that x^n has n digits when 10^(n-1) <= x^n < 10^n
10^(n-1)=x^n => 0.1*10^n=x^n => log(0.1)+n*log(10)=n*log(x) 
=> log(10)=n*(log(10)-log(x)) => n=log(10)/(log(10)-log(x))
=> n = 1/(1-log10(x))

@author Westy92
*/

public class Prob63 extends Euler
{
   public static void main(String args[])
   {
      startTiming();

      int sum = 0;
      for ( int i = 1; i < 10; i++ )
          sum += (int)(1.0 / (1 - Math.log10(i)));
      System.out.println(sum);

      stopTiming();
   }
}
