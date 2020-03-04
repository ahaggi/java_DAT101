package arv_single_table;

import javax.persistence.*;

@Entity
@Table(schema="arv_single_table", name="ansatte")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type" ) /**legg merke til at variable/tupple "type" ikke er lagt til **/

public class Ansatte {
	 @Id
	private Integer ansatteid;  
	private String fnavn;

	public Ansatte() { //får feil uten tom konstraktør
		super();
	}

	public Ansatte(Integer ansatteid, String fnavn) {
		this.ansatteid = ansatteid;
		this.fnavn = fnavn;
	}

	public Integer getAnsatteid() {
		return ansatteid;
	}

	public void setAnsatteid(Integer ansatteid) {
		this.ansatteid = ansatteid;
	}

	public String getFnavn() {
		return fnavn;
	}

	public void setFnavn(String fnavn) {
		this.fnavn = fnavn;
	}



}
