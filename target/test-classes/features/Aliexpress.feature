Feature: AliExpress Basic Operations
  @test
  Scenario: Verify URL and Make a Phone Call
    Given Utilisateur est sur la page d'accueil d'AliExpress
    When Je vérifie que title est "AliExpress - le plus grand catalogue de choix d'achat en ligne pour l'électronique, mode, maison, déco, jouets, sport, auto... Attendez-vous à plus et faites des économies avec AliExpress. | AliExpress France"
    Then Utilisateur vérifie que l'URL est correcte
    When Je clique sur le bouton pour appeler le service client
    Then Je devrais voir l'écran d'appel téléphonique