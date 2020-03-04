package no.hib.dat101.bil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Implementerer bil.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema="kronbil")
public class Bil {

    @Id
    private String regnr;
    private String merke;
    private String modell;
    private String farge;
    private Boolean ledig;
    
    @OneToOne
    @JoinColumn(name="kategori", referencedColumnName="verdi")
    private Kategori kategori;
    
    //legg merk til manyToOne ==> joincolumn
    //    ,,,,,,    OneToMany ==> mappedBy
    @ManyToOne
    @JoinColumn(name="kontor", referencedColumnName="nummer")
    private Utleiekontor kontor;
    
    /**
     * Lager en ny Bil.
     *
     */
    public Bil() {
    }

    /**
     * Henter regnr.
     *
     * @return regnr
     */
    public String getRegnr() {
        return regnr;
    }

    /**
     * Setter regnr.
     *
     * @param regnr regnr
     */
    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public Utleiekontor getKontor() {
		return kontor;
	}

	public void setKontor(Utleiekontor kontor) {
		this.kontor = kontor;
	}

	/**
     * Henter merke.
     *
     * @return merke
     */
    public String getMerke() {
        return merke;
    }

    /**
     * Setter merke.
     *
     * @param merke merke
     */
    public void setMerke(String merke) {
        this.merke = merke;
    }

    /**
     * Henter modell.
     *
     * @return modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * Setter modell.
     *
     * @param modell modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * Henter farge.
     *
     * @return farge
     */
    public String getFarge() {
        return farge;
    }

    /**
     * Setter farge.
     *
     * @param farge farge
     */
    public void setFarge(String farge) {
        this.farge = farge;
    }

    /**
     * Henter ledig.
     *
     * @return ledig
     */
    public Boolean getLedig() {
        return ledig;
    }

    /**
     * Setter ledig.
     *
     * @param ledig ledig
     */
    public void setLedig(Boolean ledig) {
        this.ledig = ledig;
    }

    /**
     * Henter kategori.
     *
     * @return kategori
     */
    public Kategori getKategori() {
        return kategori;
    }

    /**
     * Setter kategori.
     *
     * @param kategori kategori
     */
    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }


}
