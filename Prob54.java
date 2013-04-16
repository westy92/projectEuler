
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

/**
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:

Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD
Pair of Fives
 	2C 3S 8S 8D TD
Pair of Eights
 	Player 2
2	 	5D 8C 9S JS AC
Highest card Ace
 	2C 5C 7D 8S QH
Highest card Queen
 	Player 1
3	 	2D 9C AS AH AC
Three Aces
 	3D 6D 7D TD QD
Flush with Diamonds
 	Player 2
4	 	4D 6S 9H QH QC
Pair of Queens
Highest card Nine
 	3D 6D 7H QD QS
Pair of Queens
Highest card Seven
 	Player 1
5	 	2H 2D 4C 4D 4S
Full House
With Three Fours
 	3C 3D 3S 9S 9D
Full House
with Three Threes
 	Player 1
The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?

Answer: 376

@author Westy92
*/

public class Prob54 extends Euler
{
   public static void main(String args[])
   {
      startTiming();
      int p1 = 0, p2 = 0;
      try
      {
         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Westy92\\Desktop\\Other\\Project Euler\\test\\Prob54.in"));
         while ( in.ready() )
         {
            String hands = in.readLine();
            Hand h1 = new Hand(hands.substring(0, 14));
            Hand h2 = new Hand(hands.substring(15, hands.length()));
            if ( h1.getHighestRank() == h2.getHighestRank() )
            {
               if ( h1.getHighestOfRank().compareTo(h2.getHighestOfRank()) == 0 )
               {
                  int o;
                  for ( o = 0; o < 5 && h1.getHighestCard(o).compareTo(h2.getHighestCard(o)) == 0; ++o ){}
                  if ( h1.getHighestCard(o).compareTo(h2.getHighestCard(o)) > 0 )
                     ++p1;
                  else
                     ++p2;
               }
               else if ( h1.getHighestOfRank().compareTo(h2.getHighestOfRank()) > 0 )
                  ++p1;
               else
                  ++p2;
            }
            else if ( h1.getHighestRank().compareTo(h2.getHighestRank()) > 0 )
               ++p1;
            else
               ++p2;
         }
      } catch ( Exception e ) { }

      System.out.println(p1);
      stopTiming();
   }
}

class Hand
{
   public enum Rank { HIGHCARD, ONEPAIR, TWOPAIR, THREEKIND, STRAIGHT, FLUSH, FHOUSE, FOURKIND, SFLUSH, RFLUSH };
   Card[] cards = new Card[5];
   Card highestOfRank;
   
   Hand (String in)
   {
      String[] inCards = in.split(" ");
      for ( int i = 0; i < 5; ++i )
         cards[i] = new Card(inCards[i]);
      Arrays.sort(cards, new Card());
   }

   public Card getHighestCard(int offset)
   {
      return cards[4-offset];
   }

   public Card getHighestCard()
   {
      return getHighestCard(0);
   }

   public Card getHighestOfRank()
   {
      if ( highestOfRank == null )
         getHighestRank();
      return highestOfRank;
   }

   public Rank getHighestRank()
   {
      if ( cards[0].getSuit() == cards[1].getSuit() &&
           cards[1].getSuit() == cards[2].getSuit() &&
           cards[2].getSuit() == cards[3].getSuit() &&
           cards[3].getSuit() == cards[4].getSuit() )
      { // some kind of flush
         highestOfRank = cards[4];
         if ( cards[0].getValue() == Card.Value.TEN &&
              cards[4].getValue() == Card.Value.ACE )
            return Rank.RFLUSH;
         if ( cards[0].getValue().compareTo(Card.Value.TEN) < 0 &&
              cards[0].getValue().ordinal() + 4 == cards[4].getValue().ordinal() )
            return Rank.SFLUSH;
         return Rank.FLUSH;
      }

      if ( cards[0].getValue() == cards[3].getValue() ||
           cards[1].getValue() == cards[4].getValue() )
      {
         highestOfRank = cards[3];
         return Rank.FOURKIND;
      }

      if ( ( cards[0].getValue() == cards[2].getValue() &&
             cards[3].getValue() == cards[4].getValue() ) ||
           ( cards[0].getValue() == cards[1].getValue() &&
             cards[2].getValue() == cards[4].getValue() ) )
      {
         highestOfRank = cards[2];
         return Rank.FHOUSE;
      }

      if ( cards[0].getValue().ordinal() + 1 == cards[1].getValue().ordinal() &&
           cards[1].getValue().ordinal() + 1 == cards[2].getValue().ordinal() &&
           cards[2].getValue().ordinal() + 1 == cards[3].getValue().ordinal() &&
           cards[3].getValue().ordinal() + 1 == cards[4].getValue().ordinal() )
      {
         highestOfRank = cards[4];
         return Rank.STRAIGHT;
      }

      if ( cards[0].compareTo(cards[2]) == 0 ||
           cards[1].compareTo(cards[3]) == 0 ||
           cards[2].compareTo(cards[4]) == 0 )
      {
         highestOfRank = cards[2];
         return Rank.THREEKIND;
      }

      if ( ( cards[0].compareTo(cards[1]) == 0 && cards[2].compareTo(cards[3]) == 0 ) ||
           ( cards[1].compareTo(cards[2]) == 0 && cards[3].compareTo(cards[4]) == 0 ) ||
           ( cards[0].compareTo(cards[1]) == 0 && cards[3].compareTo(cards[4]) == 0 ) )
      {
         highestOfRank = cards[3];
         return Rank.TWOPAIR;
      }

      if ( cards[0].compareTo(cards[1]) == 0 || cards[1].compareTo(cards[2]) == 0 )
      {
         highestOfRank = cards[1];
         return Rank.ONEPAIR;
      }

      if ( cards[2].compareTo(cards[3]) == 0 || cards[3].compareTo(cards[4]) == 0 )
      {
         highestOfRank = cards[3];
         return Rank.ONEPAIR;
      }
      
      highestOfRank = cards[4];
      return Rank.HIGHCARD;
   }
}

class Card implements Comparable<Card>, Comparator<Card>
{
   public enum Value { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE };
   public enum Suit { SPADE, HEART, DIAMOND, CLUB };
   private Value v;
   private Suit s;

   Card()
   {
      v = Value.TWO;
      s = Suit.CLUB;
   }

   Card(String in)
   {
      v = getVal(in.charAt(0));
      s = getSuit(in.charAt(1));
   }

   public Suit getSuit()
   {
      return s;
   }

   public Value getValue()
   {
      return v;
   }

   public int compareTo(Card o)
   {
      if ( v == o.v )
         return 0;
      else if ( v.compareTo(o.v) < 0 )
         return -1; // before
      else
         return 1; // after
   }

   public int compare(Card c1, Card c2)
   {
      return c1.compareTo(c2);
   }

   private Value getVal(char c)
   {
      switch(c)
      {
         case '2': return Value.TWO;
         case '3': return Value.THREE;
         case '4': return Value.FOUR;
         case '5': return Value.FIVE;
         case '6': return Value.SIX;
         case '7': return Value.SEVEN;
         case '8': return Value.EIGHT;
         case '9': return Value.NINE;
         case 'T': return Value.TEN;
         case 'J': return Value.JACK;
         case 'Q': return Value.QUEEN;
         case 'K': return Value.KING;
         case 'A': return Value.ACE;
      }
      return null;
   }
   private Suit getSuit(char c)
   {
      switch(c)
      {
         case 'H': return Suit.HEART;
         case 'C': return Suit.CLUB;
         case 'D': return Suit.DIAMOND;
         case 'S': return Suit.SPADE;
      }
      return null;
   }

   public boolean sameSuit(Card c)
   {
      return s == c.s;
   }

   @Override
   public boolean equals(Object obj)
   {
      if ( obj == this )
         return true;
      if ( obj == null || obj.getClass() != this.getClass() )
         return false;
      Card c = (Card) obj;
      return c.s == s && c.v == v;
    }
}
