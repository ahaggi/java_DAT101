package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "skole", name = "klasse")
public class Klasse {
	
	@Id
	private String kode;
	private String program;
	
    @OneToMany(mappedBy = "klasse", cascade=CascadeType.ALL)
    private List<Student> studenter;

    
    
	public Klasse() {
		super();
	}

	public Klasse(String kode, String program, List<Student> studenter) {
		super();
		this.kode = kode;
		this.program = program;
		this.studenter = studenter;

	}

	public String getKode() {
		return kode;
	}

	public String getProgram() {
		return program;
	}

	public List<Student> getStudenter() {
		return studenter;
	}

	public void addStudent(Student std) {
		this.studenter.add(std);
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setStudenter(List<Student> studenter) {
		this.studenter = studenter;
	}

	@Override
	public String toString() {
		return "Klasse [kode=" + kode + ", program=" + program + ", studenter=" + studenter.toString() + "]";
	}
    
    
}
