package no.hib.dat101;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji 
 *
 */
@Entity
@Table(schema="bilutleie")
public class Reservasjon {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer resNr;
	
    @ManyToOne
    @JoinColumn(name="kunde", referencedColumnName="kundenr",insertable=true, updatable=true)
	private Kunde kunde;
	private Date fraDato;
	private Date tilDato;
	private Integer antallDager;
	
	@OneToOne
    @JoinColumn(name="kategori", referencedColumnName="type")
	private Kategori kategori;
	private Double beregnetPris;
	
    @ManyToOne
    @JoinColumn(name="utleiested", referencedColumnName="kontornr",insertable=true, updatable=true)
	private Utleiekontor utleieSted;
    
    @ManyToOne
    @JoinColumn(name="retursted", referencedColumnName="kontornr",insertable=true, updatable=true)
	private Utleiekontor returSted;
	
	/**
	 * tom konstruktør
	 */
	public Reservasjon() {
		
	}
	
	/**
     * Lager en ny reservasjon.
	 */
	public Reservasjon(Kunde kunde, Date fraDato, Date tilDato, Kategori kategori, Utleiekontor utleieSted, Utleiekontor returSted) {
		this.kunde = kunde;
		this.fraDato = fraDato;
		this.tilDato = tilDato;
		this.antallDager = (int)  (tilDato.getDate() - fraDato.getDate());
		this.kategori = kategori;
		this.beregnetPris = kategori.beregnetPris(antallDager);
		this.utleieSted = utleieSted;
		this.returSted = returSted;
	}

	/**
     * Henter resNr.
     *
     * @return resNr.
     */
	public Integer getResNr() {
		return resNr;
	}
	/**
     * Henter kunde.
     *
     * @return kunde.
     */
	public Kunde getKunde() {
		return kunde;
	}

	  /**
     * Setter kunde.
     *
     * @param kunde.
     */
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	/**
     * Henter fraDato.
     *
     * @return fraDato
     */
	public Date getFraDato() {
		return fraDato;
	}

	  /**
     * Setter fraDato.
     *
     * @param fraDato.
     */
	public void setFraDato(Date fraDato) {
		this.fraDato = fraDato;
	}

	/**
     * Henter tilDato.
     *
     * @return tilDato.
     */
	public Date getTilDato() {
		return tilDato;
	}

	  /**
     * Setter tilDato.
     *
     * @param tilDato.
     */
	public void setTilDato(Date tilDato) {
		this.tilDato = tilDato;
	}

	/**
     * Henter antallDager.
     *
     * @return antallDager.
     */
	public Integer getAntallDager() {
		return antallDager;
	}

	  /**
     * Setter antallDager.
     *
     * @param antallDager.
     */
	public void setAntallDager(Integer antallDager) {
		this.antallDager = antallDager;
	}

	/**
     * Henter kategori.
     *
     * @return kategori.
     */
	public Kategori getKategori() {
		return kategori;
	}

	  /**
     * Setter kategori.
     *
     * @param kategori.
     */
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	/**
     * Henter beregnetPris.
     *
     * @return beregnetPris.
     */
	public Double getBeregnetPris() {
		return beregnetPris;
	}

	  /**
     * Setter beregnetPris.
     *
     * @param beregnetPris.
     */
	public void setBeregnetPris(Double beregnetPris) {
		this.beregnetPris = beregnetPris;
	}

	/**
     * Henter utleieSted.
     *
     * @return utleieSted.
     */
	public Utleiekontor getUtleieSted() {
		return utleieSted;
	}

    /**
     * Setter utleieSted.
     *
     * @param utleieSted.
     */
	public void setUtleieSted(Utleiekontor utleieSted) {
		this.utleieSted = utleieSted;
	}

	/**
     * Henter returSted.
     *
     * @return returSted.
     */
	public Utleiekontor getReturSted() {
		return returSted;
	}
	
    /**
     * Setter returSted.
     *
     * @param returSted.
     */
	public void setReturSted(Utleiekontor returSted) {
		this.returSted = returSted;
	}

	@Override
	public String toString() {
		return "Reservasjon [resNr=" + resNr + ", kunde=" + kunde + ", fraDato=" + fraDato + ", tilDato=" + tilDato
				+ ", antallDager=" + antallDager + ", kategori=" + kategori + ", beregnetPris=" + beregnetPris
				+ ", utleieSted=" + utleieSted + ", returSted=" + returSted + "]";
	}
}
