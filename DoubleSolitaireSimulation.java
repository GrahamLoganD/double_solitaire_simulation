public final class DoubleSolitaireSimulation {
    public final static void main(String[] args) {
        DoubleSolitaire doubleSolitaire = new DoubleSolitaire(3);
        doubleSolitaire.print();
        doubleSolitaire.runRound();
        doubleSolitaire.print();
    }
}