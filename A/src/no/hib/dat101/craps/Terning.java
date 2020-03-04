package no.hib.dat101.craps;

import java.util.Random;

/**
 * Terning fra terningsspllet fra læreboken. Første eksempel.
 * 
 * @author Atle Geitung
 */
public class Terning {

    private static final Random RAND = new Random(System.currentTimeMillis());

    private int verdi;

    /**
     * Lager ny terning.
     */
    public Terning() {
    }

    /**
     * Triller terningen.
     */
    public final void trill() {
        verdi = RAND.nextInt(6) + 1;
    }

    /**
     * Henter verdien.
     * 
     * @return verdien
     */
    public final int getVerdi() {
        return verdi;
    }

}
