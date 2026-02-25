public class Simulation {
    
    public static void main(String[] args) {
        System.out.println("=" .repeat(60));
        System.out.println("BLACKJACK SIMULATION RESULTS");
        System.out.println("=" .repeat(60));
        
        // Run simulations with different numbers of games
        runSimulation(100);      // Small sample
        runSimulation(1000);     // Medium sample
        runSimulation(10000);    // Large sample
        runSimulation(100000);   // Very large sample
        
        System.out.println("=" .repeat(60));
    }
    
    /**
     * Runs a simulation with the specified number of games
     * @param numGames the number of games to simulate
     */
    public static void runSimulation(int numGames) {
        // Create a SINGLE Blackjack object for this simulation
        Blackjack game = new Blackjack();
        
        // Track statistics
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        
        // Run the games
        for (int i = 0; i < numGames; i++) {
            int result = game.game(false);  // false = quiet mode (no printing)
            
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }
        
        // Calculate percentages
        double playerWinPct = (playerWins * 100.0) / numGames;
        double dealerWinPct = (dealerWins * 100.0) / numGames;
        double pushPct = (pushes * 100.0) / numGames;
        
        // Print results with nice formatting
        System.out.println("\n SIMULATION: " + numGames + " GAMES");
        // System.out.println("-" .repeat(40));
        System.out.printf("Player wins:  %6d  (%5.2f%%)\n", playerWins, playerWinPct);
        System.out.printf("Dealer wins:  %6d  (%5.2f%%)\n", dealerWins, dealerWinPct);
        System.out.printf("Pushes:       %6d  (%5.2f%%)\n", pushes, pushPct);
        System.out.printf("TOTAL:        %6d  (100.00%%)\n", numGames);
        
        // Verify total
        assert playerWins + dealerWins + pushes == numGames : "Game count mismatch!";
    }
}


