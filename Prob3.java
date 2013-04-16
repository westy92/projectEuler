/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Answer: 6857
 *
 * @author Westy92
 */

public class Prob3 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      long MAGIC_NUM = 600851475143L;
      int i;
      for ( i = 2; i < MAGIC_NUM; ++i )
         if ( MAGIC_NUM % i == 0 )
            MAGIC_NUM /= i;
      System.out.println(i);
      stopTiming();
   }
}
