package no.hib.dat101.monopol;

/**
 * Beskriver en rute på et monopol-brett.
 * 
 * @author Atle Geitung
 */
public  class Rute {
    
    private String navn;

    /**
     * Lager en ny Rute.
     *
     * @param navn navn til ruten
     */
    public Rute(String navn) {
        this.navn = navn;
    }
    
    public void landetPa(Spiller spiller){
    	
    };

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

}


