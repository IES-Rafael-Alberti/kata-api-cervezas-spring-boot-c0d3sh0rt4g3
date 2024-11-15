package org.example.apicerveza.controllers;

import org.example.apicerveza.entities.Styles;
import org.example.apicerveza.repositories.StylesRepository;
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
public class StylesController {
    private final StylesRepository stylesRepository;
    @Autowired
    public StylesController(StylesRepository stylesRepository) {this.stylesRepository = stylesRepository;}

    @GetMapping("/styles")
    public Page<Styles> getAllStyles(Pageable pageable) {return stylesRepository.findAll(pageable);}

    @GetMapping("/style/{id}")
    public ResponseEntity<Styles> getStylesById(@PathVariable Long id) {
        return stylesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

