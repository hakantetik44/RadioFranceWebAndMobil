
Feature: Tester la catégorie Chaussures sur Aliexpress
@TEST
  Scenario: Sélectionner Mocassins depuis la catégorie Chaussures
    Given L'utilisateur visualise et vérifie la page daccueil Aliexpress
    When Je vérifie que title est "AliExpress - le plus grand catalogue de choix d'achat en ligne pour l'électronique, mode, maison, déco, jouets, sport, auto... Attendez-vous à plus et faites des économies avec AliExpress. | AliExpress France"
    Then L'utilisateur accède à longlet "Catégories"
    And L'utilisateur clique sur la catégorie "Chaussures"
    #And L'utilisateur ferme le popup "Rechercher par photo"
    And L'utilisateur sélectionne la sous-catégorie "Mocassins"
    #Then L'utilisateur visualise les produits "Mocassins"

Feature: AliExpress Basic Operations
  @test
  Scenario: Verify URL and Make a Phone Call
    Given Utilisateur est sur la page d'accueil d'AliExpress
    When Je vérifie que title est "AliExpress - le plus grand catalogue de choix d'achat en ligne pour l'électronique, mode, maison, déco, jouets, sport, auto... Attendez-vous à plus et faites des économies avec AliExpress. | AliExpress France"
    Then Utilisateur vérifie que l'URL est correcte
    When Je clique sur le bouton pour appeler le service client
    Then Je devrais voir l'écran d'appel téléphonique

