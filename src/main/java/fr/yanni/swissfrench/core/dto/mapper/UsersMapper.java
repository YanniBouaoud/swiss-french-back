package fr.yanni.swissfrench.core.dto.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.yanni.swissfrench.core.domain.Users;
import fr.yanni.swissfrench.core.dto.UsersDTO;

public class UsersMapper {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static UsersDTO usersToDto(final Users users) {
		UsersDTO dto = null;

		if (users != null) {
			dto = new UsersDTO();

			dto.setId(users.getId());
			dto.setUsername(users.getUsername());
			dto.setPassword(null);
			dto.setFirstname(users.getFirstname());
			dto.setLastname(users.getLastname());
			dto.setAddress(users.getAddress());
		}

		return dto;
	}

	public static Users dtoToEntity(UsersDTO dto) {
		Users entity = null;

		if (dto != null && allInfoFilled(dto)) {
			entity = new Users();
			entity.setId(dto.getId());
			entity.setUsername(dto.getUsername());
			entity.setPassword(hashPassword(dto.getPassword()));
			entity.setFirstname(dto.getFirstname());
			entity.setLastname(dto.getLastname());
			entity.setAddress(dto.getAddress());
		}

		return entity;
	}

	private static String hashPassword(String plainPassword) {
		return encoder.encode(plainPassword);
	}

	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return encoder.matches(plainPassword, hashedPassword);
	}

	private static boolean allInfoFilled(UsersDTO dto) {
		return dto.getUsername() != null && dto.getPassword() != null && dto.getFirstname() != null
				&& dto.getLastname() != null && dto.getAddress() != null;
	}

}