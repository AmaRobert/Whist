package domain.game;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Deck deck = new Deck(16);
        List<Card> cards = deck.generateCards();
        for (Card card: cards){
            System.out.println(card.getValue() + " " + card.getSymbol());
        }
    }
}
