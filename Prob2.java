/**
 * Each new term in the Fibonacci sequence is generated by adding the previous
 *    two terms. By starting with 1 and 2, the first 10 terms will be:
 *       1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
 *    ...By considering the terms in the Fibonacci sequence whose values do
 *    not exceed four million, find the sum of the even-valued terms.
 *
 * Answer: 4613732
 *
 * @author Westy92
 */

public class Prob2 extends Euler
{
   private static final int MAX = 4000000;
   public static void main(String args[])
   {
      startTiming();
      int sum = 0;
      int smaller = 1, bigger = 1, temp = 0;
      while (bigger < MAX)
      {
         temp = bigger;
         bigger += smaller;
         smaller = temp;
         if (bigger % 2 == 0)
            sum += bigger;
      }
      
      System.out.println(sum);
      stopTiming();
   }
}
