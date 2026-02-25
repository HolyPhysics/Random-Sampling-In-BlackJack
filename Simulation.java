public class Simulation {
    
    public static void main(String[] args) {
        System.out.println("============================================================="); // I added this here for its aesthetics
        System.out.println("BLACKJACK SIMULATION RESULTS");
        System.out.println("============================================================="); // I added this here for its aesthetics

        
        // Runs the simulations for 100, 1000, and 10000 games respectively in that order
        gameSimulation(100);
        gameSimulation(1000);
        gameSimulation(10000);
        
        System.out.println("============================================================="); // I added this here for its aesthetics

    }
    
    /**
     * Runs a simulation with the specified number of games
     * @param numGames the number of games to simulate
     */
    public static void gameSimulation(int numberOfGames) {
        Blackjack game = new Blackjack(); // creates a single blackjack object for our simulation
        
        // Track scores for player and dealer wins and records the number of pushes in the game.
        int playerScore = 0;
        int dealerScore = 0;
        int pushScore = 0;
        
        for (int i = 0; i < numberOfGames; i++) { // This runs the game the specified number fof times
            int result = game.game(false);  /* verbose = false, lets us get only the results and 
            * avoids printing game states and hands every time.
            */

            if (result == 1) {
                playerScore++;
            } else if (result == -1) {
                dealerScore++;
            } else {
                pushScore++;
            }
        }
        
        /* Calculate percentages of wins for player and dealers for after total game play. 
        *  Also calculates the number of pushes scores 
        */
        double playerWinPercentage = (playerScore * 100.0) / numberOfGames;
        double dealerWinPercentage = (dealerScore * 100.0) / numberOfGames;
        double pushPercentage = (pushScore * 100.0) / numberOfGames;
        
        // This maintains a clean formatting as instructed in the project website
        System.out.println(" \n SIMULATION FOR " + numberOfGames + " GAMES");
        System.out.printf("Player wins:  %6d times,  (%5.3f%%) of the %6d games \n", playerScore, playerWinPercentage, numberOfGames);
        System.out.printf("Dealer wins:  %6d times,  (%5.3f%%) of the %6d games \n", dealerScore, dealerWinPercentage, numberOfGames);
        System.out.printf("Pushes:       %6d times,  (%5.3f%%) of the %6d games \n", pushScore, pushPercentage, numberOfGames);
        System.out.printf("TOTAL:        %6d games,  (100.00%%) of the %6d games \n", numberOfGames, numberOfGames);
        
        // Verify total
        if (playerScore + dealerScore + pushScore != numberOfGames){
            System.out.println("Something is terribly wrong with your code");
        }
    }

}

