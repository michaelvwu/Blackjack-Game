// Michael Wu
// BlackJack Technical Interview


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class CardTest {

Card cardNew = null; 

	//Pass in a value for a card through the constructor and verify it returns that valid value passed in.
	@Test
	public void testValueConstructor() {
		cardNew = new Card(3,3);
		assertEquals(3, cardNew.getValue());
	}

	//Pass in a suit for a card through the constructor and verify it returns the valid suit passed in.
	@Test
	public void testSuitConstructor() {
	   cardNew = new Card(3,3);
		assertEquals(3, cardNew.getSuit());
	}

	//Pass in a value for a card through the constructor and verify that it returns the correct value as a string(for number cards).
	@Test
	public void testValueString() {
	   cardNew = new Card(5,0);
		assertEquals("5", cardNew.revealCard());
	}

	//Pass in a value for a card through the constructor and verify that it returns the correct value as a string(for royals) tested a boundary value.
	@Test
	public void testValueStringChar() {
	   cardNew = new Card(13,2);
		assertEquals("King", cardNew.revealCard());
	}


	//Pass in a suit for a card through the constructor and verify that it returns the correct suit as a string for a boundary value.
	@Test
	public void testSuitString() {
	   cardNew = new Card(13,3);
		assertEquals( "Clubs", cardNew.getSuitAsString());
	}
	
	//Pass in a suit and value and verify the the card is return correctly as a string.
	@Test
	public void testString() {
	   cardNew = new Card(11,3);
		assertEquals("Jack of Clubs", cardNew.toString());
	}

	//Create a card with an invalid suit and verify the card holds the suit even though it is invalid. Done on the suites upper boundary.
	@Test
	public void testInvalidsuit() {
	   cardNew = new Card(11,11); // suit 4 does not exist
	   assertEquals(11, cardNew.getSuit());
	}

	//Create a card with an invalid value and verify the card holds the value even though it is invalid. Done on the values upper boundary.
	@Test
	public void testInvalidvalue() {
	   cardNew = new Card(20,0);
		assertEquals(20, cardNew.getValue());
	}
	
	//Create a card with an invalid suit and verify the card returns an invalid string for the suit. Done on the suits lower boundary.
	@Test
	public void testInvalidsuitstring() {
	   cardNew = new Card(11,-1);
		assertEquals("??", cardNew.getSuitAsString());
	}

	//Create a card with an invalid value and verify the card returns an invalid string for the value. Done on the values lower boundary.
	@Test
	public void testInvalidvaluestring() {
	   cardNew = new Card(-1,2);
		assertEquals("??", cardNew.revealCard());
	}
}