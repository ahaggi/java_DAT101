package no.hib.dat101.main;

import no.hib.dat101.controller.App;

/**
 * Program som kjører app-en.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public final class Main {

    /**
     * Skjuler default konstruktør.
     */
    private Main() {
    }

    /**
     * Starter Appen.
     *
     * @param args ikke i bruk
     */
    public static void main(final String[] args) {
        new App().kjor();
    }

}
