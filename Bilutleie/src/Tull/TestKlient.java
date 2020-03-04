
import javax.persistence.*;

public class TestKlient {

	public static void main(String[] args) {
		
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eclipselink");

        EntityManager em = emf.createEntityManager();
        
              /**************adresse*************/
//		Adresse adresse = new Adresse("Berge", 5200, "Os");
//        try {
//            em.getTransaction().begin();
//            em.persist(adresse);
//            em.getTransaction().commit();
//        } catch (RollbackException e) {
//            em.getTransaction().rollback();
//        }
//		
//		System.out.println(adresse.toString());
		
        
        /**************selskap*************/
//        Adresse adresse=em.find(Adresse.class, 1);
//		BilutleieSelskap selskap = new BilutleieSelskap("Avis1", 99999999, adresse);
//		
//		for (Kategori k : selskap.getKategorier()) {
//			System.out.println(k.getType() + ""+ k.getPris());
//		}
        
        /*******************Utleiekontor*************/
//      Adresse adresse=em.find(Adresse.class, 2);
//      BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis");
//      Utleiekontor kontor2 = new Utleiekontor(adresse, 22222222, selskap);
//		
//      selskap.getUtleiekontor().add(kontor2); // endring i obj ==> endering i DB 
     
        
        /*******************Bil*************/

//      BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis"); //alltid henter kun selskapet obj, med unntakk av adresse
//      Utleiekontor kontor = selskap.getUtleiekontor().get(0);
//      Kategori kat= selskap.getKategorier().get(0);
//      
//      Bil bil = new Bil("AB00002", "merke2", "modell2", "farge2", kat, 00, true, kontor);
//      kontor.leggTilBil(bil); // endring i obj ==> endering i DB 

      
//        /*******************Kunde*************/
//      BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis"); //alltid henter kun selskapet obj, med unntakk av  adresse
//      Adresse adresse=em.find(Adresse.class, 2);
//
//      Kunde kunde= new Kunde("fornavn4", "etternavn4", adresse, 44444444, selskap);
//      selskap.leggTilKunde(kunde); // endring i obj ==> endering i DB 

      
        /********Reservasjon*************/
//        String fra = "20-01-2016";
//        String til = "21-01-2016";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date fraDato=null; Date tilDato=null;
//		try {
//			fraDato = dateFormat.parse(fra);
//	        tilDato =dateFormat.parse(til);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        
//        BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis"); //alltid henter kun selskapet obj, med unntakk av kategori og adresse
//        Kunde kunde=selskap.getKunder().get(1);
//        Kategori kat= selskap.getKategorier().get(0);
//        Utleiekontor utleieSted=selskap.getUtleiekontor().get(1);
//        Utleiekontor returSted=selskap.getUtleiekontor().get(1);
//        
//        Reservasjon reservasjon= new Reservasjon(kunde, fraDato, tilDato, kat, utleieSted, returSted); //må skrive en metode beregnetPris
//        utleieSted.leggTilReservasjon(reservasjon); // endring i obj ==> endering i DB 
//        kunde.leggTilReservasjon(reservasjon);// endring i obj ==> endering i DB        
        
        
        /********Utleie*************/
//        String til = "21-01-2016";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date fraDato=null; Date tilDato=null;
//		try {
//	        tilDato =dateFormat.parse(til);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        
//        BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis"); //alltid henter kun selskapet obj, med unntakk av kategori og adresse
//        Reservasjon resNr = em.find(Reservasjon.class, 5); //TODO
//        int kredittKort=123456;
//        double betaltBelop=1000;
//        
//        
//        Utleie utleie= new Utleie(resNr, tilDato, kredittKort, betaltBelop);
//        utleie.getUtleieSted().leggTilUtleie(utleie); // endring i obj ==> endering i DB 
//        utleie.getKunde().leggTilUtleie(utleie);// endring i obj ==> endering i DB
        
        /********Retur*************/
//        String til = "22-01-2016";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Date fraDato=null; Date tilDato=null;
//		try {
//	        tilDato =dateFormat.parse(til);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        
//        BilutleieSelskap selskap =em.find(BilutleieSelskap.class, "Avis"); //alltid henter kun selskapet obj, med unntakk av kategori og adresse
//        Utleie utleie = em.find(Utleie.class, 4); //TODO
//        Utleiekontor returSted =selskap.getUtleiekontor().get(0);
//        double betaltBelop=6000;
//        
//        
//        Retur retur= new Retur(utleie, 110, returSted, tilDato, betaltBelop);
//        retur.getReturSted().leggTilRetur(retur); // endring i obj ==> endering i DB 
//        retur.getKunde().leggTilRetur(retur);// endring i obj ==> endering i DB
//

        
        
        /********************for alle *******************************/
        try {
        	em.getTransaction().begin();
        	em.persist(selskap);//bare selskapet obj
        	em.getTransaction().commit();
        } catch (RollbackException e) {
        	em.getTransaction().rollback();
        }

        
        
        
        
//		Adresse adresse2 = em.find(Adresse.class, 9);
//		
//		System.out.println(adresse2.toString());
//		
//		BilutleieSelskap selskap = em.find(BilutleieSelskap.class, "Bilutleie Selskap");
//		
//		Bil bil = em.find(Bil.class, "EXS001");
//		
		//System.out.println(bil.toString());
//		
		em.close();
		emf.close();

	}

}
