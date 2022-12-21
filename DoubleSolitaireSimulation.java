public final class DoubleSolitaireSimulation {
    public final static void main(String[] args) {
        DoubleSolitaire doubleSolitaire = new DoubleSolitaire(3);
        for (int i = 0; i < 500; i++) {
            doubleSolitaire.runRound();
        }
        System.out.print(doubleSolitaire.averageSCore());
    }
}