import java.util.ArrayList;

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
     * 
     * @return {@code true} if the player is stuck
     */
    boolean isStuck() {
        return layout.isStuck();
    }

    /**
     * 
     * @return the score of the player
     */
    int getScore() {
        return layout.getScore();
    }

    /**
     * Constructs a new solitaire player.
     */
    Player() {
        deck = new Deck();
        layout = new Layout(deck);
    }

    /**
     * The player performs the top priority possible action.
     */
    void takeTurn(ArrayList<Foundation> foundations) {
        layout.takeTurn(foundations);
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
        layout.unstick();
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