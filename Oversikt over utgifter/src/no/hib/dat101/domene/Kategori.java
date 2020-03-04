package no.hib.dat101.domene;

/**
 * Beskriver konseptet Kategori. Er en del av domenemodellen.
 *
 * @author Atle Geitung
 */
public class Kategori {

    private String navn;

    /**
     * Lager en ny kategori med et navn.
     *
     * @param navn navnet
     */
    public Kategori(final String navn) {
        setNavn(navn);
    }

    /**
     * Henter navn.
     *
     * @return navnet
     */
    public final String getNavn() {
        return navn;
    }

    /**
     * Setter navn.
     *
     * @param navn nytt navn
     */
    public final void setNavn(final String navn) {
        this.navn = navn;
    }

    @Override
    public final String toString() {
        return "Kategori [navn=" + navn + "]";
    }

}
