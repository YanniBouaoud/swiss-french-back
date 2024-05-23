package fr.yanni.swissfrench.core.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.yanni.swissfrench.core.domain.DevisBati;
import fr.yanni.swissfrench.core.dto.DevisBatiDTO;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;

/**
 * Mapper class for converting between DevisBati and DevisBatiDTO objects.
 */
@Component
public class DevisBatiMapper {

	/** Service for retrieving user details. */
	public UserDetailsServiceImpl userService;

	/**
	 * Constructor for the DevisBatiMapper class.
	 *
	 * @param mUserService The UserDetailsServiceImpl instance to be injected.
	 */
	@Autowired
	public DevisBatiMapper(final UserDetailsServiceImpl mUserService) {
		this.userService = mUserService;
	}

	/**
	 * Converts a DevisBati object to a DevisBatiDTO object.
	 *
	 * @param devisBati The DevisBati object.
	 * @return The DevisBatiDTO object.
	 */
	public DevisBatiDTO devisbatiToDto(final DevisBati devisBati) {
		DevisBatiDTO dto = null;
		if (devisBati != null) {
			dto = new DevisBatiDTO();
			dto.setUsr_id(devisBati.getUsrid());
			dto.setBudget(devisBati.getBudget());
			dto.setDelais(devisBati.getDelais());
			dto.setDescription(devisBati.getDescription());
		}
		return dto;
	}

	/**
	 * Converts a DevisBatiDTO object to a DevisBati entity object.
	 *
	 * @param dto The DevisBatiDTO object.
	 * @return The DevisBati entity object.
	 */
	public DevisBati dtoToEntity(final DevisBatiDTO dto) {
		DevisBati entity = null;
		if (dto != null) {
			entity = new DevisBati();
			entity.setBudget(dto.getBudget());
			entity.setDelais(dto.getDelais());
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
	 * @return The ID of the currently logged-in user, or null if not available.
	 */
	private Long getLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			return userService.getUserIdByUsername(userDetails.getUsername());
		}
		return null;
	}

	/**
	 * Gets the UserDetailsServiceImpl instance.
	 *
	 * @return The UserDetailsServiceImpl instance.
	 */
	public UserDetailsServiceImpl getUserService() {
		return userService;
	}

	/**
	 * Sets the UserDetailsServiceImpl instance.
	 *
	 * @param mUserService The UserDetailsServiceImpl instance to set.
	 */
	public void setUserService(final UserDetailsServiceImpl mUserService) {
		this.userService = mUserService;
	}

}
