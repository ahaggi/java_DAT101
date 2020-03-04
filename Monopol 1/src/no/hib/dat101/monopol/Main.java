package no.hib.dat101.monopol;

/**
 * @author Atle Geitung
 */
public class Main {

    /**
     * Lager en ny Main.
     */
    public Main() {
    }

    /**
     * Spiller monopol med to spillere.
     * 
     * @param args ikke i bruk
     */
    public static void main(String[] args) {
        Monopolspill spillet = new Monopolspill(2);
        spillet.spill();
    }

}
