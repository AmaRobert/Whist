package domain.game;


import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DeckTest {
    @Test
    public void generateCards() {
        Deck deck = new Deck(16);
        assertEquals(deck.generateCards().size(), 16);
        Deck deck2 = new Deck(32);
        assertEquals(deck2.generateCards().size(), 32);
    }
}