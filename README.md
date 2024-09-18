# AliexpressAndroidWebProjesi


## Premiers pas avec le projet

### 1. Présentation du projet:

Ce projet est un projet de test mobile qui vise à développer des tests pour les plateformes Android/iOS et ce projet est une configuration pour les tests d'automatisation end-to-end (E2E) utilisant Appium, Cucumber et Selenium.

### 2. Technologies utilisées:

* Langage de programmation: Java
* Outil de build: Maven
* Cadre de test mobile: Appium
* Langage BDD: Gherkin (Cucumber)
* Kit de développement Java (JDK): 8
* Page Object Modèle
* Outil de reporting: Masterthought

  
### 3. Avantages du projet:

* Code compréhensible: L'utilisation du modèle Page Object rend le code plus organisé et plus compréhensible.
* Prise en charge de différentes plates-formes: Des tests peuvent être développés pour les plates-formes Android et iOS.
* Maintenance facile: Les scénarios de test écrits en langage Gherkin peuvent être facilement mis à jour.
* Rapports détaillés: Des rapports détaillés des résultats des tests peuvent être générés à l'aide de l'outil de reporting Masterthought.

**DRIVER CLASS** Ce fichier contient une classe Java nommée "Driver" qui sert à initialiser et à gérer le pilote Appium pour les tests automatisés sur les plates-formes Android et iOS. Il utilise les paramètres spécifiés dans le fichier de configuration (ConfigReader) pour déterminer la plate-forme cible et initialiser le pilote correspondant.

**HOOKS CLASS** La classe "Hooks" contient des méthodes annotées Before et After qui sont exécutées avant et après chaque scénario de test. Avant chaque scénario, la méthode setUpMobile() est appelée pour configurer l'environnement de test, tandis qu'après chaque scénario, la méthode tearDownMobile() est appelée pour nettoyer les ressources utilisées pendant le test. Ces méthodes sont utilisées pour garantir un environnement de test cohérent et reproductible.

**BASEPAGE CLASS** Cette classe "BasePage" fournit des méthodes utilitaires pour effectuer des actions courantes sur les pages de l'application mobile, telles que le défilement, le clic, la saisie de texte, etc. Elle contient également des méthodes pour générer des données aléatoires telles que des noms, des numéros de téléphone et des adresses, ainsi que des méthodes pour la manipulation des dates. Ces méthodes sont utilisées pour simplifier l'écriture des tests automatisés et garantir leur fiabilité.

**POM.XML (AliexpressAndroidWebProjesi)**
Ce fichier POM (Project Object Model) est utilisé avec Apache Maven pour gérer les dépendances et la configuration du projet. Il définit le groupe d'artefacts, l'identifiant d'artefact et la version du projet. De plus, il spécifie les versions des dépendances telles que Selenium, Cucumber et Appium, nécessaires pour l'exécution des tests. Les plugins Maven sont également configurés ici pour l'exécution des tests et la génération de rapports.# e2e_AkAk-e
