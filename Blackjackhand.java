// Michael Wu
// BlackJack Technical Interview



public class Blackjackhand extends Hand {
 
     public int getBlackjackValue() {
	// returns the face value of the cards in BlackJack

     int val;      // The value for the hand
     boolean ace;  // This will be set to true if there is an Ace in the hand
     int cards;    // Number of cards in the hand.

     val = 0;
     ace = false; // no Ace in hand
     cards = getCardCount();

     for ( int i = 0;  i < cards;  i++ ) 
     {
             // Add the value of the card in the hand.
         Card card;    // The card; 
         int cardVal;  // The blackjack value of the card.
         card = getCard(i);
         cardVal = card.getValue();  // The normal value, 1 to 13.
         if (cardVal > 10) 
         {
             cardVal = 10;   // For a Jack, Queen, or King (because it only makes sense)
         }
         if (cardVal == 1) 
         {
             ace = true;     // There is at least one ace.
         }
         val = val + cardVal;
      }

     // This is the case for whether Ace is 1 or 11. 
     // Ace becomes 11 when value is less than 21 and 
     // there are more than 2 cards in a hand

      if ( ace == true  &&  val + 10 <= 21 )
          val = val + 10;

      return val;

 }  // end getBlackjackValue()
 
} // end class Blackjackhand
