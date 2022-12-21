import java.util.ArrayList;

/**
 * A tableau of seven piles for playing olitaire.
 */
final class Tableau {
    /**
     * The array of piles.
     */
    private Pile[] piles;

    // FIX THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * Sorts the piles into descending order by size.
     * 
     * @return - the sorted array of piles
     */
    private Pile[] sortSizeDescending() {
        return piles;
    }

    /**
     * Sorts the piles into ascending order by size.
     * 
     * @return - the sorted array of piles
     */
    private Pile[] sortSizeAscending() {
        return piles;
    }

    /**
     * 
     * @return the number of cards in the tableau
     */
    int getSize() {
        int sum = 0;
        for (Pile pile : piles) {
            sum += pile.getSize();
        }
        return sum;
    }

    /**
     * Constructs a tableau by drawing cards from the deck.
     * 
     * @param deck - The deck to draw from.
     */
    Tableau(Deck deck) {
        piles = new Pile[7];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Pile();
            for (int j = 0; j < i + 1; j++) {
                piles[i].layFacedownCard(deck.drawCard());
            }
            piles[i].turnFaceup();
        }
    }

    /**
     * Plays a card from the top of the largest possible stack.
     * 
     * @param foundations - The list of foundations to play to.
     * @return {@code true} if a card was played
     */
    boolean playCard(ArrayList<Foundation> foundations) {
        for (Pile pile : sortSizeDescending()) {
            if (pile.playCard(foundations)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tries to move a partial pile of faceup cards from one pile to another.
     * 
     * @return {@code true} if a partial pile was moved
     */
    boolean movePile() {
        for (Pile lowPile : sortSizeDescending()) {
            for (Pile highPile : sortSizeAscending()) {
                if (highPile.merge(lowPile)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Tries to move the top card of the waste onto the lowest possible pile in the
     * tableau.
     *
     * @param waste - The waste to move from.
     * @return {@code true} if a card was moved
     */
    boolean moveFromWaste(Waste waste) {
        for (Pile pile : sortSizeAscending()) {
            if (pile.moveFromWaste(waste)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all the piles in the tableau.
     */
    void print() {
        for (int i = 0; i < piles.length; i++) {
            System.out.printf("Pile %d:%n", i + 1);
            piles[i].print();
            System.out.println();
        }
    }
}