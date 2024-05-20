package fr.yanni.swissfrench.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.yanni.swissfrench.core.domain.DevisBati;
import fr.yanni.swissfrench.core.repository.IDevisBatiRepository;
import fr.yanni.swissfrench.core.service.IDevisBatiService;

@Service
@CrossOrigin
public class DevisBatiService implements IDevisBatiService {
	/**
	 * Autowired field for the DevisCar repository.
	 */
	@Autowired
	private IDevisBatiRepository devisbatiRepo;

	@Override
	public final DevisBati save(final DevisBati devisBati) {
		return devisbatiRepo.saveAndFlush(devisBati);
	}

	@Override
	public final DevisBati getDevisBatiById(final Short id) {
		Optional<DevisBati> optionalDevisBati = devisbatiRepo.findById(id);
		return optionalDevisBati.orElse(null);
	}
}
