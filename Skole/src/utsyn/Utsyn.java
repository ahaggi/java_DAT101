package utsyn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import kontroll.DAO;
import model.*;

public class Utsyn {

	public static void main(String[] args) {
		 
		DAO dao= new DAO();
		Scanner tast = new Scanner(System.in);
		
		String meny = "\n\n01-Skriv ut alle studenter\n"
				+ "02-Skriv ut alle klasser\n"
				+ "03-Legg til en ny student\n"
				+ "04-Legg til en ny klasse\n"
				+ "05-Finn student nr\n"
				+ "06-Finn klasse\n"
				+ "07-Oppdater en student-opplysninger\n"
				+ "08-Oppdater en klasse-opplysninger\n"
				+ "09-Slett en student\n"
				+ "10-Slett en klasse\n"
				+ "11-Bytt klasse\n"
				+ "12-skriv ut alle studentene i en gitt klasse";
		
		
		System.out.println(meny);
		
		String valg = tast.nextLine();

		while (!valg.equals("x")) {

			switch (valg) {
			case "1":
				 List<Student> alleStudenter= dao.alleStudenterTotalt();
				 for (Student std : alleStudenter) {
					 System.out.println(std.toString());

				}

				break;
			case "2":
				 List<Klasse> alleKlasse= dao.allekalasserTotalt();
				 for (Klasse kl : alleKlasse) {
					 kl.getStudenter().size(); // for å fikse : IndirectList: not instantiated
					 System.out.println(kl.toString());

				}

				break;
			case "3":
				System.out.println("Tast inn student id");
				String id = tast.nextLine();

				System.out.println("Tast inn students navn");
				String navn = tast.nextLine();
				
				System.out.println("Tast inn students klasse");
				Klasse klasse = dao.finnKlasse(tast.nextLine());

				Student std = new Student(id, navn, klasse) ;
				dao.leggTilStudent(std);

				break;
			case "4":
				System.out.println("Tast inn klasse-kode");
				String kode = tast.nextLine();

				System.out.println("Tast inn program");
				String program = tast.nextLine();
				
				Klasse kls = new Klasse(kode, program, null) ;
				dao.leggTilKlasse(kls);

				break;
			case "5":
				System.out.println("Tast inn student nr");
				Student st = dao.finnStudent(tast.nextLine());
				System.out.println(st.toString());

				break;
			case "6":
				System.out.println("Tast inn klasse-kode");
				Klasse kl = dao.finnKlasse(tast.nextLine());
				System.out.println(kl.toString());
				break;
			case "7":
				System.out.println("Tast inn student nr");
				Student s = dao.finnStudent(tast.nextLine());

				System.out.println("Tast inn student id");
				s.setId( tast.nextLine());

				System.out.println("Tast inn students navn");
				s.setNavn( tast.nextLine());

				dao.oppdaterStudent(s);

				break;
			case "8":
				System.out.println("Tast inn Klasse kode");
				Klasse ks = dao.finnKlasse(tast.nextLine());

				System.out.println("Tast inn den nye Klassekoden");
				ks.setKode( tast.nextLine());

				System.out.println("Tast inn det nye Programmet");
				ks.setProgram( tast.nextLine());

				dao.oppdaterKlasse(ks);

				break;
			case "9":
				System.out.println("Tast inn student nr");
				dao.slettStudent(tast.nextLine());
				break;
			case "10":
				System.out.println("Tast inn Klasse-kode");
				dao.slettKlasse(tast.nextLine());

				break;
			case "11":
				System.out.println("Tast inn student nr");
				String stId = tast.nextLine();

				System.out.println("Tast inn klasse kode");
				String klss = tast.nextLine();				
				dao.byttKlasse(stId, klss);
				
				break;
			case "12":
				System.out.println("Tast inn Klasse kode");
				Klasse klas = dao.finnKlasse(tast.nextLine());
				List<Student>studenter= klas.getStudenter();
				for (Student student : studenter) {
					 System.out.println(student.toString());

				}
				break;

			default:
				break;
			}
			System.out.println(meny);
			 valg = tast.nextLine();

		}
	}

}
