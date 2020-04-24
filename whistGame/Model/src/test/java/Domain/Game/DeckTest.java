package Domain.Game;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {
    private static final int nrCards = 16;
    private Deck deck;
    @Test
    public void testGenerateCards() {
        deck = new Deck(nrCards);
        List<Card> cards= deck.generateCards();
        assertEquals(cards.size(), 16);
    }
}