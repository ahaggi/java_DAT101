package testklasser;

import java.util.*;
import javax.persistence.*;

import no.hib.dat101.*;

public class QueryTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("noe_noe");
		EntityManager em = emf.createEntityManager();

		//uten Query 
		/******************skriv ut biler**********************/
//		Utleiekontor hentetUtleiekontor1= em.find(Utleiekontor.class, 1);
//		Iterator<Bil> it = hentetUtleiekontor1.getBiler().iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next().getRegistreringsNr());			
//		}
		
		
		 //		Query for alle biler som er registerert på kontor nr 1
//	      Query query = em.createQuery("Select b from Bil b");
//	      List<Bil> biler = query.getResultList();
//	      
//
//	      for(Bil b:biler) {
//	         System.out.println(b.getRegistreringsNr());
//	      }


				 //		Query for alle biler som er registerert på kontor nr 1
		int x=1;
		Query query = em.createQuery("Select b from Bil b where b.utleiekontor.kontorNr = :kntNr").setParameter("kntNr", x);
		List<Bil> biler = query.getResultList();
		
		System.out.println("RegistreringsNr |   Utleiekontor  |   Modell   |  Status: ");

		for(Bil b:biler) {
			System.out.println("    "+b.getRegistreringsNr()+"      |        "+b.getUtleiekontor().getKontorNr()+"        |   "+b.getModell()+"  |   "+b.getStatus());
		}


//		/**Aggregate fun.**/
//		Query query1 = em.createQuery("Select COUNT(b.regnr)  from Bil b "); // kan også tilsette where b.utleiekontor.kontorNr = 1
//		Long antall = (Long) query1.getSingleResult();
//		System.out.println("Totalt registererte biler:" + antall);



	}

}
