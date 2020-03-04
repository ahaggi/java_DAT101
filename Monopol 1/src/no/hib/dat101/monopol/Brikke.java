package no.hib.dat101.monopol;

/**
 * Beskriver brikker i et monopolspill.
 * 
 * @author age-admin
 */
public class Brikke {
    
    private Rute plass; 

    /**
     * Lager en ny Brikke.
     */
    public Brikke(Rute start) {
        plass = start;
    }

    /**
     * Henter plass.
     *
     * @return nåværende plass
     */
    public Rute getPlass() {
        return plass;
    }

    /**
     * Setter ny plass.
     *
     * @param plass ny plass
     */
    public void setPlass(Rute plass) {
        this.plass = plass;
    }

}
