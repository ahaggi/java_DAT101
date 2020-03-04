package no.hib.dat101;

import java.util.*;

import javax.persistence.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji
 *
 */
@Entity
@Table(schema="bilutleie")
public class Kunde {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer kundeNr;
	private String fornavn;
	private String etternavn;
	
    @ManyToOne
    @JoinColumn(name="adresse", referencedColumnName="id",insertable=true, updatable=true)
	private Adresse adresse;
	private Integer tlfNr;
	
    @ManyToOne
    @JoinColumn(name="bilutleieSelskap", referencedColumnName="navn",insertable=true, updatable=true)
	private BilutleieSelskap bilutleieSelskap;
    
    @OneToMany(mappedBy="kunde", cascade=CascadeType.ALL)
	private List<Reservasjon> reservasjon = new ArrayList<Reservasjon>();

    @OneToMany(mappedBy="kunde", cascade=CascadeType.ALL)
	private List<Utleie> utleie = new ArrayList<Utleie>();
 
    @OneToMany(mappedBy="kunde", cascade=CascadeType.ALL)
	private List<Retur> retur = new ArrayList<Retur>();
	
	/**
	 * Lager ny kunde.
	 */
	public Kunde() {

	}
	
	/**
	 * Lager ny kunde.
	 * 
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param tlfNr
	 * @param bilutleieSelskap
	 */
	public Kunde(String fornavn, String etternavn, Adresse adresse, Integer tlfNr,	BilutleieSelskap bilutleieSelskap) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.bilutleieSelskap = bilutleieSelskap;
	}
	
	/**
	 * Legger til reservasjon i ArrayList.
	 * 
	 * @param res reservasjon
	 * @return om reservasjon er lagt til eller ikke.
	 */
	public boolean leggTilReservasjon(Reservasjon res) {
		boolean b=false;
		if (reservasjon.indexOf(res)==-1) 
			b=reservasjon.add(res);
		return b;
	}
	
	/**
	 * Fjerner reservasjon fra ArrayList.
	 * 
	 * @param res reservasjon
	 * @return om reservasjon er slettet eller ikke.
	 */
	public boolean fjernReservasjon(Reservasjon res) {
		boolean b=false;
		if (reservasjon.indexOf(res)!=-1) 
			b=reservasjon.remove(res);
		return b;
	}
	
	/**
	 * Legger til utleie i ArrayList.
	 * 
	 * @param utl utleie
	 * @return om utleie er lagt til eller ikke.
	 */
	public boolean leggTilUtleie(Utleie utl) {
		boolean b=false;
		if (this.utleie.indexOf(utl)==-1) 
			b=this.utleie.add(utl);
		return b;
	}
	
	/**
	 * Fjerner utleie fra ArrayList.
	 * 
	 * @param utl utleie
	 * @return om utleie er slettet eller ikke.
	 */
	public boolean fjernUtleie(Utleie utl) {
		boolean b=false;
		if (utleie.indexOf(utl)!=-1) 
			b=utleie.remove(utl);
		return b;
	}

	/**
	 * Legger til retur i ArrayList.
	 * 
	 * @param rtr retur
	 * @return om retur er lagt til eller ikke.
	 */
	public boolean leggTilRetur(Retur rtr) {
		boolean b=false;
		if (this.retur.indexOf(rtr)!=-1) 
			b=this.retur.add(rtr);
		return b;
	}
	
	/**
	 * Fjerner retur fra ArrayList.
	 * 
	 * @param rtr retur
	 * @return om retur er fjernet eller ikke.
	 */
	public boolean fjernRetur(Retur rtr) {
		boolean b=false;
		if (retur.indexOf(rtr)!=-1) 
			b=retur.remove(rtr);
		return b;
	}
	
	/**
	 * Henter kundeNr.
	 * 
	 * @return kundeNr
	 */
	public Integer getKundeNr() {
		return kundeNr;
	}

	/**
	 * Setter kundeNr.
	 * 
	 * @param kundeNr kundeNr
	 */
	public void setKundeNr(Integer kundeNr) {
		this.kundeNr = kundeNr;
	}

	/**
	 * Henter fornavn.
	 *  
	 * @return fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * Setter fornavn.
	 * 
	 * @param fornavn fornavn
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * Henter etternavn.
	 *  
	 * @return etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * Setter etternavn.
	 * 
	 * @param etternavn etternavn
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	/**
	 * Henter adresse.
	 * 
	 * @return adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter adresse.
	 * 
	 * @param adresse adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Henter tlfNr.
	 * 
	 * @return tlfNr
	 */
	public Integer getTlfNr() {
		return tlfNr;
	}

	/**
	 * Setter tlfNr.
	 * 
	 * @param tlfNr tlfNr
	 */
	public void setTlfNr(Integer tlfNr) {
		this.tlfNr = tlfNr;
	}

	/**
	 * Henter bilutleieSelskap.
	 * 
	 * @return bilutleieSelskap
	 */
	public BilutleieSelskap getBilutleieSelskap() {
		return bilutleieSelskap;
	}

	/**
	 * Setter bilutleieSelskap.
	 * 
	 * @param bilutleieSelskap bilutleieSelskap
	 */
	public void setBilutleieSelskap(BilutleieSelskap bilutleieSelskap) {
		this.bilutleieSelskap = bilutleieSelskap;
	}

	/**
	 * Henter liste med reservasjon.
	 * 
	 * @return reservasjon
	 */
	public List<Reservasjon> getReservasjon() {
		return reservasjon;
	}

	/**
	 * Setter liste med reservasjon.
	 * 
	 * @param reservasjon reservasjon
	 */
	public void setReservasjon(List<Reservasjon> reservasjon) {
		this.reservasjon = reservasjon;
	}

	/**
	 * Henter liste med utleie.
	 * 
	 * @return utleie
	 */
	public List<Utleie> getUtleie() {
		return utleie;
	}

	/**
	 * Setter en liste med utleie.
	 * 
	 * @param utleie utleie
	 */
	public void setUtleie(List<Utleie> utleie) {
		this.utleie = utleie;
	}

	/**
	 * Henter en liste med retur.
	 * 
	 * @return retur
	 */
	public List<Retur> getRetur() {
		return retur;
	}

	/**
	 * Setter en liste med retur.
	 * 
	 * @param retur retur
	 */
	public void setRetur(List<Retur> retur) {
		this.retur = retur;
	}

	@Override
	public String toString() {
		return "Kunde [kundeNr=" + kundeNr + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", adresse="
				+ adresse + ", tlfNr=" + tlfNr + ", bilutleieSelskap=" + bilutleieSelskap + "]";
	}
	
	
}
