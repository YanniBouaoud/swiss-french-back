package fr.yanni.swissfrench.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.yanni.swissfrench.core.domain.Appart;
import fr.yanni.swissfrench.core.dto.AppartDTO;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;

/**
 * Mapper class for converting between Appart and AppartDTO objects.
 */
@Component
public class AppartMapper {

	/** Service for retrieving user details. */

	private static UserDetailsServiceImpl userService = new UserDetailsServiceImpl();

	/**
	 * Constructor for AppartMapper.
	 *
	 * @param mUserService The UserDetailsServiceImpl instance to be injected.
	 */
	@Autowired
	public AppartMapper(final UserDetailsServiceImpl mUserService) {
		AppartMapper.userService = mUserService;
	}

	/**
	 * Converts a list of Appart objects to a list of AppartDTO objects.
	 *
	 * @param apparts The list of Appart objects.
	 * @return The list of AppartDTO objects.
	 */
	public static List<AppartDTO> appartsToDtos(final List<Appart> apparts) {
		List<AppartDTO> dtos = null;

		if ((apparts != null)) {
			dtos = new ArrayList<>();

			for (Appart appart : apparts) {
				dtos.add(appartToDto(appart));
			}
		}

		return dtos;
	}

	/**
	 * Converts an Appart object to an AppartDTO object.
	 *
	 * @param appart The Appart object.
	 * @return The AppartDTO object.
	 */

	public static AppartDTO appartToDto(final Appart appart) {
		AppartDTO dto = null;
		if (appart != null) {
			dto = new AppartDTO();
			dto.setUsr_id(appart.getUsrid());
			dto.setPrice(appart.getPrice());
			dto.setAdresse(appart.getAdresse());
			dto.setImage(appart.getImage());

			dto.setDescription(appart.getDescription());

		}
		return dto;
	}

	/**
	 * Converts an AppartDTO object to an Appart entity object.
	 *
	 * @param dto The AppartDTO object.
	 * @return The Appart entity object.
	 */

	public static Appart dtoToEntity(final AppartDTO dto) {
		Appart entity = null;
		if (dto != null) {
			entity = new Appart();
			entity.setPrice(dto.getPrice());
			entity.setAdresse(dto.getAdresse());
			entity.setImage(dto.getImage());

			entity.setDescription(dto.getDescription());
			Long userId = getLoggedInUserId();
			if (userId != null) {
				entity.setUsrid(userId.shortValue());
			}
		}
		return entity;
	}

	/**
	 * Retrieves the ID of the currently logged-in user.
	 *
	 * @return The ID of the logged-in user.
	 */

	private static Long getLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			return userService.getUserIdByUsername(userDetails.getUsername());
		}
		return null;
	}

	/**
	 * A boolean method (just for testing purposes).
	 *
	 * @return Always returns null.
	 */
	public static Boolean booleanMethod() {
		return null;
	}
}
