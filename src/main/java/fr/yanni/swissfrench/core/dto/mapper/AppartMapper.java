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

@Component
public class AppartMapper {

	private static UserDetailsServiceImpl userService = new UserDetailsServiceImpl();

	@Autowired
	public AppartMapper(UserDetailsServiceImpl userService) {
		this.userService = userService;
	}

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

	public static AppartDTO appartToDto(final Appart appart) {
		AppartDTO dto = null;
		if (appart != null) {
			dto = new AppartDTO();
			dto.setUsr_id(appart.getUsr_id());
			dto.setPrice(appart.getPrice());
			dto.setAdresse(appart.getAdresse());
			dto.setDescription(appart.getDescription());

		}
		return dto;
	}

	public static Appart dtoToEntity(AppartDTO dto) {
		Appart entity = null;
		if (dto != null) {
			entity = new Appart();
			entity.setPrice(dto.getPrice());
			entity.setAdresse(dto.getAdresse());
			entity.setDescription(dto.getDescription());
			Long userId = getLoggedInUserId();
			if (userId != null) {
				entity.setUsr_id(userId.shortValue());
			}
		}
		return entity;
	}

	private static Long getLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			return userService.getUserIdByUsername(userDetails.getUsername());
		}
		return null;
	}

	public static Boolean booleanMethod() {
		return null;
	}
}
