package no.hib.dat101.controller;

import java.time.LocalDate;
import java.util.List;

import no.hib.dat101.brukergrensesnitt.Brukerinput;
import no.hib.dat101.brukergrensesnitt.Hovedmeny;
import no.hib.dat101.domene.Kategori;
import no.hib.dat101.domene.Pengeforbruk;
import no.hib.dat101.domene.Utgift;
import no.hib.dat101.persistens.Datalagring;

/**
 * Utgiftsappen. Denne har flere ansvarsområder, derfor bør den skrives om.
 *
 * @author Atle Geitung
 */
public class App {

    private final Brukerinput brukerinput = new Brukerinput();
    private final Hovedmeny hovedmeny = new Hovedmeny();

    private final Pengeforbruk pengeforbruk = new Pengeforbruk();

    private final Datalagring databasehjelper = new Datalagring();

    /**
     * Utfør appen.
     */
    public void kjor() {

        brukerinput.skrivUt("### Utgiftoversikt ###");

        char valg;
        do {
            valg = hovedmeny.velgIMeny();

            switch (valg) {
                case Hovedmeny.REGISTRER_UTGIFT:
                    registrerUtgift();
                    break;
                case Hovedmeny.DAGENS_UTGIFTER:
                    visDagensUtgifter();
                    break;
                case Hovedmeny.MAANEDSOVERSIKT:
                    visMaanedsoversikt();
                    break;
                case Hovedmeny.REGISTRER_KATEGORI:
                    registrerNyKategori();
                    break;
                case Hovedmeny.AVSLUTT:
                default:
            }
        } while (valg != Hovedmeny.AVSLUTT);
    }

    /**
     * Registre utgift.
     */
    private void registrerUtgift() {
        final List<Kategori> kategorier = hentKategorier();

        brukerinput.skrivUt("----------------------");

        final Double belop = brukerinput.lesInnFlyttall("Skriv inn belåp: ");
        final Kategori kategori = brukerinput.velgIListe(kategorier);

        pengeforbruk.registrerUtgift(LocalDate.now(), belop, kategori);
    }

    /**
     * Vis dagens utgifter.
     */
    private void visDagensUtgifter() {
        brukerinput.skrivUt("----------------------");

        brukerinput.skrivUt("Utgifter for i dag (" + LocalDate.now() + ")");
        final List<Utgift> utgifter = pengeforbruk.finnDagensUtgifter();
        for (final Utgift utgift : utgifter) {
            visUtgift(utgift);
        }
    }

    /**
     * Vis månedsoversikt.
     */
    private void visMaanedsoversikt() {
        brukerinput.skrivUt("----------------------");

        brukerinput.skrivUt("Utgifter for denne måneden (" + LocalDate.now().getMonth() + ")");
        final List<Utgift> utgifter = pengeforbruk.finnManedensUtgifter();
        for (final Utgift utgift : utgifter) {
            visUtgift(utgift);
        }
    }

    /**
     * Legg til ny kategori.
     */
    private void registrerNyKategori() {
        brukerinput.skrivUt("----------------------");

        final String navn = brukerinput.lesInnTekst("Skriv inn kategorinavn: ");
        final Kategori kategori = new Kategori(navn);

        databasehjelper.lagreNyKategori(kategori);
    }

    /**
     * Viser info om en utgift på en linje.
     * 
     * @param utgift utgift
     */
    private void visUtgift(final Utgift utgift) {
        brukerinput.skrivUt("" + utgift.getDato() + " " + utgift.getBelop() + " " + utgift.getKategori().getNavn());
    }
    
    /**
     * Hent kategorier.
     *
     * @return liste av kategorier
     */
    private List<Kategori> hentKategorier() {
        return databasehjelper.finnKategorier();
    }

}
