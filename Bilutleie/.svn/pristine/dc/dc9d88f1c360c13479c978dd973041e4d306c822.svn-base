package no.hib.dat101;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji 
 *
 */
@Entity
@Table(schema = "bilutleie")
public class Utleie {
	@Id
	private Integer utleieNr;

	@OneToOne
	@JoinColumn(name = "resnr", referencedColumnName = "resnr")
	private Reservasjon resNr;

	@ManyToOne
	@JoinColumn(name = "kunde", referencedColumnName = "kundenr", insertable = true, updatable = true)
	private Kunde kunde;

	@OneToOne
	@JoinColumn(name = "bil", referencedColumnName = "regnr")
	private Bil bil;
	private Integer kmStand;

	@ManyToOne
	@JoinColumn(name = "utleiested", referencedColumnName = "kontornr", insertable = true, updatable = true)
	private Utleiekontor utleieSted;
	private Date fraDato;
	private Date tilDato;
	private Integer kredittKort;
	private Double pris;
	private Double betaltBelop;

	/**
	 * Lager ny utleie.
	 */
	public Utleie() {

	}

	/**
	 * Lager ny utleie.
	 * 
	 * @param resNr
	 * @param tilDato
	 * @param kredittKort
	 * @param betaltBelop
	 */
	public Utleie(Reservasjon resNr, Date tilDato, Integer kredittKort, Double betaltBelop) {
		super();
		
		this.utleieNr = resNr.getResNr();
		this.resNr = resNr;
		this.kunde = resNr.getKunde();
		this.utleieSted = resNr.getUtleieSted();
		this.bil = henteBil();
		this.kmStand = bil.getkmStand();
		this.fraDato = resNr.getFraDato();
		this.tilDato = tilDato;
		int antallDager = (int) (tilDato.getDate() - fraDato.getDate());
		this.kredittKort = kredittKort;
		this.pris = bil.getKategori().beregnetPris(antallDager);
		this.betaltBelop = betaltBelop;
		
	}

	/**
	 * Henter bil.
	 * 
	 * @return bil
	 */
	public Bil henteBil() {
		Bil bil = utleieSted.hentBil(resNr.getKategori());
		if (bil!=null)
			bil.setStatus(false);
		return bil;
	}

	/**
	 * Henter utleieNr.
	 * 
	 * @return utleieNr
	 */
	public Integer getUtleieNr() {
		return utleieNr;
	}

	/**
	 * Henter resNr.
	 * 
	 * @return resNr
	 */
	public Reservasjon getResNr() {
		return resNr;
	}

	/**
	 * Setter resNr.
	 * 
	 * @param resNr resNr
	 */
	public void setResNr(Reservasjon resNr) {
		this.resNr = resNr;
	}

	/**
	 * Henter kunde.
	 * 
	 * @return kunde
	 */
	public Kunde getKunde() {
		return kunde;
	}

	/**
	 * Setter kunde.
	 * 
	 * @param kunde kunde
	 */
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	/**
	 * Henter bil.
	 * 
	 * @return bil
	 */
	public Bil getBil() {
		return bil;
	}

	/**
	 * Setter bil
	 * 
	 * @param bil bil
	 */
	public void setBil(Bil bil) {
		this.bil = bil;
	}

	/**
	 * Henter kmStand.
	 * 
	 * @return kmStand
	 */
	public Integer getKmStand() {
		return kmStand;
	}

	/**
	 * Setter kmStand.
	 * 
	 * @param kmStand kmStand
	 */
	public void setKmStand(Integer kmStand) {
		this.kmStand = kmStand;
	}

	/**
	 * Henter returSted.
	 * 
	 * @return returSted
	 */
	public Utleiekontor getReturSted() {
		return resNr.getReturSted();
	}
	/**
	 * Henter utleieSted.
	 * 
	 * @return utleieSted
	 */
	public Utleiekontor getUtleieSted() {
		return utleieSted;
	}

	/**
	 * Setter utleieSted.
	 * 
	 * @param utleieSted utleieSted
	 */
	public void setUtleieSted(Utleiekontor utleieSted) {
		this.utleieSted = utleieSted;
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
	 * @param fraDato fraDato
	 */
	public void setFraDato(Date fraDato) {
		this.fraDato = fraDato;
	}

	/**
	 * Henter tilDato.
	 * 
	 * @return tilDato
	 */
	public Date getTilDato() {
		return tilDato;
	}

	/**
	 * Setter tilDato.
	 * 
	 * @param tilDato tilDato
	 */
	public void setTilDato(Date tilDato) {
		this.tilDato = tilDato;
	}

	/**
	 * Henter kredittKort.
	 * 
	 * @return kredittKort
	 */
	public Integer getKredittKort() {
		return kredittKort;
	}

	/**
	 * Setter kredittKort.
	 * 
	 * @param kredittKort kredittKort
	 */
	public void setKredittKort(Integer kredittKort) {
		this.kredittKort = kredittKort;
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

	/**
	 * Henter betaltBelop.
	 * 
	 * @return betaltBelop
	 */
	public Double getBetaltBelop() {
		return betaltBelop;
	}

	/**
	 * Setter betaltBelop.
	 * 
	 * @param betaltBelop betaltBelop
	 */
	public void setBetaltBelop(Double betaltBelop) {
		this.betaltBelop = betaltBelop;
	}

	@Override
	public String toString() {
		return "Utleie [utleieNr=" + utleieNr + ", resNr=" + resNr + ", kunde=" + kunde + ", bil=" + bil + ", kmStand="
				+ kmStand + ", utleieSted=" + utleieSted + ", fraDato=" + fraDato + ", tilDato=" + tilDato
				+ ", kredittKort=" + kredittKort + ", pris=" + pris + ", betaltBelop=" + betaltBelop + "]";
	}

}
