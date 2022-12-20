/**
 * The possible suits.
 */
enum Suit {
    CLUBS(Color.BLACK),
    DIAMONDS(Color.RED),
    HEARTS(Color.RED),
    SPADES(Color.BLACK);

    private final Color color;

    private Suit(Color color) {
        this.color = color;
    }

    /**
     * 
     * @return The color of the suit.
     */
    Color getColor() {
        return color;
    }
}