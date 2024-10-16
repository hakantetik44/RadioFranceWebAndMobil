Feature: Categorie d`accessoire


  Scenario:  Accéder au Menu "Accessoire" sur AliExpress
    Given Je lance mon app
    Then Je vérifie que l'URL est correcte
    Then Utilisateur est sur la page acceuil
    When Utilisateur clique sur la catégorie "Immobilier"
    Then Utilisateur devrait être redirigé vers la page de "Ventes immobilières"
