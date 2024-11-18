package org.example.apicerveza.controllers;

import org.example.apicerveza.entities.Categories;
import org.example.apicerveza.repositories.CategoriesRepository;
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
public class CategoriesController {
    private final CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesController(CategoriesRepository categoriesRepository) {this.categoriesRepository = categoriesRepository;}

    @GetMapping("/categories")
    public Page<Categories> getAllCategories(Pageable pageable) {return categoriesRepository.findAll(pageable);}

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable Long id) {
        return categoriesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

