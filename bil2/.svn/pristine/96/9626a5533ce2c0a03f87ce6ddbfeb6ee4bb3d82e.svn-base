package no.hib.dat101.bil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implementerer ktegori.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema="kronbil")
public class Kategori {

    @Id
    private Character verdi;
    private Double pris;
    private String selskap;
    
    /**
     * Lager en ny Kategori.
     *
     */
    public Kategori() {
    }

    /**
     * Henter verdi.
     *
     * @return verdi
     */
    public Character getVerdi() {
        return verdi;
    }

    /**
     * Setter verdi.
     *
     * @param verdi verdi
     */
    public void setVerdi(Character verdi) {
        this.verdi = verdi;
    }

    /**
     * Henter pris.
     *
     * @return pris
     */
    public Double getPris() {
        return pris;
    }

    /**
     * Setter pris.
     *
     * @param pris pris
     */
    public void setPris(Double pris) {
        this.pris = pris;
    }

    public String getSelskap() {
		return selskap;
	}

	public void setSelskap(String selskap) {
		this.selskap = selskap;
	}

}
