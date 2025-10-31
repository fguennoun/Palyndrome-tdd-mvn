package be.cm.palyndrometdd;

import java.util.Scanner;

/**
 * Classe principale pour tester le vérificateur de palindromes de manière interactive.
 */
public class Main {

    private static final String SEPARATOR = "=".repeat(60);

    public static void main(String[] args) {
        displayWelcome();

        // Exemples de démonstration
        runExamples();

        // Mode interactif
        runInteractiveMode();
    }

    /**
     * Affiche le message de bienvenue.
     */
    private static void displayWelcome() {
        System.out.println(SEPARATOR);
        System.out.println("🔄 VÉRIFICATEUR DE PALINDROMES");
        System.out.println(SEPARATOR);
        System.out.println("Un palindrome se lit de la même manière");
        System.out.println("de gauche à droite et de droite à gauche.");
        System.out.println(SEPARATOR);
    }

    /**
     * Exécute des exemples de démonstration.
     */
    private static void runExamples() {
        System.out.println("\n📚 EXEMPLES DE DÉMONSTRATION\n");

        String[] examples = {
            "kayak",
            "racecar",
            "A man, a plan, a canal: Panama",
            "Was it a car or a cat I saw?",
            "hello",
            "12321",
            "java"
        };

        for (String example : examples) {
            testPalindrome(example);
        }

        System.out.println(SEPARATOR);
    }

    /**
     * Lance le mode interactif où l'utilisateur peut tester ses propres chaînes.
     */
    private static void runInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("\n💬 MODE INTERACTIF\n");

        while (continuer) {
            System.out.print("Entrez une chaîne à tester (ou 'q' pour quitter) : ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                continuer = false;
                System.out.println("\n👋 Au revoir !");
            } else if (input.trim().isEmpty()) {
                System.out.println("⚠️  Veuillez entrer une chaîne non vide.\n");
            } else {
                testPalindrome(input);
                System.out.println();
            }
        }

        scanner.close();
    }

    /**
     * Teste si une chaîne est un palindrome et affiche le résultat.
     *
     * @param str la chaîne à tester
     */
    private static void testPalindrome(String str) {
        try {
            boolean isPalindrome = PalindromeVerifier.isPalindrome(str);
            String simplified = PalindromeVerifier.simplifyString(str);

            System.out.printf("%-40s ", "\"" + str + "\"");

            if (isPalindrome) {
                System.out.println("✅ PALINDROME");
                if (!str.equals(simplified) && !simplified.isEmpty()) {
                    System.out.println("   → Simplifié : " + simplified);
                }
            } else {
                System.out.println("❌ PAS UN PALINDROME");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("⚠️  ERREUR : " + e.getMessage());
        }
    }
}
