package com.biblio.api_rest.service.dto;

public class LivreDto {
    private String titre;
    private String genre;
    private Long auteurId;

    // Getters & setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Long getAuteurId() { return auteurId; }
    public void setAuteurId(Long auteurId) { this.auteurId = auteurId; }
}

