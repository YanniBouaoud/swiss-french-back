package fr.yanni.swissfrench.security.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.yanni.swissfrench.security.models.Role;
import fr.yanni.swissfrench.security.models.User;
import fr.yanni.swissfrench.security.repository.UserRepository;
import fr.yanni.swissfrench.security.utils.UserMapper;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	/** import the userRepository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Load user's details from the DB.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);
	}

	/**
	 *
	 * @param username a username
	 * @return the detail of the given user
	 * @throws UsernameNotFoundException
	 */
	public User loadUserDetails(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return user;
	}

	/**
	 * Retrieves the user ID associated with the given username.
	 *
	 * @param username The username for which to retrieve the user ID.
	 * @return The user ID corresponding to the provided username.
	 * @throws UsernameNotFoundException if no user is found with the given
	 *                                   username.
	 */
	public Long getUserIdByUsername(final String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		return user.getId();
	}

	/**
	 * Update or create a user.
	 *
	 * @param user a user to save
	 * @return the updated user
	 */
	public User update(final User user) {

		return userRepository.save(user);
	}

	/**
	 * Checks if a user exists with the given username.
	 *
	 * @param username The username to check for existence.
	 * @return {@code true} if a user with the given username exists, {@code false}
	 *         otherwise.
	 */
	public boolean existsByUsername(final String username) {
		return userRepository.existsByUsername(username);

	}

	/**
	 * Saves the user to the repository.
	 *
	 * @param user The user to be saved.
	 */

	public void save(final User user) {
		userRepository.save(user);

	}

	/**
	 * Adds a role with the specified ID to the user with the given ID.
	 *
	 * @param userId The ID of the user to whom the role will be added.
	 * @param roleId The ID of the role to be added to the user.
	 * @throws UsernameNotFoundException if no user is found with the given ID.
	 */

	public void addUserToRole(final Long userId, final Long roleId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + userId));

		Role role = new Role();
		role.setId(roleId.intValue());

		Set<Role> roles = user.getRoles();
		roles.add(role);
		user.setRoles(roles);

		userRepository.save(user);
	}

}
