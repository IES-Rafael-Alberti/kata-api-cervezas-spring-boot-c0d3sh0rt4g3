package org.example.apicerveza.repositories;

import org.example.apicerveza.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}
