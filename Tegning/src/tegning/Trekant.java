package tegning;

public class Trekant extends Figur{
	int h�yde;
	int grunnlinje;
	
	public Trekant(Pos posision, int h, int gl){
		super(posision);
		h�yde=h;
		grunnlinje= gl;
	}
	
	@Override
	public void tegn() {
		
	}

	public int getH�yde() {
		return h�yde;
	}

	public void setH�yde(int h�yde) {
		this.h�yde = h�yde;
	}

	public int getGrunnlinje() {
		return grunnlinje;
	}

	public void setGrunnlinje(int grunnlinje) {
		this.grunnlinje = grunnlinje;
	}
	

}
