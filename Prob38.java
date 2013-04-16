/*
Take the number 192 and multiply it by each of 1, 2, and 3:

192  1 = 192
192  2 = 384
192  3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

Answer: 932718654

Note: The candidate starting number must be in the 9[0-9][0-9][0-9] series.

@author Westy92
*/

public class Prob38 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long max = 0;
      for ( int i = 9000; i < 9999; i++ )
      {
         StringBuilder answers = new StringBuilder();
         for ( int j = 1; answers.length() < 9; j++ )
            answers.append(i*j);
         String answer = answers.toString();
         if ( answer.length() == 9 && isPandigital(answer) )
         {
            long temp = Integer.parseInt(answers.toString());
            if ( temp > max )
               max = temp;
         }
      }
      System.out.println("Max: "+max);
      stopTiming();
   }
}
