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
     * 
     * @return {@code true} if the layout is stuck
     */
    boolean isStuck() {
        return isStuck;
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
    }

    /**
     * Resets the waste into the stock.
     */
    private void resetStock() {
        if (stock.getSize() != 0) {
            System.out.println("Error Layout.resetStock(): Stock is not empty!");
        }
        while (waste.getSize() > 0) {
            stock.addCard(waste.drawCard());
        }
    }

    /**
     * Turns three cards at once from the stock into the waste.
     */
    private void turnStock() {
        for (int i = 0; i < 3; i++) {
            if (stock.getSize() > 0) {
                waste.layCard(stock.drawCard());
            } else {
                resetStock();
                return;
            }
        }
    }

    /**
     * The player performs the top priority possible action.
     */
    void takeTurn(ArrayList<Foundation> foundations) {
        if (tableau.playCard(foundations)) {
            return;
        }
        if (waste.playCard(foundations)) {
            return;
        }
        if (tableau.movePile()) {
            return;
        }
        if (tableau.moveFromWaste(waste)) {
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