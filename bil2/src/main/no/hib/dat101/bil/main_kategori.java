package no.hib.dat101.bil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class main_kategori {
	public static void main(String args[] ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");

        EntityManager em = emf.createEntityManager();

        // test ut adresse
        Kategori kategori = new Kategori();
        kategori.setVerdi('h');
        kategori.setPris(10.0);
        kategori.setSelskap("Bilutleie");
        // Utfør en transaksjon
        try {
            em.getTransaction().begin();
            em.persist(kategori);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }


	}
}
