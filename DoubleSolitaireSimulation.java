public final class DoubleSolitaireSimulation {
    public final static void main(String[] args) {
        int maxPlayers = 10;
        int games = 1000;
        for (int i = 1; i <= maxPlayers; i++) {
            float sum = 0;
            for (int j = 0; j < games; j++) {
                DoubleSolitaire doubleSolitaire = new DoubleSolitaire(i);
                doubleSolitaire.runGame();
                sum += doubleSolitaire.averageScore();
            }
            System.out.printf("%d players: %.1f average score%n", i, sum / games);
        }
    }
}