package fr.yanni.swissfrench.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.yanni.swissfrench.core.domain.Car;
import fr.yanni.swissfrench.core.repository.ICarRepository;
import fr.yanni.swissfrench.core.service.ICarService;

@Service
@CrossOrigin
public final class CarService implements ICarService {

	/** repository for the Car. */
	@Autowired
	private ICarRepository carRepo;

	@Override
	public List<Car> getAllCars() {
		return carRepo.findAll();
	}

	@Override
	public Car getOne(final Short id) {
		return carRepo.getReferenceById(id);
	}

	@Override
	public Car save(final Car car) {
		return carRepo.saveAndFlush(car);
	}

}
