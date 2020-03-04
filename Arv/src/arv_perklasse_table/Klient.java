package arv_perklasse_table;

import javax.persistence.*;

public class Klient {

	public static void main(String[] args) {
        

        Ansatte_laerere a5= new Ansatte_laerere(5, "navn5" , "fag5");
        Ansatte_laerere a6= new Ansatte_laerere(6, "navn6" , "fag6");
        Ansatte_ikke_laerere n7= new Ansatte_ikke_laerere(7, "navn7" , "adminstarasjon");
        Ansatte_ikke_laerere n8= new Ansatte_ikke_laerere(8, "navn8" , "adminstarasjon");

                                                /**har mer enn 1 persistenceUnit in xml filen*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink_perklasse");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a5);
            em.persist(a6);
            em.persist(n7);
            em.persist(n8);
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }	

        try {
            em.getTransaction().begin();
            em.remove(a5);
            em.remove(a6);
            em.remove(n7);
            em.remove(n8);
            em.flush();
            em.getTransaction().commit();
        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

        em.close();

	}

}
