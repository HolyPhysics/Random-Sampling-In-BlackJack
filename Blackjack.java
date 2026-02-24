public class Blackjack{
    /*
    Add appropriate comment here
    */
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
   
    public Blackjack(){
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        reset();

    }

    public void reset(){
        playerHand.reset();
        dealerHand.reset();

        if ( deck.size() < 26){
            Deck newDeck = new Deck(); // Create new deck
            newDeck.shuffle(); // Shuffle the new deck
            deck = newDeck;
        }

    }

    public void deal(){
        playerHand.add( deck.deal() );
        playerHand.add( deck.deal() );

        dealerHand.add( deck.deal() );
        dealerHand.add( deck.deal() );
    }

    public boolean playerTurn(){
        // return false; // Change to the real thing afterwards

        int playerTotal; // initialized loop variable

        for (playerTotal = playerHand.getTotalValue(); playerTotal < 16; playerTotal++){
            playerHand.add( deck.deal() );

            if (playerHand.getTotalValue() > 21){
            return false;
        }

        }

        // if (playerHand.getTotalValue() > 21){
        //     return false;
        // }
        return true;

        // return (playerTotal > 21); // returns false when playerTotal > 21
    }

    public boolean dealerTurn(){
        
        int dealerTotal; // initialized loop variable

        for (dealerTotal = dealerHand.getTotalValue(); dealerTotal < 17; dealerTotal++){
            dealerHand.add( deck.deal() );

            if (dealerHand.getTotalValue() > 21){
            return false;
        }

        }

        // if (dealerHand.getTotalValue() > 21){
        //     return false;
        // }
        return true;

        // return (dealerTotal < 21); // returns false when playerTotal > 21
    }

    /**
 * Plays a single game of Blackjack
 * @param verbose if true, prints game details
 * @return -1 if dealer wins, 0 for push, 1 if player wins
 */
public int game(boolean verbose) {
    // Reset the game
    reset();
    
    if (verbose) {
        System.out.println("Starting new game...");
    }
    
    // Deal initial cards
    deal();
    
    if (verbose) {
        System.out.println("Initial deal:");
        System.out.println(this);
    }
    
    // Player's turn
    boolean playerStillIn = playerTurn();
    
    if (verbose) {
        System.out.println("After player's turn:");
        System.out.println(this);
    }
    
    int result;
    
    if (!playerStillIn) {
        // Player busted - dealer wins
        result = -1;
        if (verbose) {
            System.out.println("Player busts! Dealer wins.");
        }
    } else {
        // Player didn't bust, now dealer's turn
        boolean dealerStillIn = dealerTurn();
        
        if (verbose) {
            System.out.println("After dealer's turn:");
            System.out.println(this);
        }
        
        if (!dealerStillIn) {
            // Dealer busted - player wins
            result = 1;
            if (verbose) {
                System.out.println("Dealer busts! Player wins.");
            }
        } else {
            // Neither busted - compare scores
            int playerScore = playerHand.getTotalValue();
            int dealerScore = dealerHand.getTotalValue();
            
            if (playerScore > dealerScore) {
                result = 1;
                if (verbose) {
                    System.out.println("Player wins with " + playerScore + 
                                      " vs dealer's " + dealerScore);
                }
            } else if (dealerScore > playerScore) {
                result = -1;
                if (verbose) {
                    System.out.println("Dealer wins with " + dealerScore + 
                                      " vs player's " + playerScore);
                }
            } else {
                result = 0;
                if (verbose) {
                    System.out.println("Push! Both have " + playerScore);
                }
            }
        }
    }
    
    if (verbose) {
        System.out.println("Final state:");
        System.out.println(this);
        System.out.println("Result: " + 
                          (result == 1 ? "PLAYER WIN" : 
                           result == -1 ? "DEALER WIN" : "PUSH"));
    }
    
    return result;
}



    @Override
    public String toString(){

        String result = "";
        result += "==== Blackjack Game State ==== \n";
        result += "Player: " + playerHand.toString() + "\n";
        result += "Dealer: " + dealerHand.toString() + "\n"; 
        result += "Cards remaining in deck: " + deck.size() + "\n";

        return result;
    }


    public static void main(String[] args){
        Blackjack game = new Blackjack();
    
        // Test a single game with verbose output
        System.out.println("=== TESTING SINGLE GAME ===");
        int result = game.game(true);
        System.out.println("Game result code: " + result);
    
        // Test multiple games to see statistics
        System.out.println("\n=== TESTING 100 GAMES ===");
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
    
        for (int i = 0; i < 100; i++) {
            result = game.game(false);  // Quiet mode
            if (result == 1) playerWins++;
            else if (result == -1) dealerWins++;
            else pushes++;
        }
    
        System.out.println("Results after 100 games:");
        System.out.println("Player wins: " + playerWins);
        System.out.println("Dealer wins: " + dealerWins);
        System.out.println("Pushes: " + pushes);
    }

}