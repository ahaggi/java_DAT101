package tegning;

public class Firekant extends Figur{
	int side;
	
	public Firekant(Pos posision, int s){
		super(posision);
		side=s;
	}
	
	@Override
	public void tegn() {
		
	}
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}


	

}
