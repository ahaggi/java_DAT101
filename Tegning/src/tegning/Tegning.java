package tegning;
import java.util.Scanner;
public class Tegning {
	Figur [] figurer;
	int antall;
	
	public Tegning(int n){
		figurer= new Figur[n];
		antall=0;
	}
	
	public void lagNyTrekant(){
		
	Scanner tast= new Scanner(System.in);
	Pos pos=tast.nextInt();
	int hd=tast.nextInt();
	int gl=tast.nextInt();
	Figur trekant= new Trekant(pos,hd,gl);
	figurer[antall]=trekant;
	antall++;
	tast.close();
	}


	public void lagNyFirekant(){
	Scanner tast= new Scanner(System.in);
	Pos pos=tast.nextInt();
	int side=tast.nextInt();
	Figur firekant= new Firekant(pos,side);
	figurer[antall]=firekant;
	antall++;
	tast.close();
	}
	
	public Tegning() {
		for (int i = 0; i < antall; i++) {
			figurer[i].tegn();
		}
	}
}
