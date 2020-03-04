package no.hib.dat101.Utsyn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import no.hib.dat101.Adresse;
import no.hib.dat101.Bil;
import no.hib.dat101.BilutleieSelskap;
import no.hib.dat101.Kategori;
import no.hib.dat101.Kunde;
import no.hib.dat101.Reservasjon;
import no.hib.dat101.Retur;
import no.hib.dat101.Utleie;
import no.hib.dat101.Utleiekontor;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji 
 *
 */
public class Tekstgrensesnitt {

	Database db = new Database();
	BilutleieSelskap selskap = db.hentFraDb();
	Scanner tastatur = new Scanner(System.in);
	
	

	/******************************Ansatte-Meny metoder*******************************************/



	/**
	 * Skriver ut info om bilutleieSelskap.
	 */
	public void skrivUtSelskap() {
		System.out.println(selskap.toString());
	}

	/**
	 * Skriver ut info om alle utleiekontor.
	 */
	public void skrivUtKontorer() {
		List<Utleiekontor> utleiekontorer = selskap.getUtleiekontor();
		for (int i = 0; i < utleiekontorer.size(); i++) {
			Utleiekontor kontor = utleiekontorer.get(i);
			System.out.println(kontor.toString());
		}
	}

	/**
	 * Skriver ut alle biler i et bestemt utleiekonto.
	 */
	public void skrivUtBiler() {
		System.out.println("Velg kontor:");
		List<Bil> biler = utleieKontor().getBiler();
		for (int i = 0; i < biler.size(); i++) {
			Bil bil1 = biler.get(i);
			System.out.println(bil1.toString());
		}
	}

	/**
	 * Skriver ut alle ledige biler i et bestemt utleiekontor.
	 */
	public void skrivUtLedigeBiler() {
		System.out.println("Velg kontor:");
		List<Bil> biler = utleieKontor().getBiler();
		for (int i = 0; i < biler.size(); i++) {
			Bil bil1 = biler.get(i);
			if (bil1.getStatus() == true) {
				System.out.println(bil1.toString());
			}
		}
	}

	/**
	 * Legger til en bil i et utleiekontor.
	 */
	public void leggTilBil() {
		System.out.println("Registreringsnummer:");
		String regNr = tastatur.nextLine();
		System.out.println("Merke:");
		String merke = tastatur.nextLine();
		System.out.println("Modell:");
		String modell = tastatur.nextLine();
		System.out.println("Farge:");
		String farge = tastatur.nextLine();
		System.out.println("Kategori:");
		Kategori kat = kategori();
		System.out.println("Kilometerstand:");
		Integer kmStand = lesInt();
		System.out.println("Status:");
		Boolean ledig = lesboolean();
		System.out.println("Kontor:");
		Utleiekontor kontor = utleieKontor();
		Bil bil = new Bil(regNr, merke, modell, farge, kat, kmStand, ledig, kontor);
		kontor.leggTilBil(bil);
		db.persist();
	}
	

	/**
	 * Lager en ny kunde.
	 * 
	 * @return kunde
	 */
	public Kunde lagNyKunde() {
		System.out.println("Fornavn:");
		String fornavn = tastatur.nextLine();
		System.out.println("Etternavn:");
		String etternavn = tastatur.nextLine();

		Adresse adresse = lagNyAdresse();

		System.out.println("tlfNr:");
		int tlfNr = lesInt();

		Kunde kunde = new Kunde(fornavn, etternavn, adresse, tlfNr, selskap);
		selskap.leggTilKunde(kunde);
		return kunde;

	}

	/**
	 * Lager et nytt utleiekontor.
	 */
	public void lagNyUtleiekontor() {

		Adresse adresse = lagNyAdresse();

		System.out.println("tlfNr:");
		int telNr = lesInt();

		Utleiekontor kontor = new Utleiekontor(adresse, telNr, selskap);
		selskap.leggTilUtleiekontor(kontor);
	}

	/**
	 * Lager en ny adresse.
	 * 
	 * @return adresse
	 */
	public Adresse lagNyAdresse() {
		System.out.println("Gateadresse:");
		String gateadresse = tastatur.nextLine();
		System.out.println("PostNr:");
		int postNr = lesInt();
		System.out.println("Poststed:");
		String postSted = tastatur.nextLine();
		Adresse adresse = new Adresse(gateadresse, postNr, postSted);
		db.persist(adresse);
		return adresse;
	}

	/**
	 * Skriver ut alle kategorier.
	 */
	public void visKategorier() {
		Collections.sort(selskap.getKategorier());

		Iterator<Kategori> it = selskap.getKategorier().iterator();
		System.out.println("Kategori |   Pris  |");
		while (it.hasNext()) {
			Kategori kategori = it.next();
			System.out.println(kategori.getType() + "   |   " + kategori.getPris() + "    |    ");

		}

	}

	/**
	 * Skriver ut info om en kunde.
	 */
	public void visKunde() {
		System.out.println("Skriv kundeNr:");
		int kundeNr = lesInt();
		Kunde kunde = selskap.finnKunde(kundeNr);
		System.out.println(kunde.toString());
	}

	/**
	 * Skriver ut info om en reservasjon.
	 */
	public void visReservasjon() {
		System.out.println("Skriv reservasjonsnummer:");
		int resNr = lesInt();
		Reservasjon resv = db.hentReservasjonFraDb(resNr);
		System.out.println(resv.toString());
	}

	/**
	 * Skriver ut info om en utleie.
	 */
	public void visUtleie() {
		System.out.println("Skriv utleienummer(reservasjonsnummer):");
		int utleieNr = lesInt();
		Utleie utleie = db.hentUtleieFraDb(utleieNr);
		System.out.println(utleie.toString());
	}

	/**
	 * Skriver ut info om en retur.
	 */
	public void visRetur() {
		System.out.println("Skriv returnummer(reservasjonsnummer):");
		int returNr = lesInt();
		Retur retur = db.hentReturFraDb(returNr);
		System.out.println(retur.toString());
	}
	
	/**
	 * Endrer pris p� en kategori.
	 */
	public void endrePris() {
		Kategori kategori = kategori();
		System.out.println("Ny pris:");
		double nyPris = lesDouble();
		kategori.setPris(nyPris);
	}
	

	/******************************Kunde-Meny metoder*******************************************/

	/**
	 * Lager en ny reservasjon.
	 */
	public void lagNyReservasjon() {
		System.out.println("Fra Dato \"dd-MM-yyyy\":");
		Date fraDato = dato();
		System.out.println("Til Dato \"dd-MM-yyyy\":");
		Date tilDato = dato();
		System.out.println("Utleiested:");
		Utleiekontor utleiested = utleieKontor();
		System.out.println("Retursted:");
		Utleiekontor retursted = utleieKontor();

		int antallDager = (int) (tilDato.getDate() - fraDato.getDate());

		visKategorier(antallDager);

		Kategori kategori = kategori();

		System.out.println("Vil du fortsette?");
		System.out.println("1. Ja");
		System.out.println("2. Nei");

		int valg = lesInt();

		if (valg == 1) {
			System.out.println("1. Ny kunde");
			System.out.println("2. Eksisterende kunde");
			valg = lesInt();

			switch (valg) {
			case 1:
				Kunde kunde = lagNyKunde();
				Reservasjon reservasjon = new Reservasjon(kunde, fraDato, tilDato, kategori, utleiested, retursted);
				utleiested.leggTilReservasjon(reservasjon);
				db.persist();
				System.out.println("Ditt kundenummer: " + reservasjon.getKunde().getKundeNr());
				System.out.println("Ditt reservasjonsnummer: " + reservasjon.getResNr());
				break;
			case 2:
				System.out.println("Skriv inn kundenummer:");
				int kundeNr = lesInt();
				Kunde kunde1 = selskap.finnKunde(kundeNr);
				Reservasjon reservasjon2 = new Reservasjon(kunde1, fraDato, tilDato, kategori, utleiested, retursted);
				utleiested.leggTilReservasjon(reservasjon2);
				db.persist();
				System.out.println("Ditt reservasjonsnummer: " + reservasjon2.getResNr());
				break;
			default:
				break;
			}
		} else {
			System.out.println("Avbrutt!");
		}
	}

	/**
	 * Lager en ny utleie.
	 * 
	 * @param resNr reservasjonsNr
	 */
	public void lagNyUtleie() {
		System.out.println("Skriv reservasjonsnummer:");
		Integer resNr = lesInt();
		
		Reservasjon resv = db.hentReservasjonFraDb(resNr);
		Utleie utleie = db.hentUtleieFraDb(resNr);
		if (utleie != null) {
			System.out.println("Allerede utleied");
			return;
		}

		System.out.println("tilDato \"dd-MM-yyyy\":");
		Date tilDato = dato();

		System.out.println("kreditt kort");
		int kredittKort = lesInt();
		System.out.println("Hva vil du betale n�?");
		double betaltBelop = lesDouble();

		utleie = new Utleie(resv, tilDato, kredittKort, betaltBelop);
		utleie.getUtleieSted().leggTilUtleie(utleie); // endring i obj ==>
														// endering i DB
		utleie.getKunde().leggTilUtleie(utleie);// endring i obj ==> endering i
												// DB
		db.persist();
	}

	/**
	 * Lager en ny retur.
	 * 
	 * @param utleieNr utleieNr
	 */
	public void lagNyRetur() {
		System.out.println("Skriv reservasjonsnummer:");
		Integer utleieNr = lesInt();
		
		Utleie utl = db.hentUtleieFraDb(utleieNr);
		Retur retur = db.hentReturFraDb(utleieNr);
		if (retur != null) {
			System.out.println("Allerede retunert");
			return;
		}
		System.out.println("tilDato \"dd-MM-yyyy\":");
		Date tilDato = dato();

		System.out.println("Kilometerstand:");
		int kmStand = lesInt();

		System.out.println("returSted:");

		Utleiekontor returSted = utleieKontor();
		
		double totalPris = utl.getBil().getKategori().beregnetPris((int) (tilDato.getDate() - utl.getFraDato().getDate()));
		System.out.println("Totalpris: " + totalPris);
		System.out.println("Betalt: " + utl.getBetaltBelop());
		Double gjenstaaende = totalPris - utl.getBetaltBelop();
		System.out.println("Gjenst�ende: " + gjenstaaende);
		
		double betaltBelop;
		do {
		System.out.println("Betal " + gjenstaaende + " for � avslutte!");
		System.out.println("Hva vil du betale?");
		betaltBelop = lesDouble();
		gjenstaaende = gjenstaaende - betaltBelop;
		} while (gjenstaaende != 0.0);
		
		retur = new Retur(utl, kmStand, returSted, tilDato, betaltBelop);
		utl.getUtleieSted().leggTilRetur(retur); // endring i obj ==> endering i
													// DB
		utl.getKunde().leggTilRetur(retur);// endring i obj ==> endering i DB
		
		db.persist();
	}

	/**
	 * Persister selskap og luker kobling til database.
	 */
	public void close() {
		db.persist();
		db.close();
	}


	/******************************hjelpe metoder*******************************************/


	
	
	public int lesInt() {
		boolean b = false;
		int valg = -1;
		do {

			try {
				valg = tastatur.nextInt();
				tastatur.nextLine();
				b = true;
			} catch (Exception e1) {
				System.out.println("Ugyldi verdi, tast p� nytt!");
				tastatur.nextLine();
			}
		} while (!b);
		return valg;
	}
	
	public double lesDouble() {
		boolean b = false;
		double valg = -1;
		do {

			try {
				valg = tastatur.nextDouble();
				tastatur.nextLine();
				b = true;
			} catch (Exception e1) {
				System.out.println("Ugyldi verdi, tast p� nytt!");
				tastatur.nextLine();
			}
		} while (!b);
		return valg;
	}
	
	public boolean lesboolean() {
		boolean b = false;
		boolean valg = false;
		do {

			try {
				valg = tastatur.nextBoolean();
				tastatur.nextLine();
				b = true;
			} catch (Exception e1) {
				System.out.println("Ugyldi verdi, tast p� nytt!");
				tastatur.nextLine();
			}
		} while (!b);
		return valg;
	}
	
	
	/**
	 * Henter et utleiekontor fra ArrayList.
	 * 
	 * @return utleiekontor
	 */
	private Utleiekontor utleieKontor() {
		Utleiekontor kontor = null;
		do {
			int valg = lesInt();
			try {
				kontor = selskap.finnUtleiekontor(valg);
			} catch (Exception e1) {
				System.out.println("Ugyldi verdi, tast p� nytt!");
			}
		} while (kontor == null);
		return kontor;
	}

	/**
	 * Konverterer dato streng til Dato objekt.
	 * 
	 * @return dato
	 */
	private Date dato() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dato1 = null;
		do {
			String dato = tastatur.nextLine();
			try {
				dato1 = dateFormat.parse(dato);
			} catch (ParseException e1) {
				System.out.println("Ugyldi verdi, tast p� nytt!");
			}
		} while (dato1 == null);
		return dato1;
	}

	/**
	 * Skriver ut alle kategorier med beregnet pris.
	 * 
	 * @param antallDager antall dager
	 */
	private void visKategorier(int antallDager) {
		Collections.sort(selskap.getKategorier());
		Iterator<Kategori> it = selskap.getKategorier().iterator();
		System.out.println("Kategori | Pris for " + antallDager + " dager" + " |");
		while (it.hasNext()) {
			Kategori kategori = it.next();
			System.out.println(kategori.getType() + "   |   " + kategori.getPris() * antallDager + "    |    ");

		}

	}

	/**
	 * Konverterer en streng kategori til Kategori objekt.
	 * 
	 * @return kategori
	 */
	private Kategori kategori() {
		Kategori kategori = null;
		do {
			System.out.println("Velg kategori");
			String temp= tastatur.nextLine();
			char x =temp.charAt(0);
			if (x >= 65 && x <= 68) {
				kategori = selskap.finnKategori(x);
			} else {
				System.out.println("Ugyldig verdi");
			}
		} while (kategori == null);
		return kategori;
	}
}