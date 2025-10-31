# 📝 Changelog - Palindrome Verifier

Toutes les modifications notables de ce projet seront documentées dans ce fichier.

Le format est basé sur [Keep a Changelog](https://keepachangelog.com/fr/1.0.0/),
et ce projet adhère au [Semantic Versioning](https://semver.org/lang/fr/).

---

## [1.0.0] - 2025-10-31

### ✨ Ajouté
- **Fonctionnalité principale** : Vérification de palindromes avec `isPalindrome()`
- **Simplification de chaînes** : Méthode `simplifyString()` pour normaliser les entrées
- **Gestion de la casse** : Conversion automatique en minuscules
- **Ignorance des caractères spéciaux** : Suppression des espaces, ponctuation, etc.
- **Support alphanumérique** : Gestion des chiffres dans les palindromes
- **Validation des entrées** : Exception `IllegalArgumentException` pour les valeurs null
- **Gestion des cas limites** : Chaînes vides et un seul caractère

### 🧪 Tests
- **20+ tests unitaires** couvrant tous les cas d'usage
- **Tests paramétrés** avec `@ParameterizedTest` pour réduire la duplication
- **Tests de palindromes simples** : kayak, racecar, radar, level, madam, noon, civic
- **Tests de palindromes complexes** : phrases avec ponctuation et espaces
- **Tests de non-palindromes** : hello, world, java, programming, test
- **Tests de cas limites** : chaîne vide, un caractère, null
- **Tests de simplifyString** : validation de la normalisation
- **Couverture de code** : > 95% avec JaCoCo

### 📚 Documentation
- **README.md complet** : Guide TDD avec exemples pas à pas
- **JavaDoc** : Documentation de toutes les méthodes publiques
- **Exemples d'utilisation** : Cas pratiques dans Main.java
- **Cycle Red-Green-Refactor** : Explication détaillée
- **Bonnes pratiques TDD** : Liste des pratiques appliquées

### 🛠️ Configuration
- **Java 21** : Utilisation des fonctionnalités modernes
- **JUnit 5** : Framework de test moderne (version 5.13.4)
- **Maven** : Gestion de projet et dépendances
- **JaCoCo** : Plugin de couverture de code (80% minimum)
- **Plugins Maven** : Surefire, Compiler, Exec
- **.gitignore** : Configuration pour Git

### 💻 Interface utilisateur
- **Mode démonstration** : Exemples prédéfinis affichés au lancement
- **Mode interactif** : Permet à l'utilisateur de tester ses propres chaînes
- **Affichage formaté** : Utilisation d'émojis et de séparateurs visuels
- **Feedback clair** : Messages explicites pour palindromes et non-palindromes

### 🏗️ Architecture
- **Classe utilitaire** : `PalindromeVerifier` avec méthodes statiques
- **Constructeur privé** : Empêche l'instanciation de la classe utilitaire
- **Séparation des responsabilités** : Une méthode = Une responsabilité
- **Code propre** : Respect des principes SOLID et Clean Code

### ♻️ Refactoring
- **Extraction de méthodes** : `simplifyString()` séparée de `isPalindrome()`
- **Variables finales** : Utilisation de `final var` pour l'immutabilité
- **Nommage explicite** : Noms de méthodes et variables clairs
- **Commentaires javadoc** : Documentation du code public

---

## 📋 Types de changements

- **✨ Ajouté** : Nouvelles fonctionnalités
- **🔧 Modifié** : Changements dans les fonctionnalités existantes
- **❌ Déprécié** : Fonctionnalités bientôt supprimées
- **🗑️ Supprimé** : Fonctionnalités supprimées
- **🐛 Corrigé** : Corrections de bugs
- **🔒 Sécurité** : Corrections de vulnérabilités

---

## 🚀 À venir

### [1.1.0] - Prochaine version
- [ ] Support des caractères accentués (é, è, ê, à, etc.)
- [ ] API REST avec Spring Boot
- [ ] Performance améliorée pour les très longues chaînes
- [ ] Support Unicode complet
- [ ] Mode benchmark pour comparer les performances

### [1.2.0] - Futures améliorations
- [ ] Interface graphique avec JavaFX
- [ ] Internationalisation (i18n) - Support multilingue
- [ ] CI/CD avec GitHub Actions
- [ ] Publication sur Maven Central
- [ ] Documentation OpenAPI/Swagger

---

## 📊 Métriques du projet

- **Lignes de code** : ~200 (production) + ~250 (tests)
- **Couverture de tests** : > 95%
- **Nombre de tests** : 20+
- **Complexité cyclomatique** : Faible (< 5 par méthode)
- **Dette technique** : Aucune

---

## 🎯 Principes appliqués

1. **TDD (Test-Driven Development)** : Tests écrits avant le code
2. **KISS (Keep It Simple, Stupid)** : Code simple et compréhensible
3. **DRY (Don't Repeat Yourself)** : Pas de duplication de code
4. **YAGNI (You Aren't Gonna Need It)** : Pas de sur-ingénierie
5. **SOLID** : Principes de conception orientée objet
6. **Clean Code** : Code lisible et maintenable

---

**Légende des versions** : [MAJOR.MINOR.PATCH]
- **MAJOR** : Changements incompatibles avec les versions précédentes
- **MINOR** : Ajout de fonctionnalités rétrocompatibles
- **PATCH** : Corrections de bugs rétrocompatibles

