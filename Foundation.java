import java.util.LinkedList;

/**
 * A foundation
 */
public class Foundation {
    /**
     * The list of cards in the foundation.
     */
    private LinkedList<Card> cards;

    public Foundation() {
        cards = new LinkedList<Card>();
    }

    /**
     * Prints all the cards in the foundation.
     */
    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
