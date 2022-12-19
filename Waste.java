import java.util.LinkedList;

/**
 * A waste for playing solitaire.
 */
public class Waste {
    /**
     * The list of cards in the waste.
     */
    private LinkedList<Card> cards;

    /**
     * Constructs an empty waste.
     */
    public Waste() {
        cards = new LinkedList<Card>();
    }

    /**
     * Prints all the cards in the waste.
     */
    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
