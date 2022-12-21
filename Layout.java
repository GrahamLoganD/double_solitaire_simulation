import java.util.ArrayList;

/**
 * A layout for playing solitaire.
 */
final class Layout {
    /**
     * The tableau.
     */
    private Tableau tableau;

    /**
     * The stock.
     */
    private Stock stock;

    /**
     * The waste.
     */
    private Waste waste;

    /**
     * {@code true} if the layout is stuck
     */
    private boolean isStuck;

    /**
     * {@code true} if the stock has already been gone through once
     */
    private boolean staleStock;

    /**
     * 
     * @return {@code true} if the layout is stuck
     */
    boolean isStuck() {
        return isStuck;
    }

    /**
     * 
     * @return the number of cards left in the layout
     */
    int getScore() {
        if (!isStuck()) {
            System.out.println("Error Layout.getScore(): Calculating score of an unstuck layout!");
        }
        return tableau.getSize() + stock.getSize() + waste.getSize();
    }

    /**
     * Constructs a solitaire layout by drawing cards from the deck.
     * 
     * @param deck - The deck to draw from.
     */
    Layout(Deck deck) {
        tableau = new Tableau(deck);
        stock = new Stock(deck);
        waste = new Waste();
        isStuck = false;
        staleStock = false;
    }

    /**
     * Resets the waste into the stock.
     */
    private void resetStock() {
        if (staleStock == true) {
            isStuck = true;
        }
        if (stock.getSize() != 0) {
            System.out.println("Error Layout.resetStock(): Stock is not empty!");
        }
        while (waste.getSize() > 0) {
            stock.addCard(waste.drawCard());
        }
        staleStock = true;
    }

    /**
     * Turns three cards at once from the stock into the waste.
     */
    private void turnStock() {
        if (stock.getSize() == 0) {
            resetStock();
            return;
        }
        if (stock.getSize() < 3) {
            while (stock.getSize() > 0) {
                waste.layCard(stock.drawCard());
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            waste.layCard(stock.drawCard());
        }
    }

    /**
     * The player performs the top priority possible action.
     * @param game - The game being played.
     * @param foundations - The foundations to play on.
     */
    void takeTurn(DoubleSolitaire game, ArrayList<Foundation> foundations) {
        if (tableau.playCard(foundations)) {
            staleStock = false;
            unstick();
            game.unstickAll();
            return;
        }
        if (waste.playCard(foundations)) {
            staleStock = false;
            unstick();
            game.unstickAll();
            return;
        }
        if (tableau.movePile()) {
            staleStock = false;
            unstick();
            return;
        }
        if (tableau.moveFromWaste(waste)) {
            staleStock = false;
            unstick();
            return;
        }
        turnStock();
    }

    /**
     * Reverses the stock.
     */
    void reverse() {
        while (waste.getSize() != 0) {
            turnStock();
        }
        stock.reverse();
    }

    /**
     * Unsticks the layout.
     */
    void unstick() {
        isStuck = false;
    }

    /**
     * Prints all the cards in the layout.
     */
    void print() {
        System.out.println("Tableau:");
        tableau.print();
        System.out.println();
        System.out.println("Stock:");
        stock.print();
        System.out.println();
        System.out.println("Waste:");
        waste.print();
        System.out.println();
    }
}