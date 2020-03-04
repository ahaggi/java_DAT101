package tegning;

public abstract class Figur {

	int posision;
	
	public Figur(Pos p){
		posision =p;
	}
	
	public abstract void tegn();
	
}
