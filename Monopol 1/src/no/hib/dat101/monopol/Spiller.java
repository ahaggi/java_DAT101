package no.hib.dat101.monopol;

import java.util.List;

/**
 * Beskriver en monopol-spiller.
 * 
 * @author Atle Geitung
 */
public class Spiller {
    
    private Brett brett;
    private Brikke brikke;
    private String navn;

    /**
     * Lager en ny Spiller.
     *
     * @param brett spillebrettet
     */
    public Spiller(Brett brett) {
        this.brett = brett;
        brikke = new Brikke(brett.finnRute("start"));
    }

    /**
     * Spiller ett trekk for spilleren.
     * 
     * @param terninger terningene
     */
    public void spillTrekk(List<Terning> terninger) {
        Integer sum = 0;
        for (Terning terning : terninger) {
            terning.trill();
            sum += terning.getVerdi();
        }
        Rute plass = brikke.getPlass();
        plass = brett.finnRute(plass, sum);
        brikke.setPlass(plass);
    }

    /**
     * Henter navn.
     *
     * @return navn
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Setter navn.
     *
     * @param navn navn
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * Henter brikke.
     *
     * @return brikke
     */
    public Brikke getBrikke() {
        return brikke;
    }

}
