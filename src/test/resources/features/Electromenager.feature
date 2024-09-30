Feature: Categorie d'Électroménager

  Background:
    Given Je suis sur la page d'acceuil d'AliExpress
    Then Je vérifie que l'URL est correcte
    Then Je suis sur la Toutes les Categories
    When Je clique sur la categorie "Électroménager"

  Scenario: Aller ou categorie d'Électroménager
    Then Je devrais être redirigé vers la page de la catégorie "Électroménager"

  Scenario: Ouvrir la page correspondante lorsque l'on clique sur un sous-titre de categorie selected
    And Je clique sur chaque groupe de produits et la page s'ouvre

  Scenario: Vérifier la présence de la livraison gratuite pour les produits
    When Je clique sur la Livraison gratuit
    Then Le produit devrait afficher la mention Livraison gratuite

  @web
  Scenario: Je trie les produits de la sous-catégorie par prix croissant et décroissant
    Given Je suis sur la page d'une sous-catégorie sélectionnée
    When Je sélectionne le tri par "Prix croissant"
    Then Les produits devraient être triés par prix du plus bas au plus élevé
    And Je vérifie que le tri est correct pour "croissant"
    When Je sélectionne le tri par "Prix décroissant"
    Then Les produits devraient être triés par prix du plus élevé au plus bas
    And Je vérifie que le tri est correct pour "décroissant"