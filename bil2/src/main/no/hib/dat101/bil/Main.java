package no.hib.dat101.bil;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * Et enkelt program for å verifisere koden.
 * 
 * @author Atle Geitung
 *
 */
public class Main {

    /**
     * Lager en ny Main.
     *
     */
    public Main() {
    }

    /**
     * Programmet.
     * 
     * @param args ikke i bruk
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");

        EntityManager em = emf.createEntityManager();

        // test ut adresse
        Adresse bergen = new Adresse();
        bergen.setGate("Byparken");
        bergen.setPostnr(5000);
        bergen.setPoststed("Bergen");

        // Utfør en transaksjon
        try {
            em.getTransaction().begin();
            em.persist(bergen);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        // Henter utleiekontor nummer 1
        Utleiekontor kontor = em.find(Utleiekontor.class, 1);

        // Henter kategori A
        Kategori kategoriA = em.find(Kategori.class, 'B');

        // lager en ny bil
        Bil nyBil = new Bil();
        nyBil.setRegnr("SX1008");
        nyBil.setFarge("Rød");
        nyBil.setKategori(kategoriA);
        nyBil.setMerke("Ford");
        nyBil.setModell("ukjent");
        nyBil.setLedig(Boolean.TRUE);
        nyBil.setKontor(kontor);
        
        System.out.println(nyBil.getKategori());

        kontor.leggTil(nyBil);

        // Utfør en transaksjon
        try {
            em.getTransaction().begin();
            em.persist(kontor);

            // legger bilen til i listen til kontoret
            em.persist(nyBil);
            em.flush();

            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        
        //skriver ut kontor 1 sine  biler
        Iterator<Bil> it = kontor.getBiler().iterator();
        while (it.hasNext()) {
        	System.out.println(it.next().getRegnr());			
		}
        
        
        // Sletter bilen slik at den kan legges til på nytt!
        try {
            em.getTransaction().begin();

            // legger bilen til i listen til kontoret
            kontor.fjern(nyBil);
            em.remove(nyBil);
            em.flush();

            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        em.close();
    }
}
