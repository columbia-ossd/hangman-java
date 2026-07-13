public class Scoreboard {
    private int gamesPlayed;
    private int wins;
    private int losses;

    public void recordWin() {
        gamesPlayed++;
        wins++;
    }

    public void recordLoss() {
        gamesPlayed++;
        losses++;
    }

    public void display() {
        System.out.println("\nScoreboard");
        System.out.println("-----------");
        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
