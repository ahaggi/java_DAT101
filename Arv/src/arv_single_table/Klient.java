package arv_single_table;

import javax.persistence.*;

//OBS dette f�rer  til feil
//import arv_perklasse_table.Ansatte_ikke_laerere;
//import arv_perklasse_table.Ansatte_laerere;
//OBS dette f�rer  til feil


public class Klient {

	public static void main(String[] args) {
        

        Ansatte_laerere a5= new Ansatte_laerere(5, "navn5" , "fag5");
        Ansatte_laerere a6= new Ansatte_laerere(6, "navn6" , "fag6");
        Ansatte_ikke_laerere n7= new Ansatte_ikke_laerere(7, "navn7" , "adminstarasjon");
        Ansatte_ikke_laerere n8= new Ansatte_ikke_laerere(8, "navn8" , "adminstarasjon");
        System.out.println("000000000000000000");

                                                /**har mer enn 1 persistenceUnit in xml filen*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink_single");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a5);
            em.persist(a6);
            em.persist(n7);
            em.persist(n8);
            em.getTransaction().commit();
            System.out.println("11111111111111111111111");

        } catch (RollbackException e) {
            em.getTransaction().rollback();
        }

//        try {
//            em.getTransaction().begin();
//            em.remove(a5);
//            em.remove(a6);
//            em.remove(n7);
//            em.remove(n8);
//            em.flush();
//            em.getTransaction().commit();
//            System.out.println("222222222222222222");
//
//        } catch (RollbackException e) {
//            em.getTransaction().rollback();
//        }

        em.close();
        System.out.println("333333333333333333333");

	}

}
