package no.hib.dat101.domene;

import java.time.LocalDate;

/**
 * Beskrivelse av konseptet Utgift. En del av domenemodellen.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class Utgift {

    private String beskrivelse;
    private Double belop;
    private Kategori kategori;
    private LocalDate dato;

    /**
     * Henter beskrivelse.
     *
     * @return beskrivelsen
     */
    public final String getBeskrivelse() {
        return beskrivelse;
    }

    /**
     * Setter beskrivelse.
     *
     * @param beskrivelse ny beskrivelse
     */
    public final void setBeskrivelse(final String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    /**
     * Henter belop.
     *
     * @return belopet
     */
    public final Double getBelop() {
        return belop;
    }

    /**
     * Setter belopet.
     *
     * @param belop belopet
     */
    public final void setBelop(final Double belop) {
        this.belop = belop;
    }

    /**
     * Henter kategori.
     *
     * @return kategorien
     */
    public final Kategori getKategori() {
        return kategori;
    }

    /**
     * Setter kategorien.
     *
     * @param kategori kategorien
     */
    public final void setKategori(final Kategori kategori) {
        this.kategori = kategori;
    }

    /**
     * Henter dato.
     *
     * @return datoen
     */
    public final LocalDate getDato() {
        return dato;
    }

    /**
     * Setter datoen.
     *
     * @param dato datoen
     */
    public final void setDato(final LocalDate dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Utgift [beskrivelse=" + beskrivelse + ", belop=" + belop + ", kategori=" + kategori + ", dato=" + dato
                + "]";
    }

}
