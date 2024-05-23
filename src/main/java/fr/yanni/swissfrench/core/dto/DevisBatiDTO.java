package fr.yanni.swissfrench.core.dto;

public class DevisBatiDTO {
	/** Unique ID of an order. */

	/** User ID of the user placing the order. */
	private Short usr_id;

	/** User ID of the user placing the order. */
	private Long budget;

	/** User ID of the user placing the order. */
	private String delais;

	private String description;

	public DevisBatiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevisBatiDTO(Short usr_id, Long budget, String delais, String description) {
		super();
		this.usr_id = usr_id;
		this.budget = budget;
		this.delais = delais;
		this.description = description;
	}

	public Short getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(Short usr_id) {
		this.usr_id = usr_id;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDelais() {
		return delais;
	}

	public void setDelais(String delais) {
		this.delais = delais;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DevisBatiDTO [usr_id=" + usr_id + ", budget=" + budget + ", delais=" + delais + ", description="
				+ description + "]";
	}

}
