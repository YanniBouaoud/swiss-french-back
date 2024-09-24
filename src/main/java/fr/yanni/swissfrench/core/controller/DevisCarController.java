package fr.yanni.swissfrench.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.yanni.swissfrench.core.domain.DevisCar;
import fr.yanni.swissfrench.core.dto.DevisCarDTO;
import fr.yanni.swissfrench.core.dto.mapper.DevisCarMapper;
import fr.yanni.swissfrench.core.service.IDevisCarService;

@RestController
@CrossOrigin
@RequestMapping("/deviscar")
public class DevisCarController {

	/**
	 * Autowired dependency for accessing order-related services.
	 */
	@Autowired
	private IDevisCarService devisCarService;

	/**
	 * Autowired dependency for mapping between DevisCarDTO and DevisCar entities.
	 */
	@Autowired
	private DevisCarMapper devisCarMapper;

	/**
	 *
	 * @param order The DevisCarDTO representing the new order to be saved.
	 * @return The DevisCarDTO of the saved order.
	 */
	@PostMapping("/")
	public DevisCarDTO save(@RequestBody final DevisCarDTO order) {
		DevisCar newOrder = devisCarMapper.dtoToEntity(order);
		DevisCar savedOrder = devisCarService.save(newOrder);
		return devisCarMapper.deviscarToDto(savedOrder);
	}
}
