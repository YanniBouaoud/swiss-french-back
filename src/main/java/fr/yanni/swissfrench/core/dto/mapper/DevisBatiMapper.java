package fr.yanni.swissfrench.core.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.yanni.swissfrench.core.domain.DevisBati;
import fr.yanni.swissfrench.core.dto.DevisBatiDTO;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;

@Component

public class DevisBatiMapper {
	public DevisBatiDTO devisbatiToDto(final DevisBati devisBati) {
		DevisBatiDTO dto = null;
		if (devisBati != null) {
			dto = new DevisBatiDTO();
			dto.setUsr_id(devisBati.getUsr_id());
			dto.setBudget(devisBati.getBudget());
			dto.setDelais(devisBati.getDelais());
			dto.setDescription(devisBati.getDescription());

		}
		return dto;
	}

	@Autowired
	private UserDetailsServiceImpl userService;

	public DevisBati dtoToEntity(DevisBatiDTO dto) {
		DevisBati entity = null;
		if (dto != null) {
			entity = new DevisBati();
			entity.setBudget(dto.getBudget());
			entity.setDelais(dto.getDelais());
			entity.setDescription(dto.getDescription());
			Long userId = getLoggedInUserId();
			if (userId != null) {
				entity.setUsr_id(userId.shortValue());
			}
		}
		return entity;
	}

	private Long getLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			return userService.getUserIdByUsername(userDetails.getUsername());
		}
		return null;
	}

}
