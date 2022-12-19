public class GroupSolitaireSimulation {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.Shuffle();
        Card card = deck.drawCard();
        System.out.println(card.getSuit());
        System.out.println(card.getRank());
        System.out.println(card.isFacedown());
    }
}