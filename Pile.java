import java.util.LinkedList;

import javax.print.event.PrintJobListener;

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
     * Lays a facedown card in the pile.
     * 
     * @param card - The facedown card to lay
     */
    void layFacedownCard(Card card) {
        if (card.getFacing() != Facing.FACEDOWN){
            System.out.println("Error Pile.layFacedownCard(): Card is not facedown!");
        }
        facedownCards.addFirst(card);
    }

    /**
     * Turns the top card of the pile faceup.
     */
    void turnFaceup() {
        if (!faceupCards.isEmpty()) {
            System.out.println("Error Pile.turnFaceup(): Pile is not empty!");
        }
        Card card = facedownCards.removeFirst();
        card.turnFaceup();
        faceupCards.add(card);
    }

    /**
     * Prints all the cards in the pile.
     */
    void print() {
        if (faceupCards.isEmpty() && facedownCards.isEmpty()) {
            System.out.println("Empty");
        }
        for (Card card : faceupCards) {
            card.print();
        }
        for (Card card : facedownCards) {
            card.print();
        }
    }
}