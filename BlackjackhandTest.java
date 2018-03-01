// Michael Wu
// BlackJack Technical Interview


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mock;

public class BlackjackhandTest {

    //Testing the behavior of a hand with a single ace in it
    @Test 
    public void testSingleAce(){
        Card ace = mock(Card.class);
        when(ace.getValue()).thenReturn(1);
        Card nine = mock(Card.class);
        when(nine.getValue()).thenReturn(9);
        Blackjackhand hand = new Blackjackhand();
        hand.addCard(ace);
        hand.addCard(nine);
        assertEquals(20, hand.getBlackjackValue());
        hand.addCard(nine);
        assertEquals(19, hand.getBlackjackValue());
    }
    
    //Testing the behavior of a hand with two aces in it
    @Test
    public void testDoubleAce(){
        Card ace = mock(Card.class);
        when(ace.getValue()).thenReturn(1);
        Card two = mock(Card.class);
        when(two.getValue()).thenReturn(2);
        Blackjackhand hand = new Blackjackhand();
        hand.addCard(ace);
        hand.addCard(two);
        assertEquals(13, hand.getBlackjackValue());
        hand.addCard(ace);
        assertEquals(14, hand.getBlackjackValue());

    }
    
    //test to see if blackjack does exist
	@Test
	public void testGetBlackjackValue() 
	{
		Card m1 = mock(Card.class);
        when(m1.getValue()).thenReturn(2);
        Card m2 = mock(Card.class);
        when(m2.getValue()).thenReturn(10);
        Blackjackhand hand = new Blackjackhand();
        hand.addCard(m1);
        hand.addCard(m1);
        assertEquals(4, hand.getBlackjackValue());
        hand.clear();
        hand.addCard(m2);
        hand.addCard(m2);
        hand.addCard(m2);
        assertEquals(30, hand.getBlackjackValue());
        hand.removeCard(1);
        hand.addCard(m1);
        assertEquals(22, hand.getBlackjackValue());
	}
	
	//Blackjack is when the hand contains only 2 cards and those cards equal 21
    @Test
    public void testBlackjack(){
        Blackjackhand hand = new Blackjackhand();
        Card mockAce = mock(Card.class);
        when(mockAce.getValue()).thenReturn(1);
        Card mockJack = mock(Card.class);
        when(mockJack.getValue()).thenReturn(10);
        hand.addCard(mockAce);
        hand.addCard(mockJack);
        assertEquals(21, hand.getBlackjackValue());
    }
    
    
    //Testing 2 hands of with different cards that should total the same amount
    @Test
    public void testPush(){
        Blackjackhand hand1 = mock(Blackjackhand.class);
        when(hand1.getBlackjackValue()).thenReturn(20);
        Card ten = mock(Card.class);
        when(ten.getValue()).thenReturn(10);
        Blackjackhand hand2 = new Blackjackhand();
        hand2.addCard(ten);
        hand2.addCard(ten);
        assertNotSame(hand1,hand2);
        assertEquals(hand1.getBlackjackValue(), hand2.getBlackjackValue());
        
    }
    

}
