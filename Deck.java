import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cardsList = new LinkedList<Card>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cardsList.add(new Card(suit, rank));
            }
        }
        Shuffle();
    }

    public void Shuffle() {
        LinkedList<Card> shuffledDeck = new LinkedList<Card>();
        while (!cardsList.isEmpty()) {
            shuffledDeck.add(cardsList.remove((int) (Math.random() * cardsList.size())));
        }
        cardsList = shuffledDeck;
    }

    public Card drawCard() {
        return cardsList.remove();
    }
}