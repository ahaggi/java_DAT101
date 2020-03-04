package no.hib.dat101.monopol;

/**
 * Definerer en terning.
 * 
 * @author Atle Geitung
 */
public class Terning {
    
    private static final int MAX = 6;
    private Integer verdi;

    /**
     * Lager en ny Terning.
     */
    public Terning() {
    }

    /**
     * Triller terningen.
     */
    public final void trill() {
        verdi = (int) ((Math.random() * MAX) + 1);
    }

    /**
     * Hent verdi.
     * 
     * @return verdien
     */
    public final int getVerdi() {
        return verdi;
    }
}
