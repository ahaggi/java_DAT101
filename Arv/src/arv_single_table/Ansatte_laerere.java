package arv_single_table;

import javax.persistence.*;

@Entity
@DiscriminatorValue( value="laerer" )/**legg merke til at variable/tupple "type" ikke er lagt til **/

public class Ansatte_laerere extends Ansatte{
	private String fag;

	public Ansatte_laerere(Integer ansatteid, String fnavn, String fag) {
		super(ansatteid, fnavn);
		this.fag = fag;
	}   
	public Ansatte_laerere() {//får feil uten tom konstraktør
		super();
	}




}
