package be.cm.palyndrometdd;

/**
 * Classe utilitaire pour vérifier si une chaîne est un palindrome.
 * Un palindrome est une chaîne qui se lit de la même manière de gauche à droite et de droite à gauche,
 * en ignorant les caractères spéciaux, les espaces et la casse.
 */
public class PalindromeVerifier {

    private PalindromeVerifier() {
        // Constructeur privé pour empêcher l'instanciation
        throw new UnsupportedOperationException("Classe utilitaire - ne doit pas être instanciée");
    }

    /**
     * Vérifie si une chaîne est un palindrome.
     *
     * @param str la chaîne à vérifier
     * @return true si la chaîne est un palindrome, false sinon
     * @throws IllegalArgumentException si la chaîne est null
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("La chaîne ne peut pas être null");
        }

        final var simplified = simplifyString(str);

        // Chaîne vide ou un seul caractère est considéré comme palindrome
        if (simplified.length() <= 1) {
            return true;
        }

        final var reversedSimplified = new StringBuilder(simplified).reverse().toString();
        return reversedSimplified.equals(simplified);
    }

    /**
     * Simplifie une chaîne en supprimant les caractères spéciaux et en convertissant en minuscules.
     *
     * @param str la chaîne à simplifier
     * @return la chaîne simplifiée contenant uniquement des lettres et des chiffres en minuscules
     */
    public static String simplifyString(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}
