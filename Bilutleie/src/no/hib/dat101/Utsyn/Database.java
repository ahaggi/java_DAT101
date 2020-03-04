package no.hib.dat101.Utsyn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import no.hib.dat101.*;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji
 *
 */
public class Database {

	private BilutleieSelskap selskap;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");
	EntityManager em = emf.createEntityManager();

	public Database() {
		selskap = em.find(BilutleieSelskap.class, "Avis");
	}

	public Database(BilutleieSelskap selskap) {
		this.selskap = selskap;
	}

	public Database(String navn) {
		selskap = em.find(BilutleieSelskap.class, navn);
	}
	
	/**
	 * Henter bilutleieSelskap fra database.
	 * 
	 * @return bilutleieSelskap
	 */
	public BilutleieSelskap hentFraDb() {
		return em.find(BilutleieSelskap.class, "Avis");
	}
	
	/**
	 * Henter en reservasjon fra database.
	 * 
	 * @param resNr reservasjonsNr
	 * @return reservasjon
	 */
	public Reservasjon hentReservasjonFraDb(Integer resNr) {
		return em.find(Reservasjon.class, resNr);
	}
	
	/**
	 * Henter en utleie fra database.
	 * 
	 * @param utleieNr utleieNr
	 * @return utleie
	 */
	public Utleie hentUtleieFraDb(Integer utleieNr) {
		return em.find(Utleie.class, utleieNr);
	}
	
	/**
	 * Henter en retur fra database.
	 * 
	 * @param rtrNr returNr
	 * @return retur
	 */
	public Retur hentReturFraDb(Integer rtrNr) {
		return em.find(Retur.class, rtrNr);
	}

	/**
	 * Persister utleieSelskap til database.
	 */
	public void persist() {
		try {
			em.getTransaction().begin();
			em.persist(selskap);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}
	
	/**
	 * Persister en adresse til database.
	 * 
	 * @param adresse adresse
	 */
	public void persist(Adresse adresse) {
		try {
			em.getTransaction().begin();
			em.persist(adresse);
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}

	/**
	 * Lukker kobling til database.
	 */
	public void close() {
		em.close();
		emf.close();
	}

	/**
	 * Henter bilutleieSelskap.
	 * 
	 * @return bilutleieSelskap
	 */
	public BilutleieSelskap getSelskap() {
		return selskap;
	}

	/**
	 * Setter bilutleieSelskap.
	 * 
	 * @param selskap bilutleieSelskap
	 */
	public void setSelskap(BilutleieSelskap selskap) {
		this.selskap = selskap;
	}

	@Override
	public String toString() {
		return "Database [selskap=" + selskap + "]";
	}

}
