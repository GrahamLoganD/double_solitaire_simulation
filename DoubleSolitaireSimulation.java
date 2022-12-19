public class DoubleSolitaireSimulation {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Deck:");
        deck.print();
        System.out.println();

        Tableau tableau = new Tableau(deck);
        System.out.println("Tableau:");
        tableau.print();
        System.out.println();

        Stock stock = new Stock(deck);
        System.out.println("Stock:");
        stock.print();
        System.out.println();

        System.out.println("Deck:");
        deck.print();
        System.out.println();
    }
}