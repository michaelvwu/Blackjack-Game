// Michael Wu
// BlackJack Technical Interview

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mock;
public class HandTest {
    
    //Test for constructor
    @Test
    public void testConstructor(){
        Hand hand = new Hand();
        assertNotNull(hand);
    }
    
    //Testing to see if the count function works
    @Test
    public void testGetCardCount(){
        Hand hand = new Hand();
        assertEquals(0, hand.getCardCount());
        assertTrue(hand.getCardCount()>-1);
    }
    
    //Test adding a mock card to a deck
    //hand should contain 1 card afterwards
    @Test
    public void testAddCard(){
        Hand hand = mock(Hand.class);
        when(hand.getCardCount()).thenReturn(1);
        Card tester = mock(Card.class);
        hand.addCard(tester);
        hand.addCard(null);
        verify(hand).addCard(tester);
        assertEquals(1, hand.getCardCount());
    }
    
    //Testing card removal, will add 20 mock cards to the hand and test that removing them 1 by 1 works
    @Test
    public void testRemoveCardCard(){
        Hand hand = new Hand();
        Card tester = mock(Card.class);
        for(int i=0;i<=20;i++){
            hand.addCard(tester);
        }
        for(int j=0;j<20;j++){
            hand.removeCard(tester);
            assertEquals( (20-j), hand.getCardCount());
        }
    }
    
    //testing removal of card by position rather than by object
    //create hand of 10 cards and remove 1 - will count 9
    @Test
    public void testRemoveCardPosition(){
        Hand hand = new Hand();
        Card tester = mock(Card.class);
        for(int i=0;i<21;i++){
            hand.addCard(tester);
        }
        hand.removeCard(8);
        assertEquals(20, hand.getCardCount());
    }
    
    //Test clear function
    @Test
    public void testClear(){
        Hand hand = new Hand();
        Card tester = mock(Card.class);
        for(int i=0;i<12;i++){
            hand.addCard(tester);
        }
        assertEquals(12, hand.getCardCount()); //should be 12
        hand.clear(); 
        assertEquals(0, hand.getCardCount()); //should be 0
    }
    
    //Testing getCard method, adding 2 tester cards testing them against each other and then against themselves
    @Test
    public void testGetCard(){
        Hand hand = new Hand();
        assertNull(hand.getCard(1));
        Card tester1 = mock(Card.class);
        Card tester2 = mock(Card.class);
        hand.addCard(tester1);
        hand.addCard(tester2);
        assertNotSame(tester1, hand.getCard(1));
        assertNotSame(tester2, hand.getCard(0));
        assertEquals(tester1, hand.getCard(0));
        assertEquals(tester2, hand.getCard(1));
        
    }
    
  //Testing sort by value, will add cards in order 8, 2, ace, Queen, 4
    //expect to see them ace,2,4,8 and Queen {1,2,4,8,12}
    @Test
    public void testSortByValue(){
        Hand hand = new Hand();
        int[] expectedValues = {1,2,4,8,12};
        Card eight = mock(Card.class);
        when(eight.getValue()).thenReturn(8);
        hand.addCard(eight);
        Card two = mock(Card.class);
        when(two.getValue()).thenReturn(2);
        hand.addCard(two);
        Card ace = mock(Card.class);
        when(ace.getValue()).thenReturn(1);
        hand.addCard(ace);
        Card Queen = mock(Card.class);
        when(Queen.getValue()).thenReturn(12);
        hand.addCard(Queen);
        Card four = mock(Card.class);
        when(four.getValue()).thenReturn(4);
        hand.addCard(four);
        hand.sortByValue();
        for(int i = 0; i<expectedValues.length;i++){
            assertEquals(expectedValues[i], hand.getCard(i).getValue());
        }
    }
    
    //Create 2cards of each suit and place them in a hand in alternating fashion,
    //sort the hand and test that both cards of a single suit are next to each other
    @Test
    public void testSortBySuit(){
        int spade = 0;
        int heart = 1;
        int diamond = 2;
        int club = 3;
        
        int[] suits = {spade,heart,diamond,club};
        
        Hand hand = new Hand();
        Card spade1 = mock(Card.class);
        when(spade1.getSuit()).thenReturn(spade);
        Card spade2 = spade1;
        hand.addCard(spade1);
        Card heart1 = mock(Card.class);
        when(heart1.getSuit()).thenReturn(heart);
        Card heart2 = heart1;
        hand.addCard(heart1);
        Card diamond1 = mock(Card.class);
        when(diamond1.getSuit()).thenReturn(diamond);
        Card diamond2 = diamond1;
        hand.addCard(diamond1);
        Card club1 = mock(Card.class);
        when(club1.getSuit()).thenReturn(club);
        Card club2 = club1;
        hand.addCard(club1);
        hand.addCard(club2);   
        hand.addCard(heart2);
        hand.addCard(diamond2);
        hand.addCard(spade2);
        
        for(int i = 0; i<suits.length;i++){//assert suits are in spade,heart,diamond,club * 2 order
            assertEquals(suits[i], hand.getCard(i).getSuit());
            assertEquals(suits[i], hand.getCard(i+4).getSuit());
        }//now sort them
        hand.sortBySuit();
        int j = 0;
        for(int i = 0; i<hand.getCardCount();i++){
            if(i%2!=0){
                j = j-1;
            }
            assertEquals(hand.getCard(i).getSuit(), suits[j]);
            j++;
        }
    }
     
    
}