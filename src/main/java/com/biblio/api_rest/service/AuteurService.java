package com.biblio.api_rest.service;

import com.biblio.api_rest.model.Auteur;
import com.biblio.api_rest.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {

    private final AuteurRepository auteurRepository;

    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public Auteur createAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    public Auteur getAuteurById(Long id) {
        return auteurRepository.findById(id).orElse(null);
    }
}
