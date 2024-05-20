package fr.yanni.swissfrench.core.dto;

public class AppartDTO {

	/** User ID of the user placing the order. */
	private Short usr_id;

	/** User ID of the user placing the order. */
	private Short price;

	/** User ID of the user placing the order. */
	private String adresse;

	/** User ID of the user placing the order. */
	private String description;

	public AppartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppartDTO(Short usr_id, Short price, String adresse, String description) {
		super();
		this.usr_id = usr_id;
		this.price = price;
		this.adresse = adresse;
		this.description = description;
	}

	public Short getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(Short usr_id) {
		this.usr_id = usr_id;
	}

	public Short getPrice() {
		return price;
	}

	public void setPrice(Short price) {
		this.price = price;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AppartDTO [usr_id=" + usr_id + ", price=" + price + ", adresse=" + adresse + ", description="
				+ description + "]";
	}

}
