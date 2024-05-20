package fr.yanni.swissfrench.security.Dto;

public class SignupRequest {

	/** the username send from the caller. */
	private String username;

	/** the password send from the caller. */
	private String password;

	/** the firstname send from the caller. */
	private String firstname;

	/** the lastname send from the caller. */
	private String lastname;

	/** the address send from the caller. */
	private String address;

	/**
	 *
	 */
	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 *
	 * @param pUsername  the pUsername for the signup request
	 * @param pPassword  the pPassword for the signup request
	 * @param pFirstname the pFirstname for the signup request
	 * @param pLastname  the pLastname for the signup request
	 * @param pAddress   the pAddress for the signup request
	 */
	public SignupRequest(final String pUsername, final String pPassword, final String pFirstname,
			final String pLastname, final String pAddress) {
		super();
		this.username = pUsername;
		this.password = pPassword;
		this.firstname = pFirstname;
		this.lastname = pLastname;
		this.address = pAddress;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pUsername the pUsername to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
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
	public String getsetFirstname() {
		return firstname;
	}

	/**
	 * @param pFirstname the pFirstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param pLastname the pLastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param pAddress the pAddress to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	@Override
	public final String toString() {
		return "SignupRequest [username=" + username + ", password=" + password + ", firstName=" + firstname
				+ ", lastName=" + lastname + ", address=" + address + "]";
	}

}
