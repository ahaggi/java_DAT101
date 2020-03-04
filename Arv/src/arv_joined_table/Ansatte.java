package arv_joined_table;

import javax.persistence.*;

@Entity
@Table(schema="arv_joined_table", name="ansatte")//m� skrive navn p� tabellen
@Inheritance( strategy = InheritanceType.JOINED ) 
@DiscriminatorColumn( name = "type" ) 

public class Ansatte {
	 @Id
	private Integer ansatteid;  
	private String fnavn;	

	public Ansatte() { //f�r feil uten tom konstrakt�r
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
