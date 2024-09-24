package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a construction quote entity.
 */
@Entity
@Table(name = ("devisbati"))
@CrossOrigin
public class DevisBati {
	/** Unique ID of a construction quote. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** User ID of the user placing the construction quote. */
	@Column(name = "usr_id")
	private Short usrid;

	/** Date of the construction quote. */
	@Column(name = "date", insertable = false, updatable = false)
	private String date;

	/** Budget for the construction quote. */
	@Column(name = "budget")
	private Long budget;

	/** Time frame for the completion of the construction quote. */
	@Column(name = "delais")
	private String delais;

	/** Description of the construction quote. */
	@Column(name = "description")
	private String description;

	/**
	 * Get the description of the construction quote.
	 *
	 * @return The description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the construction quote.
	 *
	 * @param bDescription The description.
	 */
	public void setDescription(final String bDescription) {
		this.description = bDescription;
	}

	/**
	 * Constructor with parameters.
	 *
	 * @param bId          The unique ID of the construction quote.
	 * @param bUsrid       The user ID of the user placing the construction quote.
	 * @param bDate        The date of the construction quote.
	 * @param bBudget      The budget for the construction quote.
	 * @param bDelais      The time frame for the completion of the construction
	 *                     quote.
	 * @param bDescription The description of the construction quote.
	 */
	public DevisBati(final Short bId, final Short bUsrid, final String bDate, final Long bBudget, final String bDelais,
			final String bDescription) {
		super();
		this.id = bId;
		this.usrid = bUsrid;
		this.date = bDate;
		this.budget = bBudget;
		this.delais = bDelais;
		this.description = bDescription;
	}

	/**
	 * Default constructor.
	 */
	public DevisBati() {
		super();
	}

	// Getters and setters

	/**
	 * Get the unique ID of the construction quote.
	 *
	 * @return The ID.
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Set the unique ID of the construction quote.
	 *
	 * @param bId The ID.
	 */
	public void setId(final Short bId) {
		this.id = bId;
	}

	/**
	 * Get the user ID of the user placing the construction quote.
	 *
	 * @return The user ID.
	 */
	public Short getUsrid() {
		return usrid;
	}

	/**
	 * Set the user ID of the user placing the construction quote.
	 *
	 * @param bUsrid The user ID.
	 */
	public void setUsrid(final Short bUsrid) {
		this.usrid = bUsrid;
	}

	/**
	 * Get the date of the construction quote.
	 *
	 * @return The date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date of the construction quote.
	 *
	 * @param bDate The date.
	 */
	public void setDate(final String bDate) {
		this.date = bDate;
	}

	/**
	 * Get the budget for the construction quote.
	 *
	 * @return The budget.
	 */
	public Long getBudget() {
		return budget;
	}

	/**
	 * Set the budget for the construction quote.
	 *
	 * @param bBudget The budget.
	 */
	public void setBudget(final Long bBudget) {
		this.budget = bBudget;
	}

	/**
	 * Get the time frame for the completion of the construction quote.
	 *
	 * @return The time frame.
	 */
	public String getDelais() {
		return delais;
	}

	/**
	 * Set the time frame for the completion of the construction quote.
	 *
	 * @param bDelais The time frame.
	 */
	public void setDelais(final String bDelais) {
		this.delais = bDelais;
	}

	@Override
	public final String toString() {
		return "DevisBati [id=" + id + ", usr_id=" + usrid + ", date=" + date + ", budget=" + budget + ", delais="
				+ delais + "]";
	}

}
