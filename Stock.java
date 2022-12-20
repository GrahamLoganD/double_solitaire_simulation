import java.util.LinkedList;

/**
 * A stock for playing solitaire.
 */
final class Stock {
    /**
     * The list of cards in the stock.
     */
    private LinkedList<Card> cards;

    /**
     * 
     * @return the number of cards in the stock
     */
    int getSize() {
        return cards.size();
    }

    /**
     * Constructs a stock by drawing cards from the deck.
     */
    Stock(Deck deck) {
        cards = new LinkedList<Card>();
        while (deck.getSize() > 0) {
            cards.add(deck.drawCard());
        }
    }

    /**
     * Draw a card from the stock.
     * 
     * @return the card drawn
     */
    Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Error Stock.drawCard(): Stock is empty!");
        }
        return cards.removeFirst();
    }

    /**
     * Adds a card to the stock and turns it facedown.
     * 
     * @param card - The card to add.
     */
    void addCard(Card card) {
        card.turnFacedown();
        cards.addFirst(card);
    }

    /**
     * Reverses the stock.
     */
    void reverse() {
        LinkedList<Card> reversed = new LinkedList<Card>();
        while (getSize() > 0) {
            reversed.addFirst(cards.removeFirst());
        }
        cards = reversed;
    }

    /**
     * Prints all the cards in the stock.
     */
    void print() {
        if (cards.isEmpty()) {
            System.out.println("Empty");
        }
        for (Card card : cards) {
            card.print();
        }
    }
}