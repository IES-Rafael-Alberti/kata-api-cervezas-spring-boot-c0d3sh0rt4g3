package org.example.apicerveza.repositories;

import org.example.apicerveza.entities.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
