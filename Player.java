/**
 * A solitaire player.
 */
final class Player {
    /**
     * The standard 52-card deck.
     */
    private Deck deck;

    /**
     * The solitaire layout.
     */
    private Layout layout;

    /**
     * {@code true} if the player is stuck
     */
    private boolean isStuck;

    /**
     * 
     * @return {@code true} if the player is stuck
     */
    boolean isStuck() {
        return isStuck;
    }

    /**
     * Constructs a new solitaire player.
     */
    Player() {
        deck = new Deck();
        layout = new Layout(deck);
        isStuck = false;
    }

    void takeTurn() {
        layout.turnStock();
    }

    /**
     * Reverses the player's stock.
     */
    void reverse() {
        layout.reverse();
    }

    /**
     * Unsticks the player.
     */
    void unstick() {
        isStuck = false;
    }

    /**
     * Prints all the cards controlled by the player.
     */
    void print() {
        System.out.println("Deck:");
        deck.print();
        System.out.println();

        System.out.println("Layout:");
        layout.print();
        System.out.println();
    }
}