package fr.yanni.swissfrench.core.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a user entity.
 */
@Entity
@Table(name = "users")
@CrossOrigin
public class Users {

	/** Unique ID of a user. */
	@Id
	@Column(name = "id")
	private Short id;

	/** Username of the user. */
	@Column(name = "username")
	private String username;

	/** Password of the user. */
	@Column(name = "password")
	private String password;

	/** First name of the user. */
	@Column(name = "firstname")
	private String firstname;

	/** Last name of the user. */
	@Column(name = "lastname")
	private String lastname;

	/** Address of the user. */
	@Column(name = "address")
	private String address;

	/**
	 * Default constructor.
	 */
	public Users() {
		super();
	}

	/**
	 * Parameterized constructor.
	 *
	 * @param pId        The unique pId of the user.
	 * @param pUsername  The pUsername of the user.
	 * @param pPassword  The pPassword of the user.
	 * @param pFirstname The pFirstname of the user.
	 * @param pLastname  The pLastname of the user.
	 * @param pAddress   The pAddress of the user.
	 */
	public Users(final Short pId, final String pUsername, final String pPassword, final String pFirstname,
			final String pLastname, final String pAddress) {
		super();
		this.id = pId;
		this.username = pUsername;
		this.password = pPassword;
		this.firstname = pFirstname;
		this.lastname = pLastname;
		this.address = pAddress;
	}

	/**
	 * Getter for ID.
	 *
	 * @return The ID of the user.
	 */
	public Short getId() {
		return id;
	}

	/**
	 * Setter for ID.
	 *
	 * @param pId The pId to set.
	 */
	public void setId(final Short pId) {
		this.id = pId;
	}

	/**
	 * Getter for username.
	 *
	 * @return The username of the user.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter for username.
	 *
	 * @param pUsername The pUsername to set.
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

	/**
	 * Getter for password.
	 *
	 * @return The password of the user.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password.
	 *
	 * @param pPassword The pPassword to set.
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * Getter for first name.
	 *
	 * @return The first name of the user.
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setter for first name.
	 *
	 * @param pFirstname The pFirstname to set.
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * Getter for last name.
	 *
	 * @return The last name of the user.
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Setter for last name.
	 *
	 * @param pLastname The pLastname to set.
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * Getter for address.
	 *
	 * @return The address of the user.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for address.
	 *
	 * @param pAddress The pAddress to set.
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	/**
	 * String representation of the object.
	 *
	 * @return String representation of the user.
	 */
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address=" + address + "]";
	}

}
