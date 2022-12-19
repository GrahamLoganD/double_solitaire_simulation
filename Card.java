/**
 * A card from a standard 52-card deck.
 */
public class Card {
    /**
     * The possible suits.
     */
    enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;

        /**
         * The possible colors.
         */
        enum Color {
            RED,
            BLACK
        }

        /**
         * 
         * @return The color of the suit.
         */
        public Color getColor() {
            if (this == CLUBS || this == SPADES) {
                return Color.BLACK;
            } else {
                return Color.RED;
            }
        }
    }

    /**
     * The possible ranks.
     */
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

    /**
     * The possible facings.
     */
    enum Facing {
        FACEDOWN,
        FACEUP
    }

    /**
     * The suit of the card.
     */
    private Suit suit;

    /**
     * The rank of the card.
     */
    private Rank rank;

    /**
     * The facing of the card.
     */
    private Facing facing;

    /**
     * 
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * 
     * @return the color of the card
     */
    public Suit.Color getColor() {
        return suit.getColor();
    }

    /**
     * 
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * 
     * @return {@code true} if the card is an ace, otherwise {@code false}
     */
    public boolean isAce() {
        if (rank == Rank.ACE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return the facing of the card
     */
    public Facing getFacing() {
        return facing;
    }

    /**
     * 
     * @param foundationCard - The foundation card to play on.
     * @return {@code true} if the card can be placed on the given foundation card,
     *         {@code false} otherwise
     */
    public boolean canBeBuiltUp(Card foundationCard) {
        if (getSuit() == foundationCard.getSuit() && getRank().ordinal() == (foundationCard.getRank().ordinal() + 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param tableauCard - The tableau card to play on.
     * @return {@code true} if the card can be placed on the given tableau card,
     *         {@code false} otherwise
     */
    public boolean canBeBuiltDown(Card tableauCard) {
        if (getColor() != tableauCard.getColor() && getRank().ordinal() == (tableauCard.getRank().ordinal() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Constructs a card of the given specifications.
     * 
     * @param suit   - The suit of the card.
     * @param rank   - The rank of the card.
     * @param facing - The facing of the card.
     */
    public Card(
            Suit suit,
            Rank rank,
            Facing facing) {
        this.suit = suit;
        this.rank = rank;
        this.facing = facing;
    }

    /**
     * Turns the card faceup.
     */
    public void turnFaceup() {
        facing = Facing.FACEUP;
    }

    /**
     * Turns the card facedown.
     */
    public void turnFacedown() {
        facing = Facing.FACEDOWN;
    }

    /**
     * Prints the card.
     */
    public void print() {
        System.out.printf("%s of %s (%s)%n", getRank().toString(), getSuit().toString(), getFacing().toString());
    }
}