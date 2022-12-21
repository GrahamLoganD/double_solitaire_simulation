public final class DoubleSolitaireSimulation {
    public final static void main(String[] args) {
        DoubleSolitaire doubleSolitaire = new DoubleSolitaire(2);
        doubleSolitaire.runGame();
        System.out.print(doubleSolitaire.averageScore());
    }
}