package fr.yanni.swissfrench.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.yanni.swissfrench.core.domain.Users;
import fr.yanni.swissfrench.core.repository.IUsersRepository;
import fr.yanni.swissfrench.core.service.IUsersService;

@Service
@CrossOrigin
public class UsersService implements IUsersService {

	/**
	 * Autowired field for the Users repository.
	 */
	@Autowired
	private IUsersRepository usersRepo;

	@Override
	public final Users save(final Users users) {
		return usersRepo.saveAndFlush(users);
	}

	@Override
	public final Users getUserByUsername(final String username) {
		Optional<Users> userOptional = usersRepo.findByUsername(username);
		return userOptional.orElse(null);
	}

	@Override
	public final Short getUserIdByUsername(final String username) {
		Users user = getUserByUsername(username);
		if (user != null) {
			return user.getId();
		} else {
			throw new RuntimeException("User not found for username: " + username);
		}
	}

}
