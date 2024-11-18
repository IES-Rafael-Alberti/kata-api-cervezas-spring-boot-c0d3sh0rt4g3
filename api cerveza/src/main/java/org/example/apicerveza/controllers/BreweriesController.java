package org.example.apicerveza.controllers;

import org.example.apicerveza.entities.Breweries;
import org.example.apicerveza.repositories.BreweriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BreweriesController {
    private final BreweriesRepository breweriesRepository;
    @Autowired
    public BreweriesController(BreweriesRepository breweriesRepository) {this.breweriesRepository = breweriesRepository;}

    @GetMapping("/breweries")
    public Page<Breweries> getAllBreweries(Pageable pageable) {return breweriesRepository.findAll(pageable);}

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<Breweries> getBreweriesById(@PathVariable Long id) {
        return breweriesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
