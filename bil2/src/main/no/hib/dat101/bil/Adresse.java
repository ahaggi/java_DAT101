package no.hib.dat101.bil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implementerer adresser.
 * 
 * @author Atle Geitung
 *
 */
@Entity
@Table(schema="kronbil")
public class Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String gate;
    private Integer postnr;
    private String poststed;
    
    /**
     * Lager en ny Adresse.
     *
     */
    public Adresse() {
    }

    /**
     * Henter gate.
     *
     * @return gate
     */
    public String getGate() {
        return gate;
    }

    /**
     * Setter gate.
     *
     * @param gate gate
     */
    public void setGate(String gate) {
        this.gate = gate;
    }

    /**
     * Henter postnr.
     *
     * @return postnr
     */
    public Integer getPostnr() {
        return postnr;
    }

    /**
     * Setter postnr.
     *
     * @param postnr postnr
     */
    public void setPostnr(Integer postnr) {
        this.postnr = postnr;
    }

    /**
     * Henter poststed.
     *
     * @return poststed
     */
    public String getPoststed() {
        return poststed;
    }

    /**
     * Setter poststed.
     *
     * @param poststed poststed
     */
    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    @Override
    public String toString() {
        return "Afresse [gate=" + gate + ", postnr=" + postnr + ", poststed=" + poststed + "]";
    }

}
