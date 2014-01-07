
import java.util.ArrayDeque;
import java.util.Deque;

/*
The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:

169 → 363601 → 1454 → 169
871 → 45361 → 871
872 → 45362 → 872

It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

69 → 363600 → 1454 → 169 → 363601 (→ 1454)
78 → 45360 → 871 → 45361 (→ 871)
540 → 145 (→ 145)

Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.

How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?

Answer: 402

@author Westy92
*/

public class Prob74 extends Euler
{
   
   static int[] fact = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
   static int[] terms = new int[7*362880];
   
   static int nonRepeatingTerms(int n) {
      int count = 0;
      //Stack s = new Stack(); // <- 2x slower than Deque...
      Deque<Integer> s = new ArrayDeque<Integer>();
      while ( terms[n] == 0 ) {
         s.push(n);
         count++;
         n = factSum(n);
      }
      int temp = terms[n] + 1;
      while ( !s.isEmpty() )
         terms[s.pop()] = temp++;
      return count + terms[n];
   }
   
   static int factSum(int n) {
      int sum = 0;
      while ( n > 0 ) {
         sum += fact[n % 10];
         n /= 10;
      }
      return sum;
   }
   
   public static void main(String[] args)
   {
      startTiming();
      terms[169] = terms[363601] = terms[1454] = 3;
      terms[871] = terms[872] = terms[45361] = terms[45362] = 2;
      terms[1] = terms[2] = terms[145] = terms[40585] =  1;
      int ans = 0;
      for ( int i = 3; i < 1000000; i++ )
         if ( nonRepeatingTerms(i) == 60 )
            ans++;
      System.out.println(ans);
      stopTiming();
   }
}