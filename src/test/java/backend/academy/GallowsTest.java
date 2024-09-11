package backend.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GallowsTest {
    private Gallows gallow;

    @BeforeEach
    void setUp() {
        gallow = new Gallows(); // Чтобы тесты не влияли на код, наверное это требовалось
    }

    @Test
    void testPrint() {
        List<char[][]> hangmanStages = ConstantsGallows.HANGMAN_STAGES();
        for (int i = 0; i < hangmanStages.size(); i++) {
            assertTrue(Arrays.deepEquals(gallow.hangman(), hangmanStages.get(i)), "Incorrect print at stage " + i);
            gallow.add();
        }
    }
}

