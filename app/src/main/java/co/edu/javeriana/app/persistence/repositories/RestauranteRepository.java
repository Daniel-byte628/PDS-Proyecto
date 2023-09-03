package co.edu.javeriana.app.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.app.persistence.entities.RestauranteEntity;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
}
