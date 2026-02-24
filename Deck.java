import java.util.Random;

public class Deck {

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>(); //empty deck of card
        build(); // Builds the deck of Cards
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {

        // create four cards each of values between 2 and 9
        for (int values =2; values <=9; values++){
            for (int counter =0; counter < 4; counter++){
                Card card = new Card(values); // creates one instance of the desired card to be added to the deck
                deck.add(card);
            }
        }

        for (int counter =0; counter < 4; counter++){ // creates four cards with value equal to 11
            Card card = new Card(11);
            deck.add(card);
        }

        for (int counter =0; counter < 16; counter++){ // creates sixteen cards with value equal to 16
            Card card = new Card(10);
            deck.add(card);
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        // if(size() == 0){
        //     return null;
        // }
        // else{
        //     return deck.remove(0); // deals the first card and removes it from the deck.
        // }

        // alternatively, we can write this shortly usinig the ternary operator as
        return (size() == 0) ? null : deck.remove(0); // returns null if the condition is true and the first card if condition is false(deck contains a card and so a first card exists)
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        Random random = new Random(); // Creates a new Random object

        for (int i = 0; i < size(); i++){
            int j = random.nextInt(size()); // generates random index between 0 and size()-1
            Card temporaryCard = deck.get(i);
            deck.set(i, deck.get(j)); // Moves the card at index j to index i
            deck.set(j, temporaryCard); // Moves the card at index i to index j
        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    @Override
    public String toString() {
        String result = "" + "["; // I added the empty string "" for safety to help Java recognize that result should be fomratted in a string concatenation

        for (int i = 0; i < size(); i++){
            Card card = deck.get(i);
            int cardValue = card.getValue();
            result += cardValue;

            if (i < size() - 1){
                result += ", " ;
            }
        }

        result += "]";
        // result += getTotalValue();
        return result;
    }
}