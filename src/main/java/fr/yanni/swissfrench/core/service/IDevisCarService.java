package fr.yanni.swissfrench.core.service;

import fr.yanni.swissfrench.core.domain.DevisCar;

public interface IDevisCarService {

	/**
	 * Saves the given order to the repository.
	 *
	 * @param devisCar The order to be saved.
	 * @return The saved order.
	 */

	DevisCar save(DevisCar devisCar);

	/**
	 * Retrieves an order by its unique identifier.
	 *
	 * @param id The unique identifier of the order to retrieve.
	 * @return The order with the specified ID, or null if no such order exists.
	 */

	DevisCar getDevisCarById(Short id);

}
