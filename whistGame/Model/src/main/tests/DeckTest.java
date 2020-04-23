package main.tests;

import main.java.domain.app.Card;
import main.java.domain.app.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void generateCards() {

        Deck deck  = new Deck(16);


        for (Card c:deck.generateCards()) {
            System.out.println(c.getValue() + " "  + c.getSymbol());
        }

    }


}