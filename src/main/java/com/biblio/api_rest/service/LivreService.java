package com.biblio.api_rest.service;

import com.biblio.api_rest.model.Auteur;
import com.biblio.api_rest.model.Livre;
import com.biblio.api_rest.repository.AuteurRepository;
import com.biblio.api_rest.repository.LivreRepository;
import com.biblio.api_rest.service.dto.LivreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Autowired
    private AuteurRepository auteurRepository;
    public Livre createLivre(LivreDto dto) {
        Auteur auteur = auteurRepository.findById(dto.getAuteurId())
                .orElseThrow(() -> new RuntimeException("Auteur non trouvé"));

        Livre livre = new Livre();
        livre.setTitre(dto.getTitre());
        livre.setGenre(dto.getGenre());
        livre.setAuteur(auteur);

        return livreRepository.save(livre);
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public List<Livre> getLivresByAuteurId(Long auteurId) {
        return livreRepository.findByAuteurId(auteurId);
    }

    public Livre updateLivre(Long id, Livre updatedLivre) {
        return livreRepository.findById(id).map(existingLivre -> {
            // Retirer le livre de l'ancien auteur
            Auteur oldAuteur = existingLivre.getAuteur();
            if (oldAuteur != null) {
                oldAuteur.getLivres().remove(existingLivre);
            }
            // Mettre à jour les champs
            existingLivre.setTitre(updatedLivre.getTitre());
            existingLivre.setGenre(updatedLivre.getGenre());
            existingLivre.setAuteur(updatedLivre.getAuteur());

            // Ajouter le livre au nouvel auteur
            Auteur newAuteur = updatedLivre.getAuteur();
            if (newAuteur != null && !newAuteur.getLivres().contains(existingLivre)) {
                newAuteur.getLivres().add(existingLivre);
            }
            return livreRepository.save(existingLivre);
        }).orElse(null);
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}

