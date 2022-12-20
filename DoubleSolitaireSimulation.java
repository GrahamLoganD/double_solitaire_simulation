public final class DoubleSolitaireSimulation {
    public final static void main(String[] args) {
        DoubleSolitaire doubleSolitaire = new DoubleSolitaire(1);
        doubleSolitaire.print();
        for (int i = 0; i < 5000; i++) {
            doubleSolitaire.runRound();
        }
        doubleSolitaire.print();
    }
}