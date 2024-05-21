package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appartement")
@CrossOrigin
public class Appart {
	/** Unique ID of an order. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Short id;

	/** Appart ID of the user placing the order. */
	@Column(name = "usr_id")
	private Short usr_id;

	/** User ID of the user placing the order. */
	@Column(name = "price")
	private Long price;

	/** Adress of the appart placing the order. */
	@Column(name = "adresse")
	private String adresse;

	/** URL for retrieving the picture of the appart. */
	@Column(name = "image")
	private String image;

	/** Description of the appart placing the order. */
	@Column(name = "description")
	private String description;

	/** Date of the order. */
	@Column(name = "date", insertable = false, updatable = false)
	private String date;

	public Appart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appart(Short id, Short usr_id, Long price, String adresse, String image, String description, String date) {
		super();
		this.id = id;
		this.usr_id = usr_id;
		this.price = price;
		this.adresse = adresse;
		this.image = image;
		this.description = description;
		this.date = date;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Appart [id=" + id + ", usr_id=" + usr_id + ", price=" + price + ", adresse=" + adresse + ", image="
				+ image + ", description=" + description + ", date=" + date + "]";
	}

}
