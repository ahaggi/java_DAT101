package no.hib.dat101.monopol;

import java.util.ArrayList;
import java.util.List;

/**
 * Beskriver et monopol-brett.
 *  
 * @author Atle Geitung
 */
public class Brett {
    
    private final static int ANT_RUTER = 40;
    private List<Rute> brett;

    /**
     * Lager en ny Brett.
     */
    public Brett() {
        brett = new ArrayList<Rute>(ANT_RUTER);
        brett.add(new Rute("start"));
        for (int i = 1; i < ANT_RUTER; i++) {
            brett.add(new Rute("rute " + i));
        }
    }

    /**
     * Finner første forekomst av en en navngitt rute.
     * 
     * @param navn navnet
     * @return rute med navnet navn
     */
    public Rute finnRute(String navn) {
        Rute funnetRute = null;
        for (Rute rute : brett) {
            if (rute.getNavn().equals(navn)) {
                funnetRute = rute;
                break;
            }
        }
        return funnetRute;
    }

    /**
     * Finner rute sum plasser etter plass på brettet.
     * 
     * @param plass plass å søke fra
     * @param sum antall ruter frem
     * @return ny rute
     */
    public Rute finnRute(Rute plass, Integer sum) {
        Boolean funnet = false;
        Integer pos = 0;
        for (; pos < brett.size() && !funnet; pos++) {
            if (brett.get(pos).getNavn().equals(plass.getNavn())) {
                funnet = true;
            }
        }
        pos = (pos - 1 + sum) % brett.size();
        return brett.get(pos);
    }

}
