package fr.yanni.swissfrench.core.service;

import java.util.List;

import fr.yanni.swissfrench.core.domain.Appart;

public interface IAppartService {
	List<Appart> getAllApparts();

	Appart getAppartById(Short id);

	Appart save(Appart appart);
}
