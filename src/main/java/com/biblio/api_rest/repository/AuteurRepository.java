package com.biblio.api_rest.repository;



import com.biblio.api_rest.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}
