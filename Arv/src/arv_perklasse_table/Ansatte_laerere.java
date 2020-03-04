package arv_perklasse_table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema="arv_perklasse_table", name="ansatte_laerere")

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
