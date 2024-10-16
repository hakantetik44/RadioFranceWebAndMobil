Feature: Recherche dans l'application Radio France

  Scenario: Rechercher "histoire" sur Radio France
    Given Je lance mon app
    Then Je vérifie que je suis sur la page d'accueil
    When Je clique sur le bouton "Rechercher"
    And Je saisis "histoire" dans le champ de recherche
    Then Je devrais voir les résultats de recherche pour "histoire"