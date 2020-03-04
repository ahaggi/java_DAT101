package kontroll;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import model.*;


public class DAO {


	EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");
	EntityManager em = emf.createEntityManager();

	public void leggTilKlasse(Klasse k) {
		persist(k);
		
	}
	public void leggTilStudent(Student s) {
		persist(s);
	}
	
	public Klasse finnKlasse(String kls) {
		return em.find(Klasse.class, kls);
	}
	
	public Student finnStudent(String id) {
		return em.find(Student.class, id);
	}

	public void oppdaterStudent(Student s) {
		merge(s);
	}
	public void  oppdaterKlasse(Klasse k) {
		persist(k);

	}

	public void slettStudent(String id) {
		remove(em.find(Student.class, id));
	}
	public void  slettKlasse(String k) {
		Klasse kl=em.find(Klasse.class, k);
		remove(kl);

	}

	public void byttKlasse(String studentid, String klassekode) {

		Student s = em.find(Student.class, studentid);
		Klasse k = em.find(Klasse.class, klassekode); 
		s.setKlasse(k);
//		k.addStudent(s);
		merge(s);
//		merge(k);
//? flush() ..
	}

	public List<Student> alleStudenterIKlasse(String klassekode) {
		return em.find(Klasse.class, klassekode).getStudenter();
	}
	
	public List<Student> alleStudenterTotalt() {
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
		return query.getResultList();
	}

	public List<Klasse> allekalasserTotalt() {
		TypedQuery<Klasse> query = em.createQuery("SELECT k FROM Klasse k", Klasse.class);
		return query.getResultList();
	}

 	public void persist(Object obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.flush();
			em.getTransaction().commit();
		} catch (RollbackException e) {
			em.getTransaction().rollback();
		}
	}
	
	public void merge(Object obj) {

	try {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	} catch (RollbackException e) {
		em.getTransaction().rollback();
	}
	}



	public void remove(Object obj) {

	try {
		em.getTransaction().begin();
		em.remove(obj);
		em.flush();
		em.getTransaction().commit();
	} catch (RollbackException e) {
		em.getTransaction().rollback();
	}
	}

	
	public void close() {
		em.close();
		emf.close();
	}


}
