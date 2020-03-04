package no.hib.dat101;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji 
 *
 */
@Entity
@Table(schema="bilutleie", name="adresse")
public class Adresse {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	private String gateadresse;
	private Integer postnr;
	private String poststed;
	
	/**
     * tom konstruktør
	 */
	public Adresse() {
		
	}
	

	/**
     * Lager en ny Adresse.
	 */
	public Adresse(String gateadresse, Integer postnr, String poststed) {
		this.gateadresse = gateadresse;
		this.postnr = postnr;
		this.poststed = poststed;
	}

	/**
	 * henter gate
	 */
	public String getgateadresse() {
		return gateadresse;
	}

	/**
	 * setter gateadresse
	 */
	public void setgateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	
	/**
	 * henter postNr
	 */
	public Integer getpostnr() {
		return postnr;
	}

	
	/**
	 * setter postNr
	 */
	public void setpostnr(Integer postnr) {
		this.postnr = postnr;
	}

	/**
	 * henter postSted
	 */
	public String getpoststed() {
		return poststed;
	}

	/**
	 * setter poststed
	 */
	public void setpoststed(String poststed) {
		this.poststed = poststed;
	}

	
	@Override
	public String toString() {
		return "Adresse [gateadresse=" + gateadresse + ", postnr=" + postnr + ", poststed=" + poststed + "]";
	}
	
	

}
