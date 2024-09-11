package backend.academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void testGetWord() {
        // Test fetching a word from various themes and levels
        String word = Dictionary.getWord(0, 1); // War, Level 1
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.THEMES().get(0)[1].containsKey(word), "Word should be present in the theme and level");

        word = Dictionary.getWord(1, 2); // Development, Level 2
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.THEMES().get(1)[2].containsKey(word), "Word should be present in the theme and level");

        word = Dictionary.getWord(2, 3); // Religion, Level 3
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.THEMES().get(2)[3].containsKey(word), "Word should be present in the theme and level");

        // Test with an invalid theme
        word = Dictionary.getWord(99, 1);
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.THEMES().get(0)[1].containsKey(word), "Default theme and level should be used");
    }

    @Test
    void testGetHint() {
        String hint = Dictionary.getHint(0, 1, "battle");
        assertEquals("A fight between armed forces.", hint, "Hint should match the description");

        hint = Dictionary.getHint(1, 1, "plugin");
        assertEquals("A software component that adds specific features to an existing application.", hint, "Hint should match the description");

        hint = Dictionary.getHint(2, 3, "transubstantiation");
        assertEquals("The belief in the transformation of the bread and wine into the body and blood of Christ in the Eucharist.", hint, "Hint should match the description");

        hint = Dictionary.getHint(0, 1, "nonexistent");
        assertEquals("Word not found in the specified theme and level.", hint, "Hint for a non-existent word should be a default message");
    }

    @Test
    void testGetWordLength() {
        for (String word : Dictionary.THEMES().get(0)[1].keySet()) {
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(0)[2].keySet()) {
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 7 and 8 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(0)[3].keySet()) {
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }

        for (String word : Dictionary.THEMES().get(1)[1].keySet()) {
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(1)[2].keySet()) {
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 8 and 12 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(1)[3].keySet()) {
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }

        for (String word : Dictionary.THEMES().get(2)[1].keySet()) {
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(2)[2].keySet()) {
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 8 and 12 characters " + word);
        }

        for (String word : Dictionary.THEMES().get(2)[3].keySet()) {
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }
    }
}

