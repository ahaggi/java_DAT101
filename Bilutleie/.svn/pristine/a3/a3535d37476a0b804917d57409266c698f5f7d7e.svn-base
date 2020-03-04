package no.hib.dat101;

import java.util.InputMismatchException;

import javax.persistence.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji
 *
 */
@Entity
@Table(schema="bilutleie")

public class Kategori implements Comparable<Kategori> {
	@Id
	private Character type;
	private Double pris;
	
	@ManyToOne
    @JoinColumn(name="bilutleieSelskap", referencedColumnName="navn",insertable=true, updatable=true)
	private BilutleieSelskap bilutleieSelskap; 
	
	//prisA/prisB/prisC/prisD heter "pris" i databasen
	
	/**
	 * Lager en ny kategori.
	 */
	public Kategori() {
		
	}

	public Kategori(Character type,BilutleieSelskap sls) {
		if (type>=65 && type<=68 ) {
			this.type = type;
			pris=finnPris();
			bilutleieSelskap=sls;
		}else{
			throw new InputMismatchException("ugyldig kategori");
		}
	}
     //finnPris vil bli slettet 
	public Double finnPris() {
		if (type == 'A') {
			pris = 1000. ;
		} else if (type == 'B') {
			pris = 2000. ;
		} else if (type == 'C') {
			pris = 3000. ;
		} else if (type == 'D') {
			pris = 4000. ;
		}
		return pris;
	}
	
	public double beregnetPris(int dager){
		
		return pris * dager;
	}
	
	/**
	 * Henter type.
	 * 
	 * @return type
	 */
	public Character getType() {
		return type;
	}

	/**
	 * Setter type.
	 * 
	 * @param type type
	 */
	public void setType(Character type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Kategori [type=" + type + ", pris=" + pris + "]";
	}

	@Override
	public int compareTo(Kategori denAndre) {
		int res=0;
		res =this.getType().compareTo(denAndre.getType());
		return res;
	}
	
	
	
}
