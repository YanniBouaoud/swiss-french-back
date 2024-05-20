package fr.yanni.swissfrench.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yanni.swissfrench.core.domain.DevisBati;

@Repository

public interface IDevisBatiRepository extends JpaRepository<DevisBati, Short> {

}
