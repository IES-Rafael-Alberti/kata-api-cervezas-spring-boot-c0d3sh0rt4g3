package org.example.apicerveza.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Beers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Integer breweryId;
    private String name;
    private Integer categoryId;
    private Integer styleId;
    private Float abv;
    private Float ibu;
    private Float srm;
    private Long upc;
    private String filepath;
    private String descript;
    private Integer addUser;
    private LocalDateTime lastModified;
}

