package com.biblio.api_rest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Auteur {

    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Livre> livres  = new ArrayList<>();

}
