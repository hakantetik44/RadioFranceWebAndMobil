Feature: Categorie d`accessoire

  Background:
    Given Je suis sur la page d'acceuil d'AliExpress

  Scenario:  Accéder au Menu "Accessoire" sur AliExpress
    Then Je vérifie que l'URL est correcte
    Then Je suis sur la Toutes les Categories
    When Je clique sur la categorie "Accessoires"
    Then Je devrais être redirigé vers la page de la catégorie "Accessoires"