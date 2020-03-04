package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "skole", name = "student")
public class Student {
	
	@Id
	private String id;
	private String navn;
	
    @ManyToOne
    @JoinColumn(name="klasse_kode", referencedColumnName = "kode",insertable=true, updatable=true)
    private Klasse klasse;

    
    
    
	public Student() {
		super();
	}

	public Student(String id, String navn, Klasse klasse) {
		super();
		this.id = id;
		this.navn = navn;
		this.klasse = klasse;
	}

	public String getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse k) {
		klasse=k;
		
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", navn=" + navn + ", klasse=" + klasse.getKode() + "]";
	}
    
    
}
