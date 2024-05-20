package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents an devisCar lvvine entity. test
 */
@Entity
@Table(name = ("deviscar_line"))
@CrossOrigin
public class DevisCarLine {
	/** Unique ID of an devisCar line. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	@ManyToOne
	@JoinColumn(name = "dcr_id", referencedColumnName = "id")
	private DevisCar devisCar;

	/** Car ID of the ordered pizza. */
	@Column(name = "car_id")
	private Short car_id;

	/** Quantity of the ordered pizza. */
	@Column(name = "commentaire")
	private String commentaire;

	public DevisCarLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevisCarLine(Short id, DevisCar devisCar, Short car_id, String commentaire) {
		super();
		this.id = id;
		this.devisCar = devisCar;
		this.car_id = car_id;
		this.commentaire = commentaire;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public DevisCar getDevisCar() {
		return devisCar;
	}

	public void setDevisCar(DevisCar devisCar) {
		this.devisCar = devisCar;
	}

	public Short getCar_id() {
		return car_id;
	}

	public void setCar_id(Short car_id) {
		this.car_id = car_id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "DevisCarLine [id=" + id + ", devisCar=" + devisCar + ", car_id=" + car_id + ", commentaire="
				+ commentaire + "]";
	}

}
