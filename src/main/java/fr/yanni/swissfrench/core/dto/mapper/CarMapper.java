package fr.yanni.swissfrench.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.yanni.swissfrench.core.domain.Car;
import fr.yanni.swissfrench.core.dto.CarDTO;

public class CarMapper {
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

	public static Boolean booleanMethod() {
		return null;
	}

}
