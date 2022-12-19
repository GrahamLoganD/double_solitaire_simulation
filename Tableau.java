/**
 * A tableau of seven piles for playing Solitaire.
 */
public class Tableau {
    /**
     * The array of piles.
     */
    Pile[] piles;

    /**
     * Constructs a tableau by drawing cards from the deck.
     * 
     * @param deck - The deck to draw from.
     */
    public Tableau(Deck deck) {
        piles = new Pile[7];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Pile();
            for (int j = 0; j < i + 1; j++) {
                piles[i].layCard(deck.drawCard());
            }
            piles[i].turnFaceup();
        }
    }

    /**
     * Prints all the piles in the tableau.
     */
    public void print() {
        int i = 1;
        for (Pile pile : piles) {
            System.out.printf("Pile %d%n", i++);
            pile.print();
            System.out.println();
        }
    }
}
