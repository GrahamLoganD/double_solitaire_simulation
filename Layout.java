/**
 * A layout for playing solitaire.
 */
public class Layout {
    /**
     * The tableau.
     */
    Tableau tableau;

    /**
     * The stock.
     */
    Stock stock;

    /**
     * The waste.
     */
    Waste waste;

    /**
     * Constructs a solitaire layout by drawing cards from the deck.
     * 
     * @param deck - The deck to draw from.
     */
    public Layout(Deck deck) {
        tableau = new Tableau(deck);
        stock = new Stock(deck);
        waste = new Waste();
    }

    /**
     * Prints all the cards in the layout.
     */
    public void print() {
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
