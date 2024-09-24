package fr.yanni.swissfrench.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yanni.swissfrench.core.domain.DevisCar;

@Repository

public interface IDevisCarRepository extends JpaRepository<DevisCar, Short> {

}
