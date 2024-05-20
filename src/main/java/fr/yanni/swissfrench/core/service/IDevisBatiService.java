package fr.yanni.swissfrench.core.service;

import fr.yanni.swissfrench.core.domain.DevisBati;

public interface IDevisBatiService {
	DevisBati getDevisBatiById(Short id);

	DevisBati save(DevisBati devisBati);
}
