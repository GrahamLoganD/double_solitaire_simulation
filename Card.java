public class Card {
    enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    private Suit suit;
    private Rank rank;
    private boolean facedown;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isFacedown() {
        return facedown;
    }

    public Card(
            Suit suit,
            Rank rank) {
        this.suit = suit;
        this.rank = rank;
        facedown = true;
    }

    public void turnFaceup() {
        facedown = false;
    }

    public void turnFacedown() {
        facedown = true;
    }
}