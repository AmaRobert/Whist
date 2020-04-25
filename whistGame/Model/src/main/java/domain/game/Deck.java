package domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;
    private int noCards; // asta nu e verificat


    public Deck(int noCards) {
        this.noCards = noCards;
    }


    public List<Card> generateCards(){

        List<Card> cards = new ArrayList<>();
        List<Value> val = new ArrayList<>();

        for (Value  v : Value.values()) {
            val.add(v);
        }
        Collections.reverse(val);  // inverseaza enumeratia Odrin stie de ce


        // 8 ,16 ,  48(6 playeri)
        for (Value v : val) {
            for (Symbol s : Symbol.values() ){
                if (noCards == cards.size())
                    return cards;

                cards.add(new Card(v,s));
            }
        }

        return null;
    }


}
