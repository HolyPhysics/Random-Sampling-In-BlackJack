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
    public int game(boolean verbose){
        reset();  // Resets the game at the start of every game.

        if (verbose){ // Prints out starting instructions when verbose is true
            System.out.println("Starting new game... Get Ready.\n");
        }

        deal(); // Deals two cards each to the player and the dealer

        if (verbose){ // Prints out the initial hands of the game when verbose is true
            System.out.println("Initial Hands: ");
            System.out.println(toString()); // This is the desired initial hands to be printed.
        }

        boolean playerPlaysAll = playerTurn();

        if (verbose){ // Prints game state after the player's play, but only if verbose is true.
            System.out.println("Hands After Player's Turn: ");
            System.out.println(toString()); // Game states to be printed.
        }

        int result;

        if (!playerPlaysAll){ // This code runs only if player busts. Meaning dealer wins.
            result = -1;

            if (verbose){
                System.out.println("Player busts. Dealer takes the win.\n");
            }
        }
        else{ // Player didn't bust. Dealer plays next.
            boolean dealerPlaysAll = dealerTurn();

            if (verbose){ // Prints game state after the dealer's play, but only if verbose is true.
                System.out.println("Hands After Dealer's Turn: ");
                System.out.println(toString()); // Game state to be printed.
            }

            if (!dealerPlaysAll){ // This code runs only if dealer busts. Meaning player wins.
                result = 1;

                if (verbose){
                    System.out.println("Dealer busts. Player takes the win.\n");
                }
            }
            else{
                int playerTotal = playerHand.getTotalValue(); // Gets the total value of player's hand 
                int dealerTotal = dealerHand.getTotalValue(); // Gets the total value of dealer's hand 

                if (playerTotal > dealerTotal){
                    result = 1;

                    if (verbose){
                        System.out.println("Player wins with total " + playerTotal + " against dealer's total " + dealerTotal);
                    }
                } 
                else if (dealerTotal > playerTotal){
                    result = -1;

                    if (verbose){
                        System.out.println("Dealer wins with total " + dealerTotal + " against player's total " + playerTotal);
                    }
                }
                else{ // Runs when we have a tie(push)
                    result = 0;

                    if (verbose){
                        System.out.println("We have a push! player and dealer have total " + playerTotal);
                    }

                }

            }
        }

        if (verbose){ // This code prints the final game state when verbose is true
            System.out.println("Final Hands: ");
            System.out.println(toString());
            String winingConditon = (result == 1 ? "Player Wins!" : (result == -1 ? "Dealer Wins!" : "Push!")); /* I used the ternary operation here to make the if statements 
            * This condition first checks whether result equals 1 and if it's true, "Player wins!" is stored
            * If it's false, the the second string of condition is check.
            * If the first condition in the second condition is true, "Dealer wins!" is stored.
            * If the condition is false, "Push!" is stored
            */
            System.out.println("Final Result: " + winingConditon + "\n");
        }

        return result;
    }


    @Override
    public String toString(){

        String result = "";
        result += "==== Blackjack Game State ==== \n";
        result += "Player: " + playerHand.toString() + "\n";
        result += "Dealer: " + dealerHand.toString() + "\n"; 
        result += "Cards remaining in deck: " + deck.size() + " cards" + "\n";

        return result;
    }


    public static void main(String[] args){
        Blackjack game = new Blackjack(); // Starts a new Blackjack game

        // game.deal();

        // System.out.println(game.toString());

        // boolean player = game.playerTurn(); // Player plays all his/her games.
        // String postPlayerStates = game.toString(); // Checks the state after the player plays.
        // boolean dealer = game.dealerTurn(); // Dealer plays all his/her games.
        // String postDealerStates = game.toString(); // Checks the state after the dealer plays.

        // System.out.println(player);
        // System.out.println(postPlayerStates);
        // System.out.println(dealer);
        // System.out.println(postDealerStates);

        // System.out.println(game.toString());

        System.out.println("======= Playing 3 Games ======");

        int playerScore = 0;
        int dealerScore = 0;
        int pushScore = 0;

        for (int i = 0; i < 3; i++){ // Plays the required 3 games
            int result = game.game(true); // I don't want all the game states and initial and fnal hands to be displayed 

            if (result == 1){
                playerScore +=1;
            }
            else if (result == -1){
                dealerScore +=1;
            }
            else{
                pushScore +=1;
            }
        }

        System.out.println(" Player wins " + playerScore + " times");
        System.out.println(" Dealer wins " + dealerScore + " times");
        System.out.println(" Both player and dealer ties " + pushScore + " times");
        System.out.println("======= End of Results ======");
    }

}