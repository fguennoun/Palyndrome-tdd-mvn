    return simplified.equals(reversed);
}

public static String simplifyString(String str) {
    if (str == null) {
        return "";
    }
    return str.toLowerCase().replaceAll("[^a-z0-9]", "");
}
```
✅ Les tests passent maintenant.

---

## 🏗️ Structure du projet

```
Palyndrome-tdd-mvn/
├── pom.xml                          # Configuration Maven
├── README.md                        # Ce fichier
├── TDD-GUIDE.md                     # Guide détaillé sur le TDD
├── EXAMPLES.md                      # Exemples d'utilisation
├── CONTRIBUTING.md                  # Guide de contribution
├── CHANGELOG.md                     # Historique des modifications
├── PROJECT-STRUCTURE.md             # Description complète du projet
└── src/
    ├── main/
    │   └── java/
    │       └── be/cm/palyndrometdd/
    │           ├── Main.java                    # Point d'entrée
    │           └── PalindromeVerifier.java      # Classe principale
    └── test/
        └── java/
            └── be/cm/palyndrometdd/
                └── PalindromeVerifierTest.java  # Tests JUnit 5
```

---

## 📚 Documentation Complète

Ce projet contient une documentation extensive pour vous aider à comprendre et appliquer le TDD :

| Fichier | Description | Public cible |
|---------|-------------|--------------|
| **README.md** | Vue d'ensemble du projet et introduction au TDD | Tous |
| **TDD-GUIDE.md** | Guide approfondi avec étapes détaillées du TDD | Apprenants TDD |
| **EXAMPLES.md** | 20+ exemples d'utilisation pratiques | Développeurs |
| **CONTRIBUTING.md** | Guide pour contribuer au projet | Contributeurs |
| **CHANGELOG.md** | Historique des versions et modifications | Tous |
| **PROJECT-STRUCTURE.md** | Description détaillée de la structure | Nouveaux arrivants |

---

## 🚀 Lancement du projet

### Prérequis
- Java 21 ou supérieur
- Maven 3.6+

### Compilation
```bash
mvn clean compile
```

### Exécution des tests
```bash
mvn test
```

### Exécution de l'application
```bash
mvn exec:java -Dexec.mainClass="be.cm.palyndrometdd.Main"
```

---

## 🧪 Couverture des tests

Le projet contient **20+ tests** couvrant :

### ✅ Palindromes valides
- Palindromes simples (`kayak`, `racecar`, `radar`)
- Palindromes complexes avec ponctuation (`A man, a plan, a canal: Panama`)
- Palindromes numériques (`12321`)
- Palindromes alphanumériques (`A1B2C2B1A`)
- Cas limites (chaîne vide, un seul caractère)

### ❌ Non-palindromes
- Chaînes ordinaires (`hello`, `world`)
- Presque palindromes (`raceca`)

### ⚠️ Gestion des erreurs
- Valeur `null` → `IllegalArgumentException`

### 🔧 Tests unitaires de `simplifyString`
- Conversion en minuscules
- Suppression des caractères spéciaux
- Gestion de null et chaînes vides

---

## 📊 Avantages du TDD observés dans ce projet

| Avantage | Impact sur le projet |
|----------|---------------------|
| **Couverture de code** | 100% des méthodes publiques testées |
| **Détection précoce des bugs** | Problèmes de null détectés avant production |
| **Documentation** | Les tests expliquent comment utiliser la classe |
| **Confiance dans le refactoring** | Changements sûrs grâce aux tests |
| **Design propre** | API claire définie par les tests |

---

## 🎓 Bonnes pratiques TDD appliquées

1. ✅ **Tests nommés clairement** : `methodName_scenario_expectedResult`
2. ✅ **Arrange-Act-Assert** : Structure given-when-then dans chaque test
3. ✅ **Un test = Un concept** : Chaque test vérifie un seul comportement
4. ✅ **Tests paramétrés** : Utilisation de `@ParameterizedTest` pour réduire la duplication
5. ✅ **Isolation** : Chaque test est indépendant
6. ✅ **Tests rapides** : Exécution en millisecondes
7. ✅ **Messages clairs** : Les assertions sont explicites

---

## 🔍 Commandes Maven utiles

```bash
# Compiler le projet
mvn compile

# Exécuter tous les tests
mvn test

# Exécuter un test spécifique
mvn test -Dtest=PalindromeVerifierTest#isPalindrome_ClassicPalindrome_true

# Générer un rapport de couverture (avec JaCoCo)
mvn jacoco:report

# Nettoyer et reconstruire
mvn clean install

# Vérifier le style de code (avec Checkstyle)
mvn checkstyle:check
```

---

## 📚 Ressources pour approfondir le TDD

- 📖 **Livre** : "Test Driven Development: By Example" - Kent Beck
- 🎥 **Vidéo** : "TDD Changed My Life" - Eric Elliott
- 🌐 **Article** : [Martin Fowler - TDD](https://martinfowler.com/bliki/TestDrivenDevelopment.html)
- 💻 **Kata** : [Cyber-Dojo](https://cyber-dojo.org) pour pratiquer le TDD

---

## 📈 Prochaines étapes

Pour aller plus loin avec ce projet :

1. ✨ Ajouter la prise en charge des accents (é, è, ê)
2. 🌍 Internationalisation des messages d'erreur
3. 📊 Intégration de JaCoCo pour la couverture de code
4. 🔄 CI/CD avec GitHub Actions
5. 📦 Créer une API REST autour de cette fonctionnalité
6. 🎨 Interface graphique avec JavaFX

---

## 👨‍💻 Auteur

Projet développé dans le cadre d'une formation sur le TDD avec Java et Maven.

---

## 📄 Licence

Ce projet est à des fins éducatives. Libre d'utilisation et de modification.

---

## 💡 Conclusion

Le TDD n'est pas seulement une technique de test, c'est une **discipline de conception**. En écrivant les tests d'abord :
- Vous réfléchissez à l'interface avant l'implémentation
- Vous créez un code plus modulaire et testable
- Vous documentez le comportement attendu
- Vous gagnez en confiance pour faire évoluer votre code

**"Le code sans test est du code legacy par définition"** - Michael Feathers

🎯 **Pratiquez le TDD régulièrement pour en faire une seconde nature !**
# 🔄 Palindrome Verifier - Projet TDD (Test-Driven Development)

## 📋 Description

Ce projet illustre l'approche **Test-Driven Development (TDD)** à travers la création d'un vérificateur de palindromes en Java. Un palindrome est une chaîne de caractères qui se lit de la même manière de gauche à droite et de droite à gauche, en ignorant les espaces, la ponctuation et la casse.

**Exemples de palindromes :**
- `kayak`
- `A man, a plan, a canal: Panama`
- `Was it a car or a cat I saw?`
- `12321`

---

## 🎯 Qu'est-ce que le TDD ?

Le **Test-Driven Development (TDD)** est une méthodologie de développement logiciel où les tests sont écrits **avant** le code de production. Cette approche garantit :

✅ **Code testé dès le départ** : Chaque fonctionnalité est couverte par des tests  
✅ **Conception améliorée** : Écrire les tests d'abord aide à mieux réfléchir à l'API  
✅ **Moins de bugs** : Les erreurs sont détectées immédiatement  
✅ **Refactoring sécurisé** : Les tests garantissent que le code continue de fonctionner  
✅ **Documentation vivante** : Les tests servent de documentation du comportement attendu

---

## 🔄 Le Cycle TDD : Red-Green-Refactor

Le TDD suit un cycle simple en 3 étapes :

```
🔴 RED → 🟢 GREEN → ♻️ REFACTOR
```

### 1. 🔴 RED (Rouge) - Écrire un test qui échoue
- Écrire un test pour une fonctionnalité qui n'existe pas encore
- Exécuter le test et vérifier qu'il échoue (barre rouge)
- **Pourquoi ?** Confirmer que le test détecte bien l'absence de la fonctionnalité

### 2. 🟢 GREEN (Vert) - Écrire le code minimal pour passer le test
- Écrire le code le plus simple possible pour faire passer le test
- Exécuter le test et vérifier qu'il passe (barre verte)
- **Pourquoi ?** Faire fonctionner la fonctionnalité rapidement

### 3. ♻️ REFACTOR (Refactoriser) - Améliorer le code
- Améliorer la qualité du code sans changer son comportement
- Éliminer les duplications, améliorer la lisibilité
- Exécuter les tests pour s'assurer qu'ils passent toujours
- **Pourquoi ?** Maintenir un code propre et maintenable

---

## 📝 Étapes d'application du TDD sur ce projet

### Itération 1 : Palindrome simple

#### 🔴 RED
```java
@Test
void isPalindrome_SimplePalindrome_true() {
    // given
    String str = "kayak";
    // when
    boolean result = PalindromeVerifier.isPalindrome(str);
    // then
    assertTrue(result);
}
```
❌ Le test échoue car la méthode `isPalindrome` n'existe pas.

#### 🟢 GREEN
```java
public static boolean isPalindrome(String str) {
    String reversed = new StringBuilder(str).reverse().toString();
    return str.equals(reversed);
}
```
✅ Le test passe maintenant.

#### ♻️ REFACTOR
Pas de refactoring nécessaire à ce stade.

---

### Itération 2 : Ignorer la casse

#### 🔴 RED
```java
@Test
void isPalindrome_MixedCase_true() {
    // given
    String str = "Kayak";
    // when
    boolean result = PalindromeVerifier.isPalindrome(str);
    // then
    assertTrue(result);
}
```
❌ Le test échoue car "Kayak" != "kayaK".

#### 🟢 GREEN
```java
public static boolean isPalindrome(String str) {
    String lower = str.toLowerCase();
    String reversed = new StringBuilder(lower).reverse().toString();
    return lower.equals(reversed);
}
```
✅ Le test passe maintenant.

---

### Itération 3 : Ignorer les espaces et la ponctuation

#### 🔴 RED
```java
@Test
void isPalindrome_WithSpacesAndPunctuation_true() {
    // given
    String str = "A man, a plan, a canal: Panama";
    // when
    boolean result = PalindromeVerifier.isPalindrome(str);
    // then
    assertTrue(result);
}
```
❌ Le test échoue car les espaces et la ponctuation ne sont pas ignorés.

#### 🟢 GREEN
```java
public static boolean isPalindrome(String str) {
    String simplified = str.toLowerCase().replaceAll("[^a-z0-9]", "");
    String reversed = new StringBuilder(simplified).reverse().toString();
    return simplified.equals(reversed);
}
```
✅ Le test passe maintenant.

#### ♻️ REFACTOR
Extraction d'une méthode pour améliorer la lisibilité :
```java
public static boolean isPalindrome(String str) {
    final var simplified = simplifyString(str);
    final var reversed = new StringBuilder(simplified).reverse().toString();
    return simplified.equals(reversed);
}

public static String simplifyString(String str) {
    return str.toLowerCase().replaceAll("[^a-z0-9]", "");
}
```

---

### Itération 4 : Gestion des cas limites

#### 🔴 RED
```java
@Test
void isPalindrome_EmptyString_true() {
    assertTrue(PalindromeVerifier.isPalindrome(""));
}

@Test
void isPalindrome_NullString_throwsException() {
    assertThrows(IllegalArgumentException.class, 
        () -> PalindromeVerifier.isPalindrome(null));
}
```
❌ Les tests échouent (NullPointerException pour null, pas de gestion explicite).

#### 🟢 GREEN
```java
public static boolean isPalindrome(String str) {
    if (str == null) {
        throw new IllegalArgumentException("La chaîne ne peut pas être null");
    }
    
    final var simplified = simplifyString(str);
    
    if (simplified.length() <= 1) {
        return true;
    }
    
    final var reversed = new StringBuilder(simplified).reverse().toString();

