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
 * Represents a car quotation entity.
 */
@Entity
@Table(name = ("deviscar"))
@CrossOrigin
public class DevisCar {

	/** Unique ID of a car quotation. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** User ID of the user placing the car quotation. */
	@Column(name = "usr_id")
	private Short usrid;

	/** Date of the car quotation. */
	@Column(name = "date", insertable = false, updatable = false)
	private String date;

	/** List of car quotation lines associated with this car quotation. */
	@OneToMany(mappedBy = "devisCar", cascade = CascadeType.ALL)
	private List<DevisCarLine> deviscarLines = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	public DevisCar() {
		super();
	}

	/**
	 * Constructor with parameters.
	 *
	 * @param cId            The unique ID of the car quotation.
	 * @param cUsrid         The user ID of the user placing the car quotation.
	 * @param cDate          The date of the car quotation.
	 * @param cDeviscarLines The list of car quotation lines associated with this
	 *                       car quotation.
	 */
	public DevisCar(final Short cId, final Short cUsrid, final String cDate, final List<DevisCarLine> cDeviscarLines) {
		super();
		this.id = cId;
		this.usrid = cUsrid;
		this.date = cDate;
		this.deviscarLines = cDeviscarLines;
	}

	// Getters and setters

	/**
	 * Get the unique ID of the car quotation.
	 *
	 * @return The ID.
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Set the unique ID of the car quotation.
	 *
	 * @param cId The ID.
	 */
	public void setId(final Short cId) {
		this.id = cId;
	}

	/**
	 * Get the user ID of the user placing the car quotation.
	 *
	 * @return The user ID.
	 */
	public Short getUsrid() {
		return usrid;
	}

	/**
	 * Set the user ID of the user placing the car quotation.
	 *
	 * @param cUsrid The user ID.
	 */
	public void setUsrid(final Short cUsrid) {
		this.usrid = cUsrid;
	}

	/**
	 * Get the date of the car quotation.
	 *
	 * @return The date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date of the car quotation.
	 *
	 * @param cDate The date.
	 */
	public void setDate(final String cDate) {
		this.date = cDate;
	}

	/**
	 * Get the list of car quotation lines associated with this car quotation.
	 *
	 * @return The list of car quotation lines.
	 */
	public List<DevisCarLine> getDevisCarLines() {
		return deviscarLines;
	}

	/**
	 * Set the list of car quotation lines associated with this car quotation.
	 *
	 * @param cDeviscarLines The list of car quotation lines.
	 */
	public void setDevisCarLines(final List<DevisCarLine> cDeviscarLines) {
		this.deviscarLines = cDeviscarLines;
	}

	@Override
	public final String toString() {
		return "DevisCar [id=" + id + ", usr_id=" + usrid + ", date=" + date + ", deviscarLines=" + deviscarLines + "]";
	}

}
