package no.hib.dat101.bil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Implementerer utleiekotor.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema="kronbil")
public class Utleiekontor {

    @Id
    private Integer nummer;
    private String telefon;
    @OneToOne
    @JoinColumn(name="adresse", referencedColumnName="id")
    private Adresse adresse;
    
    
    //legg merk til manyToOne ==> joincolumn
    //    ,,,,,,    OneToMany ==> mappedBy
    @OneToMany(mappedBy="kontor", cascade=CascadeType.ALL)
    private List<Bil> biler = new ArrayList<Bil>();

    /**
     * Lager en ny Utleiekontor.
     *
     */
    public Utleiekontor() {
    }

    /**
     * Legger til en ny bil.
     * 
     * @param bil ny bil
     */
    public void leggTil(Bil bil) {
        biler.add(bil);
    }
    
    /**
     * Fjerner en bil.
     * 
     * @param bil bil som skal fjernes
     */
    public void fjern(Bil bil) {
        biler.remove(bil);
    }
    
    /**
     * Henter en liste av biler med gitt kategori.
     * 
     * @param kategori kategori
     * @return liste av biler
     */
    public List<Bil> hentBiler(Kategori kategori) {
        List<Bil> retur = new ArrayList<Bil>();
        for (Bil bil : biler) {
            if (bil.getKategori().equals(kategori)) {
                retur.add(bil);
            }
        }
        return retur;
    }
    
    /**
     * Henter nummer.
     *
     * @return nummer
     */
    public Integer getNummer() {
        return nummer;
    }

    /**
     * Setter nummer.
     *
     * @param nummer nummer
     */
    public void setNummer(Integer nummer) {
        this.nummer = nummer;
    }

    /**
     * Henter telefon.
     *
     * @return telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setter telefon.
     *
     * @param telefon telefon
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
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
     * Henter biler.
     *
     * @return biler
     */
    public List<Bil> getBiler() {
        return biler;
    }

    /**
     * Setter biler.
     *
     * @param biler biler
     */
    public void setBiler(List<Bil> biler) {
        this.biler = biler;
    }

    @Override
    public String toString() {
        return "Utleiekontor [nummer=" + nummer + ", telefon=" + telefon + ", adresse=" + adresse + ", biler=" + biler
                + "]";
    }

}
