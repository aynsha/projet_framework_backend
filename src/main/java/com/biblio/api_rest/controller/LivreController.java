package com.biblio.api_rest.controller;

import com.biblio.api_rest.service.dto.LivreDto;
import com.biblio.api_rest.model.Livre;
import com.biblio.api_rest.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping
    public ResponseEntity<Livre> createLivre(@Valid @RequestBody LivreDto livreDto) {
        Livre livre = livreService.createLivre(livreDto);
        return new ResponseEntity<>(livre, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/auteur/{auteurId}")
    public List<Livre> getLivresByAuteur(@PathVariable Long auteurId) {
        return livreService.getLivresByAuteurId(auteurId);
    }

    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable Long id, @Valid @RequestBody Livre livre) {
        return livreService.updateLivre(id, livre);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }
}
