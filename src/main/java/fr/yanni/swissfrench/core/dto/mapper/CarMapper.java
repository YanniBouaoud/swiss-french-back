package fr.yanni.swissfrench.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.yanni.swissfrench.core.domain.Car;
import fr.yanni.swissfrench.core.dto.CarDTO;

/**
 * Mapper class for converting between Car and CarDTO objects.
 */
public class CarMapper {

	/**
	 * Converts a list of Car objects to a list of CarDTO objects.
	 *
	 * @param cars The list of Car objects.
	 * @return The list of CarDTO objects.
	 */
	public static List<CarDTO> carsToDtos(final List<Car> cars) {
		List<CarDTO> dtos = null;
		if ((cars != null)) {
			dtos = new ArrayList<>();
			for (Car car : cars) {
				dtos.add(carToDto(car));
			}
		}
		return dtos;
	}

	/**
	 * Converts a Car object to a CarDTO object.
	 *
	 * @param car The Car object.
	 * @return The CarDTO object.
	 */
	public static CarDTO carToDto(final Car car) {
		CarDTO dto = null;
		if (car != null) {
			dto = new CarDTO();
			dto.setId(car.getId());
			dto.setDescription(car.getDescription());
			dto.setPrice(car.getPrice());
			dto.setName(car.getName());
			dto.setImage(car.getImage());
		}
		return dto;
	}

	/**
	 * Converts a CarDTO object to a Car entity object.
	 *
	 * @param dto The CarDTO object.
	 * @return The Car entity object.
	 */
	public static Car dtoToEntity(final CarDTO dto) {
		Car entity = null;
		if (dto != null) {
			entity = new Car();
			entity.setId(dto.getId());
			entity.setImage(dto.getImage());
			entity.setDescription(dto.getDescription());
			entity.setName(dto.getName());
		}
		return entity;
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
