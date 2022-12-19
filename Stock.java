import java.util.LinkedList;

/**
 * A stock for playing solitaire.
 */
public class Stock {
    /**
     * The list of cards in the stock.
     */
    private LinkedList<Card> cards;

    /**
     * Constructs a stock by drawing cards from the deck.
     */
    public Stock(Deck deck) {
        cards = new LinkedList<Card>();
        while (deck.getSize() > 0) {
            cards.add(deck.drawCard());
        }
    }

    /**
     * Prints all the cards in the stock.
     */
    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}