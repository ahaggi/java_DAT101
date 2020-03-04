package no.hib.dat101;

import javax.persistence.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji 
 *
 */
@Entity
@Table(schema="bilutleie", name="bil")

public class Bil {
    @Id
	private String regNr;
	private String merke;
	private String modell;
	private String farge;
	@OneToOne
    @JoinColumn(name="kategori", referencedColumnName="type",insertable=true, updatable=true)
	private Kategori kategori;
	private Integer kmStand;
	private Boolean status;
    @ManyToOne
    @JoinColumn(name="utleiekontor", referencedColumnName="kontornr",insertable=true, updatable=true)
	private Utleiekontor utleiekontor;
	
	/**
	 * tom konstruktør
	 */
	public Bil(){

	}

	/**
	 * lag ny bil
	 */
	public Bil(String regNr, String merke, String modell, String farge, Kategori kategori, Integer kmStand,
			Boolean status, Utleiekontor utleiekontor) {
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.kategori = kategori;
		this.kmStand = kmStand;
		this.status = status;
		this.utleiekontor = utleiekontor;
	}

	/**
	 * henter regNr
	 * @return
	 */
	public String getregNr() {
		return regNr;
	}

	/**
	 * setter regNr
	 * 
	 */
	public void setregNr(String regNr) {
		this.regNr = regNr;
	}

	/**
	 * henter merke
	 */
	public String getMerke() {
		return merke;
	}

	/**
	 * setter merke
	 */
	public void setMerke(String merke) {
		this.merke = merke;
	}

	/**
	 * henter modell
	 */
	public String getModell() {
		return modell;
	}

	/**
	 * setter modell
	 */
	public void setModell(String modell) {
		this.modell = modell;
	}

	/**
	 * henter farge
	 */
	public String getFarge() {
		return farge;
	}

	/**
	 * setter farge
	 */
	public void setFarge(String farge) {
		this.farge = farge;
	}

	/**
	 * henter kmStand
	 */
	public Integer getkmStand() {
		return kmStand;
	}

	/**
	 * setter kmStand
	 */
	public void setkmStand(Integer kmStand) {
		this.kmStand = kmStand;
	}

	/**
	 * henter status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * setter status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * setter kategori
	 */
	public Kategori getKategori() {
		return kategori;
	}

	/**
	 * setter kategori
	 */
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	/**
	 * henter utleiekontor
	 * @return
	 */
	public Utleiekontor getUtleiekontor() {
		return utleiekontor;
	}

	/**
	 * setter utleiekontor
	 */
	public void setUtleiekontor(Utleiekontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	@Override
	public String toString() {
		return "Bil [regNr=" + regNr + ", merke=" + merke + ", modell=" + modell + ", farge=" + farge + ", kategori="
				+ kategori + ", kmStand=" + kmStand + ", status=" + status + ", utleiekontor=" + utleiekontor + "]";
	}
	
	
}
