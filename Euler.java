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
      long end = System.nanoTime();
      System.out.println("Elapsed "+(end - startTime)/1000000.0+" milliseconds.");
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

   static int concat(int a, int b)
   {
      int zeros = digits(b, 10);
      while ( zeros-- > 0 )
         a *= 10;
      return a + b;
   }

   static long concat(long a, long b)
   {
      int zeros = digits(b, 10);
      while ( zeros-- > 0 )
         a *= 10;
      return a + b;
   }

   static int digits(int num, int base)
   {
      int len = 0;
      if ( num < 0 )
         num = -num;
      if ( num == 0 )
         return 1;
      while ( num > 0 )
      {
         num /= base;
         ++len;
      }
      return len;
   }

   static int digits(long num, int base)
   {
      int len = 0;
      if ( num < 0 )
         num = -num;
      if ( num == 0 )
         return 1;
      while ( num > 0 )
      {
         num /= base;
         ++len;
      }
      return len;
   }

   static int digitSum(int n)
   {
      int sum = 0;
      while ( n > 0 )
      {
         sum += n % 10;
         n /= 10;
      }
      return sum;
   }

   static int digitSum(long n)
   {
      int sum = 0;
      while ( n > 0 )
      {
         sum += n % 10;
         n /= 10;
      }
      return sum;
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
      int len = digits(i, 10);
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
      int len = digits(i, 10);
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

   static boolean isHeptagonal(int n)
   {
      double test = (Math.sqrt(9 + 40 * n) + 3) / 10;
      return test == (int)test;
   }

   static boolean isOctagonal(int n)
   {
      double test = (Math.sqrt(1 + 3 * n) + 1) / 3;
      return test == (int)test;
   }

   static boolean isNgonal(int N, int n) // (3,n) for triangular, etc.
   {
      double test = (Math.sqrt(((8*N-16)*n)+(N-4)*(N-4))+N-4) / (2*N-4);
      return test == (int)test;
   }

   static int reverse(int n, int base)
   {
      int reversed = 0;
      while ( n > 0 )
      {
         reversed = base * reversed + n % base;
         n /= base;
      }
      return reversed;
   }

   static long reverse(long n, int base)
   {
      long reversed = 0;
      while ( n > 0 )
      {
         reversed = base * reversed + n % base;
         n /= base;
      }
      return reversed;
   }

   static boolean isPalindrome(int n, int base)
   {
      return n == reverse(n, base);
   }

   static boolean isPalindrome(long n, int base)
   {
      return n == reverse(n, base);
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

   static boolean isSquare(int n)
   {
      int h = n & 0xF; // last hexidecimal "digit"
      if ( h > 9 )
         return false; // return immediately in 6 cases out of 16.

       // Take advantage of Boolean short-circuit evaluation
      if ( h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8 )
      {
         int t = (int)(Math.sqrt((double) n) + 0.5);
         return t*t == n;
      }
      return false;
   }

   static int max(int a, int b)
   {
      if ( a > b )
         return a;
      return b;
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
   
   static int relativePrimes(int n) {
      double primes = n;
      if ( n % 2 == 0 ) {
         primes *= (1.-(1./2));
         while ( n % 2 == 0 )
            n /= 2;
      }
      for ( int i = 3; i*i <= n; i += 2 ) {
         if ( n % i == 0 && isPrime(i) ) {
            primes *= (1.-(1./i));
            while ( n % i == 0 )
               n /= i;
         }
      }
      if ( n > 1 )
         primes *= (1.-(1./n));
      return (int)primes;
   }
   
   static int relativePrimes(long n) {
      double primes = n;
      if ( n % 2 == 0 ) {
         primes *= (1.-(1./2));
         while ( n % 2 == 0 )
            n /= 2;
      }
      for ( long i = 3; i*i <= n; i += 2 ) {
         if ( n % i == 0 && isPrime(i) ) {
            primes *= (1.-(1./i));
            while ( n % i == 0 )
               n /= i;
         }
      }
      if ( n > 1 )
         primes *= (1.-(1./n));
      return (int)primes;
   }
   
   static double resilience(int d) {
      return relativePrimes(d)/(d - 1.0);
   }
   
   static double resilience(long d) {
      return relativePrimes(d)/(d - 1.0);
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
   
   static int lcm(int a, int b) {
      return a*b/gcd(a,b);
   }
   
   static long lcm(long a, long b) {
      return a*b/gcd(a,b);
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
      for ( int k = 2; k*k <= a; ++k )
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
      for ( int k = 2; k*k <= a; ++k )
      {
         if (k*k == a)
            sum += k;
         else if (a % k == 0)
            sum += k + (a/k);
      }
      return sum;
   }
}
