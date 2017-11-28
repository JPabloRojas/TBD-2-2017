package cl.citiaps.spring.backend.entities;


import javax.persistence.*;

@Entity
@Table(name="keywords")
@NamedQuery(name="Keywords.findAll", query="SELECT k FROM Keywords k")
public class Keywords {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "keyword", unique = false, nullable = false)
	private String keyword;

	public int getId() {
		return id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
