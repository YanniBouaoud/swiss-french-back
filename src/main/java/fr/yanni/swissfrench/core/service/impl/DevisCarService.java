package fr.yanni.swissfrench.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.yanni.swissfrench.core.domain.DevisCar;
import fr.yanni.swissfrench.core.repository.IDevisCarRepository;
import fr.yanni.swissfrench.core.service.IDevisCarService;

@Service
@CrossOrigin
public class DevisCarService implements IDevisCarService {

	/**
	 * Autowired field for the DevisCar repository.
	 */
	@Autowired
	private IDevisCarRepository deviscarRepo;

	@Override
	public final DevisCar save(final DevisCar devisCar) {
		return deviscarRepo.saveAndFlush(devisCar);
	}

	@Override
	public final DevisCar getDevisCarById(final Short id) {
		Optional<DevisCar> optionalDevisCar = deviscarRepo.findById(id);
		return optionalDevisCar.orElse(null);
	}
}
