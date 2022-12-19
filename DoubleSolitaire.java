import java.util.ArrayList;

/**
 * A game of double solitaire.
 */
public class DoubleSolitaire {
    /**
     * The list of players.
     */
    private ArrayList<Player> players;

    /**
     * The list of foundations.
     */
    private ArrayList<Foundation> foundations;

    /**
     * Constructs a game of double solitaire.
     * @param playerCount - The number of players in the game.
     */
    public DoubleSolitaire(int playerCount) {
        players = new ArrayList<Player>();
        foundations = new ArrayList<Foundation>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }
    }

    /**
     * Prints all the cards in the game.
     */
    public void print() {
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("Player %d:%n", i + 1);
            players.get(i).print();
            System.out.println();
        }

        for (int i = 0; i < foundations.size(); i++) {
            System.out.printf("Foundation %d:%n", i + 1);
            foundations.get(i).print();
            System.out.println();
        }
    }
}
