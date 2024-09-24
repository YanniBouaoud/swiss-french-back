package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents an apartment entity.
 */
@Entity
@Table(name = "appartement")
@CrossOrigin
public class Appart {
	/** Unique ID of an apartment. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** User ID of the user placing the order. */
	@Column(name = "usr_id")
	private Short usrid;

	/** Price of the apartment. */
	@Column(name = "price")
	private Long price;

	/** Address of the apartment. */
	@Column(name = "adresse")
	private String adresse;

	/** URL for retrieving the picture of the apartment. */
	@Column(name = "image")
	private String image;

	/** Description of the apartment. */
	@Column(name = "description")
	private String description;

	/** Date of the creation of the apartment. */
	@Column(name = "date", insertable = false, updatable = false)
	private String date;

	/**
	 * Default constructor.
	 */
	public Appart() {
		super();
	}

	/**
	 * Constructor with parameters.
	 *
	 * @param aId          The unique ID of the apartment.
	 * @param aUsrid       The user ID of the user placing the order.
	 * @param aPrice       The price of the apartment.
	 * @param aAdresse     The address of the apartment.
	 * @param aImage       The URL for retrieving the picture of the apartment.
	 * @param aDescription The description of the apartment.
	 * @param aDate        The date of the creation of the apartment.
	 */
	public Appart(final Short aId, final Short aUsrid, final Long aPrice, final String aAdresse, final String aImage,
			final String aDescription, final String aDate) {
		super();
		this.id = aId;
		this.usrid = aUsrid;
		this.price = aPrice;
		this.adresse = aAdresse;
		this.image = aImage;
		this.description = aDescription;
		this.date = aDate;
	}

	// Getters and setters

	/**
	 * Get the unique ID of the apartment.
	 *
	 * @return The ID of the apartment.
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Set the unique ID of the apartment.
	 *
	 * @param aId The ID of the apartment.
	 */
	public void setId(final Short aId) {
		this.id = aId;
	}

	/**
	 * Get the user ID of the user placing the order.
	 *
	 * @return The user ID.
	 */
	public Short getUsrid() {
		return usrid;
	}

	/**
	 * Set the user ID of the user placing the order.
	 *
	 * @param aUsrid The user ID.
	 */
	public void setUsrid(final Short aUsrid) {
		this.usrid = aUsrid;
	}

	/**
	 * Get the price of the apartment.
	 *
	 * @return The price.
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * Set the price of the apartment.
	 *
	 * @param aPrice The price.
	 */
	public void setPrice(final Long aPrice) {
		this.price = aPrice;
	}

	/**
	 * Get the address of the apartment.
	 *
	 * @return The address.
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Set the address of the apartment.
	 *
	 * @param aAdresse The address.
	 */
	public void setAdresse(final String aAdresse) {
		this.adresse = aAdresse;
	}

	/**
	 * Get the URL for retrieving the picture of the apartment.
	 *
	 * @return The image URL.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set the URL for retrieving the picture of the apartment.
	 *
	 * @param aImage The image URL.
	 */
	public void setImage(final String aImage) {
		this.image = aImage;
	}

	/**
	 * Get the description of the apartment.
	 *
	 * @return The description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the apartment.
	 *
	 * @param aDescription The description.
	 */
	public void setDescription(final String aDescription) {
		this.description = aDescription;
	}

	/**
	 * Get the date of the creation of the apartment.
	 *
	 * @return The creation date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date of the creation of the apartment.
	 *
	 * @param aDate The creation date.
	 */
	public void setDate(final String aDate) {
		this.date = aDate;
	}

	@Override
	public final String toString() {
		return "Appart [id=" + id + ", usr_id=" + usrid + ", price=" + price + ", adresse=" + adresse + ", image="
				+ image + ", description=" + description + ", date=" + date + "]";
	}

}
