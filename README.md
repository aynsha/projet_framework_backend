
# Projet - Gestion simplifiée d'une bibliothèque

Ce projet est une application de gestion d’une bibliothèque simplifiée développée avec **Spring Boot**, **JPA**, **Swagger UI** et une base de données **PostgreSql**, gérer avec les entités de données  **livres** et les **auteurs**. 


## Objectifs

- Créer une API REST simple pour la gestion des livres et des auteurs.
- Implémenter les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer).
- Gérer la relation **ManyToOne** et **OneToMany** entre les livres et les auteurs.
- Tester les endpoints avec Postman.

---

## Technologies utilisées

- Java 17  
- Spring Boot  
- Spring Data JPA
- Lombok
- Swagger UI  
- PostgreSql 
- Maven  
- Postman  

---

## Modèle de données

- **Auteur** (id, nom, liste des livres)
- **Livre** (id, titre, genre, auteurId)

Relation :  
- Un auteur peut avoir plusieurs livres (**@OneToMany**),  
- Un livre appartient à un seul auteur (**@ManyToOne**).

---

## Structure du projet

```
src/
├── controller/
│   ├── LivreController.java
│   └── AuteurController.java
├── model/
│   ├── Livre.java
│   └── Auteur.java
├── repository/
│   ├── LivreRepository.java
│   └── AuteurRepository.java
├── service/
│   ├── dto
│      ├── LivreDto
│   ├── LivreService.java
│   └── AuteurService.java
└── ApiRestApplication.java
└── OpenApiConfig.java
```

---

## ⚙️ Configuration PostgreSql

```properties
# Configuration de la source de donnees
spring.datasource.url=jdbc:postgresql://localhost:5432/biblio_backend
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
server.port=8080
```

## Endpoints REST

### Livres

| Méthode | Endpoint                    | Action                           |
|--------|------------------------------|----------------------------------|
| GET    | api/livres                   | Lister tous les livres           |
| GET    | api/livres/auteur/{auteurId} | Obtenir un livre par l'Id auteur |
| POST   | api/livres                   | Créer un nouveau livre           |
| PUT    | api/livres/{id}              | Mettre à jour un livre           |
| DELETE | api/livres/{id}              | Supprimer un livre               |

### Auteurs

| Méthode| Endpoint          | Action                     |
|--------|-------------------|----------------------------|
| GET    | api/auteurs       | Lister tous les auteurs    |
| POST   | api/auteurs       | Créer un auteur            |

---

## Exemples JSON pour les tests

### Ajouter un auteur

```json
{
  "nom": "Victor Hugo"
}
```

### Ajouter un livre

```json
{
  "titre": "Les Misérables",
  "genre": "Roman",
  "auteurId": 1
  
}
```

---

## Lancer l’application

```bash
./mvnw spring-boot:run
```
Ou avec IntelliJ via le fichier `ApiRestApplication.java`.

---


## Réalisé par

Nom de l’étudiant(e) : **Aissatou FALL**  
Formation : Master 1 - MICDA 
INE: N02537520192
Évaluation : **Langages & Frameworks Backend 1**
