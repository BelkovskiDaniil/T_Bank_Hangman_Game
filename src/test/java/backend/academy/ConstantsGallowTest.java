package backend.academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantsGallowTest {
    @Test
    void testMaxAttempts() {
        //Проверяем, что попыток не меньше 6
        assertTrue(ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME >= 6, "Number of attempts less than 6");
    }

    @Test
    void testMaxGallowSteps() {
        //Проверяем, что попыток не меньше 6
        assertTrue(ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME <= ConstantsGallows.HANGMAN_STAGES().size(), "Number of attempts less than 6");
    }
}
