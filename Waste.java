import java.util.LinkedList;

/**
 * A waste for playing solitaire.
 */
final class Waste {
    /**
     * The list of cards in the waste.
     */
    private LinkedList<Card> cards;

    /**
     * 
     * @return the number of cards in the waste
     */
    int getSize() {
        return cards.size();
    }

    /**
     * Constructs an empty waste.
     */
    Waste() {
        cards = new LinkedList<Card>();
    }

    /**
     * Lay a card into the waste
     * 
     * @param card - the card to lay
     */
    void layCard(Card card) {
        card.turnFaceup();
        cards.addFirst(card);
    }

    /**
     * Draws a card off the top of the waste
     * 
     * @return - the card drawn
     */
    Card drawCard() {
        return cards.removeFirst();
    }

    /**
     * Prints all the cards in the waste.
     */
    void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}