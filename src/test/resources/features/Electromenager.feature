
Feature: Categorie d'Électroménager

  Scenario: Aller ou categorie d'Électroménager
    Given Je suis sur la page d'acceuil d'AliExpress
    Then Je vérifie que l'URL est correcte
    Then Je suis sur la Toutes les Categories
    When Je clique sur la categorie "Électroménager"
    Then Je devrais être redirigé vers la page de la catégorie "Électroménager"


  Scenario: Ouvrir la page correspondante lorsque l'on clique sur un sous-titre de categorie selected
    Given Je suis sur la page d'acceuil d'AliExpress
    Then Je suis sur la Toutes les Categories
    And Je clique sur la categorie "Électroménager"
    And Je clique sur chaque groupe de produits et la page s'ouvre

  @web
  Scenario: Vérifier la présence de la livraison gratuite pour les produits
    Given Je suis sur la page d'acceuil d'AliExpress
    Then Je suis sur la Toutes les Categories
    And Je clique sur la categorie "Électroménager"
    When Je clique sur la Livraison gratuit
    Then Le produit devrait afficher la mention Livraison gratuite