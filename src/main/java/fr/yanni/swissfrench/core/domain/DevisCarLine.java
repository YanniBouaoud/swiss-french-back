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
 * Represents a line item in a car quotation.
 */
@Entity
@Table(name = ("deviscar_line"))
@CrossOrigin
public class DevisCarLine {
	/** Unique ID of a line item in a car quotation. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** Car quotation associated with this line item. */
	@ManyToOne
	@JoinColumn(name = "dcr_id", referencedColumnName = "id")
	private DevisCar devisCar;

	/** Car ID of the ordered car. */
	@Column(name = "car_id")
	private Short carid;

	/** Comment related to the ordered car. */
	@Column(name = "commentaire")
	private String commentaire;

	/**
	 * Default constructor.
	 */
	public DevisCarLine() {
		super();
	}

	/**
	 * Constructor with parameters.
	 *
	 * @param lId          The unique ID of the line item.
	 * @param lDevisCar    The car quotation associated with this line item.
	 * @param lCarid       The ID of the ordered car.
	 * @param lCommentaire The comment related to the ordered car.
	 */
	public DevisCarLine(final Short lId, final DevisCar lDevisCar, final Short lCarid, final String lCommentaire) {
		super();
		this.id = lId;
		this.devisCar = lDevisCar;
		this.carid = lCarid;
		this.commentaire = lCommentaire;
	}

	// Getters and setters

	/**
	 * Get the unique ID of the line item.
	 *
	 * @return The ID.
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Set the unique ID of the line item.
	 *
	 * @param lId The ID.
	 */
	public void setId(final Short lId) {
		this.id = lId;
	}

	/**
	 * Get the car quotation associated with this line item.
	 *
	 * @return The car quotation.
	 */
	public DevisCar getDevisCar() {
		return devisCar;
	}

	/**
	 * Set the car quotation associated with this line item.
	 *
	 * @param lDevisCar The car quotation.
	 */
	public void setDevisCar(final DevisCar lDevisCar) {
		this.devisCar = lDevisCar;
	}

	/**
	 * Get the ID of the ordered car.
	 *
	 * @return The car ID.
	 */
	public Short getCarid() {
		return carid;
	}

	/**
	 * Set the ID of the ordered car.
	 *
	 * @param lCarid The car ID.
	 */
	public void setCarid(final Short lCarid) {
		this.carid = lCarid;
	}

	/**
	 * Get the comment related to the ordered car.
	 *
	 * @return The comment.
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Set the comment related to the ordered car.
	 *
	 * @param lCommentaire The comment.
	 */
	public void setCommentaire(final String lCommentaire) {
		this.commentaire = lCommentaire;
	}

	@Override
	public final String toString() {
		return "DevisCarLine [id=" + id + ", devisCar=" + devisCar + ", car_id=" + carid + ", commentaire="
				+ commentaire + "]";
	}

}
