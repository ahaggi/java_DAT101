package no.hib.dat101.Utsyn;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji
 *
 */
public class KlientAnstatt {

	/**
	 * Starter meny for ansatte. Denne klienten er for � legg til objekt i databasen og f� ut informasjon om det som st�r i databasen fra f�r.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MenyAnsatt meny = new MenyAnsatt();
		
		meny.start();
		meny.close();
	}

}
