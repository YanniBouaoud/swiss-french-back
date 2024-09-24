package fr.yanni.swissfrench.core.dto;

/**
 * Data Transfer Object (DTO) représentant un utilisateur.
 */
public class UsersDTO {

	/** Identifiant unique de l'utilisateur. */
	private Short id;

	/** Nom d'utilisateur de l'utilisateur. */
	private String username;

	/** Mot de passe de l'utilisateur. */
	private String password;

	/** Prénom de l'utilisateur. */
	private String firstname;

	/** Nom de famille de l'utilisateur. */
	private String lastname;

	/** Adresse de l'utilisateur. */
	private String address;

	/**
	 * Constructeur par défaut.
	 */
	public UsersDTO() {
		super();
	}

	/**
	 * Constructeur avec paramètres.
	 *
	 * @param id        Identifiant unique de l'utilisateur
	 * @param username  Nom d'utilisateur de l'utilisateur
	 * @param password  Mot de passe de l'utilisateur
	 * @param firstname Prénom de l'utilisateur
	 * @param lastname  Nom de famille de l'utilisateur
	 * @param address   Adresse de l'utilisateur
	 */
	public UsersDTO(final Short id, String username, String password, String firstname, String lastname,
			String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

	/**
	 * Obtient l'identifiant unique de l'utilisateur.
	 *
	 * @return L'identifiant unique de l'utilisateur
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Définit l'identifiant unique de l'utilisateur.
	 *
	 * @param id L'identifiant unique de l'utilisateur à définir
	 */
	public void setId(final Short id) {
		this.id = id;
	}

	/**
	 * Obtient le nom d'utilisateur de l'utilisateur.
	 *
	 * @return Le nom d'utilisateur de l'utilisateur
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Définit le nom d'utilisateur de l'utilisateur.
	 *
	 * @param username Le nom d'utilisateur de l'utilisateur à définir
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * Obtient le mot de passe de l'utilisateur.
	 *
	 * @return Le mot de passe de l'utilisateur
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Définit le mot de passe de l'utilisateur.
	 *
	 * @param password Le mot de passe de l'utilisateur à définir
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Obtient le prénom de l'utilisateur.
	 *
	 * @return Le prénom de l'utilisateur
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Définit le prénom de l'utilisateur.
	 *
	 * @param firstname Le prénom de l'utilisateur à définir
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Obtient le nom de famille de l'utilisateur.
	 *
	 * @return Le nom de famille de l'utilisateur
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Définit le nom de famille de l'utilisateur.
	 *
	 * @param lastname Le nom de famille de l'utilisateur à définir
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Obtient l'adresse de l'utilisateur.
	 *
	 * @return L'adresse de l'utilisateur
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Définit l'adresse de l'utilisateur.
	 *
	 * @param address L'adresse de l'utilisateur à définir
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * String representation of the object.
	 *
	 * @return String representation of the order.
	 */
	@Override
	public String toString() {
		return "UsersDTO [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address=" + address + "]";
	}

}