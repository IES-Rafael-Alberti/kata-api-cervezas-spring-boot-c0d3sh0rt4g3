package org.example.apicerveza.controllers;

import org.example.apicerveza.entities.Beer;
import org.example.apicerveza.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Asegúrate de importar esta clase
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class BeerController {
    @Autowired
    private BeerRepository beerRepository;

    @GetMapping("/beers")
    public Page<Beer> getAllBeers(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    @GetMapping("/beer/id")
    public ResponseEntity<Beer> getBeerById(@PathVariable long id){
        return beerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable Long id, @RequestBody Beer updatedBeer) {
        return beerRepository.findById(id)
            .map(beer -> {
                beer.setBreweryId(updatedBeer.getBreweryId());
                beer.setName(updatedBeer.getName());
                beer.setCategoryId(updatedBeer.getCategoryId());
                beer.setStyleId(updatedBeer.getStyleId());
                beer.setAbv(updatedBeer.getAbv());
                beer.setIbu(updatedBeer.getIbu());
                beer.setSrm(updatedBeer.getSrm());
                beer.setUpc(updatedBeer.getUpc());
                beer.setFilepath(updatedBeer.getFilepath());
                beer.setDescription(updatedBeer.getDescription());
                beer.setAddUser(updatedBeer.getAddUser());
                beer.setLastModified(LocalDateTime.now());
                return ResponseEntity.ok(beerRepository.save(beer));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/beer/id")
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer){
        return ResponseEntity.ok(beerRepository.save(beer));
    }

    @DeleteMapping("/beer/id")
    public ResponseEntity deleteBeerById(@PathVariable long id){
        return beerRepository.findById(id)
                .map(beer -> {
                    beerRepository.delete(beer);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
