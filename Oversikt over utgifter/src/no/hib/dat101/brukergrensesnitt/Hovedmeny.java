package no.hib.dat101.brukergrensesnitt;

import java.util.Scanner;

/**
 * Beskriver UI-komponenten meny.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class Hovedmeny {

    public static final char REGISTRER_UTGIFT = '1';
    public static final char DAGENS_UTGIFTER = '2';
    public static final char MAANEDSOVERSIKT = '3';
    public static final char REGISTRER_KATEGORI = '4';
    public static final char AVSLUTT = 'x';

    private static final Scanner VALG = new Scanner(System.in);

    /**
     * Menyen.
     *
     * @return valg
     */
    public final char velgIMeny() {
        System.out.println("----------------------");
        System.out.println("1: Registrere utgift");
        System.out.println("2: Vise dagens utgifter");
        System.out.println("3: Vise månedsoversikt");
        System.out.println("4: Legge til ny utgiftskategori");
        System.out.println("x: Avslutt");
        System.out.print("Valg> ");
        return VALG.nextLine().charAt(0);
    }
}
