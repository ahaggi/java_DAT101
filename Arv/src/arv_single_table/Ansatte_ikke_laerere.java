package arv_single_table;

import javax.persistence.*;

@Entity
@DiscriminatorValue( value="laerer" )/**legg merke til at variable/tupple "type" ikke er lagt til **/

public class Ansatte_ikke_laerere extends Ansatte {

	private String spesialisering;

	
	public Ansatte_ikke_laerere() {//får feil uten tom konstraktør
		super();
	}

	
	public Ansatte_ikke_laerere(Integer ansatteid, String fnavn, String sp) {
		super(ansatteid, fnavn);
		spesialisering = sp;
	}

	public String getSpesialisering() {
		return spesialisering;
	}

	public void setSpesialisering(String spesialisering) {
		this.spesialisering = spesialisering;
	}



}
