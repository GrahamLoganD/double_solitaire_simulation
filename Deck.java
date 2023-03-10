import java.util.LinkedList;

/**
 * A standard 52-card deck.
 */
class Deck {
    /**
     * The list of cards in the deck.
     */
    private LinkedList<Card> cards;

    /**
     * 
     * @return the number of cards in the deck
     */
    int getSize() {
        return cards.size();
    }

    /**
     * Constructs a shuffled standard 52-card deck.
     */
    Deck() {
        cards = new LinkedList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank, Facing.FACEDOWN));
            }
        }
        Shuffle();
    }

    /**
     * Shuffles the deck.
     */
    private void Shuffle() {
        LinkedList<Card> shuffled = new LinkedList<Card>();
        while (!cards.isEmpty()) {
            shuffled.add(cards.remove((int) (Math.random() * cards.size())));
        }
        cards = shuffled;
    }

    /**
     * Draws the top card off of the deck.
     * 
     * @return the card drawn
     */
    Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Error Deck.drawCard(): Deck is empty.");
        }
        return cards.remove();
    }

    /**
     * Prints all the cards in the deck.
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