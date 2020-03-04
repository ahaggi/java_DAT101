package arv_joined_table;

import javax.persistence.*;

@Entity
@Table(schema="arv_joined_table", name="ansatte_laerere")//må skrive navn på tabellen
@DiscriminatorValue( value="laerer" )/**Unoedvendig !!  legg merke til at variable/tupple "type" ikke er lagt til **/
//@PrimaryKeyJoinColumn(referencedColumnName="ansatteid")/**Unoedvendig !!

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
