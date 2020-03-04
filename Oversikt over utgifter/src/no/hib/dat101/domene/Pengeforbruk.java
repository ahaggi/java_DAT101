package no.hib.dat101.domene;

import java.time.LocalDate;
import java.util.List;

import no.hib.dat101.persistens.Datalagring;

/**
 * Beskriver konseptet Pengeforbruk. Er en del av domenemodellen.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class Pengeforbruk {

    private final Datalagring databasehjelper = new Datalagring();

    /**
     * Registrer utgift.
     *
     * @param date dato
     * @param belop belåp
     * @param kategori kategori
     */
    public void registrerUtgift(final LocalDate date, final Double belop, final Kategori kategori) {

        final Utgift utgift = new Utgift();

        utgift.setDato(date);
        utgift.setBelop(belop);
        utgift.setKategori(kategori);

        databasehjelper.lagreNyUtgift(utgift);
    }

    /**
     * Finner dagens utgifter.
     *
     * @return dagens utgifter
     */
    public List<Utgift> finnDagensUtgifter() {
        final List<Utgift> utgifter = databasehjelper.finnDagUtgifter(LocalDate.now());
        return utgifter;
    }

    /**
     * Finner denne månedens utgifter.
     *
     * @return månedens utgifter
     */
    public List<Utgift> finnManedensUtgifter() {
        final List<Utgift> utgifter = databasehjelper.finnManedUtgifter(LocalDate.now());
        return utgifter;
    }

}
