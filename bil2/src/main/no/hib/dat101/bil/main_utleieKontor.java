package no.hib.dat101.bil;
import java.util.Iterator;
import javax.persistence.*;

public class main_utleieKontor {
	public static void main(String args[] ){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");
		EntityManager em = emf.createEntityManager();

		/** laster ned kontor 1 fra DB*/
		Utleiekontor kontor = em.find(Utleiekontor.class, 1);

		Iterator<Bil> it = kontor.getBiler().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getRegnr());			
		}
		
		kontor.getBiler().remove(4);
		kontor.getBiler().remove(3);
		kontor.getBiler().remove(2);
		kontor.getBiler().remove(1);
		kontor.getBiler().remove(0);


		em.getTransaction().begin();
		em.persist(kontor);
		em.flush();
		em.getTransaction().commit();

	}
}
