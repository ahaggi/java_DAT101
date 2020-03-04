package tegning;

public class Trekant extends Figur{
	int høyde;
	int grunnlinje;
	
	public Trekant(Pos posision, int h, int gl){
		super(posision);
		høyde=h;
		grunnlinje= gl;
	}
	
	@Override
	public void tegn() {
		
	}

	public int getHøyde() {
		return høyde;
	}

	public void setHøyde(int høyde) {
		this.høyde = høyde;
	}

	public int getGrunnlinje() {
		return grunnlinje;
	}

	public void setGrunnlinje(int grunnlinje) {
		this.grunnlinje = grunnlinje;
	}
	

}
