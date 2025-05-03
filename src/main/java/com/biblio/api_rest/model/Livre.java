package com.biblio.api_rest.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@Entity
public class Livre {

    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    @NotBlank(message = "Le genre est obligatoire")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    @JsonBackReference
    @NotNull(message = "L'auteur est obligatoire")
    private Auteur auteur;

}
