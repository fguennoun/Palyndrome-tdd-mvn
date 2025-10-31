# 💡 Exemples d'utilisation - Palindrome Verifier

Ce fichier contient des exemples pratiques d'utilisation de la classe `PalindromeVerifier`.

---

## 🎯 Utilisation basique

### Exemple 1 : Palindrome simple
```java
String word = "kayak";
boolean result = PalindromeVerifier.isPalindrome(word);
System.out.println(result); // true
```

### Exemple 2 : Non-palindrome
```java
String word = "hello";
boolean result = PalindromeVerifier.isPalindrome(word);
System.out.println(result); // false
```

---

## 🔤 Gestion de la casse

### Exemple 3 : Majuscules et minuscules
```java
String word1 = "Kayak";
String word2 = "KAYAK";
String word3 = "kAyAk";

// Tous retournent true car la casse est ignorée
System.out.println(PalindromeVerifier.isPalindrome(word1)); // true
System.out.println(PalindromeVerifier.isPalindrome(word2)); // true
System.out.println(PalindromeVerifier.isPalindrome(word3)); // true
```

---

## 📝 Palindromes avec ponctuation et espaces

### Exemple 4 : Phrase palindrome
```java
String phrase = "A man, a plan, a canal: Panama";
boolean result = PalindromeVerifier.isPalindrome(phrase);
System.out.println(result); // true

// Voir la version simplifiée
String simplified = PalindromeVerifier.simplifyString(phrase);
System.out.println(simplified); // "amanaplanacanalpanama"
```

### Exemple 5 : Question palindrome
```java
String question = "Was it a car or a cat I saw?";
System.out.println(PalindromeVerifier.isPalindrome(question)); // true
```

---

## 🔢 Palindromes numériques et alphanumériques

### Exemple 6 : Palindrome numérique
```java
String number = "12321";
System.out.println(PalindromeVerifier.isPalindrome(number)); // true
```

### Exemple 7 : Palindrome alphanumérique
```java
String mixed = "A1B2C2B1A";
System.out.println(PalindromeVerifier.isPalindrome(mixed)); // true
```

---

## ⚠️ Cas limites

### Exemple 8 : Chaîne vide
```java
String empty = "";
System.out.println(PalindromeVerifier.isPalindrome(empty)); // true
```

### Exemple 9 : Un seul caractère
```java
String single = "a";
System.out.println(PalindromeVerifier.isPalindrome(single)); // true
```

### Exemple 10 : Uniquement des caractères spéciaux
```java
String special = "!@#$%^&*()";
System.out.println(PalindromeVerifier.isPalindrome(special)); // true
// Devient une chaîne vide après simplification
```

---

## ❌ Gestion des erreurs

### Exemple 11 : Valeur null
```java
String nullString = null;

try {
    PalindromeVerifier.isPalindrome(nullString);
} catch (IllegalArgumentException e) {
    System.out.println("Erreur : " + e.getMessage());
    // Affiche : "Erreur : La chaîne ne peut pas être null"
}
```

---

## 🧪 Utilisation de simplifyString

### Exemple 12 : Simplification de chaîne
```java
String complex = "Hello, World! 123";
String simplified = PalindromeVerifier.simplifyString(complex);
System.out.println(simplified); // "helloworld123"
```

### Exemple 13 : Vérification manuelle
```java
String text = "Able was I ere I saw Elba";
String simplified = PalindromeVerifier.simplifyString(text);
String reversed = new StringBuilder(simplified).reverse().toString();

System.out.println("Original    : " + text);
System.out.println("Simplifié   : " + simplified);
System.out.println("Inversé     : " + reversed);
System.out.println("Palindrome  : " + simplified.equals(reversed));
```

---

## 🔄 Utilisation dans une boucle

### Exemple 14 : Tester plusieurs mots
```java
String[] words = {"kayak", "hello", "radar", "world", "level"};

for (String word : words) {
    boolean isPalindrome = PalindromeVerifier.isPalindrome(word);
    System.out.printf("%s : %s%n", word, isPalindrome ? "✓" : "✗");
}

// Sortie :
// kayak : ✓
// hello : ✗
// radar : ✓
// world : ✗
// level : ✓
```

---

## 📊 Utilisation avec Stream API

### Exemple 15 : Filtrer les palindromes
```java
import java.util.List;
import java.util.stream.Collectors;

List<String> words = List.of("kayak", "hello", "radar", "world", "level", "java");

List<String> palindromes = words.stream()
    .filter(PalindromeVerifier::isPalindrome)
    .collect(Collectors.toList());

System.out.println(palindromes); // [kayak, radar, level]
```

### Exemple 16 : Compter les palindromes
```java
List<String> words = List.of("kayak", "hello", "radar", "world", "level");

long count = words.stream()
    .filter(PalindromeVerifier::isPalindrome)
    .count();

System.out.println("Nombre de palindromes : " + count); // 3
```

---

## 🎨 Formatage de sortie

### Exemple 17 : Affichage formaté
```java
String[] testCases = {
    "racecar",
    "hello",
    "A man, a plan, a canal: Panama"
};

System.out.println("TEST DES PALINDROMES");
System.out.println("=".repeat(50));

for (String test : testCases) {
    boolean result = PalindromeVerifier.isPalindrome(test);
    String status = result ? "✅ PALINDROME" : "❌ PAS UN PALINDROME";
    System.out.printf("%-40s %s%n", test, status);
}
```

---

## 🧮 Validation de formulaire

### Exemple 18 : Dans une application
```java
public class UserInput {
    public static String validatePalindrome(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Veuillez entrer une chaîne valide.";
        }
        
        boolean isPalindrome = PalindromeVerifier.isPalindrome(input);
        
        if (isPalindrome) {
            return "✅ '" + input + "' est un palindrome !";
        } else {
            return "❌ '" + input + "' n'est pas un palindrome.";
        }
    }
}
```

---

## 📱 Application console interactive

### Exemple 19 : Menu interactif
```java
import java.util.Scanner;

public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        
        System.out.println("🔄 VÉRIFICATEUR DE PALINDROMES");
        
        while (continuer) {
            System.out.print("\nEntrez un texte (ou 'q' pour quitter) : ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("q")) {
                continuer = false;
                System.out.println("Au revoir !");
            } else {
                try {
                    boolean result = PalindromeVerifier.isPalindrome(input);
                    if (result) {
                        System.out.println("✅ C'est un palindrome !");
                    } else {
                        System.out.println("❌ Ce n'est pas un palindrome.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Erreur : " + e.getMessage());
                }
            }
        }
        
        scanner.close();
    }
}
```

---

## 🎓 Tests unitaires - Exemples

### Exemple 20 : Test simple avec JUnit
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTest {
    @Test
    void testSimplePalindrome() {
        assertTrue(PalindromeVerifier.isPalindrome("kayak"));
        assertFalse(PalindromeVerifier.isPalindrome("hello"));
    }
    
    @Test
    void testComplexPalindrome() {
        String phrase = "A man, a plan, a canal: Panama";
        assertTrue(PalindromeVerifier.isPalindrome(phrase));
    }
    
    @Test
    void testNullThrowsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> PalindromeVerifier.isPalindrome(null));
    }
}
```

---

## 🌟 Palindromes célèbres à tester

```java
// Palindromes en français
"Élu par cette crapule"
"Ésope reste ici et se repose"
"La mariée ira mal"
"Tu l'as trop écrasé, César, ce Port-Salut"

// Palindromes en anglais
"A Santa at NASA"
"Do geese see God?"
"Never odd or even"
"Mr. Owl ate my metal worm"
"Was it a car or a cat I saw?"

// Palindromes numériques
"12321"
"1234321"
"123454321"
```

---

## 🚀 Conseils d'utilisation

1. **Validation** : Toujours gérer le cas null avec try-catch
2. **Performance** : Pour de grandes listes, utilisez les Streams en parallèle
3. **Affichage** : Utilisez `simplifyString()` pour montrer la transformation
4. **Tests** : Écrivez des tests pour vos cas d'usage spécifiques
5. **Immutabilité** : Les méthodes ne modifient pas les chaînes d'entrée

---

## 📚 Ressources supplémentaires

- Voir `README.md` pour l'approche TDD complète
- Voir `PalindromeVerifierTest.java` pour tous les tests
- Exécutez `Main.java` pour une démonstration interactive

---

**💡 Astuce** : Utilisez ces exemples comme base pour créer vos propres tests et applications !

