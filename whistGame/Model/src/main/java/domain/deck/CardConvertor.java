package domain.Game;

public class CardConvertor {

    public static int convertValue(Card card){

        switch (card.getValue()){
            case TWO  : return 2;
            case THREE: return 3;
            case FOUR : return 4;
            case FIVE : return 5;
            case SIX  : return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE : return 9;
            case TEN  : return 10;
            case JACK : return 11;
            case QUEEN: return 12;
            case KING : return 13;
            case ACE  : return 14;
        }
        return -1; /// ERROR

    }

}
