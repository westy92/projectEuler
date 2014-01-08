/*
It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.

120 cm: (30,40,50), (20,48,52), (24,45,51)

Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?

Answer: 161667

Note: I used Euclid's formula to generate Pythagorean triples.
      With integers m > n: a = m^2 - n^2, b = 2mn, c = m^2 + n^2.
      They are primative if m and n are coprime and m − n is odd.
      Multiply primative triples by constants to find all of them.
      Since we are finding a + b + c, we can write that as:
      (m^2 - n^2) + (2mn) + (m^2 + n^2) = 2m(m + n).
      To find the limit for my outer loop:
      2m(m + n)      <= 1,500,000
      4n^2 + 6n + 2  <= 1,500,000
      n              <  612.

@author Westy92
*/

public class Prob75 extends Euler
{
   public static void main(String[] args)
   {      
      startTiming();
      int max = 1500000, count = 0;
      short[] len = new short[max + 1]; // 1,500,000 / 120 = 12,500 < 32,767.
      for ( int n = 1; n <= 612; n++ ) {
         for ( int m = n + 1; true; m += 2 ) { // m - n is odd
            if ( gcd(m, n) != 1 ) // not primitive triple
               continue;
            int temp = 2 * m * (m + n);
            if ( temp > max )
               break;
            for ( int i = 1; i*temp <= max; i++ )
               len[i*temp]++;
         }
      }

      for ( int i = 0; i <= max; i++ )
         if ( len[i] == 1 )
            count++;

      System.out.println(count);
      stopTiming();
   }
}