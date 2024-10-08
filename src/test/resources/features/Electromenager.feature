
Feature: Categorie d'Électroménager

  Background:
    Given Utilisateur est sur la page d'accueil d'AliExpress
    Then Utilisateur vérifie que l'URL est correcte
    Then Utilisateur est sur la page Toutes les Catégories
    When Utilisateur clique sur la catégorie "Électroménager"

  Scenario: Aller à la catégorie d'Électroménager
    Then Utilisateur devrait être redirigé vers la page de la catégorie "Électroménager"

  Scenario: Ouvrir la page correspondante lorsque l'on clique sur un sous-titre de catégorie sélectionnée
    And Utilisateur clique sur chaque groupe de produits et la page s'ouvre

  Scenario: Vérifier la présence de la livraison gratuite pour les produits
    When Utilisateur clique sur la Livraison gratuite
    Then Les produits devrait afficher la mention Livraison gratuite

  Scenario: Utilisateur trie les produits de la sous-catégorie par prix croissant et décroissant
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur sélectionne le tri par "Prix croissant"
    Then Les produits devraient être triés par prix du plus bas au plus élevé
    And Utilisateur vérifie que le tri est correct pour "croissant"
    When Utilisateur sélectionne le tri par "Prix décroissant"
    Then Les produits devraient être triés par prix du plus élevé au plus bas
    And Utilisateur vérifie que le tri est correct pour "décroissant"

  Scenario: Filtrer les produits par prix en utilisant les champs min et max
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur saisis un prix minimum de "50" et un prix maximum de "100"
    And  valide les filtres de prix
    Then Les produits doivent être affichés dans la fourchette de prix spécifiée
    And Utilisateur vérifie que tous les produits affichés ont un prix compris entre "50" et "100"

  Scenario: Affichage d'un avertissement lorsque des caractères non numériques sont saisis dans les champs min et max
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur saisis un prix minimum de "abc" et un prix maximum de "xyz"
    And  valide les filtres de prix
    Then Un message d'avertissement devrait être affiché

  Scenario: Sélectionner un pays et vérifier l'affichage du produit
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur sélectionne le pays "France"
    And Utilisateur clique sur un produit aléatoire
    Then La page du produit doit afficher expédié depuis "France"

  Scenario: Vérifier l'ordre des produits selon les ventes
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur clique sur la Commandes
    Then Les produits devrait afficher de plus vendus à moins vendus

  Scenario: Utilisateur sélectionne une promotion et voit les produits en promotion
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur clique sur la Promo
    Then Réductions Promo affiche
    And Chaque produit devrait afficher au moins une étiquette 'Promo' ou 'Offre de bienvenue' ou 'Choice'

  Scenario: L'utilisateur peut visualiser les produits en mode galerie
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur clique sur l'option "Galerie"
    Then Les produits doivent être affichés en mode "Galerie"
@web
  Scenario: L'utilisateur peut visualiser les produits en mode liste
    Given Utilisateur est sur la page d'une sous-catégorie sélectionnée
    When Utilisateur clique sur l'option "List"
    Then Les produits doivent être affichés en mode "List"
