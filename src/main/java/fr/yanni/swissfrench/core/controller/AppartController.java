package fr.yanni.swissfrench.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.yanni.swissfrench.core.dto.AppartDTO;
import fr.yanni.swissfrench.core.dto.mapper.AppartMapper;
import fr.yanni.swissfrench.core.service.IAppartService;

@RestController
@CrossOrigin
@RequestMapping("/appart")
public class AppartController {

	/**
	 * The appart service.
	 */
	@Autowired
	private IAppartService appartService;

	/**
	 * Retrieves all apparts and returns them as a list of AppartDTO objects.
	 *
	 * @return A list of AppartDTO objects representing all apparts.
	 */

	@GetMapping("/")
	public List<AppartDTO> getAll() {
		return AppartMapper.appartsToDtos(appartService.getAllApparts());
	}

	/**
	 * Autowired dependency for mapping between DevisCarDTO and DevisCar entities.
	 */
	@Autowired
	private AppartMapper appartMapper;

	/**
	 *
	 * @param order The AppartDTO representing the new order to be saved.
	 * @return The AppartDTO of the saved order.
	 */
	@PostMapping("/")
	public AppartDTO save(@RequestBody final AppartDTO appart) {
		return AppartMapper.appartToDto(appartService.save(AppartMapper.dtoToEntity(appart)));
	}
}
