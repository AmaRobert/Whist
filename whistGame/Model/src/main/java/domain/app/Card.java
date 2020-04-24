package domain.app;

import java.util.Comparator;

public class Card implements Comparable<Card> {  // nu cred ca trebuie sa extinda Entity


    private Value value;
    private Symbol symbol;


    public Card(Value value, Symbol symbol) { // nu stiu exact cum merg enumeratiile in java
        this.value = value;
        this.symbol = symbol;
    }

    public Value getValue() {
        return value;
    }
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public int compareTo(Card o) { // I have no idea if they are ascending or descending
        return CardConvertor.convertValue(this) - CardConvertor.convertValue(o); // <0 this<o else 0>
    }
}
