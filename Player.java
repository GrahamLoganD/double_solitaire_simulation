/**
 * A solitaire player.
 */
public class Player {
    /**
     * The standard 52-card deck.
     */
    Deck deck;

    /**
     * The solitaire layout.
     */
    Layout layout;

    public Player() {
        deck = new Deck();
        layout = new Layout(deck);
    }

    /**
     * Prints all the cards controlled by the player.
     */
    public void print() {
        System.out.println("Deck:");
        deck.print();
        System.out.println();

        System.out.println("Layout:");
        layout.print();
        System.out.println();
    }
}
