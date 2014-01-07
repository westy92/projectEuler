/*
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that there are 3 fractions between 1/3 and 1/2.

How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?

Answer: 7295372

Note: Farey sequence of order n is the sequence of reduced fractions between 0
      and 1 which have denominators less than or equal to n, arranged in order
      of increasing size.
      A median fraction between n1/d1 and n2/d2 is (n1+n2)/(d1+d2).

@author Westy92
*/

public class Prob73 extends Euler
{
   public static void main(String[] args)
   {      
      startTiming();
      System.out.println(between(1,2, 1,3, 12000));
      stopTiming();
   }
   
   static int between(int n1, int d1, int n2, int d2, int maxd) {
      if ( d1 + d2 > maxd )
         return 0;
      return 1 + between(n1, d1, n1 + n2, d1 + d2, maxd)
               + between(n1 + n2, d1 + d2, n2, d2, maxd);
   }

}