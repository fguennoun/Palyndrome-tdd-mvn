# 🤝 Guide de Contribution

Merci de votre intérêt pour contribuer au projet Palindrome Verifier ! Ce guide vous aidera à contribuer efficacement.

---

## 📋 Table des matières

1. [Code de conduite](#-code-de-conduite)
2. [Comment contribuer](#-comment-contribuer)
3. [Processus TDD](#-processus-tdd)
4. [Standards de code](#-standards-de-code)
5. [Tests](#-tests)
6. [Documentation](#-documentation)
7. [Commits](#-commits)

---

## 🤝 Code de conduite

- Soyez respectueux et constructif
- Accueillez les nouveaux contributeurs
- Concentrez-vous sur le code, pas sur les personnes
- Privilégiez la collaboration

---

## 💡 Comment contribuer

### 1. Fork et Clone

```bash
# Fork le projet sur GitHub, puis :
git clone https://github.com/votre-username/Palyndrome-tdd-mvn.git
cd Palyndrome-tdd-mvn
```

### 2. Créer une branche

```bash
git checkout -b feature/ma-nouvelle-fonctionnalite
```

### 3. Faire vos modifications

Suivez le processus TDD (voir section suivante)

### 4. Tester

```bash
mvn clean test
```

### 5. Committer

```bash
git add .
git commit -m "feat: description de la fonctionnalité"
```

### 6. Push et Pull Request

```bash
git push origin feature/ma-nouvelle-fonctionnalite
```

Créez ensuite une Pull Request sur GitHub.

---

## 🔄 Processus TDD

**IMPORTANT** : Ce projet suit strictement le TDD. Toute contribution DOIT suivre le cycle Red-Green-Refactor.

### Étape 1 : 🔴 RED - Écrire un test qui échoue

```java
@Test
void nouvelleFeature_casNominal_comportementAttendu() {
    // given
    String input = "test";
    
    // when
    String result = PalindromeVerifier.nouvelleMethode(input);
    
    // then
    assertEquals("expected", result);
}
```

✅ Vérifiez que le test échoue :
```bash
mvn test
```

### Étape 2 : 🟢 GREEN - Faire passer le test

Écrivez le code minimal pour faire passer le test :

```java
public static String nouvelleMethode(String input) {
    return "expected"; // Implémentation minimale
}
```

✅ Vérifiez que le test passe :
```bash
mvn test
```

### Étape 3 : ♻️ REFACTOR - Améliorer le code

- Éliminez les duplications
- Améliorez la lisibilité
- Optimisez si nécessaire

✅ Vérifiez que tous les tests passent toujours :
```bash
mvn test
```

---

## 📝 Standards de code

### Conventions de nommage

```java
// Classes : PascalCase
public class PalindromeVerifier { }

// Méthodes : camelCase avec nom descriptif
public static boolean isPalindrome(String str) { }

// Tests : methodName_scenario_expectedResult
@Test
void isPalindrome_SimplePalindrome_true() { }

// Variables : camelCase
String simplifiedString = "abc";

// Constantes : UPPER_SNAKE_CASE
private static final String SEPARATOR = "=".repeat(60);
```

### Structure des méthodes

```java
/**
 * Description de la méthode.
 *
 * @param parametre description du paramètre
 * @return description de la valeur de retour
 * @throws ExceptionType description de quand l'exception est levée
 */
public static ReturnType methodName(ParamType parametre) {
    // Validation des entrées
    if (parametre == null) {
        throw new IllegalArgumentException("Message explicite");
    }
    
    // Logique métier
    final var result = processData(parametre);
    
    // Retour
    return result;
}
```

### Bonnes pratiques

✅ **À FAIRE** :
- Utiliser `final var` pour les variables locales
- Documenter toutes les méthodes publiques avec JavaDoc
- Valider les paramètres (null, vide, etc.)
- Utiliser des noms explicites
- Garder les méthodes courtes (< 20 lignes)
- Une méthode = Une responsabilité

❌ **À ÉVITER** :
- Méthodes trop longues (> 50 lignes)
- Variables avec des noms cryptiques (a, b, tmp)
- Code commenté (supprimez-le)
- Magic numbers (utilisez des constantes)
- Duplication de code

---

## 🧪 Tests

### Convention de nommage des tests

```
methodName_scenario_expectedResult
```

Exemples :
- `isPalindrome_SimplePalindrome_true`
- `isPalindrome_NullString_throwsException`
- `simplifyString_WithSpaces_removesSpaces`

### Structure Given-When-Then

```java
@Test
void exampleTest() {
    // given - Préparer les données
    String input = "test";
    
    // when - Exécuter l'action
    boolean result = PalindromeVerifier.isPalindrome(input);
    
    // then - Vérifier le résultat
    assertFalse(result);
}
```

### Couverture de code

La couverture minimale est de **80%**. Vérifiez avec :

```bash
mvn clean test jacoco:report
```

Le rapport sera dans `target/site/jacoco/index.html`

### Types de tests à inclure

Pour chaque nouvelle fonctionnalité, ajoutez :

1. **Tests positifs** : Cas où tout fonctionne
2. **Tests négatifs** : Cas d'erreur
3. **Tests limites** : Valeurs min/max, vide, null
4. **Tests paramétrés** : Plusieurs cas similaires

```java
@ParameterizedTest
@ValueSource(strings = {"kayak", "racecar", "radar"})
void testMultipleCases(String palindrome) {
    assertTrue(PalindromeVerifier.isPalindrome(palindrome));
}
```

---

## 📚 Documentation

### JavaDoc

Toutes les méthodes publiques doivent avoir une JavaDoc :

```java
/**
 * Courte description (une ligne).
 * 
 * Description détaillée si nécessaire.
 * Peut s'étendre sur plusieurs lignes.
 *
 * @param str la chaîne à analyser, ne peut pas être null
 * @return true si palindrome, false sinon
 * @throws IllegalArgumentException si str est null
 */
public static boolean isPalindrome(String str) {
    // ...
}
```

### Commentaires

```java
// ✅ BON : Commentaire expliquant le POURQUOI
// Utilise StringBuilder.reverse() pour des raisons de performance
String reversed = new StringBuilder(str).reverse().toString();

// ❌ MAUVAIS : Commentaire expliquant le QUOI (évident)
// Inverse la chaîne
String reversed = new StringBuilder(str).reverse().toString();
```

### README et CHANGELOG

- Mettez à jour `README.md` si vous ajoutez une fonctionnalité majeure
- Ajoutez une entrée dans `CHANGELOG.md` pour chaque modification

---

## 🔖 Commits

### Format des messages de commit

Suivez la convention [Conventional Commits](https://www.conventionalcommits.org/) :

```
<type>(<scope>): <description>

[corps optionnel]

[footer optionnel]
```

### Types de commits

- `feat`: Nouvelle fonctionnalité
- `fix`: Correction de bug
- `docs`: Documentation uniquement
- `style`: Formatage (pas de changement de code)
- `refactor`: Refactoring (pas de nouvelle fonctionnalité ni de fix)
- `test`: Ajout ou modification de tests
- `chore`: Tâches de maintenance (build, config, etc.)

### Exemples

```bash
# Nouvelle fonctionnalité
git commit -m "feat: ajouter support des caractères accentués"

# Correction de bug
git commit -m "fix: corriger NullPointerException pour chaînes vides"

# Documentation
git commit -m "docs: améliorer le README avec exemples"

# Refactoring
git commit -m "refactor: extraire la logique de validation dans une méthode"

# Tests
git commit -m "test: ajouter tests pour cas limites"
```

---

## 🔍 Checklist avant Pull Request

Avant de soumettre votre PR, vérifiez :

- [ ] J'ai suivi le processus TDD (Red-Green-Refactor)
- [ ] Tous les tests passent (`mvn test`)
- [ ] J'ai ajouté des tests pour ma fonctionnalité
- [ ] La couverture de code est >= 80%
- [ ] J'ai documenté les méthodes publiques avec JavaDoc
- [ ] Mon code respecte les conventions de nommage
- [ ] J'ai mis à jour `CHANGELOG.md`
- [ ] Mes commits suivent la convention Conventional Commits
- [ ] Pas de warning de compilation
- [ ] Le code est formaté correctement

```bash
# Vérification complète
mvn clean test jacoco:report
```

---

## 🎯 Idées de contributions

Vous ne savez pas par où commencer ? Voici des idées :

### Facile (débutants) 🟢
- Ajouter plus de tests
- Améliorer la documentation
- Corriger des typos
- Ajouter des exemples

### Moyen (intermédiaire) 🟡
- Support des caractères accentués
- Optimisation des performances
- Internationalisation (i18n)
- Meilleure gestion des erreurs

### Difficile (avancé) 🔴
- API REST avec Spring Boot
- Interface graphique JavaFX
- CI/CD avec GitHub Actions
- Benchmarking et profiling

---

## 📬 Contact

Pour toute question :

- Ouvrez une [Issue](https://github.com/username/repo/issues)
- Commentez sur une Pull Request existante
- Consultez la documentation du projet

---

## 📄 Licence

En contribuant, vous acceptez que vos contributions soient sous la même licence que le projet.

---

## 🙏 Remerciements

Merci à tous les contributeurs qui font avancer ce projet ! 

Chaque contribution, petite ou grande, est précieuse. 🌟

---

**Bon coding avec TDD ! 🚀**

