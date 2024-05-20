package fr.yanni.swissfrench.core.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents an order entity.
 */
@Entity
@Table(name = ("deviscar"))
@CrossOrigin
public class DevisCar {

	/** Unique ID of an order. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** User ID of the user placing the order. */
	@Column(name = "usr_id")
	private Short usr_id;

	/** Date of the order. */
	@Column(name = "date", insertable = false, updatable = false)
	private String date;

	@OneToMany(mappedBy = "devisCar", cascade = CascadeType.ALL)
	private List<DevisCarLine> deviscarLines = new ArrayList<>();

	public DevisCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevisCar(Short id, Short usr_id, String date, List<DevisCarLine> deviscarLines) {
		super();
		this.id = id;
		this.usr_id = usr_id;
		this.date = date;
		this.deviscarLines = deviscarLines;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Short getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(Short usr_id) {
		this.usr_id = usr_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<DevisCarLine> getDevisCarLines() {
		return deviscarLines;
	}

	public void setDevisCarLines(List<DevisCarLine> deviscarLines) {
		this.deviscarLines = deviscarLines;
	}

	@Override
	public String toString() {
		return "DevisCar [id=" + id + ", usr_id=" + usr_id + ", date=" + date + ", deviscarLines=" + deviscarLines
				+ "]";
	}

}
