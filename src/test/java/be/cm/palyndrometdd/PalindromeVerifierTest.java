package be.cm.palyndrometdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeVerifierTest {

    // ========== Tests isPalindrome - Cas vrais palindromes ==========

    @Test
    void isPalindrome_ClassicPalindrome_true() {
        // given
        String str = "A man, a plan, a canal: Panama";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "kayak",
            "racecar",
            "radar",
            "level",
            "madam",
            "noon",
            "civic"
    })
    void isPalindrome_SimplePalindromes_true(String palindrome) {
        assertTrue(PalindromeVerifier.isPalindrome(palindrome));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Was it a car or a cat I saw?",
            "Never odd or even",
            "Do geese see God?",
            "A Santa at NASA",
            "Mr. Owl ate my metal worm"
    })
    void isPalindrome_ComplexPalindromes_true(String palindrome) {
        assertTrue(PalindromeVerifier.isPalindrome(palindrome));
    }

    @Test
    void isPalindrome_SingleCharacter_true() {
        // given
        String str = "a";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_EmptyString_true() {
        // given
        String str = "";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_OnlySpecialCharacters_true() {
        // given
        String str = "!@#$%^&*()";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result); // Devient vide après simplification
    }

    @Test
    void isPalindrome_NumericPalindrome_true() {
        // given
        String str = "12321";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    @Test
    void isPalindrome_AlphanumericPalindrome_true() {
        // given
        String str = "A1B2C2B1A";
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertTrue(result);
    }

    // ========== Tests isPalindrome - Cas faux palindromes ==========

    @Test
    void isPalindrome_NotPalindrome_false() {
        // given
        String text = "apple";
        // when
        boolean result = PalindromeVerifier.isPalindrome(text);
        // then
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "hello",
            "world",
            "java",
            "programming",
            "test"
    })
    void isPalindrome_NotPalindromes_false(String notPalindrome) {
        assertFalse(PalindromeVerifier.isPalindrome(notPalindrome));
    }

    @Test
    void isPalindrome_AlmostPalindrome_false() {
        // given
        String str = "raceca"; // Presque "racecar" mais pas tout à fait
        // when
        boolean result = PalindromeVerifier.isPalindrome(str);
        // then
        assertFalse(result);
    }

    // ========== Tests isPalindrome - Cas d'erreur ==========

    @Test
    void isPalindrome_NullString_throwsException() {
        // given
        String str = null;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> PalindromeVerifier.isPalindrome(str));
    }

    // ========== Tests simplifyString ==========

    @Test
    void simplifyString_WithSpecialCharacters() {
        // given
        final var str = "1Red run, sir, is murder1";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("1redrunsirismurder1", result);
    }

    @Test
    void simplifyString_OnlyUpperCase() {
        // given
        final var str = "HELLO";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("hello", result);
    }

    @Test
    void simplifyString_WithNumbers() {
        // given
        final var str = "Test123";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("test123", result);
    }

    @Test
    void simplifyString_OnlySpecialCharacters() {
        // given
        final var str = "!@#$%";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("", result);
    }

    @Test
    void simplifyString_NullString_returnsEmpty() {
        // given
        String str = null;
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("", result);
    }

    @Test
    void simplifyString_EmptyString_returnsEmpty() {
        // given
        final var str = "";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("", result);
    }

    @Test
    void simplifyString_WithSpaces() {
        // given
        final var str = "Hello World";
        // when
        final var result = PalindromeVerifier.simplifyString(str);
        // then
        assertEquals("helloworld", result);
    }
}