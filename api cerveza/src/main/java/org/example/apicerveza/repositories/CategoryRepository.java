package org.example.apicerveza.repositories;

import org.example.apicerveza.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
