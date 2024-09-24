package fr.yanni.swissfrench.core.service;

import fr.yanni.swissfrench.core.domain.Users;

public interface IUsersService {
	/**
	 * create or update a users.
	 *
	 * @param users
	 * @return the updated users
	 */
	Users save(Users users);

	/**
	 * Retrieve a user by their username.
	 *
	 * @param username the username of the user to retrieve
	 * @return the user corresponding to the given username, or null if not found
	 */
	Users getUserByUsername(String username);

	/**
	 * Retrieves the user ID associated with the given username.
	 *
	 * @param username The username for which to retrieve the user ID.
	 * @return The user ID corresponding to the provided username, or null if the
	 *         username is not found.
	 */

	Short getUserIdByUsername(String username);

}
