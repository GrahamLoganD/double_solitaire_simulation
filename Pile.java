import java.util.LinkedList;

/**
 * A fanned pile of cards for playing solitaire.
 */
public class Pile {
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
    public Pile() {
        facedownCards = new LinkedList<Card>();
        faceupCards = new LinkedList<Card>();
    }

    /**
     * Lays a card in the pile.
     * 
     * @param card - The card to lay
     */
    public void layCard(Card card) {
        if (card.getFacing() == Card.Facing.FACEDOWN) {
            facedownCards.add(card);
        } else {
            faceupCards.add(card);
        }
    }

    /**
     * Turns the top card of the pile faceup.
     */
    public void turnFaceup() {
        faceupCards.add(facedownCards.removeFirst());
    }

    /**
     * Prints all the cards in the pile.
     */
    public void print() {
        for (Card card : facedownCards) {
            card.print();
        }
        for (Card card : faceupCards) {
            card.print();
        }
    }
}