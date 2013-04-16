/**
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

Answer: 142857

@author Westy92
*/

public class Prob52 extends Euler
{

   public static void main(String args[])
   {
      startTiming();
      int answer = 123456;
      while ( !( isPermutation(answer, answer*2) &&
                 isPermutation(answer, answer*3) &&
                 isPermutation(answer, answer*4) &&
                 isPermutation(answer, answer*5) &&
                 isPermutation(answer, answer*6) ) )
         answer++;
      System.out.println(answer);
      stopTiming();
   }
}
