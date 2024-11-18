package org.example.apicerveza.repositories;

import org.example.apicerveza.entities.Breweries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweriesRepository extends JpaRepository<Breweries, Long> {
}
