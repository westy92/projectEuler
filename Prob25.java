/**
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?


Answer: 4782

@author Westy92
*/

public class Prob25 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      System.out.println(findFibonacciOfDigit(1000));
      stopTiming();
   }

   // returns the number of the first term with the given number of digits
	private static int findFibonacciOfDigit(int digits)
   {
		int[] a = new int[digits];
		int[] b = new int[digits];
		int[] fib = new int[digits];

		// initialize
      // Note: values are stored in "reverse."  1 = {1, 0, ..., 0}.
		a[0] = 1;
		b[0] = 1;

		int term = 2;
		boolean termFound = false;

		while (!termFound)
      {
			fib = addBigNumbers(a,b);
			a = b;
			b = fib;
			if ( fib[digits-1] > 0 )
				termFound = true;

			term++;
		}

		return term;
	}

	// last digit is lost,if sum exceeds range
   // Note: values are stored in "reverse."  1 = {1, 0, ..., 0}.
	private static int[] addBigNumbers(int[] a, int[] b)
   {
		int[] result = new int[a.length];
		int rem = 0;
		for ( int i = 0; i < a.length; ++i )
      {
			int res = a[i] + b[i] + rem;
			rem = res/10;
			res = res%10;
			result[i] = res;
		}
		return result;
	}

   /*
   // Only fits up to 92nd in a long.
   // fib n = [((1+√5)/2)ⁿ- ((1-√5)/2)ⁿ]/√5
   private static long getFib(int term)
   {
      final double GOLDEN_RATIO = 1.618033988749895;
      final double SQRT_5 = 2.23606797749979;
      return (long)((Math.pow(GOLDEN_RATIO, (double)term) - Math.pow(1.0 - GOLDEN_RATIO, (double)term)) / SQRT_5);
   }
   */
}
