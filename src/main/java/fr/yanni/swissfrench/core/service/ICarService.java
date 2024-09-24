package fr.yanni.swissfrench.core.service;

import java.util.List;

import fr.yanni.swissfrench.core.domain.Car;

public interface ICarService {

	/**
	 *
	 * @return all known cars
	 */

	List<Car> getAllCars();

	/**
	 *
	 * @param name a filter
	 * @return all pizza whose name starts with the given name
	 */

	/**
	 * Find a pokemon from its id.
	 *
	 * @param id the id of the pokemon
	 * @return athe pokemon with the given id
	 */
	Car getOne(Short id);

	/**
	 * create or update a pizza.
	 *
	 * @param car
	 * @return the updated pizza
	 */
	Car save(Car car);

}
