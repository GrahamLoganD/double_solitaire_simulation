import java.util.LinkedList;

/**
 * A foundation
 */
final class Foundation {
    /**
     * The list of cards in the foundation.
     */
    private LinkedList<Card> cards;

    Card getTop() {
        if (cards.isEmpty()) {
            System.out.println("Error Foundation.getTop(): Foundation is empty!");
        }
        return cards.getFirst();
    }

    /**
     * Constructs an empty foundation.
     */
    Foundation() {
        cards = new LinkedList<Card>();
    }

    /**
     * Starts the foundation with an ace.
     * @param ace - The ace to start with.
     */
    void startAce(Card ace) {
        if (!cards.isEmpty()) {
            System.out.println("Error Foundation.startAce(): Foundation is not empty!");
        }
        cards.add(ace);
    }

    /**
     * Tries to build up the foundation.
     * @param card - The card to build with.
     * @return {@code true} if the foundation was built up
     */
    boolean buildUp(Card card) {
        if (cards.isEmpty()) {
            System.out.println("Error Foundation.buildUp(): Foundation is empty!");
        }
        if (card.canBeBuiltUp(cards.getFirst())) {
            cards.addFirst(card);
            return true;
        }
        return false;
    }

    /**
     * Prints all the cards in the foundation.
     */
    void print() {
        if (cards.isEmpty()) {
            System.out.println("Empty");
        }
        for (Card card : cards) {
            card.print();
        }
    }
}