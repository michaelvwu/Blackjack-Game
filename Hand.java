// Michael Wu
// BlackJack Technical Interview




import java.util.*;

public class Hand 
{

   private ArrayList<Card> hand;   // The cards in the hand. Inherits Card class
   
   public Hand() {
           // Create a Hand object that is initially empty.
      hand = new ArrayList<Card>();
   }
   
   
   public void clear() 
   {
         // Discard all the cards from the hand.
      hand.clear();
   }
   
   public void addCard(Card c) 
   {
      if (c != null)
         hand.add(c);
   }
   
   public void removeCard(Card c) 
   {
      hand.remove(c);
   }
   
   public void removeCard(int position) 
   {
      if (position >= 0 && position < hand.size())
         hand.remove(position);
   }
   
   public int getCardCount() 
   {
         // Return the number of cards in the hand.
      return hand.size();
   }
   
   public Card getCard(int position) 
   {
          // Get the card from the hand in given position, where positions
      // are numbered starting from 0.  If the specified position is
      // not the position number of a card in the hand, then null
      // is returned.
      if (position >= 0 && position < hand.size())
         return ((Card)hand.get(position));
      else
         return null;
   }
   
   public void sortBySuit() 
   {
         // Sorts the cards in the hand so that cards of the same suit are
     // grouped together, and within a suit the cards are sorted by value.
     // Note that aces are considered to have the lowest value, 1.
	  ArrayList<Card> newHand = new ArrayList<Card>();
	  while (hand.size() > 0) {
	     int pos = 0;  // Position of minimal card.
	     Card c = (Card)hand.get(0);  // Minimal card.
	         for (int i = 1; i < hand.size(); i++) 
	         {
	            Card c1 = (Card)hand.get(i);
	            if ( c1.getSuit() < c.getSuit() ||
	                    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) 
	            {
	                pos = i;
	                c = c1;
	            }
	         }
	         hand.remove(pos);
	         newHand.add(c);
	      }
	      hand = newHand;
   }
   
   public void sortByValue() 
   {
         // Sorts the cards in the hand so that cards of the same value are
     // grouped together.  Cards with the same value are sorted by suit.
     // Note that aces are considered to have the lowest value, 1.
	   ArrayList<Card> newHand = new ArrayList<Card>();
	   while (hand.size() > 0) 
	   {
	     int pos = 0;  // Position of minimal card.
	     Card c = (Card)hand.get(0);  // Minimal card.
	         for (int i = 1; i < hand.size(); i++) 
	         {
	            Card c1 = (Card)hand.get(i);
	            if ( c1.getValue() < c.getValue() ||
	                    (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) 
	            {
	                pos = i;
	                c = c1;
	            }
	         }
	         hand.remove(pos);
	         newHand.add(c);
	      }
	      hand = newHand;
   }
   
}