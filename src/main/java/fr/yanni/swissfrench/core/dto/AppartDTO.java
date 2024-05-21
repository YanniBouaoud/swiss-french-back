package fr.yanni.swissfrench.core.dto;

public class AppartDTO {

	/** User ID of the user placing the order. */
	private Short usr_id;

	/** User ID of the user placing the order. */
	private Long price;

	/** User ID of the user placing the order. */
	private String adresse;

	private String image;

	/** User ID of the user placing the order. */
	private String description;

	public AppartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppartDTO(Short usr_id, Long price, String adresse, String image, String description) {
		super();
		this.usr_id = usr_id;
		this.price = price;
		this.adresse = adresse;
		this.image = image;
		this.description = description;
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

	@Override
	public String toString() {
		return "AppartDTO [usr_id=" + usr_id + ", price=" + price + ", adresse=" + adresse + ", image=" + image
				+ ", description=" + description + "]";
	}

}
