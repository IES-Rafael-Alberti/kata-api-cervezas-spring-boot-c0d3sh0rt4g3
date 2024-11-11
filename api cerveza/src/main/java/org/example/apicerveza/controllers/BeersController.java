package org.example.apicerveza.controllers;

import org.example.apicerveza.entities.Beers;
import org.example.apicerveza.repositories.BeersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Asegúrate de importar esta clase
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class BeersController {
    private final BeersRepository beerRepository;
    @Autowired
    public BeersController(BeersRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public Page<Beers> getAllBeers(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    @GetMapping("/beer/id")
    public ResponseEntity<Beers> getBeersById(@PathVariable long id){
        return beerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<Beers> updateBeers(@PathVariable Long id, @RequestBody Beers updatedBeers) {
        return beerRepository.findById(id)
            .map(beer -> {
                beer.setBreweryId(updatedBeers.getBreweryId());
                beer.setName(updatedBeers.getName());
                beer.setCategoryId(updatedBeers.getCategoryId());
                beer.setStyleId(updatedBeers.getStyleId());
                beer.setAbv(updatedBeers.getAbv());
                beer.setIbu(updatedBeers.getIbu());
                beer.setSrm(updatedBeers.getSrm());
                beer.setUpc(updatedBeers.getUpc());
                beer.setFilepath(updatedBeers.getFilepath());
                beer.setDescription(updatedBeers.getDescription());
                beer.setAddUser(updatedBeers.getAddUser());
                beer.setLastModified(LocalDateTime.now());
                return ResponseEntity.ok(beerRepository.save(beer));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/beer/{id}")
    public ResponseEntity<Beers> createBeers(@RequestBody Beers beer){
        return ResponseEntity.ok(beerRepository.save(beer));
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<?> deleteBeersById(@PathVariable long id){
        return beerRepository.findById(id)
                .map(beer -> {
                    beerRepository.delete(beer);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
