package no.hib.dat101.Utsyn;

import java.util.Scanner;

/**
 * @author Peter Boer, Daniel Moberg og Abdella Haji
 *
 */
public class MenyAnsatt {
	
	Tekstgrensesnitt tg = new Tekstgrensesnitt();
	Scanner tastatur = new Scanner(System.in);
	int valg = 0;
	
	/**
	 * Starter menyen til ansatte.
	 */
	public void start() {
		do {
			System.out.println("*************************************");
			System.out.println("Meny");
			System.out.println("1. Info selskap");
			System.out.println("2. Utleiekontorer i selskap");
			System.out.println("3. Biler i et bestemt utleiekontor");
			System.out.println("4. Ledige biler i et bestemt utleiekontor");
			System.out.println("5. Legg til ny bil");
			System.out.println("6. Legg til ny kunde");
			System.out.println("7. Legg til ny utleiekontor");
			System.out.println("8. Legg til ny adresse");
			System.out.println("9. Vis kategorier");
			System.out.println("10. Vis kunde");
			System.out.println("11. Vis reservasjon");
			System.out.println("12. Vis utleie");
			System.out.println("13. Vis retur");
			System.out.println("14. Endre pris på kategori");
			
			System.out.println("15. Exit");
			System.out.println("*************************************");

			valg = tastatur.nextInt();
			tastatur.nextLine();

			switch (valg) {
			case 1:
				tg.skrivUtSelskap();
				break;
			case 2:
				tg.skrivUtKontorer();
				break;
			case 3:
				tg.skrivUtBiler();
				break;
			case 4:
				tg.skrivUtLedigeBiler();
				break;
			case 5:
				tg.leggTilBil();
				break;
			case 6:
				tg.lagNyKunde();
				break;
			case 7:
				tg.lagNyUtleiekontor();
				break;
			case 8:
				tg.lagNyAdresse();
				break;
			case 9:
				tg.visKategorier();
				break;
			case 10:
				tg.visKunde();
				break;
			case 11:
				tg.visReservasjon();
				break;
			case 12:
				tg.visUtleie();
				break;
			case 13:
				tg.visRetur();
				break;
			case 14:
				tg.endrePris();
				break;
			default:
				System.out.println("Lukker meny");
				break;
			}
		} while (valg != 15);
	}
	
	/**
	 * Lukker kobling til database.
	 */
	public void close() {
		tg.close();
	}
}
