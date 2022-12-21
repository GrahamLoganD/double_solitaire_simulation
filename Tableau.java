import java.util.ArrayList;

/**
 * A tableau of seven piles for playing olitaire.
 */
final class Tableau {
    /**
     * The array of piles.
     */
    private Pile[] piles;

    /**
     * Quicksorts the piles into descending order by size.
     * 
     * @param pilesToSort - The array of piles to sort.
     * @param lowIndex    - The lowest index to sort from.
     * @param highIndex   - The highest index to sort to.
     * @param ascending   - {@code true} if it should be sorted in ascending order
     *                    by size.
     */
    private void sortSize(Pile[] pilesToSort, int lowIndex, int highIndex, boolean ascending) {
        if (lowIndex >= highIndex || lowIndex < 0)
            return;
        Pile pivotElement = pilesToSort[highIndex];
        int pivotIndex = lowIndex - 1;
        for (int i = lowIndex; i < highIndex - 1; i++) {
            if ((pilesToSort[i].getSize() <= pivotElement.getSize() && ascending)
                    || (pilesToSort[i].getSize() >= pivotElement.getSize() && !ascending)) {
                pivotIndex++;
                Pile swapPile = pilesToSort[i];
                pilesToSort[i] = pilesToSort[pivotIndex];
                pilesToSort[pivotIndex] = swapPile;
            }
        }
        pivotIndex++;
        Pile swapPile = pilesToSort[highIndex];
        pilesToSort[highIndex] = pilesToSort[pivotIndex];
        pilesToSort[pivotIndex] = swapPile;
        sortSize(pilesToSort, lowIndex, pivotIndex - 1, ascending);
        sortSize(pilesToSort, pivotIndex + 1, highIndex, ascending);
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
        Pile[] sortedDescendingPiles = piles.clone();
        sortSize(sortedDescendingPiles, 0, piles.length - 1, false);
        for (Pile pile : sortedDescendingPiles) {
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
        Pile[] sortedDescendingPiles = piles.clone();
        sortSize(sortedDescendingPiles, 0, piles.length - 1, false);
        for (Pile lowPile : sortedDescendingPiles) {
            Pile[] sortedAscendingPiles = piles.clone();
            sortSize(sortedAscendingPiles, 0, piles.length - 1, true);
            for (Pile highPile : sortedAscendingPiles) {
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
        Pile[] sortedAscendingPiles = piles.clone();
        sortSize(sortedAscendingPiles, 0, piles.length - 1, true);
        for (Pile pile : sortedAscendingPiles) {
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