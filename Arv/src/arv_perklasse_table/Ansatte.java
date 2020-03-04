package arv_perklasse_table;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
 /**har ikke variable/tupple "type" OG HAR IKKE TABELL FOR ANSATTE**/

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
