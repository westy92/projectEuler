/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


Answer: 2783915460

@author Westy92
*/

public class Prob24 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      for ( int i = 1; i < 1000000; ++i )
         nextPermutation(a);
      System.out.println(concatenateDigits(a));
      stopTiming();
   }

   public static String concatenateDigits(int [] digits)
   {
      StringBuilder sb = new StringBuilder(digits.length);
      for (int digit : digits)
         sb.append(digit);
      return sb.toString();
   }

   /*
    * Transitions perm to the next lexigraphical permutation, 
    * unless it is the last permutation, in which case it
    * resets to the first permutation.
    */
   static private void nextPermutation(int[] perm)
   {
      int n = perm.length;
      int k = -1;
      for ( int i = 1; i < n; i++ )
         if ( perm[i - 1] < perm[i] )
            k = i - 1;
      if ( k == -1 )
      {
          for ( int i = 0; i < n; i++ )
              perm[i] = i;
          return;
      }
      int l = k + 1;
      for ( int i = l; i < n; i++ )
         if ( perm[k] < perm[i] )
            l = i;

      int t = perm[k];
      perm[k] = perm[l];
      perm[l] = t;

      arrayReverse(perm, k + 1, perm.length - (k + 1));
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
