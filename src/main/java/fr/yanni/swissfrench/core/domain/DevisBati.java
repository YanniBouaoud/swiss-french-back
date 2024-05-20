package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = ("devisbati"))
@CrossOrigin
public class DevisBati {
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

	/** User ID of the user placing the order. */
	@Column(name = "budget")
	private Short budget;

	/** User ID of the user placing the order. */
	@Column(name = "delais")
	private String delais;

	/** User ID of the user placing the order. */
	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DevisBati(Short id, Short usr_id, String date, Short budget, String delais, String description) {
		super();
		this.id = id;
		this.usr_id = usr_id;
		this.date = date;
		this.budget = budget;
		this.delais = delais;
		this.description = description;
	}

	public DevisBati() {
		super();
		// TODO Auto-generated constructor stub
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

	public Short getBudget() {
		return budget;
	}

	public void setBudget(Short budget) {
		this.budget = budget;
	}

	public String getDelais() {
		return delais;
	}

	public void setDelais(String delais) {
		this.delais = delais;
	}

	@Override
	public String toString() {
		return "DevisBati [id=" + id + ", usr_id=" + usr_id + ", date=" + date + ", budget=" + budget + ", delais="
				+ delais + "]";
	}

}
