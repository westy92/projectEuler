/*

Private helper methods for Project Euler problems.
There are multiple versions as needed since int is faster than long.

@author Westy92

Java:
   double Math.pow(double base, double exp);
   double Math.log(double a); // base e
   double Math.sqrt(double a);

C++: #include <math.h>
   double pow(double base, int/double exp);
   double log(double a); // base e
   double sqrt(double a);
*/

public class Euler 
{
   private static long startTime;
   static void startTiming()
   {
      startTime = System.nanoTime();
   }

   static void stopTiming()
   {
      System.out.println("Elapsed "+(System.nanoTime() - startTime)/1000000.0+" milliseconds.");
   }

   static boolean isAbundant(int num)
   {
      return divisorSum(num) > num;
   }

   static boolean isAbundant(long num)
   {
      return divisorSum(num) > num;
   }
   
   static boolean isAmicable(int n)
   {
      int sum = divisorSum(n);
      return sum != n && n == divisorSum(sum);
   }

   static boolean isAmicable(long n)
   {
      long sum = divisorSum(n);
      return sum != n && n == divisorSum(sum);
   }

   static int binomial(int n, int r) // "n choose r"
   {
      int t = 1;
      int m = n - r;
      if  (r < m )
         r = m;
      for ( int i = n, j = 1; i > r; i--, ++j )
         t = t * i / j;
      return t;
   }

   static long binomial(long n, long r) // "n choose r"
   {
      long t = 1;
      long m = n - r;
      if ( r < m )
         r = m;
      for ( long i = n, j = 1; i > r; i--, ++j )
         t = t * i / j;
      return t;
   }

   static int distinctPrimeFactors(int n)
   {
      int count = 0;
      if ( n % 2 == 0 )
         count++;
      while ( n % 2 == 0 )
         n /= 2;
      for ( int i = 3; i*i <= n; i += 2 )
      {
         if ( n % i == 0 && isPrime(i) )
            count++;
         while ( n % i == 0 )
            n /= i;
      }
      if ( count > 0 && n > 1 )
         count++;
      return count;
   }

   static int distinctPrimeFactors(long n)
   {
      int count = 0;
      if ( n % 2 == 0 )
         count++;
      while ( n % 2 == 0 )
         n /= 2;
      for ( int i = 3; i*i <= n; i += 2 )
      {
         if ( n % i == 0 && isPrime(i) )
            count++;
         while ( n % i == 0 )
            n /= i;
      }
      if ( count > 0 && n > 1 )
         count++;
      return count;
   }

   static long factorial(int n)
   {
       long result = 1;
       while ( n > 0 )
           result *= n--;
       return result;
   }

   static int gcd(int a, int b)
   {
      if ( a < 0 )
         a = -a;
      if ( b < 0 )
         b = -b;
      while ( b > 0 )
      {
         int c = a % b;
         a = b;
         b = c;
      }
      return a;
   }

   static long gcd(long a, long b)
   {
      if ( a < 0 )
         a = -a;
      if ( b < 0 )
         b = -b;
      while ( b > 0 )
      {
         long c = a % b;
         a = b;
         b = c;
      }
      return a;
   }

   static boolean isCircularPrime(int i)
   {
      if ( !isPrime(i) )
         return false;
      int len = numLength(i, 10);
      int multiplier = (int)Math.pow(10.0, (double)len-1);
      int n = i;
      for ( int j = 1; j < len; j++ )
      {
         long r = n % 10;
         n /= 10;
         n += multiplier * r;
         if ( !isPrime(n) )
            return false;
      }
      return true;
   }

   static boolean isCircularPrime(long i)
   {
      if ( !isPrime(i) )
         return false;
      int len = numLength(i, 10);
      int multiplier = (int)Math.pow(10.0, (double)len-1);
      long n = i;
      for ( int j = 1; j < len; j++ )
      {
         long r = n % 10;
         n /= 10;
         n += multiplier * r;
         if ( !isPrime(n) )
            return false;
      }
      return true;
   }

   static boolean isPalindrome(int n, int base)
   {
      int reversed = 0;
      int k = n;
      while ( k > 0 )
      {
         reversed = base * reversed + k % base;
         k /= base;
      }
      return n == reversed;
   }

   static boolean isPrime(int n)
   {
      if ( n < 2 )
         return false;
      if ( n == 2 || n == 3 )
         return true;
      if ( n % 2 == 0 || n % 3 == 0 )
         return false;
      int sqrtN = (int)Math.sqrt(n)+1;
      for ( int i = 6; i <= sqrtN; i += 6 )
        if ( n % (i - 1) == 0 || n % (i + 1) == 0 )
           return false;
      return true;
   }

   static boolean isPrime(long n)
   {
      if ( n < 2 )
         return false;
      if ( n == 2 || n == 3 )
         return true;
      if ( n % 2 == 0 || n % 3 == 0 )
         return false;
      long sqrtN = (long)Math.sqrt(n)+1;
      for ( long i = 6; i <= sqrtN; i += 6 )
        if ( n % (i - 1) == 0 || n % (i + 1) == 0 )
           return false;
      return true;
   }

   static int numLength(int num, int base)
   {
      if ( num > 0 )
         return (int)(Math.log(num) / Math.log(base)) + 1;
      return 1;
   }

   static int numLength(long num, int base)
   {
      if ( num > 0 )
         return (int)(Math.log(num) / Math.log(base)) + 1;
      return 1;
   }

   static int pentagonal(int n)
   {
      return n * (3 * n - 1) >> 1;
   }

   static long pentagonal(long n)
   {
      return n * (3 * n - 1) >> 1;
   }

   static boolean isPentagonal(int n)
   {
      double test = (Math.sqrt(1 + 24 * n) + 1) / 6;
      return test == (int)test;
   }

   static boolean isPentagonal(long n)
   {
      double test = (Math.sqrt(1 + 24 * n) + 1) / 6;
      return test == (int)test;
   }

   static int triangular(int n)
   {
      return n * (n + 1) >> 1;
   }

   static long triangular(long n)
   {
      return n * (n + 1) >> 1;
   }

   static boolean isTriangular(int n)
   {
      double sqrt = Math.sqrt((n << 3) + 1);
      return sqrt == (int)sqrt;
   }

   static boolean isTriangular(long n)
   {
      double sqrt = Math.sqrt((n << 3) + 1);
      return sqrt == (int)sqrt;
   }

   static int hexagonal(int n)
   {
      return n * ((n << 1) - 1);
   }

   static long hexagonal(long n)
   {
      return n * ((n << 1) - 1);
   }

   static boolean isHexagonal(int n)
   {
      double test = (Math.sqrt(1 + (n << 3)) + 1) / 4;
      return test == (int)test;
   }

   static boolean isHexagonal(long n)
   {
      double test = (Math.sqrt(1 + (n << 3)) + 1) / 4;
      return test == (int)test;
   }

   static boolean isPandigital(String s)
   {
      for ( int i = 1; i <= s.length(); ++i )
         if ( !s.contains(i + "") )
            return false;
      return true;
   }

   static boolean isPandigital(int n)
   {
      return isPandigital(Integer.toString(n));
   }

   static boolean isPandigital(long n)
   {
      return isPandigital(Long.toString(n));
   }

   static boolean isPermutation(int a, int b) // counts digit occurrences
   {
      byte[] c = new byte[10];
      while ( a > 0 )
      {
         c[a%10]++;
         a /= 10;
      }
      while ( b > 0 )
      {
         c[b%10]--;
         b /= 10;
      }
      boolean res = true;
      for ( int i = 0; i < 10; ++i )
         res &= c[i] == 0;
      return res;
   }

   static int numberOfDivisors(int number)
   {
       int divisors = 0;
       for ( int i = 1; i*i <= number; i++ )
           if ( number % i == 0 )
               divisors += 2;
       //Correction if the number is a perfect square
       int sqrt = (int)Math.sqrt(number);
       if ( sqrt * sqrt == number )
           divisors--;

       return divisors;
   }

   static int numberOfDivisors(long number)
   {
       int divisors = 0;
       for ( int i = 1; i*i <= number; i++ )
           if ( number % i == 0 )
               divisors += 2;
       //Correction if the number is a perfect square
       int sqrt = (int)Math.sqrt(number);
       if ( sqrt * sqrt == number )
           divisors--;

       return divisors;
   }
   
   static int divisorSum(int a)
   {
      int sum = 1;
      for (int k = 2; k*k <= a; ++k)
      {
         if (k*k == a)
            sum += k;
         else if (a % k == 0)
            sum += k + (a/k);
      }
      return sum;
   }

   static long divisorSum(long a)
   {
      long sum = 1;
      for (int k = 2; k*k <= a; ++k)
      {
         if (k*k == a)
            sum += k;
         else if (a % k == 0)
            sum += k + (a/k);
      }
      return sum;
   }
}
