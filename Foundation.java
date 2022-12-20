import java.util.LinkedList;

/**
 * A foundation
 */
final class Foundation {
    /**
     * The list of cards in the foundation.
     */
    private LinkedList<Card> cards;

    /**
     * Constructs an empty foundation.
     */
    Foundation() {
        cards = new LinkedList<Card>();
    }

    /**
     * Prints all the cards in the foundation.
     */
    void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
