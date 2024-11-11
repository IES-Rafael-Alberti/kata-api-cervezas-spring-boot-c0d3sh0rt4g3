package org.example.apicerveza.repositories;

import org.example.apicerveza.entities.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeersRepository extends JpaRepository<Beers, Long> {
}
