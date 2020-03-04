package no.hib.dat101.monopol;

import java.util.ArrayList;
import java.util.List;

/**
 * Realiserer et monopolspill.
 * 
 * @author Atle Geitung
 */
public class Monopolspill {

    private final static int N = 20;

    private List<Terning> terninger;
    private List<Spiller> spillere;
    private Brett brett;

    private Integer rundeNr;

    /**
     * Lager en ny Monopolspill.
     */
    public Monopolspill(Integer antallSpillere) {
        brett = new Brett();
        
        // Lager en liste av to terninger
        terninger = new ArrayList<Terning>();
        terninger.add(new Terning());
        terninger.add(new Terning());

        // lager spillerne
        spillere = new ArrayList<Spiller>();
        for (int i = 0; i < antallSpillere; i++) {
            spillere.add(new Spiller(brett));
        }
    }

    /**
     * Starter og spiller monopol.
     */
    public void spill() {
        for (rundeNr = 0; rundeNr < N; rundeNr++) {
            spillRunde();
        }
    }

    /**
     * Spiller en enkelt runde.
     */
    private void spillRunde() {
        for (Spiller spiller : spillere) {
            spiller.spillTrekk(terninger);
            
            // TODO Må fjernes fra denne klassen!
            System.out.println("Runde " + rundeNr + "Spiller " + spiller.getNavn() + " flytter til "
                    + spiller.getBrikke().getPlass().getNavn() + " med terningkast " + terninger.get(0).getVerdi() + " "
                    + terninger.get(1).getVerdi());
        }
    }
}
