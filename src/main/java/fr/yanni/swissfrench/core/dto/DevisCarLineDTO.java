package fr.yanni.swissfrench.core.dto;

/**
 * Data Transfer Object (DTO) représentant une ligne de commande d'une commande.
 */
public class DevisCarLineDTO {

	/** Identifiant de la commande associée à cette ligne. */
	private Short ord_id;

	/** Identifiant de la pizza associée à cette ligne. */
	private Short car_id;

	/** Quantité de pizzas commandées dans cette ligne. */
	private String commentaire;

	/**
	 * Constructeur par défaut.
	 */
	public DevisCarLineDTO() {
		super();
	}

	/**
	 * Constructeur avec paramètres.
	 *
	 * @param id          Identifiant unique de la ligne de commande
	 * @param ord_id      Identifiant de la commande associée
	 * @param piz_id      Identifiant de la pizza associée
	 * @param description Quantité de pizzas commandées
	 */
	public DevisCarLineDTO(Short ord_id, Short car_id, String commentaire) {
		super();
		this.ord_id = ord_id;
		this.car_id = car_id;
		this.commentaire = commentaire;
	}

	/**
	 * Obtient l'identifiant de la commande associée à cette ligne.
	 *
	 * @return L'identifiant de la commande associée
	 */
	public Short getOrd_id() {
		return ord_id;
	}

	/**
	 * Définit l'identifiant de la commande associée à cette ligne.
	 *
	 * @param ord_id L'identifiant de la commande associée à définir
	 */
	public void setOrd_id(final Short ord_id) {
		this.ord_id = ord_id;
	}

	/**
	 * Obtient l'identifiant de la pizza associée à cette ligne.
	 *
	 * @return L'identifiant de la pizza associée
	 */
	public Short getCar_id() {
		return car_id;
	}

	/**
	 * Définit l'identifiant de la pizza associée à cette ligne.
	 *
	 * @param piz_id L'identifiant de la pizza associée à définir
	 */
	public void setCar_id(final Short car_id) {
		this.car_id = car_id;
	}

	/**
	 * Obtient la quantité de pizzas commandées dans cette ligne.
	 *
	 * @return La quantité de pizzas commandées
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Définit la quantité de pizzas commandées dans cette ligne.
	 *
	 * @param quantity La quantité de pizzas commandées à définir
	 */
	public void setCommentaire(final String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * String representation of the object.
	 *
	 * @return String representation of the order_line.
	 */
	@Override
	public String toString() {
		return "DevisCarLineDTO [ord_id=" + ord_id + ", car_id=" + car_id + ", commentaire=" + commentaire + "]";
	}
}
