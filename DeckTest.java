// Michael Wu
// BlackJack Technical Interview


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class DeckTest {

	Deck deckNew = null;
	
	//makes sure a full deck of cards exist
	@Test
	public void testInitialCards() {
		deckNew = new Deck();
		assertEquals(52, deckNew.cardsLeft());
	}
	
	//Verify two decks are not the same after one is shuffled.
	@Test
	public void testUniqueDecks() {
		deckNew = new Deck();
		Deck deckNew2 = new Deck();
		deckNew2.shuffle();
		boolean allequal=true;
		for(int i=0;i<52;i++)
		{
			if(!(deckNew.dealCard().toString()).equals(deckNew2.dealCard().toString()))
				allequal=false;
		}
		assertFalse(allequal);
	}

	//Verify no invalid cards are ever dealt by the deck.
	@Test
	public void testNoInvalids() {
		deckNew = new Deck();
		boolean containsinvalid=false;
		for(int i=0;i<52;i++)
		{
			if(deckNew.dealCard().toString().contains("?"))
				containsinvalid=true;
		}
		assertFalse(containsinvalid);
	}
	
	//make sure the game is not rigged with duplicate cards
	@Test
	public void testUniqueDeck() {
		deckNew = new Deck();
		String[] cards = new String[52];
		boolean contain=false;
		for(int i=0;i<52;i++)
		{
			String temp=deckNew.dealCard().toString();
			for(int j=i; j>0;j--)
			{
				if(temp.equals(cards[j-1]))
					contain=true;
			}
			cards[i]=temp;
		}
		assertFalse(contain);
	}

	//Verify the deck will correctly track the amount of cards that are left in the deck.
	@Test
	public void testTrackedammount() {
		deckNew = new Deck();
		for(int i=0;i<12;i++)
		{
			deckNew.dealCard();
		}
		assertEquals(40, deckNew.cardsLeft());
	}

	
}