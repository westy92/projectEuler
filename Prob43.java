
import java.util.Arrays;

/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.

Answer: 16695334890

@author Westy92
*/

public class Prob43 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long sum = 0;
      int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      for ( int [] i = nextPermutation(a); !Arrays.equals(a, i); i = nextPermutation(i) )
         if ( isFancy(i) )
            sum += concatenateDigits(i);
      System.out.println(sum);
      stopTiming();
   }

   private static boolean isFancy(int[] d)
   {
      return 
            (100 * d[1] + 10 * d[2] + d[3]) % 2 == 0 &&
            (100 * d[2] + 10 * d[3] + d[4]) % 3 == 0 &&
            (100 * d[3] + 10 * d[4] + d[5]) % 5 == 0 &&
            (100 * d[4] + 10 * d[5] + d[6]) % 7 == 0 &&
            (100 * d[5] + 10 * d[6] + d[7]) % 11 == 0 &&
            (100 * d[6] + 10 * d[7] + d[8]) % 13 == 0 &&
            (100 * d[7] + 10 * d[8] + d[9]) % 17 == 0;
   }

   public static long concatenateDigits(int [] digits)
   {
      StringBuilder sb = new StringBuilder(digits.length);
      for (int digit : digits)
         sb.append(digit);
      return Long.parseLong(sb.toString());
   }

   /*
    * Transitions perm to the next lexigraphical permutation,
    * unless it is the last permutation, in which case it
    * resets to the first permutation.
    */
   private static int[] nextPermutation(int[] perm)
   {
      int [] temp = perm.clone();
      int n = temp.length;
      int k = -1;
      for ( int i = 1; i < n; i++ )
         if ( temp[i - 1] < temp[i] )
            k = i - 1;
      if ( k == -1 )
      {
          for ( int i = 0; i < n; i++ )
              temp[i] = i;
          return temp;
      }
      int l = k + 1;
      for ( int i = l; i < n; i++ )
         if ( temp[k] < temp[i] )
            l = i;

      int t = temp[k];
      temp[k] = temp[l];
      temp[l] = t;

      arrayReverse(temp, k + 1, n - (k + 1));

      return temp;
   }

   // Should be same as C# Array.Reverse(Array array, int index, int length);
   private static void arrayReverse(int [] array, int index, int length)
   {
      int num = index;
      int num2 = (index + length) - 1;
      while (num < num2)
      {
          int temp = array[num];
          array[num] = array[num2];
          array[num2] = temp;
          num++;
          num2--;
      }
   }
}
