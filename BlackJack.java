// Michael Wu
// BlackJack Technical Interview

import java.util.*;

/* This is the driver program for the blackjack game */

public class BlackJack {
private static Scanner scanner = new Scanner(System.in);

	/* main interaction pane*/
   public static void main(String[] args) {
	   
	   boolean play; 		//start game
       String start;            // Amount user bets on a game.
       boolean userWins;   // Did the user win the game?

       System.out.println("Welcome to the game of blackjack.\n");
       System.out.println("Rules are simple; to win, just beat the dealer.\n"
       		+ "Values are on the face of the card. Ace is 1 or 11. J, Q, K are worth 10.\n");


       System.out.println("Would you like to play?");
       

       play = true;
       while (play == true)
       {
       	start = scanner.next();
     	
       	if(start.equalsIgnoreCase("yes"))
           {
           	
           	userWins = playBlackjack();
           	 
           	if (userWins)
                {
                	System.out.println("Would you like to play again?\n");
                } 
           	else
           	{
           		System.out.println("You Lose.\nBut, would you like to play again?");
           	}
           }
       	
       	if(start.equalsIgnoreCase("no"))
       	{
       		break;
       	}
       	
       	
       	if (!start.equalsIgnoreCase("YES")  || !start.equalsIgnoreCase("NO"))
           {
           	System.out.println("To play you must type 'YES' to start, or 'NO' to quit");
           }
       }
       
 
       System.out.println();
       System.out.println("The game of BlackJack has concluded. Thanks for playing!");
   
   } // end main()
   
   
   static boolean playBlackjack() {
	   // starts the game of blackjack
       // Return true if the user wins
   	   // Returns false if the user loses

      Deck deck;                  // A deck of cards. (inherited from Deck.java) 
      Blackjackhand dealerHand;   // The dealer's hand.
      Blackjackhand userHand;     // The user's hand.
      
      deck = new Deck();
      dealerHand = new Blackjackhand();
      userHand = new Blackjackhand();

      /*  Shuffle the deck first, then deal two cards to each player. */
      
      deck.shuffle();
      
      /* creates the players in the game and starts each one with two cards*/
      userHand.addCard( deck.dealCard() ); //user gets first hand
      dealerHand.addCard( deck.dealCard() ); //dealer second
      userHand.addCard( deck.dealCard() );
      dealerHand.addCard( deck.dealCard() );
      
      
      System.out.println();
      System.out.println();
      
      /* Check if one of the players wins in first round (first two cards totaling to 21).
      The player with Blackjack wins the game. No one wins in tie.
       */
      
      
      if (userHand.getBlackjackValue() == 21) {
          System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
          System.out.println("User has the " + userHand.getCard(0)  + " and the " + userHand.getCard(1) + ".");
          System.out.println();
          System.out.println("You have Blackjack. You win.");
          return true;
     }
      
      if (dealerHand.getBlackjackValue() == 21) {
           System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
           System.out.println("User has the " + userHand.getCard(0)  + " and the " + userHand.getCard(1) + ".");
           System.out.println();
           System.out.println("Dealer has Blackjack. Dealer wins.");
           return false;
      }
      
     
      
      /*  The game goes on until someone hits 21 or busts or chooses to stop dealing.
      The choices are to hit (deal card) or the stand (or hold cards)
      The while loop ends when the user chooses to "Stand" or when the user goes over 21.
       */
      
      while (true) {
          
    	  /* Show user's cards, and let user decide to Hit or Stand. */

           System.out.println();
           System.out.println();
           System.out.println("Your cards are:");
           for ( int i = 0; i < userHand.getCardCount(); i++ )
           {
              System.out.println("    " + userHand.getCard(i));
           }
           System.out.println("Your total is " + userHand.getBlackjackValue());
           System.out.println();
           System.out.println("Dealer is showing the " + dealerHand.getCard(0));
           System.out.println();
           System.out.println("Hit (H) or Stand (S)? ");
           char userAction;  // User's response, 'H' or 'S'.
           do {
              userAction = Character.toUpperCase( scanner.next().charAt(0) );
              if (userAction != 'H' && userAction != 'S')
                 System.out.println("Please respond H or S:  ");
           } while (userAction != 'H' && userAction != 'S');

           /* If the user Hits, the user gets a card.  If the user Stands,
              the loop ends (and it's the dealer's turn to draw cards).
           */

           if ( userAction == 'S' ) {
                   // Loop ends; user is done taking cards.
               break;
           }
           else {  // userAction is 'H'.  Give the user a card.  
                   // If the user goes over 21, the user loses.
               Card newCard = deck.dealCard();
               userHand.addCard(newCard);
               System.out.println();
               System.out.println("User hits.");
               System.out.println("Your card is the " + newCard);
               System.out.println("Your total is now " + userHand.getBlackjackValue());
               if (userHand.getBlackjackValue() > 21) {
                   System.out.println();
                   System.out.println("You busted by going over 21.  You lose.");
                   System.out.println("Dealer's other card was the "  + dealerHand.getCard(1));
                   return false;  
               }
           }
           
      } // end while loop
      
      /* If the user did not bust, the dealer will draw. This the automated portion for the dealer.
       */

      System.out.println();
      System.out.println("User stands.");
      System.out.println("Dealer's cards are");
      System.out.println("    " + dealerHand.getCard(0));
      System.out.println("    " + dealerHand.getCard(1));
      while (dealerHand.getBlackjackValue() <= 16) {
         Card newCard = deck.dealCard();
         System.out.println("Dealer hits and gets the " + newCard);
         dealerHand.addCard(newCard);
         if (dealerHand.getBlackjackValue() > 21) {
            System.out.println();
            System.out.println("Dealer busted by going over 21.  You win.");
            return true;
         }
      }
      System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());
      
      // reveal the winner of the game
      
      System.out.println();
      if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
         System.out.println("Dealer wins on a tie.  You lose.");
         return false;
      }
      else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
         System.out.println("Dealer wins, " + dealerHand.getBlackjackValue()   + " points to " + userHand.getBlackjackValue() + ".");
         return false;
      }
      else {
         System.out.println("You win, " + userHand.getBlackjackValue()   + " points to " + dealerHand.getBlackjackValue() + ".");
         return true;
      }

   }  // end playBlackjack()


} // end class BlackJack