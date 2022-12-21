import java.util.ArrayList;
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
     * 
     * @return - The top card of the waste.
     */
    Card topCard() {
        if (cards.size() == 0) {
            System.out.println("Error Waste.topCard(): Waste is empty!");
        }
        return cards.getFirst();
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
     * @return the card drawn
     */
    Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Error Waste.drawCard(): Waste is empty!");
        }
        return cards.removeFirst();
    }

    /**
     * Plays the top card of the waste if possible.
     * @param foundations - The list of foundations to play to.
     * @return {@code true} if a card was played
     */
    boolean playCard(ArrayList<Foundation> foundations) {
        if (cards.isEmpty()) {
            return false;
        }
        if (cards.getFirst().isAce()) {
            Foundation newFoundation = new Foundation();
            newFoundation.startAce(cards.removeFirst());
            foundations.add(newFoundation);
            return true;
        }
        for (Foundation foundation : foundations) {
            if (foundation.buildUp(cards.getFirst())) {
                cards.removeFirst();
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all the cards in the waste.
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