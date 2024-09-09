import backend.academy.Dictionary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void testGetWord() {
        //Проверка получения слова
        String word = Dictionary.getWord(1, 1);
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.WORDS_WAR()[0].containsKey(word), "Word should be present in the theme and level");

        word = Dictionary.getWord(2, 2);
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.WORDS_DEV()[1].containsKey(word), "Word should be present in the theme and level");

        word = Dictionary.getWord(3, 3);
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.WORDS_RELIGION()[2].containsKey(word), "Word should be present in the theme and level");

        // Test with an invalid theme
        word = Dictionary.getWord(99, 1);
        assertNotNull(word, "Word should not be null");
        assertTrue(Dictionary.WORDS_WAR()[1].containsKey(word), "Default theme and level should be used");
    }

    @Test
    void testGetHint() {
        //Проверка получения подсказки
        String hint = Dictionary.getHint(1, 1, "battle");
        assertEquals("A fight between armed forces.", hint, "Hint should match the description");

        hint = Dictionary.getHint(2, 2, "algorithm");
        assertEquals("A step-by-step procedure for solving a problem or performing a task.", hint, "Hint should match the description");

        hint = Dictionary.getHint(3, 3, "transubstantiation");
        assertEquals("The belief in the transformation of the bread and wine into the body and blood of Christ in the Eucharist.", hint, "Hint should match the description");

        // Test with a non-existent word
        hint = Dictionary.getHint(1, 1, "nonexistent");
        assertEquals("Word not found in the specified theme and level.", hint, "Hint for a non-existent word should be a default message ");
    }

    @Test
    void testGetWordLength() {
        //Проверка сложности слова
        for (int i = 0; i < Dictionary.WORDS_WAR()[0].size(); i++) {
            String word = Dictionary.getWord(1, 1);
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_DEV()[0].size(); i++) {
            String word = Dictionary.getWord(2, 1);
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_RELIGION()[0].size(); i++) {
            String word = Dictionary.getWord(3, 1);
            assertTrue(word.length() >= 6 && word.length() <= 7, "Level 1 word length should be between 7 and 8 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_WAR()[1].size(); i++) {
            String word = Dictionary.getWord(1, 2);
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 8 and 12 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_DEV()[1].size(); i++) {
            String word = Dictionary.getWord(2, 2);
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 8 and 12 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_RELIGION()[1].size(); i++) {
            String word = Dictionary.getWord(3, 2);
            assertTrue(word.length() >= 8 && word.length() <= 12, "Level 2 word length should be between 8 and 12 characters " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_WAR()[2].size(); i++) {
            String word = Dictionary.getWord(1, 3);
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_DEV()[2].size(); i++) {
            String word = Dictionary.getWord(2, 3);
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }

        for (int i = 0; i < Dictionary.WORDS_RELIGION()[2].size(); i++) {
            String word = Dictionary.getWord(3, 3);
            assertTrue(word.length() >= 13, "Level 3 word length should be 13 characters or more " + word);
        }
    }
}
