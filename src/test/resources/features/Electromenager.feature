
Feature: Categorie d'Électroménager

  Background:
    Given Utilisateur est sur la page d'accueil d'AliExpress
    Then Utilisateur vérifie que l'URL est correcte
    Then Utilisateur est sur la page Toutes les Catégories
    When Utilisateur clique sur la catégorie "Maison, jardin"

  Scenario: Aller à la catégorie d'Électroménager
    Then Utilisateur devrait être redirigé vers la page de la catégorie "Électroménager"

  Scenario: Ouvrir la page correspondante lorsque l'on clique sur un sous-titre de catégorie sélectionnée
    And Utilisateur clique sur chaque groupe de produits et la page s'ouvre

  Scenario: Vérifier la présence de la livraison gratuite pour les produits
    When Utilisateur clique sur la Livraison gratuite
    Then Le produit devrait afficher la mention Livraison gratuite
  @web
  Scenario: Utilisateur trie les produits de la sous-catégorie par prix croissant et décroissant
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur sélectionne le tri par "Prix croissant"
    Then Les produits devraient être triés par prix du plus bas au plus élevé
    And Utilisateur vérifie que le tri est correct pour "croissant"
    When Utilisateur sélectionne le tri par "Prix décroissant"
    Then Les produits devraient être triés par prix du plus élevé au plus bas
    And Utilisateur vérifie que le tri est correct pour "décroissant"

 Scenario: