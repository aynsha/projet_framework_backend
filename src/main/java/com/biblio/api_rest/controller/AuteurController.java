package com.biblio.api_rest.controller;


import com.biblio.api_rest.model.Auteur;
import com.biblio.api_rest.service.AuteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {

    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @PostMapping
    public Auteur createAuteur(@Valid @RequestBody Auteur auteur) {
        return auteurService.createAuteur(auteur);
    }

    @GetMapping
    public List<Auteur> getAllAuteurs() {
        return auteurService.getAllAuteurs();
    }
}

