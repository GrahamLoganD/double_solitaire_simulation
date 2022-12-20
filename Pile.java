import java.util.ArrayList;
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
     * 
     * @return the number of cards in the pile
     */
    int getSize() {
        return facedownCards.size() + faceupCards.size();
    }

    Card rootCard() {
        if (faceupCards.size() == 0) {
            System.out.println("Error Pile.rootCard(): Pile has no faceup cards!");
        }
        return faceupCards.getLast();
    }

    /**
     * Takes all the faceup cards off of the pile
     * 
     * @return - The list of faceup cards removed.
     */
    LinkedList<Card> takeFaceupPile() {
        LinkedList<Card> partialPile = (LinkedList<Card>) faceupCards.clone(); // This warning is also probably fine.
        faceupCards.clear();
        if (facedownCards.size() > 0) {
            turnFaceup();
        }
        return partialPile;
    }

    /**
     * Constructs an empty pile.
     */
    Pile() {
        facedownCards = new LinkedList<Card>();
        faceupCards = new LinkedList<Card>();
    }

    /**
     * Plays the top card of the foundation if possible.
     * 
     * @param foundations - The list of foundations to play to.
     * @return {@code true} if a card was played
     */
    boolean playCard(ArrayList<Foundation> foundations) {
        if (faceupCards.isEmpty() && facedownCards.isEmpty()) {
            return false;
        }
        if (faceupCards.isEmpty() && !facedownCards.isEmpty()) {
            System.out.println("Error Pile.playCard(): Pile exists but has no faceup cards!");
            return false;
        }
        if (faceupCards.getFirst().isAce()) {
            Foundation newFoundation = new Foundation();
            newFoundation.startAce(faceupCards.removeFirst());
            foundations.add(newFoundation);
            if (faceupCards.isEmpty() && !facedownCards.isEmpty()) {
                turnFaceup();
            }
            return true;
        }
        for (Foundation foundation : foundations) {
            if (foundation.buildUp(faceupCards.getFirst())) {
                faceupCards.removeFirst();
                if (faceupCards.isEmpty() && !facedownCards.isEmpty()) {
                    turnFaceup();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the faceup cards off the lower pile onto this pile if possible.
     * 
     * @param lowPile - The lower pile.
     * @return {@code true} if the cards were moved
     */
    boolean merge(Pile lowPile) {
        if (lowPile.getSize() == 0) {
            return false;
        }
        if (getSize() == 0) {
            if (lowPile.rootCard().isKing()) {
                faceupCards = lowPile.takeFaceupPile();
                return true;
            }
            return false;
        }
        if (lowPile.rootCard().isKing()) {
            return false;
        }
        if (lowPile.rootCard().canBeBuiltDown(faceupCards.getFirst())) {
            LinkedList<Card> newFaceupCards = lowPile.takeFaceupPile();
            newFaceupCards.addAll(faceupCards);
            faceupCards = newFaceupCards;
            return true;
        }
        return false;
    }

    /**
     * Tries to move the top card of the waste onto the pile if possible.
     *
     * @param waste - The waste to move from.
     * @return {@code true} if a card was moved
     */
    boolean moveFromWaste(Waste waste) {
        if (waste.getSize() == 0) {
            return false;
        }
        if (faceupCards.size() == 0) {
            if (waste.topCard().isKing() && faceupCards.size() == 0) {
                faceupCards.add(waste.drawCard());
                return true;
            }
            return false;
        }
        if (waste.topCard().canBeBuiltDown(faceupCards.getFirst())) {
            faceupCards.addFirst(waste.drawCard());
            return true;
        }
        return false;
    }

    /**
     * Lays a facedown card in the pile.
     * 
     * @param card - The facedown card to lay
     */
    void layFacedownCard(Card card) {
        if (card.getFacing() != Facing.FACEDOWN) {
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