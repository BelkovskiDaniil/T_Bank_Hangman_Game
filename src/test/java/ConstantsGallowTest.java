import backend.academy.ConstantsGallows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConstantsGallowTest {
    @Test
    void testMaxAttempts() {
        //Проверяем, что попыток не меньше 6
        assertNotNull(ConstantsGallows.MAX_ATTEMPTS, "Word should not be null");
        assertTrue(ConstantsGallows.MAX_ATTEMPTS >= 6, "Number of attempts less than 6");
    }
}
