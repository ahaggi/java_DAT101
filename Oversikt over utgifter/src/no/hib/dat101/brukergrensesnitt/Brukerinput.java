package no.hib.dat101.brukergrensesnitt;

import java.util.List;
import java.util.Scanner;

import no.hib.dat101.domene.Kategori;

/**
 * Beskriver UI-komponenter.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class Brukerinput {

    private final Scanner taste = new Scanner(System.in);

    /**
     * Skriv et objekt. Benytter toString.
     *
     * @param o objektet
     */
    public final void skrivUt(final Object o) {
        System.out.println("" + o);
    }

    /**
     * Leser neste tekst.
     *
     * @param ledetekst ledetekst
     * @return tekst
     */
    public final String lesInnTekst(final String ledetekst) {
        System.out.print(ledetekst);
        final String tekst = taste.next();
        taste.nextLine();
        return tekst;
    }

    /**
     * Leser neste flyttall.
     *
     * @param ledetekst ledetekst
     * @return flyttall
     */
    public final Double lesInnFlyttall(final String ledetekst) {
        System.out.print(ledetekst);
        final Double tall = taste.nextDouble();
        taste.nextLine();
        return tall;
    }

    /**
     * Leser neste helyall.
     *
     * @return heltallet
     */
    public final Integer lesInnHeltall() {
        final Integer tall = taste.nextInt();
        taste.nextLine();
        return tall;
    }

    /**
     * Velger verdi fra liste av kategorier.
     *
     * @param alternativer kategoriene
     * @return valgt kategori
     */
    public final Kategori velgIListe(final List<Kategori> alternativer) {

        Integer valgt;
        do {
            String ledetekst = "Valg (";
            for (int i = 0; i < alternativer.size(); i++) {
                ledetekst += i + 1;
                ledetekst += "=" + alternativer.get(i) + ", ";
            }
            ledetekst += ") > ";

            System.out.print(ledetekst);
            valgt = lesInnHeltall();

        } while (valgt < 1 || valgt > alternativer.size());

        return alternativer.get(valgt - 1);
    }

}
