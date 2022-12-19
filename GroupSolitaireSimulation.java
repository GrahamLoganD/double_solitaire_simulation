public class GroupSolitaireSimulation {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.print();
        Tableau tableau = new Tableau(deck);
        deck.print();
        tableau.print();
    }
}