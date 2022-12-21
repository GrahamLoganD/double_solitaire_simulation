import java.util.ArrayList;

/**
 * A game of double solitaire.
 */
final class DoubleSolitaire {
    /**
     * The list of players.
     */
    private ArrayList<Player> players;

    /**
     * The list of foundations.
     */
    private ArrayList<Foundation> foundations;

    /**
     * 
     * @return {@code true} if all the players are stuck
     */
    private boolean checkAllStuck() {
        for (Player player : players) {
            if (!player.isStuck()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Constructs a game of double solitaire.
     * 
     * @param playerCount - The number of players in the game.
     */
    DoubleSolitaire(int playerCount) {
        players = new ArrayList<Player>();
        foundations = new ArrayList<Foundation>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }
    }

    /**
     * Reverses the stocks of all players.
     */
    private void reverse() {
        for (Player player : players) {
            player.reverse();
        }
    }

    /**
     * Resets the stuck trackers of all players.
     */
    void unstickAll() {
        for (Player player : players) {
            player.unstick();
        }
    }

    /**
     * Each player takes a turn in a random order.
     */
    void runRound() {
        ArrayList<Player> randomPlayers = (ArrayList<Player>) players.clone(); // This warning is probably fine
        while (!randomPlayers.isEmpty()) {
            int nextPlayer = (int) (Math.random() * randomPlayers.size());
            randomPlayers.get(nextPlayer).takeTurn(this, foundations);
            randomPlayers.remove(nextPlayer);
        }
    }

    /**
     * Runs a complete game of double solitaire.
     */
    void runGame() {
        while (!checkAllStuck()) {
            runRound();
        }
        reverse();
        unstickAll();
        while (!checkAllStuck()) {
            runRound();
        }
    }

    /**
     * 
     * @return the average score of players in the game
     */
    float averageScore() {
        int sum = 0;
        for (Player player : players) {
            sum += player.getScore();
        }
        return (float) sum / players.size();
    }

    /**
     * Prints all the cards in the game.
     */
    void print() {
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