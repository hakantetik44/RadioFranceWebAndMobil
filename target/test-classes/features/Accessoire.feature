Feature: Categorie d`accessoire


  Scenario:  Accéder au Menu "Accessoire" sur AliExpress
    Then Je vérifie que l'URL est correcte
    Then Utilisateur est sur la page Toutes les Catégories
    When Utilisateur clique sur la catégorie "Accessoires"
    Then Utilisateur devrait être redirigé vers la page de la catégorie "Accessoires"
