import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A game of double solitaire.
 */
public class DoubleSolitaire {
    /**
     * The list of players.
     */
    private ArrayList<Player> players;

    /**
     * The list of foundations.
     */
    private ArrayList<Foundation> foundations;

    /**
     * A solitaire player.
     */
    public class Player {
        /**
         * The standard 52-card deck.
         */
        Deck deck;

        /**
         * The solitaire layout.
         */
        Layout layout;

        /**
         * A standard 52-card deck.
         */
        public class Deck {
            /**
             * The list of cards in the deck.
             */
            private LinkedList<Card> cards;

            /**
             * 
             * @return the number of cards in the deck
             */
            public int getSize() {
                return cards.size();
            }

            /**
             * Constructs a shuffled standard 52-card deck.
             */
            public Deck() {
                cards = new LinkedList<Card>();
                for (Card.Suit suit : Card.Suit.values()) {
                    for (Card.Rank rank : Card.Rank.values()) {
                        cards.add(new Card(suit, rank, Card.Facing.FACEDOWN));
                    }
                }
                Shuffle();
            }

            /**
             * Shuffles the deck.
             */
            public void Shuffle() {
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
            public Card drawCard() {
                return cards.remove();
            }

            /**
             * Prints all the cards in the deck.
             */
            public void print() {
                for (Card card : cards) {
                    card.print();
                }
            }
        }

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
             * A tableau of seven piles for playing olitaire.
             */
            public class Tableau {
                /**
                 * The array of piles.
                 */
                Pile[] piles;

                /**
                 * A fanned pile of cards for playing solitaire.
                 */
                public class Pile {
                    /**
                     * The list of facedown cards in the pile.
                     */
                    private LinkedList<Card> facedownCards;

                    /**
                     * The list of faceup cards in the pile.
                     */
                    private LinkedList<Card> faceupCards;

                    /**
                     * Constructs an empty pile.
                     */
                    public Pile() {
                        facedownCards = new LinkedList<Card>();
                        faceupCards = new LinkedList<Card>();
                    }

                    /**
                     * Lays a card in the pile.
                     * 
                     * @param card - The card to lay
                     */
                    public void layCard(Card card) {
                        if (card.getFacing() == Card.Facing.FACEDOWN) {
                            facedownCards.add(card);
                        } else {
                            faceupCards.add(card);
                        }
                    }

                    /**
                     * Turns the top card of the pile faceup.
                     */
                    public void turnFaceup() {
                        Card card = facedownCards.removeFirst();
                        card.turnFaceup();
                        faceupCards.add(card);
                    }

                    /**
                     * Prints all the cards in the pile.
                     */
                    public void print() {
                        for (Card card : facedownCards) {
                            card.print();
                        }
                        for (Card card : faceupCards) {
                            card.print();
                        }
                    }
                }

                /**
                 * Constructs a tableau by drawing cards from the deck.
                 * 
                 * @param deck - The deck to draw from.
                 */
                public Tableau(Deck deck) {
                    piles = new Pile[7];
                    for (int i = 0; i < piles.length; i++) {
                        piles[i] = new Pile();
                        for (int j = 0; j < i + 1; j++) {
                            piles[i].layCard(deck.drawCard());
                        }
                        piles[i].turnFaceup();
                    }
                }

                /**
                 * Prints all the piles in the tableau.
                 */
                public void print() {
                    for (int i = 0; i < piles.length; i++) {
                        System.out.printf("Pile %d:%n", i + 1);
                        piles[i].print();
                        System.out.println();
                    }
                }
            }

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

            /**
             * A waste for playing solitaire.
             */
            public class Waste {
                /**
                 * The list of cards in the waste.
                 */
                private LinkedList<Card> cards;

                /**
                 * Constructs an empty waste.
                 */
                public Waste() {
                    cards = new LinkedList<Card>();
                }

                /**
                 * Prints all the cards in the waste.
                 */
                public void print() {
                    for (Card card : cards) {
                        card.print();
                    }
                }
            }

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

        /**
         * Constructs a new solitaire player.
         */
        public Player() {
            deck = new Deck();
            layout = new Layout(deck);
        }

        /**
         * Prints all the cards controlled by the player.
         */
        public void print() {
            System.out.println("Deck:");
            deck.print();
            System.out.println();

            System.out.println("Layout:");
            layout.print();
            System.out.println();
        }
    }

    /**
     * A foundation
     */
    public class Foundation {
        /**
         * The list of cards in the foundation.
         */
        private LinkedList<Card> cards;

        public Foundation() {
            cards = new LinkedList<Card>();
        }

        /**
         * Prints all the cards in the foundation.
         */
        public void print() {
            for (Card card : cards) {
                card.print();
            }
        }
    }

    /**
     * Constructs a game of double solitaire.
     * 
     * @param playerCount - The number of players in the game.
     */
    public DoubleSolitaire(int playerCount) {
        players = new ArrayList<Player>();
        foundations = new ArrayList<Foundation>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }
    }

    /**
     * Prints all the cards in the game.
     */
    public void print() {
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("Player %d:%n", i + 1);
            players.get(i).print();
            System.out.println();
        }

        for (int i = 0; i < foundations.size(); i++) {
            System.out.printf("Foundation %d:%n", i + 1);
            foundations.get(i).print();
            System.out.println();
        }
    }
}
