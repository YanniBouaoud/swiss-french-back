package fr.yanni.swissfrench.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import fr.yanni.swissfrench.core.domain.DevisCar;
import fr.yanni.swissfrench.core.domain.DevisCarLine;
import fr.yanni.swissfrench.core.dto.DevisCarDTO;
import fr.yanni.swissfrench.core.dto.DevisCarLineDTO;
import fr.yanni.swissfrench.core.service.impl.DevisCarService;
import fr.yanni.swissfrench.security.service.impl.UserDetailsServiceImpl;

@Component

public class DevisCarMapper {
	public DevisCarDTO deviscarToDto(final DevisCar devisCar) {
		DevisCarDTO dto = null;
		if (devisCar != null) {
			dto = new DevisCarDTO();
			dto.setUsr_id(devisCar.getUsr_id());
			dto.setDevisCarLines(deviscarLinesToDtos(devisCar.getDevisCarLines()));
		}
		return dto;
	}

	@Autowired
	private UserDetailsServiceImpl userService;

	public DevisCar dtoToEntity(DevisCarDTO dto) {
		DevisCar entity = null;
		if (dto != null) {
			entity = new DevisCar();
			Long userId = getLoggedInUserId();
			if (userId != null) {
				entity.setUsr_id(userId.shortValue());
			}
			entity.setDevisCarLines(dtosToDevisCarLines(dto.getDevisCarLines(), entity));
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

	public static DevisCarLineDTO deviscarLineToDto(final DevisCarLine deviscarLine) {
		DevisCarLineDTO dto = null;
		if (deviscarLine != null) {
			dto = new DevisCarLineDTO();
			dto.setCar_id(deviscarLine.getCar_id());
			dto.setCommentaire(deviscarLine.getCommentaire());
			dto.setOrd_id(deviscarLine.getDevisCar().getId());
		}
		return dto;
	}

	public DevisCarLine dtoToDevisCarLine(DevisCarLineDTO dto) {
		DevisCarLine entity = null;
		if (dto != null) {
			entity = new DevisCarLine();
			entity.setCar_id(dto.getCar_id());
			entity.setCommentaire(dto.getCommentaire());
		}
		return entity;
	}

	public DevisCar getOrderById(Short id) {
		DevisCarService devisCarService = new DevisCarService();

		DevisCar devisCar = devisCarService.getDevisCarById(id);

		return devisCar;
	}

	private List<DevisCarLineDTO> deviscarLinesToDtos(List<DevisCarLine> deviscarLines) {
		List<DevisCarLineDTO> dtos = new ArrayList<>();
		if (deviscarLines != null) {
			for (DevisCarLine deviscarLine : deviscarLines) {
				dtos.add(deviscarLineToDto(deviscarLine));
			}
		}
		return dtos;
	}

	private List<DevisCarLine> dtosToDevisCarLines(List<DevisCarLineDTO> dtos, DevisCar devisCar) {
		List<DevisCarLine> deviscarLines = new ArrayList<>();
		if (dtos != null) {
			for (DevisCarLineDTO dto : dtos) {
				DevisCarLine deviscarLine = dtoToDevisCarLine(dto);
				deviscarLine.setDevisCar(devisCar);
				deviscarLines.add(deviscarLine);
			}
		}
		return deviscarLines;
	}
}
