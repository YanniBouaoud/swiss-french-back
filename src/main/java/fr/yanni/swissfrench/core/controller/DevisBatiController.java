package fr.yanni.swissfrench.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.yanni.swissfrench.core.domain.DevisBati;
import fr.yanni.swissfrench.core.dto.DevisBatiDTO;
import fr.yanni.swissfrench.core.dto.mapper.DevisBatiMapper;
import fr.yanni.swissfrench.core.service.IDevisBatiService;

@RestController
@CrossOrigin
@RequestMapping("/devisbati")
public class DevisBatiController {

	@Autowired
	private IDevisBatiService devisBatiService;

	/**
	 * Autowired dependency for mapping between DevisCarDTO and DevisCar entities.
	 */
	@Autowired
	private DevisBatiMapper devisBatiMapper;

	/**
	 *
	 * @param order The DevisCarDTO representing the new order to be saved.
	 * @return The DevisCarDTO of the saved order.
	 */
	@PostMapping("/")
	public DevisBatiDTO save(@RequestBody final DevisBatiDTO order) {
		DevisBati newOrder = devisBatiMapper.dtoToEntity(order);
		DevisBati savedOrder = devisBatiService.save(newOrder);
		return devisBatiMapper.devisbatiToDto(savedOrder);
	}
}
