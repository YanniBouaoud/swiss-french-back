package fr.yanni.swissfrench.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yanni.swissfrench.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * find a user from its login.
	 *
	 * @param username the login
	 * @return an optional user if found
	 */
	Optional<User> findByUsername(String username);

	/**
	 * Check if a user exists by username.
	 *
	 * @param username the username
	 * @return true if the user exists, false otherwise
	 */
	boolean existsByUsername(String username);

	/**
	 * Saves the user to the repository.
	 *
	 * @param user The user to be saved.
	 * @return The saved user.
	 */
	@Override
	<S extends User> S save(S entity);

}
