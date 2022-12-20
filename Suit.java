/**
 * The possible suits.
 */
enum Suit {
    CLUBS(Color.BLACK),
    DIAMONDS(Color.RED),
    HEARTS(Color.RED),
    SPADES(Color.BLACK);

    /**
     * The color of the suit.
     */
    private final Color color;

    /**
     * Constructs a new suit.
     * 
     * @param color - The color of the suit.
     */
    private Suit(Color color) {
        this.color = color;
    }

    /**
     * 
     * @return the color of the suit
     */
    Color getColor() {
        return color;
    }
}