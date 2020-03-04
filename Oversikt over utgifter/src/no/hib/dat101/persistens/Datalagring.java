package no.hib.dat101.persistens;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import no.hib.dat101.domene.Kategori;
import no.hib.dat101.domene.Utgift;

/**
 * Beskriver persistering av utgifter.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class Datalagring {

    // databasen til dette eksempelet
    private final List<Utgift> utgifter = new ArrayList<Utgift>();
    private final List<Kategori> kategorier = new ArrayList<Kategori>();

    {
        kategorier.add(new Kategori("Mat"));
        kategorier.add(new Kategori("Klår"));
        kategorier.add(new Kategori("Buss"));
    }

    /**
     * Legg til en ny utgift.
     *
     * @param utgift ny utgift
     */
    public void lagreNyUtgift(final Utgift utgift) {
        utgifter.add(utgift);
    }

    /**
     * Legg til en ny kategori.
     *
     * @param kategori ny kategori
     */
    public void lagreNyKategori(final Kategori kategori) {
        kategorier.add(kategori);
    }

    /**
     * Finn alle kategorier.
     *
     * @return liste av kategorier
     */
    public List<Kategori> finnKategorier() {
        return kategorier;
    }

    /**
     * Finner utgifter for en dato i databasen.
     *
     * @param date dato
     * @return utgifter
     */
    public List<Utgift> finnDagUtgifter(final LocalDate date) {
        final List<Utgift> datoUtgifter = new ArrayList<Utgift>();
        for (final Utgift utgift : utgifter) {
            if (utgift.getDato().equals(date)) {
                datoUtgifter.add(utgift);
            }
        }
        return datoUtgifter;
    }

    /**
     * Finner utgifter for en måned i databasen.
     *
     * @param dato dato
     * @return utgifter
     */
    public List<Utgift> finnManedUtgifter(final LocalDate dato) {
        final List<Utgift> manedUtgifter = new ArrayList<Utgift>();
        for (final Utgift utgift : utgifter) {
            if (utgift.getDato().getMonth().equals(dato.getMonth())) {
                manedUtgifter.add(utgift);
            }
        }
        return manedUtgifter;
    }

}
