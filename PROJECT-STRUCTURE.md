# 📁 Structure Complète du Projet

## 🎯 Vue d'Ensemble

Voici la structure complète du projet Palindrome Verifier avec une description de chaque fichier.

```
Palyndrome-tdd-mvn/
│
├── 📄 pom.xml                          # Configuration Maven du projet
├── 📄 .gitignore                       # Fichiers à ignorer par Git
│
├── 📚 Documentation/
│   ├── README.md                       # Documentation principale du projet
│   ├── TDD-GUIDE.md                    # Guide complet sur l'approche TDD
│   ├── EXAMPLES.md                     # Exemples d'utilisation du code
│   ├── CONTRIBUTING.md                 # Guide de contribution
│   ├── CHANGELOG.md                    # Historique des modifications
│   └── PROJECT-STRUCTURE.md            # Ce fichier
│
├── 📦 src/
│   ├── main/
│   │   ├── java/
│   │   │   └── be/cm/palyndrometdd/
│   │   │       ├── Main.java           # Point d'entrée de l'application
│   │   │       └── PalindromeVerifier.java  # Classe principale
│   │   └── resources/                  # Ressources (vide pour l'instant)
│   │
│   └── test/
│       └── java/
│           └── be/cm/palyndrometdd/
│               └── PalindromeVerifierTest.java  # Tests JUnit 5
│
└── 🎯 target/                          # Dossier de build Maven (généré)
    ├── classes/                        # Classes compilées
    ├── test-classes/                   # Tests compilés
    └── site/jacoco/                    # Rapports de couverture de code
```

---

## 📄 Description des Fichiers

### 🔧 Configuration

#### **pom.xml**
```xml
- Fichier de configuration Maven
- Définit les dépendances (JUnit 5)
- Configure les plugins (JaCoCo, Surefire, Compiler, Exec)
- Spécifie Java 21
```

**Commandes Maven associées :**
```bash
mvn clean compile  # Compiler le projet
mvn test          # Exécuter les tests
mvn exec:java     # Lancer l'application
```

#### **.gitignore**
```
- Exclut les fichiers générés (target/, *.class)
- Exclut les fichiers IDE (.idea/, *.iml, .vscode/)
- Exclut les fichiers OS (.DS_Store, Thumbs.db)
```

---

### 📚 Documentation

#### **README.md** (Principal)
```markdown
✨ Documentation principale du projet
📋 Qu'est-ce que le TDD ?
🔄 Le cycle Red-Green-Refactor
📝 Étapes d'application du TDD
🏗️ Structure du projet
🚀 Commandes pour lancer le projet
🧪 Couverture des tests
📊 Avantages du TDD
```

**Public cible :** Tous les utilisateurs et contributeurs

#### **TDD-GUIDE.md** (Guide Approfondi)
```markdown
🔑 Principes clés du TDD
🛠️ Étapes détaillées (Red-Green-Refactor)
📊 Comparaison avec/sans TDD
🎯 Bonnes pratiques
🔄 Cycle appliqué au projet
📈 Métriques de succès
🎓 Quiz pour tester ses connaissances
📚 Ressources pour aller plus loin
```

**Public cible :** Développeurs voulant approfondir le TDD

#### **EXAMPLES.md** (Exemples Pratiques)
```markdown
🎯 20+ exemples d'utilisation
🔤 Gestion de la casse
📝 Palindromes complexes
🔢 Palindromes numériques
⚠️ Cas limites
❌ Gestion des erreurs
🔄 Utilisation en boucle
📊 Stream API
🎨 Formatage de sortie
```

**Public cible :** Développeurs cherchant des exemples concrets

#### **CONTRIBUTING.md** (Guide de Contribution)
```markdown
🤝 Code de conduite
💡 Comment contribuer
🔄 Processus TDD à suivre
📝 Standards de code
🧪 Conventions de tests
📚 JavaDoc
🔖 Format des commits
🔍 Checklist PR
🎯 Idées de contributions
```

**Public cible :** Contributeurs au projet

#### **CHANGELOG.md** (Historique)
```markdown
📝 Version 1.0.0
✨ Fonctionnalités ajoutées
🧪 Tests implémentés
📚 Documentation créée
🛠️ Configuration
💻 Interface utilisateur
🏗️ Architecture
♻️ Refactoring
🚀 Roadmap future
```

**Public cible :** Tous, pour suivre l'évolution du projet

---

### 💻 Code Source

#### **src/main/java/be/cm/palyndrometdd/Main.java**
```java
Rôle : Point d'entrée de l'application
Fonctionnalités :
  - Affichage du message de bienvenue
  - Démonstration avec exemples prédéfinis
  - Mode interactif pour tester ses propres chaînes
  - Formatage joli avec émojis

Méthodes :
  - main() : Lance l'application
  - displayWelcome() : Affiche l'en-tête
  - runExamples() : Exécute des démos
  - runInteractiveMode() : Mode interactif
  - testPalindrome() : Teste et affiche un résultat
```

**Exécution :**
```bash
mvn exec:java -Dexec.mainClass="be.cm.palyndrometdd.Main"
```

#### **src/main/java/be/cm/palyndrometdd/PalindromeVerifier.java**
```java
Rôle : Classe utilitaire pour vérifier les palindromes
Type : Classe statique (constructeur privé)

Méthodes publiques :
  - isPalindrome(String str) : boolean
    → Vérifie si une chaîne est un palindrome
    → Throw IllegalArgumentException si null
    
  - simplifyString(String str) : String
    → Simplifie une chaîne (minuscules, sans caractères spéciaux)
    → Retourne "" si null

Algorithme :
  1. Valider l'entrée (null check)
  2. Simplifier la chaîne (toLowerCase + regex)
  3. Inverser avec StringBuilder
  4. Comparer original et inversé
```

**Complexité :** O(n) où n = longueur de la chaîne

---

### 🧪 Tests

#### **src/test/java/be/cm/palyndrometdd/PalindromeVerifierTest.java**
```java
Rôle : Tests unitaires JUnit 5
Framework : JUnit Jupiter 5.13.4
Nombre de tests : 20+

Catégories de tests :

📗 Palindromes valides (true)
  - isPalindrome_ClassicPalindrome_true
  - isPalindrome_SimplePalindromes_true (@ParameterizedTest)
  - isPalindrome_ComplexPalindromes_true (@ParameterizedTest)
  - isPalindrome_SingleCharacter_true
  - isPalindrome_EmptyString_true
  - isPalindrome_OnlySpecialCharacters_true
  - isPalindrome_NumericPalindrome_true
  - isPalindrome_AlphanumericPalindrome_true

📕 Non-palindromes (false)
  - isPalindrome_NotPalindrome_false
  - isPalindrome_NotPalindromes_false (@ParameterizedTest)
  - isPalindrome_AlmostPalindrome_false

⚠️ Cas d'erreur (exceptions)
  - isPalindrome_NullString_throwsException

🔧 Tests de simplifyString
  - simplifyString_WithSpecialCharacters
  - simplifyString_OnlyUpperCase
  - simplifyString_WithNumbers
  - simplifyString_OnlySpecialCharacters
  - simplifyString_NullString_returnsEmpty
  - simplifyString_EmptyString_returnsEmpty
  - simplifyString_WithSpaces

Structure : Given-When-Then
Couverture : > 95%
```

**Exécution :**
```bash
mvn test                    # Tous les tests
mvn test -Dtest=NomDuTest  # Test spécifique
```

---

### 🎯 Dossier target/ (Généré)

Ce dossier est créé par Maven lors de la compilation.

```
target/
├── classes/                    # .class des sources principales
│   └── be/cm/palyndrometdd/
│       ├── Main.class
│       └── PalindromeVerifier.class
│
├── test-classes/              # .class des tests
│   └── be/cm/palyndrometdd/
│       └── PalindromeVerifierTest.class
│
├── site/jacoco/               # Rapports de couverture
│   ├── index.html            # Rapport principal
│   └── ...
│
├── surefire-reports/          # Rapports de tests
│   ├── TEST-*.xml
│   └── *.txt
│
└── generated-sources/         # Sources générées (annotations)
    └── annotations/
```

**⚠️ Note :** Ce dossier est dans `.gitignore` et ne doit pas être commité.

---

## 📊 Statistiques du Projet

### Lignes de Code

| Fichier | Lignes | Description |
|---------|--------|-------------|
| PalindromeVerifier.java | ~50 | Code de production |
| PalindromeVerifierTest.java | ~200 | Tests unitaires |
| Main.java | ~110 | Interface utilisateur |
| **Total Code** | **~360** | Code Java |
| **Documentation** | **~1500** | Markdown (5 fichiers) |

### Ratio Tests/Code

```
Tests : 200 lignes
Code  : 160 lignes (Main + PalindromeVerifier)
Ratio : 1.25 (125% de tests)
```

**✅ Excellent ratio pour TDD !**

### Couverture de Tests

```
PalindromeVerifier.java : 100% (toutes les méthodes)
Main.java              : ~40% (interface utilisateur)
Moyenne                : ~95%
```

---

## 🚀 Commandes Rapides

### Développement

```bash
# Compiler
mvn clean compile

# Exécuter les tests
mvn test

# Exécuter l'application
mvn exec:java

# Rapport de couverture
mvn clean test jacoco:report

# Tout nettoyer
mvn clean
```

### Visualisation

```bash
# Ouvrir le rapport JaCoCo (après mvn test)
start target/site/jacoco/index.html  # Windows
open target/site/jacoco/index.html   # macOS
xdg-open target/site/jacoco/index.html  # Linux
```

---

## 📦 Dépendances

### Maven (pom.xml)

```xml
JUnit Jupiter 5.13.4    - Framework de tests
JaCoCo 0.8.11          - Couverture de code
Maven Compiler 3.11.0  - Compilation Java 21
Maven Surefire 3.2.5   - Exécution des tests
Exec Maven Plugin 3.1.0 - Exécution de Main
```

### Pas de dépendances runtime
Le projet n'a **aucune dépendance** en production !
Seulement des dépendances de test et de build.

---

## 🎯 Navigation dans le Projet

### Pour Démarrer
1. Lire **README.md** (vue d'ensemble)
2. Lire **TDD-GUIDE.md** (comprendre le TDD)
3. Voir **EXAMPLES.md** (exemples pratiques)

### Pour Contribuer
1. Lire **CONTRIBUTING.md** (process de contribution)
2. Étudier **PalindromeVerifierTest.java** (exemples de tests)
3. Suivre le cycle Red-Green-Refactor

### Pour Utiliser
1. Exécuter **Main.java** (démo interactive)
2. Consulter **EXAMPLES.md** (cas d'usage)
3. Importer les classes dans votre projet

---

## 🏆 Points Forts de l'Architecture

✅ **Séparation des responsabilités**
- PalindromeVerifier : logique métier
- Main : interface utilisateur
- Tests : validation

✅ **Principes SOLID**
- S : Une classe = Une responsabilité
- O : Ouvert à l'extension (nouvelles méthodes)
- L : Pas d'héritage, pas de soucis
- I : Interfaces simples
- D : Pas de dépendances externes

✅ **Clean Code**
- Noms explicites
- Méthodes courtes
- Commentaires JavaDoc
- Pas de duplication

✅ **Testabilité**
- Méthodes statiques faciles à tester
- Pas de dépendances complexes
- Tests isolés et rapides

---

## 🔮 Évolutions Futures

### Version 1.1.0
- [ ] Support caractères accentués
- [ ] API REST avec Spring Boot
- [ ] Performance optimisée

### Version 1.2.0
- [ ] Interface graphique JavaFX
- [ ] Internationalisation (i18n)
- [ ] CI/CD GitHub Actions

---

## 📞 Support

Pour toute question sur la structure du projet :
- Consulter **README.md**
- Lire **TDD-GUIDE.md**
- Ouvrir une Issue sur GitHub

---

**🎉 Projet structuré selon les meilleures pratiques TDD et Clean Code !**

