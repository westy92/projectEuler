
import java.math.BigInteger;

/*
The square root of 2 can be written as an infinite continued fraction.

2 = 1 +
1

 	2 +
1

 	 	2 +
1

 	 	 	2 +
1

 	 	 	 	2 + ...
The infinite continued fraction can be written, 2 = [1;(2)], (2) indicates that 2 repeats ad infinitum. In a similar way, 23 = [4;(1,3,1,8)].

It turns out that the sequence of partial values of continued fractions for square roots provide the best rational approximations. Let us consider the convergents for 2.

1 +
1

= 3/2

2

1 +
1

= 7/5
 	2 +
1


2

1 +
1

= 17/12
 	2 +
1


 	 	2 +
1



2

1 +
1

= 41/29
 	2 +
1

 	 	2 +
1


 	 	 	2 +
1



2

Hence the sequence of the first ten convergents for 2 are:

1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
What is most surprising is that the important mathematical constant,
e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].

The first ten terms in the sequence of convergents for e are:

2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.

Answer: 272

@author Westy92
*/

public class Prob65 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long digitSum = 0;
      String digits = getNumerator(100).toString();
      for ( int i = 0; i < digits.length(); i++ )
         digitSum += digits.charAt(i) - '0';
      System.out.println(digitSum);
      stopTiming();
   }

   private static BigInteger getNumerator(int n)
   {
      BigInteger prevNumerator = BigInteger.ONE;
      BigInteger numerator = BigInteger.valueOf(2);
      int factor = 2;
      int count = 2;
      BigInteger temp;
      for ( int i = 1; i < n; i++ )
      {
         if ( count++ == 3 )
         {
            // temp = prevNumerator + (factor * numerator);
            temp = prevNumerator.add(numerator.multiply(BigInteger.valueOf(factor)));
            factor += 2;
            prevNumerator = numerator;
            numerator = temp;
            count = 1;
         }
         else
         {
            temp = prevNumerator.add(numerator);
            prevNumerator = numerator;
            numerator = temp;
         }
      }

      return numerator;
   }


}
