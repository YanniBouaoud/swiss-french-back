package fr.yanni.swissfrench.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object (DTO) représentant une pizza.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

	/** Identifiant unique de la pizza. */
	private Short id;

	/** Nom de la pizza. */
	private String name;

	/** Description de la pizza. */
	private String description;

	/** URL pour récupérer l'image de la pizza. */
	private String image;

	/** Deuxième URL pour récupérer l'image de la pizza. */
	private String image2;

	/** Troisième URL pour récupérer l'image de la pizza. */
	private String image3;

	/** Prix de la pizza. */
	private Double price;

	/**
	 * Constructeur par défaut.
	 */
	public CarDTO() {
		super();
	}

	/**
	 * Constructeur avec paramètres.
	 *
	 * @param id          Identifiant unique de la pizza
	 * @param name        Nom de la pizza
	 * @param description Description de la pizza
	 * @param image       URL pour récupérer l'image de la pizza
	 * @param image2      Deuxième URL pour récupérer l'image de la pizza
	 * @param image3      Troisième URL pour récupérer l'image de la pizza
	 * @param price       Prix de la pizza
	 */
	public CarDTO(final Short id, String name, String description, String image, String image2, String image3, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.image2 = image2;
		this.image3 = image3;
		this.price = price;
	}

	/**
	 * Obtient l'identifiant unique de la pizza.
	 *
	 * @return L'identifiant unique de la pizza
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Définit l'identifiant unique de la pizza.
	 *
	 * @param id L'identifiant unique de la pizza à définir
	 */
	public void setId(final Short id) {
		this.id = id;
	}

	/**
	 * Obtient le nom de la pizza.
	 *
	 * @return Le nom de la pizza
	 */
	public String getName() {
		return name;
	}

	/**
	 * Définit le nom de la pizza.
	 *
	 * @param name Le nom de la pizza à définir
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Obtient la description de la pizza.
	 *
	 * @return La description de la pizza
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Définit la description de la pizza.
	 *
	 * @param description La description de la pizza à définir
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Obtient l'URL pour récupérer l'image de la pizza.
	 *
	 * @return L'URL pour récupérer l'image de la pizza
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Définit l'URL pour récupérer l'image de la pizza.
	 *
	 * @param image L'URL pour récupérer l'image de la pizza à définir
	 */
	public void setImage(final String image) {
		this.image = image;
	}

	/**
	 * Obtient le deuxième URL pour récupérer l'image de la pizza.
	 *
	 * @return Le deuxième URL pour récupérer l'image de la pizza
	 */
	public String getImage2() {
		return image2;
	}

	/**
	 * Définit le deuxième URL pour récupérer l'image de la pizza.
	 *
	 * @param image2 Le deuxième URL pour récupérer l'image de la pizza à définir
	 */
	public void setImage2(final String image2) {
		this.image2 = image2;
	}

	/**
	 * Obtient le troisième URL pour récupérer l'image de la pizza.
	 *
	 * @return Le troisième URL pour récupérer l'image de la pizza
	 */
	public String getImage3() {
		return image3;
	}

	/**
	 * Définit le troisième URL pour récupérer l'image de la pizza.
	 *
	 * @param image3 Le troisième URL pour récupérer l'image de la pizza à définir
	 */
	public void setImage3(final String image3) {
		this.image3 = image3;
	}

	/**
	 * Obtient le prix de la pizza.
	 *
	 * @return Le prix de la pizza
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Définit le prix de la pizza.
	 *
	 * @param price Le prix de la pizza à définir
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}

	/**
	 * String representation of the object.
	 *
	 * @return String representation of the DTO.
	 */
	@Override
	public String toString() {
		return "CarDTO [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image 
		        + ", image2=" + image2 + ", image3=" + image3 + ", price=" + price + "]";
	}
}
