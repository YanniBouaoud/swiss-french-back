package fr.yanni.swissfrench.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.yanni.swissfrench.core.domain.Appart;
import fr.yanni.swissfrench.core.repository.IAppartRepository;
import fr.yanni.swissfrench.core.service.IAppartService;

@Service
@CrossOrigin
public class AppartService implements IAppartService {
	/** repository for the Appart. */
	@Autowired
	private IAppartRepository appartRepo;

	@Override
	public List<Appart> getAllApparts() {
		return appartRepo.findAll();
	}

	@Override
	public final Appart save(final Appart appart) {
		return appartRepo.saveAndFlush(appart);
	}

	@Override
	public final Appart getAppartById(final Short id) {
		Optional<Appart> optionalAppart = appartRepo.findById(id);
		return optionalAppart.orElse(null);
	}
}
