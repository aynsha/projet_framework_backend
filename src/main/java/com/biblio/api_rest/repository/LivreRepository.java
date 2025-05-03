package com.biblio.api_rest.repository;

import com.biblio.api_rest.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByAuteurId(Long auteurId);
}
