
package domain.game;

import java.util.List;



public class main {

    public static void deckTest(){

        Deck deck = new Deck(16);
        List<Card> cards = deck.generateCards();
        for (Card card: cards){
            System.out.println(card.getValue() + " " + card.getSymbol());
        }
    }


    public static void main(String[] args) {
      deckTest();
    }

}
