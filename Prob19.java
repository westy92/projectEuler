/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

Answer: 171

@author Westy92
*/

public class Prob19 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      Date d = new Date();
      while ( d.getYear() < 2001 )
      {
         d.addMonth();
      }
      System.out.println(d.getSundaysOnFirst());
      stopTiming();
   }

   private static class Date
   {
      public Date()
      {
         year = 1901;
         month = 1;
         weekday = 2;
         sundaysOnFirst = 0;
      }

      private int year;
      private int month;
      private int weekday; // 0 = Sunday, ... , 6 = Saturday
      private int sundaysOnFirst;

      private boolean isLeapYear()
      {
         if ( year % 400 == 0 )
            return true;
         else if ( year % 100 == 0 )
            return false;
         else
            return year % 4 == 0;
      }

      public void addMonth()
      {
         if ( weekday == 0 )
            sundaysOnFirst++;
         switch ( month )
         {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: weekday = ( weekday + 31 ) % 7;
                     break;
            case 12: year++;
                     month = 0;
                     weekday = ( weekday + 31 ) % 7;
                     break;
            case 4:
            case 6:
            case 9:
            case 11: weekday = ( weekday + 30 ) % 7;
                     break;
            case 2:  if ( isLeapYear() )
                        weekday = ( weekday + 29 ) % 7;
                     else
                        weekday = ( weekday + 28 ) % 7;
                     break;
         }
         month++;
      }

      public int getYear()
      {
         return year;
      }

      public int getSundaysOnFirst()
      {
         return sundaysOnFirst;
      }
   };
}
