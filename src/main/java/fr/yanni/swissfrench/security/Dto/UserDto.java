package fr.yanni.swissfrench.security.Dto;

import fr.yanni.swissfrench.security.models.User;

/**
 * This class represents the details of a user.
 */
public class UserDto {

	/** the login. */
	private String username;
	/** the firstname. */
	private String password;

	/** the firstname. */
	private String firstname;

	/** the lastname. */
	private String lastname;

	/** the lastname. */
	private String address;

	/** the role of te user. */
	private String role;

	/** Default constructor. */
	public UserDto() {
		super();
	}

	/**
	 * Create a new UserDto from a User.
	 *
	 * @param pUser the user to use
	 */
	public UserDto(final User pUser) {
		this.username = pUser.getUsername();
		this.password = pUser.getPassword();

		this.firstname = pUser.getFirstname();
		this.lastname = pUser.getLastname();
		this.address = pUser.getAddress();

		this.role = pUser.getRoles().iterator().next().getName().name();

	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pPassword the pPassword to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the lastname
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pAddress the pAddress to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	/**
	 * @param pRole the role to set
	 */
	public void setRole(final String pRole) {
		this.role = pRole;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
