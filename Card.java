public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        // TBD
        this.value = val;
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        // TBD
        return this.value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    @Override // This overrides Java's default string representation for this class
    public String toString() {
        // TBD
        return "" + this.value; // The empty "" instructs Java to perform a string concatenation
    }
}