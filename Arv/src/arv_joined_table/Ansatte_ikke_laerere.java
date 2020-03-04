package arv_joined_table;

import javax.persistence.*;

@Entity
@Table(schema="arv_joined_table", name="ansatte_ikke_laerere")//må skrive navn på tabellen
@DiscriminatorValue( value="admin" )/**Unoedvendig !!  legg merke til at variable/tupple "type" ikke er lagt til **/
//@PrimaryKeyJoinColumn(referencedColumnName="ansatteid")/**Unoedvendig !!

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
