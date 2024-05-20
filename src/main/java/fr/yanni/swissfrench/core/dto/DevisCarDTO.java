package fr.yanni.swissfrench.core.dto;

import java.util.List;

/**
 * Data Transfer Object (DTO) représentant une commande.
 */
public class DevisCarDTO {

	/** Identifiant de l'utilisateur associé à cette commande. */
	private Short usr_id;

	private List<DevisCarLineDTO> deviscarLines;

	public List<DevisCarLineDTO> getDevisCarLines() {
		return deviscarLines;
	}

	public void setDevisCarLines(List<DevisCarLineDTO> deviscarLines) {
		this.deviscarLines = deviscarLines;
	}

	public DevisCarDTO(Short usr_id, List<DevisCarLineDTO> deviscarLines) {
		super();
		this.usr_id = usr_id;
		this.deviscarLines = deviscarLines;
	}

	public DevisCarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtient l'identifiant de l'utilisateur associé à cette commande.
	 *
	 * @return L'identifiant de l'utilisateur associé
	 */
	public Short getUsr_id() {
		return usr_id;
	}

	/**
	 * Définit l'identifiant de l'utilisateur associé à cette commande.
	 *
	 * @param usr_id L'identifiant de l'utilisateur associé à définir
	 */
	public void setUsr_id(final Short usr_id) {
		this.usr_id = usr_id;
	}

	/**
	 * String representation of the object.
	 *
	 * @return String representation of the order.
	 */
	@Override
	public String toString() {
		return "DevisCarDTO [usr_id=" + usr_id + "]";
	}

}
