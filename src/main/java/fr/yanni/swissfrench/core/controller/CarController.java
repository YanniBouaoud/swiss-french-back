package fr.yanni.swissfrench.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.yanni.swissfrench.core.dto.CarDTO;
import fr.yanni.swissfrench.core.dto.mapper.CarMapper;
import fr.yanni.swissfrench.core.service.ICarService;

@RestController
@CrossOrigin
@RequestMapping("/car")

public class CarController {

	/**
	 * The order service.
	 */
	@Autowired
	private ICarService carService;

	/**
	 * Retrieves all cars and returns them as a list of CarDTO objects.
	 *
	 * @return A list of CarDTO objects representing all cars.
	 */

	@GetMapping("/")
	public List<CarDTO> getAll() {
		return CarMapper.carsToDtos(carService.getAllCars());
	}

	/**
	 * Find a pizza from its id.
	 *
	 * @param id the id of the pizza
	 * @return the pizza with the given id
	 */
	@GetMapping("/{id}")
	public CarDTO getOne(@PathVariable("id") final Short id) {
		return CarMapper.carToDto(carService.getOne(id));
	}

}
