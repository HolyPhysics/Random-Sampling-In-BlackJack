public class Hand {

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }
    

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        hand = new ArrayList<>();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int total = 0;

        for (int i = 0; i < size(); i++){ // size() call hand.size() which retrieves the size of cards on the hand
            // Hand desiredHand = new Hand(); // We need this to use the getCard method since the method is not created with the "static" keyword.
            Card card = getCard(i); // No casting required but we could have done the casting with (Card) in fromt of getCard(i).
            total += card.getValue();
        }
        return total;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    @Override // This overrides Java's default string representation for this class.
    public String toString(){

        String result = "" + "["; // I added the empty string "" for safety to help Java recognize that result should be fomratted in a string concatenation

        for (int i = 0; i < size(); i++){
            Card card = getCard(i);
            int cardValue = card.getValue();
            result += cardValue;

            if (i < size() - 1){
                result += ", " ;
            }
        }

        result += "] : ";
        result += getTotalValue();
        return result;
    }

}

