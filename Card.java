/**
 * A card from a standard 52-card deck.
 */
public class Card {
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
    Suit getSuit() {
        return suit;
    }

    /**
     * 
     * @return the color of the card
     */
    Color getColor() {
        return suit.getColor();
    }

    /**
     * 
     * @return the rank of the card
     */
    Rank getRank() {
        return rank;
    }

    /**
     * 
     * @return {@code true} if the card is an ace, otherwise {@code false}
     */
    boolean isAce() {
        if (rank == Rank.ACE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return {@code true} if the card is a king, otherwise {@code false}
     */
    boolean isKing() {
        if (rank == Rank.KING) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return the facing of the card
     */
    Facing getFacing() {
        return facing;
    }

    /**
     * 
     * @param foundationCard - The foundation card to play on.
     * @return {@code true} if the card can be placed on the given foundation card,
     *         {@code false} otherwise
     */
    boolean canBeBuiltUp(Card foundationCard) {
        if (foundationCard.isKing()) {
            return false;
        }
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
    boolean canBeBuiltDown(Card tableauCard) {
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
    Card(
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
    void turnFaceup() {
        facing = Facing.FACEUP;
    }

    /**
     * Turns the card facedown.
     */
    void turnFacedown() {
        facing = Facing.FACEDOWN;
    }

    /**
     * Prints the card.
     */
    void print() {
        System.out.printf("%s of %s (%s)%n", getRank().toString(), getSuit().toString(), getFacing().toString());
    }
}