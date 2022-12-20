import java.util.LinkedList;

/**
 * A fanned pile of cards for playing solitaire.
 */
final class Pile {
    /**
     * The list of facedown cards in the pile.
     */
    private LinkedList<Card> facedownCards;

    /**
     * The list of faceup cards in the pile.
     */
    private LinkedList<Card> faceupCards;

    /**
     * Constructs an empty pile.
     */
    Pile() {
        facedownCards = new LinkedList<Card>();
        faceupCards = new LinkedList<Card>();
    }

    /**
     * Lays a card in the pile.
     * 
     * @param card - The card to lay
     */
    void layCard(Card card) {
        if (card.getFacing() == Facing.FACEDOWN) {
            facedownCards.addFirst(card);
        } else {
            faceupCards.addFirst(card);
        }
    }

    /**
     * Turns the top card of the pile faceup.
     */
    void turnFaceup() {
        Card card = facedownCards.removeFirst();
        card.turnFaceup();
        faceupCards.addFirst(card);
    }

    /**
     * Prints all the cards in the pile.
     */
    void print() {
        for (Card card : faceupCards) {
            card.print();
        }
        for (Card card : facedownCards) {
            card.print();
        }
    }
}