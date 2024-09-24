package fr.yanni.swissfrench.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yanni.swissfrench.core.domain.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Short> {

	/**
	 *
	 * @param username a filter
	 * @return all users whose username starts with the given username
	 */
	List<Users> findByUsernameStartingWith(String username);

	/**
	 * Repository interface for managing Users entities.
	 */

	Optional<Users> findByUsername(String username);

	Short findIdByUsername(String username);

}
