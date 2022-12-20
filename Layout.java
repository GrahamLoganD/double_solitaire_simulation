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
     * Constructs a solitaire layout by drawing cards from the deck.
     * 
     * @param deck - The deck to draw from.
     */
    Layout(Deck deck) {
        tableau = new Tableau(deck);
        stock = new Stock(deck);
        waste = new Waste();
    }

    /**
     * Resets the waste into the stock.
     */
    private void resetStock() {
        while (waste.getSize() > 0) {
            stock.addCard(waste.drawCard());
        }
    }

    /**
     * Turns three cards at once from the stock into the waste.
     */
    void turnStock() {
        for (int i = 0; i < 3; i++) {
            if (stock.getSize() > 0) {
                waste.layCard(stock.drawCard());
            } else {
                resetStock();
                return;
            }
        }
    }

    void reverse() {
        while (waste.getSize() != 0) {
            turnStock();
        }
        stock.reverse();
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