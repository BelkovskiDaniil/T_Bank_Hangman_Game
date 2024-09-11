package backend.academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordTest {

    @Test
    void testWordNull() {
        Word word = new Word(Dictionary.getWord(3, 3));
        assertNotNull(word.word(), "Word should not be null");
    }

    @Test
    void testCleanWord() {
        Word word = new Word(Dictionary.getWord(3, 3));
        char[] characters = word.word().toCharArray();

        for (char character : characters) {
            word.letterCheck(String.valueOf(character));
        }

        //Проверка, что слово корректно отгадывается
        assertTrue(word.isClear(), "Word should be clear after adding all letters");
    }
}
